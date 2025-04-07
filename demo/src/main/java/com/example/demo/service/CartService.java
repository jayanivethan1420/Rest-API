package com.example.demo.service;

import com.example.demo.entity.Cart;
import com.example.demo.repository.CartRepository;

import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Transactional
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart updateCart(Long id, Cart cartDetails) {
        Cart cart = cartRepository.findById(id).orElse(null);
        if (cart != null) {
            cart.setName(cartDetails.getName());
            return cartRepository.save(cart);
        }
        return null;
    }

    @Transactional
    public Cart updateCartById(Long id, Cart cartDetails) {
        Cart cart = cartRepository.findById(id).orElse(null);
        if (cart != null) {
            cart.setName(cartDetails.getName());
            // Update other fields as necessary
            return cartRepository.save(cart);
        }
        return null;
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    public List<Cart> paginate(int page, int size) {
        return cartRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    public List<Cart> pageBySort(int page, int size) {
        return cartRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id"))).getContent();
    }

    public List<Cart> sortByField(String field) {
        return cartRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }
    public Cart findbyname(String name){
        return cartRepository.findByName(name);
    }

}
