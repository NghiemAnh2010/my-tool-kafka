package com.example.mytoolkafka.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRes {
    private String username;
    private long numberLogin;
    @Override
    public String toString(){
        return "UserReq{" +
                ", username = " + username + '\'' +
                ", numberLogin = " + numberLogin + '\''+
                '}';
    }
}
