package com.example.blogms;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query("select b from Blog b where b.title like :title")
    public Page<Blog> blogByTitle(@Param("title") String t, Pageable pageable);
}
