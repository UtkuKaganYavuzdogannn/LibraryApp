package com.turkcell.libraryApp.persistence.member;

import com.turkcell.libraryApp.domain.member.model.*;
import org.springframework.stereotype.Component;

@Component
public class MemberEntityMapper {
    public JpaMemberEntity toEntity(Member member){
        JpaMemberEntity memberEntity = new JpaMemberEntity();

        memberEntity.setId(member.id().value());
        memberEntity.setName(member.name().value());
        memberEntity.setEmail(member.email().value());
        memberEntity.setPhone(member.phone().value());
        memberEntity.setAddress(member.address().value());
        memberEntity.setMemberShipLevel(member.memberShipLevel());
        memberEntity.setMemberStatus(member.memberStatus());
        return memberEntity;
    }
    public Member toDomain(JpaMemberEntity entity){
        return Member.rehydrate(
                new MemberId(entity.id()),
                new Name(entity.name()),
                new Email(entity.email()),
                new Phone(entity.phone()),
                new Address(entity.address()),
                entity.memberShipLevel(),
                entity.memberStatus()
        );
    }
}
