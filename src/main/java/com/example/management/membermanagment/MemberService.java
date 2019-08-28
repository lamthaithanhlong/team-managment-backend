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

    public void saveMembers(MemberDto memberDto) { memberRepository.save(toEntity(memberDto));}

    private MemberEntity toEntity(MemberDto memberDto ) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setName(memberDto.getName());
        memberEntity.setAge(memberDto.getAge());
        memberEntity.setAbility(memberDto.getAbility());
        return memberEntity;
    };
}
