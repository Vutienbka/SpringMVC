package com.codegym.PostController;

import com.codegym.PostService.PostService;
import com.codegym.Model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class PostController {
    private PostService postService;

    PostController(PostService postService){
        this.postService=postService;
    }
    @RequestMapping(value = "/homepage")
    public String homePage(){
        return "HomePage";
    }

    @RequestMapping(value = "/post/list", method = RequestMethod.GET)
    public String showPostList(Model model, RedirectAttributes redirect){
        ArrayList<Post> postList = postService.getAllPost();
        if(redirect.asMap().get("message")!=null){
            redirect.addFlashAttribute("message",model.asMap().get("message").toString());
        }
        model.addAttribute("postList", postList);
        return "PostList";
    }

    @RequestMapping(value = "/addForm")
    public String getPostFromAddForm(){
        return "addPost";
    }

    @RequestMapping(value = "/post/add")
    public String addNewPost(@ModelAttribute Post post, RedirectAttributes redirect){
        String createdDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        String updatedDate = "";
        Post newPost = new Post(post.getId(),post.getTitle(),post.getAuthor(),post.getContent(),createdDate,updatedDate);
        boolean check = this.postService.addNewPost(newPost);
        if(check) {
            redirect.addFlashAttribute("message", "Add post successful");
        }else {
            redirect.addFlashAttribute("message", "Add post not successful");
        }
        return "redirect:/post/list";
    }
    @RequestMapping(value = "/post/{id}/delete")
    public String deletePost(@PathVariable("id") int postId, Model model){
        boolean check = postService.deletePost(postId);
        if(check){
            model.addAttribute("message", "Delete successful");
        }else {
            model.addAttribute("message", "Delete not successful");
        }
        return "redirect:/post/list";
    }

    @RequestMapping(value = "/post/edit")
    public String editPost(@ModelAttribute Post post, RedirectAttributes redirect){
        post.setUpdatedDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        boolean check = postService.editPost(post);
        if(check){
            redirect.addFlashAttribute("message", "Edit successful");
        }else {
            redirect.addFlashAttribute("message", "Delete successful");
        }
        return "redirect:/post/list";
    }

    @RequestMapping(value = "/post/{id}/edit")
     public String gotoEditForm(@PathVariable("id") int postId, Model model){
       Post post = postService.findById(postId);
       model.addAttribute("post",post);
        return "editPost";
    }

    @RequestMapping(value = "/post/{id}/view")
    public String showPost(@PathVariable("id") int postId, Model model){
        Post post = postService.findById(postId);
        model.addAttribute("post",post);
        return "showPost";
    }
}
