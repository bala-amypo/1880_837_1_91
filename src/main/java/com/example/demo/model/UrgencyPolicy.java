package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.PrePersist;
@Entity
public class UrgencyPolicy{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String category;
    @NotNull(message="No Data")
    private String keyword;
    private String matchType;
    private Long priority;
    private LocalDateTime createdAt;
    @PrePersist
    public void onCreate(){
        if(createdAt==null){
            createdAt=LocalDateTime.now();
        }
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public String getMatchType(){
        return matchType;
    } 
    public void setMatchType(String matchType){
        this.matchType=matchType;
    }
    public Long getPriority(){
        return priority;
    }
    public void setPriority(Long priority){
        this.priority=priority;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setKeyword(String keyword){
        this.keyword=keyword;
    }
    public String getKeyWord(){
        return keyword;
    }
    public UrgencyPolicy(Long id,String category,String keyword,String matchType,Long priority,LocalDateTime createdAt){
        this.id=id;
        this.category=category;
        this.keyword=keyword;
        this.matchType=matchType;
        this.priority=priority;
        this.createdAt=createdAt;
    }
    public UrgencyPolicy(){}
}