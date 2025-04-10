package com.nhnacademy.springmvcfinal.repository;

import com.nhnacademy.springmvcfinal.domain.User;

import java.util.List;

public interface UserRepository {
    boolean exist(String id);

    boolean matches(String id, String password);

    List<User> getUser();

    User getUser(String id);
}
