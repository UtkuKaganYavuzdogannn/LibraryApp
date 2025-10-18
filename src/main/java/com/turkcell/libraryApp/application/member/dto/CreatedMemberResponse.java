package com.turkcell.libraryApp.application.member.dto;

import java.util.UUID;

public record CreatedMemberResponse(UUID id,
                                    String name,
                                    String email,
                                    String phone,
                                    String address,
                                    MemberShipLevelDto memberShipLevel,
                                    MemberStatusDto memberStatus){
}
