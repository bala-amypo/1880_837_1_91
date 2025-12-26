package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.impl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping("/{id}")
    public Category get(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAllCategories();
    }
}
