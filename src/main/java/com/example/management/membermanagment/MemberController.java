package com.example.management.membermanagment;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/members")
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    @GetMapping
    public ResponseEntity<?> getMember() {
        if(memberService.getMembers() != null)
            return new ResponseEntity<>(memberService.getMembers(), HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping
    public void addMember(@RequestBody MemberDto dto) {
        memberService.saveMembers(dto);
    }
}
