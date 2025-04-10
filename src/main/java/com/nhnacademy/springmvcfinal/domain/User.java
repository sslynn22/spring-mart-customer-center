package com.nhnacademy.springmvcfinal.domain;

import lombok.Getter;
import lombok.Setter;

public class User {
    private static final String MASK = "*****";

    @Getter
    private final String id;

    @Getter
    private final String password;

    @Getter
    @Setter
    private String name;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public static User create(String id, String password) {
        return new User(id, password);
    }

    //  비밀번호를 마스킹한 새 User 객체를 생성
    public static User constructPasswordMaskedUser(User user) {
        User newUser = User.create(user.getId(), MASK);
        newUser.setName(user.getName());
        return newUser;
    }
}
