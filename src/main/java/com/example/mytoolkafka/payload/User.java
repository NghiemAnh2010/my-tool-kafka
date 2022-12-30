package com.example.mytoolkafka.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private Integer id;
    private String name;
    private Integer old;

    @Override
    public String toString(){
        return "User{" +
                "id=" + id +
                ", name = " + name + '\'' +
                ", old = " + old + '\''+
                '}';
    }
}
