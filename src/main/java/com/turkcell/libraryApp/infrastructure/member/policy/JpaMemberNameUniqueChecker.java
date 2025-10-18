package com.turkcell.libraryApp.infrastructure.member.policy;

import com.turkcell.libraryApp.domain.member.repository.MemberRepository;
import com.turkcell.libraryApp.domain.policy.MemberNameUniquePolicy;
import org.springframework.stereotype.Component;

@Component
public class JpaMemberNameUniqueChecker implements MemberNameUniquePolicy {
    private final MemberRepository memberRepository;

    public JpaMemberNameUniqueChecker(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public boolean isUnique(String name) {
        return !memberRepository.existsByNameIsIgnoreCase(name);
    }
}
