package com.example.core.web;

import com.example.core.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/start")
public class StartResource {

    private final ApplicationContext context;

    private final MemberVO hello;

    private final MemberVO memberVO;

    @GetMapping("")
    public String showByWebStart() {
        return "SUCCESS";
    }

    @GetMapping("/test1")
    public MemberVO showByMember() {
        return context.getBean("memberVO", MemberVO.class);
    }

    @GetMapping("/test2")
    public MemberVO showByPrint() {
        return hello;
    }

    @GetMapping("/test3")
    public boolean checkByBean() {
        MemberVO beanMemberVO = context.getBean("memberVO", MemberVO.class);
        return beanMemberVO.equals(memberVO);
    }

}
