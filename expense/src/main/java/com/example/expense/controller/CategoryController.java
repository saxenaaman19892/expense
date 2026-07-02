package com.example.expense.controller;

import com.example.expense.entity.Category;
import com.example.expense.service.CategoryService;
import com.example.expense.service.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private MainService mainService;

    private final Logger log = LoggerFactory.getLogger(com.example.expense.controller.CategoryController.class);

    @Autowired
    public CategoryController(MainService service) {
        this.mainService = service;
    }

    @PostMapping("/save-category")
    public ResponseEntity<String> saveNewCategory(@RequestBody Category category) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Category with id = " + mainService.addNewCategory(category));
    }
}
