package com.example.demo.model;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
@Entity
public class Category{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String categoryName;
    @Size(min=10,message="desc must be minimum 10 charecters")
    private String description;
    @NotBlank(message="no empty")
    private String defaultUrgency;
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
    public String getCategoryName(){
        return categoryName;
    }
    public void setCategoryName(String categoryName){
        this.categoryName=categoryName;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getDefaultUrgency(){
        return defaultUrgency;
    }
    public void setDefaultUrgency(String defaultUrgency){
        this.defaultUrgency=defaultUrgency;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
      public void setCreatedAt(LocalDateTime createdAt){
            this.createdAt=createdAt;
}
    public Category(String categoryName,String description,String defaultUrgency,LocalDateTime createdAt){
        this.categoryName=categoryName;
        this.description=description;
        this.defaultUrgency=defaultUrgency;
        this.createdAt=createdAt;
}
public Category(){

}
}