package com.example.demo.repository;

import com.example.demo.entity.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

//using jpql implement getOrdersBetweenDates
    @Query("SELECT o FROM Order o WHERE o.date BETWEEN :startDate AND :endDate")
    List<Order> getOrdersBetweenDates(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
