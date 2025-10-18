package com.turkcell.libraryApp.application.member.query;

import com.turkcell.libraryApp.application.member.dto.MemberResponse;
import com.turkcell.libraryApp.application.member.mapper.MemberResponseMapper;
import com.turkcell.libraryApp.core.cqrs.QueryHandler;
import com.turkcell.libraryApp.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListMemberQueryHandler implements QueryHandler<ListMemberQuery, List<MemberResponse>> {
    private final MemberRepository memberRepository;
    private final MemberResponseMapper memberResponseMapper;

    public ListMemberQueryHandler(MemberRepository memberRepository, MemberResponseMapper memberResponseMapper) {
        this.memberRepository = memberRepository;
        this.memberResponseMapper = memberResponseMapper;
    }

    @Override
    public List<MemberResponse> handle(ListMemberQuery query) {
        return memberRepository
                .findAllPaged(query.pageIndex(), query.pageSize())
                .stream()
                .map(memberResponseMapper::toResponse)
                .toList();
    }
}
