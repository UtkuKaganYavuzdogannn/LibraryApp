package com.turkcell.libraryApp.application.member.mapper;

import com.turkcell.libraryApp.application.member.command.CreateMemberCommand;
import com.turkcell.libraryApp.application.member.dto.CreatedMemberResponse;
import com.turkcell.libraryApp.application.member.dto.MemberShipLevelDto;
import com.turkcell.libraryApp.application.member.dto.MemberStatusDto;
import com.turkcell.libraryApp.domain.member.model.*;
import org.springframework.stereotype.Component;

@Component
public class CreateMemberMapper {
    public Member toDomain(CreateMemberCommand command){

        MemberShipLevel level = MemberShipLevel.valueOf(command.memberShipLevel().name());
        MemberStatus status = MemberStatus.valueOf(command.memberStatus().name());

        return Member.create(
               new Name(command.name()),
               new Email(command.email()),
               new Phone(command.phone()),
               new Address(command.address()),
               level,
               status
        );
    }
    public CreatedMemberResponse toResponse(Member member){


        var levelDto  = MemberShipLevelDto.valueOf(member.memberShipLevel().name());
        var statusDto = MemberStatusDto.valueOf(member.memberStatus().name());
        return new CreatedMemberResponse(
                member.id().value(),
                member.name().value(),
                member.email().value(),
                member.phone().value(),
                member.address().value(),
                levelDto,
                statusDto
        );
    }
}
