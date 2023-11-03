package com.example.demo.dao;

import com.example.demo.model.User;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class UserDataAccess implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertUser(UUID id, User user) {
        return 0;
    }

    @Override
    public int insertUser(User user) {
        return UserDao.super.insertUser(user);
    }

    @Override


    @Override
    public List<User> selectAllUser() {
        final String select = "SELECT id, age, name FROM user";

        List<User> users = jdbcTemplate.query(select, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            int age = resultSet.getInt("age");
            String name = resultSet.getString("name");
            return new User(id, age, name);
        });

        return users;
    }


    @Override
    public Optional<User> selectUserById(UUID id) {
        String selectUserById = "SELECT id, name, age FROM users WHERE id = ?";

        User user = jdbcTemplate.queryForObject(selectUserById, new Object[] { id }, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("id"));
            int age = resultSet.getInt("age");
            String name = resultSet.getString("name");
            return new User(userId, age, name);
    }

    @Override
    public int deleteUserById(UUID id) {
            String deleteSql = "DELETE FROM users WHERE id = ?";

            int rowsAffected = jdbcTemplate.update(deleteSql, id.toString());

            if (rowsAffected == 0) {
                // Handle the case where no user was deleted (e.g., user not found).
                // You can throw an exception or perform other appropriate error handling.
            }
    }

    @Override
    public int updateUserById(UUID id, User user) {
        return 0;
    }
}
