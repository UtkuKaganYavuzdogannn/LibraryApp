package com.turkcell.libraryApp.domain.member.repository;

import com.turkcell.libraryApp.domain.member.model.Member;
import com.turkcell.libraryApp.domain.member.model.MemberId;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(MemberId memberId);
    List<Member> findAll();
    List<Member> findAllPaged(Integer pageIndex, Integer pageSize);
    void delete(MemberId memberId);

    // policyler için
    boolean existsByNameIsIgnoreCase(String name);
}
