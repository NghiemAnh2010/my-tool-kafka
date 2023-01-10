package com.example.mytoolkafka.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
//    private Integer id;
    private String userName;
    private String password;
//    private Integer old;

    @Override
    public String toString(){
        return "User{" +
                ", name = " + userName + '\'' +
                ", password = " + password + '\''+
                '}';
    }
}
