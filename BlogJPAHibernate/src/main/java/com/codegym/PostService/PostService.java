package com.codegym.PostService;

import com.codegym.PostRepository.PostRepository;
import com.codegym.Model.Post;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class PostService implements IPostService{

    PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository=postRepository;
    }

    @Override
    public ArrayList<Post> getAllPost() {
        return postRepository.getAllPost();
    }

    @Override
    public boolean addNewPost(Post post) {
        return postRepository.addNewPost(post);
    }

    @Override
    public Post findById(int postId) {
        return postRepository.findById(postId);
    }

    @Override
    public boolean editPost(Post post) {
        return postRepository.editPost(post);
    }

    @Override
    public boolean deletePost(int postId) {

        return postRepository.deletePost(postId);
    }
}
