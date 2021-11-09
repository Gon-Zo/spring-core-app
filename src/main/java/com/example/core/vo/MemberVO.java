package com.example.core.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {

    @Setter
    private String name;

    @Setter
    private String nickName;

    @Autowired
    @Qualifier("printA")
    private Print print;

    public String getPrint() {
        return print.sout();
    }

    public MemberVO(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
    }

}
