package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Grocery;
import com.example.demo.exception.GroceryNotFoundException;
import com.example.demo.repository.GroceryRepository;

import java.util.List;

@Service
public class GroceryService {

    @Autowired
    private GroceryRepository groceryRepository;

    public Grocery addGrocery(Grocery grocery) {
        return groceryRepository.save(grocery);
    }

    public List<Grocery> getAllGroceries() {
        return groceryRepository.findAll();
    }

    public Grocery getGroceryById(Long id) {
        return groceryRepository.findById(id).orElse(null);
    }

    public void deleteGrocery(Long id) {
        groceryRepository.deleteById(id);
    }

    public List<Grocery> paginate(int page, int size) {
        return groceryRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    public List<Grocery> pageBySort(int page, int size, String sortBy) {
        return groceryRepository.findAll(PageRequest.of(page, size).withSort(Sort.by(Direction.ASC, sortBy))).getContent();
    }

    public Grocery updateGrocery(Long id, Grocery groceryDetails) {
        Grocery grocery = groceryRepository.findById(id).orElse(null);
        if (grocery != null) {
            grocery.setName(groceryDetails.getName());
            grocery.setPrice(groceryDetails.getPrice());
            return groceryRepository.save(grocery);
        }
        return null;
    }
}
