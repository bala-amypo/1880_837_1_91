package com.example.demo.repository;
import com.example.demo.model.CategorizationRule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.demo.model.Category;
public interface CategorizationRulerepo extends JpaRepository<CategorizationRule,Long>{
    List<CategorizationRule> findByCategoryId(Long CategoryId); 
}