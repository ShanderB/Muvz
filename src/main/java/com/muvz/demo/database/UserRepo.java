package com.muvz.demo.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.muvz.demo.entitiy.User;

public interface UserRepo extends JpaRepository<User, Long>{
    User findByName(String name);
    List<User> findByNameOrderByNameDesc(String name);
    List<User> findAllByOrderByNameDesc();
}
