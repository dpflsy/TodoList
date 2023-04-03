package com.dpflsy.todo.mapper;

import com.dpflsy.todo.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

// DAO
@Mapper
@Repository
public interface MemberMapper {
    int getId(Member member);
    int insertMember(Member member);
    Member login(Member member);
}
