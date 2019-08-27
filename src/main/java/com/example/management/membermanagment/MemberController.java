package com.example.management.membermanagment;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    @GetMapping
    public List<MemberEntity> getMember() {
        return memberService.getMembers();
    }
}
