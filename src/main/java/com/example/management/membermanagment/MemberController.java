package com.example.management.membermanagment;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    @GetMapping
    public ResponseEntity getMember() {

        List<MemberEntity> memberEntity = memberService.getMembers();
        if(memberService.getMembers() != null)
            return ResponseEntity.ok(memberEntity);
        else
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping
    public void addMember(@RequestBody MemberDto dto) {
        memberService.saveMembers(dto);
    }

    @PutMapping("/{id}")
    public void updateMember(@RequestBody MemberEntity memberEntity,@PathVariable Long id) {
        memberService.updateMember(memberEntity,id);
    }

    @GetMapping("/{id}")
    public MemberEntity getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }
}
