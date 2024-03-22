package com.example.project.DAO.User;


import com.example.project.Entity.User;

import java.util.List;

public interface UserDAO {
    void save(User user);
    User findById(int id);
//    List<User> getAll();
    User findByNameOrEmail(String name, String email);
    User getByEmail(String email);

    int deleteUser(int id);

    List<User> findAllUsers();
}
