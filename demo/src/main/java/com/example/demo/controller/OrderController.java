package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/post")
    public String createOrder(@RequestBody Order order) {
         orderService.createOrder(order);
         return "Order created successfully";
    }

    @GetMapping("/get")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders(); 
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/page")
    public List<Order> paginate(@RequestParam int page, @RequestParam int size) {
        return orderService.paginate(page, size);
    }

    @GetMapping("/page/sort")
    public List<Order> pageBySort(@RequestParam int page, @RequestParam int size) {
        return orderService.pageBySort(page, size);
    }
    //get all oedwes bwtween LocalDate
    @GetMapping("/date")
    public List<Order> getOrdersBetweenDates(@RequestParam String startDate, @RequestParam String endDate) {
        return orderService.getOrdersBetweenDates(startDate, endDate);
    }
    
}
