package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import java.time.LocalDateTime;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.PrePersist;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.example.demo.model.Category;
@Entity
public class CategorizationRule{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @NotNull(message="This Feild is Recquired")
    private String keyword;
    private String matchType;
    @Min(0)
    private int priority;
    private LocalDateTime createdAt;
    @PrePersist
    public void onCreate(){
        if(createdAt==null){
            createdAt=LocalDateTime.now();
        }
    }
    public void setCategory(Category category){
        this.category=category;
        }
    public Category getCategory(){
        return category;
    }
    public void setKeyword(String keyword){
        this.keyword=keyword;
    }
    public String getKeyword(){
        return keyword;
    }
    public void setMatchType(String matchType){
        this.matchType=matchType;
    }
    public String getMatchType(){
        return matchType;
    }  
    public void setPriority(int priority){
        this.priority=priority;
    }
    public int getPriority(){
        return priority;
    }
    public void setCreatedAt(LocalDateTime createdAt){
    this.createdAt=createdAt;
}
    public LocalDateTime getCreatedAt(){
        return createdAt;
}
public CategorizationRule(Long id,Category category,String keyword,String matchType,int priority,LocalDateTime createdAt){
this.id=id;
this.category=category;
this.keyword=keyword;
this.matchType=matchType;
this.priority=priority;
this.createdAt=createdAt;
}
public CategorizationRule(){}
}