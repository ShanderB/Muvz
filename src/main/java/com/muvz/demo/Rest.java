package com.muvz.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muvz.demo.database.UserRepo;
import com.muvz.demo.entitiy.User;

@RestController
@RequestMapping("/user")
public class Rest {
    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public List<User> get(){
        return userRepo.findAll();
    }

    @PutMapping
    public void update(@RequestBody User user){
        if(user.getId() > 0){
            userRepo.save(user);
        }
    }

    @DeleteMapping
    public void delete(@RequestBody User user){
        userRepo.delete(user);
    }

    @PostMapping
    public void post(@RequestBody User user){
        userRepo.save(user);
    }

    //Search
    @GetMapping("/name")
    public Optional<User> searchUser(@RequestBody User user){
        return Optional.ofNullable(userRepo.findByName(user.getName()));
    }

    //SearchSort
    @GetMapping("/nameSort")
    public Optional<List<User>> searchUserSort(){
        return Optional.ofNullable(userRepo.findAllByOrderByNameDesc());
    }
}
