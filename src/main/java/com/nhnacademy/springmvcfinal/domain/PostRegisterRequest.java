package com.nhnacademy.springmvcfinal.domain;

import lombok.Value;

@Value
public class PostRegisterRequest {
    String title;
    String content;
    PostCategory category;
}
