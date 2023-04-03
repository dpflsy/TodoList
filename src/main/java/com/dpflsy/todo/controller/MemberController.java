package com.dpflsy.todo.controller;

import com.dpflsy.todo.domain.Member;
import com.dpflsy.todo.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/member")
@RestController
public class MemberController {
    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping("/getId")
    public String getId(Member member) {
        System.out.println("MemberController - getId");
        boolean boo = service.getId(member);

        // 아이디 중복
        if(boo) {
            return "no";
        }
        return "ok";
    }

    @PostMapping("/insertMember")
    public String insertMember(Member member) {
        System.out.println("MemberController - insert member");
        boolean boo = service.insertMember(member);
        // 회원가입 완료
        if(boo) {
            return "ok";
        }

        return "no";
    }

    @PostMapping("/login")
    public Member login(Member member) {
        System.out.println("MemberController - login");
        return service.login(member);
    }


}
