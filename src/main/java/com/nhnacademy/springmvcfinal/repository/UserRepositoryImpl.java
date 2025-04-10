package com.nhnacademy.springmvcfinal.repository;

import com.nhnacademy.springmvcfinal.domain.Role;
import com.nhnacademy.springmvcfinal.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<String, User> userMap = new HashMap<>();

    public UserRepositoryImpl() {
        userMap.put("joo", User.create("joo", "0924", Role.CUSTOMER));
        userMap.put("seo", User.create("seo", "0202", Role.ADMIN));
        userMap.put("v", User.create("v", "1230", Role.CUSTOMER));
    }

    @Override
    public boolean exist(String id) {
        return userMap.containsKey(id);
    }

    @Override
    public boolean matches(String id, String password) {
        return Optional.ofNullable(getUser(id))
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }

    @Override
    public List<User> getUser() {
        return userMap.values().stream().toList();
    }

    @Override
    public User getUser(String id) {
        return userMap.get(id);
    }
}
