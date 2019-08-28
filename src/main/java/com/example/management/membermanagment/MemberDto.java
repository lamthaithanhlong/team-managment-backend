package com.example.management.membermanagment;

import lombok.Data;

@Data
public class MemberDto {
    private Long id;
    private String name;
    private int age;
    private String ability;
}
