package com.example.mytoolkafka.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserReq {
//    private Integer id;
    private String userName;
//    private String password;
//    private Integer old;

    @Override
    public String toString(){
        return "UserReq{" +
                ", name = " + userName + '\'' +
//                ", password = " + password + '\''+
                '}';
    }
}
