package com.example.mytoolkafka.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonRes {
    private int status;
    private String message;
    private Object data;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
