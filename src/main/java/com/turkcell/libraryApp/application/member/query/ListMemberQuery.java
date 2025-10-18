package com.turkcell.libraryApp.application.member.query;

import com.turkcell.libraryApp.application.member.dto.MemberResponse;
import com.turkcell.libraryApp.core.cqrs.Query;

import java.util.List;

public record ListMemberQuery(Integer pageIndex, Integer pageSize)
        implements Query<List<MemberResponse>> {

}
