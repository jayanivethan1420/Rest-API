package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setDate(orderDetails.getDate());
            order.setDescription(orderDetails.getDescription());
            order.setTotal(orderDetails.getTotal());
            return orderRepository.save(order);
        }
        return null;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public List<Order> paginate(int page, int size) {
        return orderRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    public List<Order> pageBySort(int page, int size) {
        return orderRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id"))).getContent();
    }

    public List<Order> getOrdersBetweenDates(String startDate, String endDate) {
        return orderRepository.getOrdersBetweenDates(startDate, endDate);
    }
}
