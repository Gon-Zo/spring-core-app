package com.example.core.config;

import com.example.core.vo.MemberVO;
import com.example.core.vo.PrintA;
import com.example.core.vo.PrintB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfiguration {

    @Bean
    public MemberVO memberVO() {
        MemberVO memberVO = new MemberVO();
        memberVO.setName("릴보이");
        memberVO.setNickName("작은거인");
        return memberVO;
    }

    @Bean(name = "hello")
    public MemberVO memberVO1() {
        return new MemberVO("페노메코", "페노메코1");
    }

    @Bean
    public PrintA printA() {
        return new PrintA();
    }

    @Bean
    public PrintB printB() {
        return new PrintB();
    }

}
