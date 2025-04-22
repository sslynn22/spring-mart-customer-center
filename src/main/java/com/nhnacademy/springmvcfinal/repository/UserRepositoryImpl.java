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
        User joo = User.create("joo", "0924", Role.CUSTOMER);
        joo.setName("주형");
        userMap.put("joo", joo);

        User seo = User.create("seo", "0202", Role.ADMIN);
        seo.setName("서인");
        userMap.put("seo", seo);

        User v = User.create("v", "1230", Role.CUSTOMER);
        v.setName("태형");
        userMap.put("v", v);
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
