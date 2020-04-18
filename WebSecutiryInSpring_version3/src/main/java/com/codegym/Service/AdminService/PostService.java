package com.codegym.Service.AdminService;

import com.codegym.Repository.AdminRepository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PostService implements IPostService{

    @Autowired
    IBookRepository postRepository;

}
