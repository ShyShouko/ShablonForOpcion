package com.example.demo.repository;

import com.example.demo.model.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface DescriptionRepository extends JpaRepository<Description, String> {
    List<Description> findAllByOrderByNumberAsc();
    List<Description> findByUserId(String userId);
}


