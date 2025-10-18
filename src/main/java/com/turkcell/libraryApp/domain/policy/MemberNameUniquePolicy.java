package com.turkcell.libraryApp.domain.policy;

import org.springframework.stereotype.Repository;


public interface MemberNameUniquePolicy {
    boolean isUnique(String name);
}
