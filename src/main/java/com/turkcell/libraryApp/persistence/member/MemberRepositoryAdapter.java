package com.turkcell.libraryApp.persistence.member;

import com.turkcell.libraryApp.domain.member.model.Member;
import com.turkcell.libraryApp.domain.member.model.MemberId;
import com.turkcell.libraryApp.domain.member.repository.MemberRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryAdapter implements MemberRepository {
    private final JpaMemberRepository jpaMemberRepository;
    private final MemberEntityMapper memberEntityMapper;

    public MemberRepositoryAdapter(JpaMemberRepository jpaMemberRepository, MemberEntityMapper memberEntityMapper) {
        this.jpaMemberRepository = jpaMemberRepository;
        this.memberEntityMapper = memberEntityMapper;
    }


    @Override
    public Member save(Member member) {

        //Member -JpaMemberEntity mapping
        JpaMemberEntity entity = memberEntityMapper.toEntity(member);

        // veritabına kaydet
        entity = this.jpaMemberRepository.save(entity);

        //kaydedilen yapıyı memberde geri maple return
        return memberEntityMapper.toDomain(entity);
    }

    @Override
    public Optional<Member> findById(MemberId memberId) {
        return jpaMemberRepository.findById(memberId.value()).map(memberEntityMapper::toDomain);
    }

    @Override
    public List<Member> findAll() {
        return jpaMemberRepository.findAll()
                .stream()
                .map(memberEntityMapper::toDomain)
                .toList();
    }

    @Override
    public List<Member> findAllPaged(Integer pageIndex, Integer pageSize) {
        return jpaMemberRepository.findAll(PageRequest.of(pageIndex,pageSize))
                .stream().map(memberEntityMapper::toDomain)
                .toList();
    }

    @Override
    public void delete(MemberId memberId) {
        jpaMemberRepository.deleteById(memberId.value());
    }

    @Override
    public boolean existsByNameIsIgnoreCase(String name) {
        return jpaMemberRepository.existsByNameIsIgnoreCase(name);
    }




}
