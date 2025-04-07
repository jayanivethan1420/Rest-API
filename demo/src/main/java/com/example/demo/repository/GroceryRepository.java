package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Grocery;

public interface GroceryRepository extends JpaRepository<Grocery,Long> {
    boolean existsByname(String name);
    boolean existsByid(Long id);
    
}
