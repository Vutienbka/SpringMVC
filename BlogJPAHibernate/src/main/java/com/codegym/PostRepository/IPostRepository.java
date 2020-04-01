package com.codegym.PostRepository;

import com.codegym.Model.Post;

import java.util.ArrayList;

public interface IPostRepository {

    ArrayList<Post> getAllPost();
    boolean addNewPost(Post post);
    boolean editPost(Post post);
    Post findById(int postId);
    boolean deletePost(int PostId);
}
