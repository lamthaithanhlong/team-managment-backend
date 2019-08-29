package com.example.management.membermanagment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    List<MemberEntity> findAll();

    @Override
    <S extends MemberEntity> S save(S s);

    Optional<MemberEntity> findAllById(Long id);

}
