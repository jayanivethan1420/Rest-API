package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Grocery;
import com.example.demo.service.GroceryService;

@RestController
@RequestMapping("/groceries")
public class GroceryController {

    @Autowired
    private GroceryService groceryService;

    @PostMapping
    public Grocery createGrocery(@RequestBody Grocery grocery) {
        return groceryService.addGrocery(grocery);
    }

    @GetMapping("/{id}")
    public Grocery getGroceryById(@PathVariable Long id) {
        Grocery grocery = groceryService.getGroceryById(id);
        if (grocery == null) {
            throw new RuntimeException("Grocery not found with id " + id);
        }
        return grocery;
    }

    @PutMapping("/{id}")
    public Grocery updateGrocery(@PathVariable Long id, @RequestBody Grocery groceryDetails) {
        return groceryService.updateGrocery(id, groceryDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteGrocery(@PathVariable Long id) {
        groceryService.deleteGrocery(id);
    }
}
