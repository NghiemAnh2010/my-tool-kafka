package com.example.mytoolkafka.logic;

import com.example.mytoolkafka.entity.DtbLogin;
import com.example.mytoolkafka.repository.LoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CheckLoginLogic {
    @Autowired private LoginRepository loginRepository;

    public void saveMessageLogin(String username){
        DtbLogin dtbLogin = new DtbLogin();
        dtbLogin.setUsername(username);
        loginRepository.save(dtbLogin);
    }
}
