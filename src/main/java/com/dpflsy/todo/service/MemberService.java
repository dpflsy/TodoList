package com.dpflsy.todo.service;

import com.dpflsy.todo.domain.Member;
import com.dpflsy.todo.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    // 아이디 중복 여부 (중복 O - true, 중복 X - false)
    public boolean getId(Member member) {
        int n = memberMapper.getId(member);
        return n > 0;
    }

    // 회원 등록 성공 여부 (등록 O - true, 등록 X - false)
    public boolean insertMember(Member member) {
        int n = memberMapper.insertMember(member);
        return n > 0;
    }

    // DB로부터 로그인한 유저의 모든 정보를 가져옴 - Member형태를 반환형으로 지정
    public Member login(Member member) {
        return memberMapper.login(member);
    }



}
