package com.example.blogms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    BlogRepository BlogRepo;

    public Blog addBlog(Blog Formation) {
        return BlogRepo.save(Formation);
    }
    public Blog updateBlog(int id, Blog newBlog) {
        if (BlogRepo.findById(id).isPresent()) {
            Blog existingBlog = BlogRepo.findById(id).get();
            existingBlog.setTitle(newBlog.getTitle());
            existingBlog.setDescription(newBlog.getDescription());


            return BlogRepo.save(existingBlog);
        } else
            return null;
    }


    public String deleteBlog(int id) {
        if (BlogRepo.findById(id).isPresent()) {
            BlogRepo.deleteById(id);
            return "Post deleted";
        } else
            return "Post not deleted";
    }
    public List<Blog> getAllBlog(){

        return BlogRepo.findAll();
    }

    public Blog getBlogById(int id) {
        Optional<Blog> optionalBlog = BlogRepo.findById(id);

        if (optionalBlog.isPresent()) {
            return optionalBlog.get();
        } else {
            return null;
        }
    }
}
