package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import com.example.demo.model.Category;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;
@Entity
public class Ticket{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String location;
    private String createdBy;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name="category_id",nullable=true)
    private Category assignedCategory;
    private String urgencyLevel;
    @PrePersist
    void ch(){
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
    public String getFullName(){
        return fullName;
    }
    public void setFullName(){
        this.fullName=fullName;
    }
    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location=location;
    }
    public String getCreatedBy(){
        return createdBy;
    }
    public void setCreatedBy(String createdBy){
        this.createdBy=createdBy;
    }
    public Category getAssignedcategory(){
        return assignedCategory;
    }
    public void setAssignedCtaegory(Category assignedCategory){
        this.assignedCategory=assignedCategory;
    }
    public String getUrgencyLevel(){
        return urgencyLevel;
    }
    public void setUrgencyLevel(String urgencyLevel){
        this.urgencyLevel=urgencyLevel;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }
    public Ticket(Long id,String fullName,String Loaction,String createdBy,LocalDateTime createdAt,Category assignedCategory,String urgencyLevel){
        this.id=id;
        this.location=location;
        this.createdBy=createdBy;
        this.createdAt=createdAt;
        this.assignedCategory=assignedCategory;
        this.urgencyLevel=urgencyLevel;
    }
    public Ticket(){}
}