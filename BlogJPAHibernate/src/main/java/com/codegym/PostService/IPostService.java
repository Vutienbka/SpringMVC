package com.codegym.PostService;

import com.codegym.Model.Post;

import java.util.ArrayList;

public interface IPostService {
    ArrayList<Post> getAllPost();
    boolean addNewPost(Post post);
    Post findById(int postId);
    boolean editPost(Post post);
    boolean deletePost(int postId);
}
