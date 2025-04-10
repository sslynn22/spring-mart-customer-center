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

    @Getter
    private final Role role;

    public User(String id, String password, Role role) {
        this.id = id;
        this.password = password;
        this.role = role;
    }

    public static User create(String id, String password, Role role) {
        return new User(id, password, role);
    }

    //  비밀번호를 마스킹한 새 User 객체를 생성
    public static User constructPasswordMaskedUser(User user) {
        User newUser = User.create(user.getId(), MASK, user.getRole());
        newUser.setName(user.getName());
        return newUser;
    }
}
