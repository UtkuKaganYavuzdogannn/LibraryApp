package com.turkcell.libraryApp.application.member.command;

import com.turkcell.libraryApp.application.member.dto.CreatedMemberResponse;
import com.turkcell.libraryApp.application.member.dto.MemberResponse;
import com.turkcell.libraryApp.application.member.mapper.CreateMemberMapper;
import com.turkcell.libraryApp.core.cqrs.CommandHandler;
import com.turkcell.libraryApp.domain.member.model.Member;
import com.turkcell.libraryApp.domain.member.repository.MemberRepository;
import com.turkcell.libraryApp.domain.policy.MemberNameUniquePolicy;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CreateMemberCommandHandler implements CommandHandler<CreateMemberCommand, CreatedMemberResponse> {

    private final MemberRepository memberRepository;
    private final CreateMemberMapper createMemberMapper;
    private final MemberNameUniquePolicy memberNameUniquePolicy;

    public CreateMemberCommandHandler(MemberRepository memberRepository, CreateMemberMapper createMemberMapper, MemberNameUniquePolicy memberNameUniquePolicy) {
        this.memberRepository = memberRepository;
        this.createMemberMapper = createMemberMapper;
        this.memberNameUniquePolicy = memberNameUniquePolicy;
    }

    @Override
    public CreatedMemberResponse handle(CreateMemberCommand command) {
        // iş kuralını burada yapıyoruz(app katmanında)
        if(!memberNameUniquePolicy.isUnique(command.name()))
            throw new IllegalArgumentException("Member name is not unique");
        Member member = createMemberMapper.toDomain(command);
        member = memberRepository.save(member);
        return createMemberMapper.toResponse(member);
    }
}
