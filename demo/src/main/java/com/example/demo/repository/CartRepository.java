package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    boolean existsByName(String name);
    @Query("SELECT c FROM Cart c WHERE c.name = :name")
    Cart findByName(String name);
    
}
