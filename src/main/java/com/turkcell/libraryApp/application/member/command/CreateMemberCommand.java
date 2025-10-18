package com.turkcell.libraryApp.application.member.command;

import com.turkcell.libraryApp.application.member.dto.*;
import com.turkcell.libraryApp.core.cqrs.Command;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CreateMemberCommand(
        @NotBlank String name,
        @NotBlank String email,
        @NotBlank String phone,
        @NotBlank String address,
        @NotNull MemberShipLevelDto memberShipLevel,
        @NotNull MemberStatusDto memberStatus
)implements Command<CreatedMemberResponse> { }
