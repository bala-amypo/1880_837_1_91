package com.example.demo.service.impl;
import com.example.demo.service.CategoryService;
import com.example.demo.model.Category;
import com.example.demo.repository.Categoryrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CategoryServiceImplimentation implements CategoryService{
    @Autowired
    Categoryrepo obj;
    public Category createCategory(Category category){
        return obj.save(category);
    }
    public List<Category> getAllCategories(){
        return obj.findAll();
    }
   public Category getCategory(Long id){
        return obj.findById(id).orElse(null);
    }
}
