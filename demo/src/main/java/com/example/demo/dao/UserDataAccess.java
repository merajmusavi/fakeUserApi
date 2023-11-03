package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("postgres")
public class UserDataAccess implements UserDao{
    @Override
    public int insertUser(UUID id, User user) {
        return 0;
    }

    @Override
    public int insertUser(User user) {
        return UserDao.super.insertUser(user);
    }

    @Override
    public List<User> selectAllUser() {
        return List.of(new User(UUID.randomUUID(),0,"from db"));
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteUserById(UUID id) {
        return 0;
    }

    @Override
    public int updateUserById(UUID id, User user) {
        return 0;
    }
}
