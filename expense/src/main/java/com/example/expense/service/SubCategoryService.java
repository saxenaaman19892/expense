package com.example.expense.service;

import com.example.expense.entity.SubCategory;
import com.example.expense.repository.SubCategoryRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    private static final Logger log = LoggerFactory.getLogger(com.example.expense.service.SubCategoryService.class);

    @Transactional
    public int saveSubCategory(SubCategory subCategory) {
        log.info("saving sub category = " + subCategory.toString());
        subCategory = subCategoryRepository.save(subCategory);
        return subCategory.getId();
    }

    public List<SubCategory> getAll() {
        return subCategoryRepository.findAll();
    }
}
