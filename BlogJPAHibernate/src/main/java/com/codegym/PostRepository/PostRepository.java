package com.codegym.PostRepository;

import com.codegym.Model.Post;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Date;

public class PostRepository implements IPostRepository {

    SessionFactory sessionFactory;
    EntityManager entityManager;
    public PostRepository(){
        this.sessionFactory= new Configuration().configure("hibernate.config.xml").buildSessionFactory();
        this.entityManager = this.sessionFactory.createEntityManager();
    }
    @Override
    public ArrayList<Post> getAllPost() {

        String query = "SELECT p FROM Post p";
        ArrayList<Post> postList = (ArrayList<Post>) (entityManager.createQuery(query, Post.class).getResultList());
        return postList;
    }

    @Override
    public boolean addNewPost(Post post) {
        try{
            entityManager.getTransaction().begin();
            if(post.getId()>0){
                entityManager.persist(post);
                entityManager.getTransaction().commit();
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return false;
    }
    @Override
    public boolean editPost(Post post) {
        try{
            entityManager.getTransaction().begin();
            if(post.getId()>0){
                entityManager.merge(post);
                entityManager.getTransaction().commit();
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return false;
//           if(post.getId()>0) {
//               entityManager.merge(post);
//               return true;
//           }
//        return false;
    }

    @Override
    public Post findById(int postId) {
        TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post p WHERE p.Id =:postId",Post.class);
        query.setParameter("postId",postId);
        return query.getSingleResult();
    }

    @Override
    public boolean deletePost(int postId) {
        Post post = this.findById(postId);
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(post);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return false;
    }
}
