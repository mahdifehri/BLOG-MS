package com.example.blogms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogRestAPI {
    @Autowired
    BlogService blogService;
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.addBlog(blog), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Blog> updateBlog(@PathVariable(value = "id") int id, @RequestBody Blog blog)
    {
        return new ResponseEntity<>(blogService.updateBlog(id, blog), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteBlog(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(blogService.deleteBlog(id), HttpStatus.OK);
    }

    @GetMapping(value = "/blog", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Blog> getBlog() {
        List<Blog> listBlog = blogService.getAllBlog();
        return listBlog ;
    }

}
