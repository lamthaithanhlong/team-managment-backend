package com.example.management.membermanagment;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class MemberService {
    private MemberRepository memberRepository;

    public List<MemberEntity> getMembers() {
        return memberRepository.findAll();
    }
}
