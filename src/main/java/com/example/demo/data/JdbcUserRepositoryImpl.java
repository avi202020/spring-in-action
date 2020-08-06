package com.example.demo.data;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.UUID;

@Repository
public class JdbcUserRepositoryImpl implements UserRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcUserRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<User> findAll() {
        return jdbc.query("SELECT id, name, permissions from users", this::mapRowToUser);
    }

    @Override
    public User findOne(String name) {
        return jdbc.queryForObject(
                "SELECT id, name, permissions from users where name=?",
                this::mapRowToUser,
                name);
    }


    @Override
    public void save(User user) {
        jdbc.update(
                "insert into users (id,name,permissions) values (?,?,?)",
                user.getId(),
                user.getName(),
                user.getPermissions().toString()
        );
    }

    private User mapRowToUser(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                UUID.fromString(rs.getString("id")),
                rs.getString("name"),
                User.Permissions.valueOf(rs.getString("permissions"))
        );
    }
}
