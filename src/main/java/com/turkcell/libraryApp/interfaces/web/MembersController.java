package com.turkcell.libraryApp.interfaces.web;

import com.turkcell.libraryApp.application.member.command.CreateMemberCommand;
import com.turkcell.libraryApp.application.member.dto.CreatedMemberResponse;
import com.turkcell.libraryApp.application.member.dto.MemberResponse;
import com.turkcell.libraryApp.application.member.query.ListMemberQuery;
import com.turkcell.libraryApp.core.cqrs.CommandHandler;
import com.turkcell.libraryApp.core.cqrs.QueryHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/members")
public class MembersController {
    private final QueryHandler<ListMemberQuery, List<MemberResponse>> listMemberQueryHandler;
    private final CommandHandler<CreateMemberCommand, CreatedMemberResponse> createMemberCommandHandler;

    public MembersController(QueryHandler<ListMemberQuery, List<MemberResponse>> listMemberQueryHandler, CommandHandler<CreateMemberCommand, CreatedMemberResponse> createMemberCommandHandler) {
        this.listMemberQueryHandler = listMemberQueryHandler;
        this.createMemberCommandHandler = createMemberCommandHandler;
    }
    @GetMapping
    public List<MemberResponse> getMembers(ListMemberQuery query){
        return listMemberQueryHandler.handle(query);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedMemberResponse createMember(@Valid @RequestBody CreateMemberCommand command){
        return createMemberCommandHandler.handle(command);
    }
}
