package com.example.expense.service;

import com.example.expense.entity.Category;
import com.example.expense.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    private final Logger log = LoggerFactory.getLogger(com.example.expense.service.CategoryService.class);

    @Autowired
    public CategoryService(CategoryRepository repo) {
        this.categoryRepository = repo;
    }

    public int saveCategory(Category entity) {
        log.info("saving entity");
        entity = categoryRepository.save(entity);
        return entity.getId();
    }

    public List<Category> getAllCategory() {
        log.info("returning all category");
        return categoryRepository.findAll();
    }
}
