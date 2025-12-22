package com.example.demo.service.impl;
import com.example.demo.model.User;
public interface Userservice{
    public User register(User user);
    public User getUser(Long id);
    public User findByEmail(String  Email);
}