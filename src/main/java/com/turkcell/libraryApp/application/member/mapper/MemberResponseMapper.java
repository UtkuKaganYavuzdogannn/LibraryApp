package com.turkcell.libraryApp.application.member.mapper;

import com.turkcell.libraryApp.application.member.dto.MemberResponse;
import com.turkcell.libraryApp.application.member.dto.MemberShipLevelDto;
import com.turkcell.libraryApp.application.member.dto.MemberStatusDto;
import com.turkcell.libraryApp.domain.member.model.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberResponseMapper {
    public MemberResponse toResponse(Member member){

        // domain enumu -> dto enuma
        MemberShipLevelDto memberShipLevelDto = MemberShipLevelDto.valueOf(member.memberShipLevel().name());

        // domain sttusu -> dto statusa
        MemberStatusDto memberStatusDto = MemberStatusDto.valueOf(member.memberStatus().name());

        return new MemberResponse(
                member.id().value(),
                member.name().value(),
                member.email().value(),
                member.phone().value(),
                member.address().value(),
                memberShipLevelDto,
                memberStatusDto
        );
    }
}
