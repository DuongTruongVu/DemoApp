package com.example.demo.repository;

import com.example.demo.model.entity.Account;
import com.example.demo.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByAccount(Account account);

    @Query(value = "SELECT * FROM post WHERE created_on BETWEEN :startDate AND :endDate ORDER BY created_on DESC",
            nativeQuery = true)
    List<Post> findByCreatedOn(String startDate, String endDate);

}
