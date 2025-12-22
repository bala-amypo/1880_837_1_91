package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.service.impl.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping; 
@RequestMapping("/users")
@RestController
public class UserController{
    @Autowired
    Userservice obj;
    @PostMapping("/Reg")
    public User Register(@RequestBody User user){
        return obj.register(user);
    }
    @GetMapping("{id}")
    public User GetUser(@PathVariable Long id){
        return obj.getUser(id);
    }
    @GetMapping("/email/{email}")
    public User FindByEmail(@PathVariable String  email){
        return obj.findByEmail(email);
    }
}