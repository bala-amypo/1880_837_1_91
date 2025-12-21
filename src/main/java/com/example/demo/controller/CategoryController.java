package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.CategoryService;
import com.example.demo.model.Category;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/category")
@RestController
public class CategoryController{
@Autowired
CategoryService cs;
@PostMapping("/Category")
public Category postData(@RequestBody Category cty){
    return cs.createCategory(cty);
}
@GetMapping("/cat")
public List<Category> getData(){
    return cs.getAllCategories();
}
@GetMapping("/{id}")
public Category getIdData(@PathVariable Long id){
    return cs.getCategory(id);
}
}