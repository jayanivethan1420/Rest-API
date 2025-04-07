package com.example.demo.controller;

import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public String createCart(@RequestBody Cart cart) {
       cartService.addCart(cart);
       return "`Cart created successfully`";
    }

    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable Long id) {
        return cartService.getCartById(id);
    }

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @PutMapping("/{id}")
    public String updateCart(@PathVariable Long id, @RequestBody Cart cartDetails) {
        cartService.updateCart(id, cartDetails);
        return "Updated Successfully";
    }

    @PutMapping("/update/{id}")
    public String updateCartById(@PathVariable Long id, @RequestBody Cart cartDetails) {
        cartService.updateCartById(id, cartDetails);
        return "Cart updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return "Deleted Succesfully";
    }

    @GetMapping("/page")
    public List<Cart> paginate(@RequestParam int page, @RequestParam int size) {
        return cartService.paginate(page, size);
    }

    @GetMapping("/page/sort")
    public List<Cart> pageBySort(@RequestParam int page, @RequestParam int size) {
        return cartService.pageBySort(page, size);
    }

    @GetMapping("/sort")
    public List<Cart> sortByField(@RequestParam String field) {
        return cartService.sortByField(field);
    }
    @GetMapping("/name/{name}")
    public Cart getMethodName(@PathVariable String name) {
        return  cartService.findbyname(name);
    }
    
    
}
