package com.example.mytoolkafka.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRes {
    private String userName;
    private String password;

    @Override
    public String toString(){
        return "User{" +
                ", name = " + userName + '\'' +
                ", password = " + password + '\''+
                '}';
    }
}
