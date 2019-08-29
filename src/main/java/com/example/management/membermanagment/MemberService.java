package com.example.management.membermanagment;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<MemberEntity> updateMember(MemberEntity memberEntity, @PathVariable Long id) {
        Optional<MemberEntity> MemberOptional = memberRepository.findAllById(id);
        if(!MemberOptional.isPresent())
            return ResponseEntity.notFound().build();

        memberEntity.setId(id);
        memberRepository.save(memberEntity);
        return ResponseEntity.noContent().build();
    }

    public MemberEntity getMemberById(Long id) {
        Optional<MemberEntity> MemberOptional = memberRepository.findAllById(id);
        return MemberOptional.orElseThrow(() -> new MemberNotFoundException("Couldn't find a Dog with id: " + id));
    }
}
