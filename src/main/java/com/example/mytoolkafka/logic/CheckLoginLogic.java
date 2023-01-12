package com.example.mytoolkafka.logic;

import com.example.mytoolkafka.dto.CommonRes;
import com.example.mytoolkafka.entity.DtbLogin;
import com.example.mytoolkafka.payload.UserReq;
import com.example.mytoolkafka.payload.UserRes;
import com.example.mytoolkafka.repository.LoginRepository;
import lombok.experimental.Helper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class CheckLoginLogic {
    @Autowired private LoginRepository loginRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    public void saveMessageLogin(String username){
        DtbLogin dtbLogin = new DtbLogin();
        dtbLogin.setUsername(username);
        loginRepository.save(dtbLogin);
    }

    public ResponseEntity<List<UserRes>> getAllNumberLoginUser(){
        // 1 Là phải lấy ra được tất cả các username có số lần login > 2
        // 2 Phải sắp xếp các
        List<UserRes> userRes = loginRepository.findAllByNubmerLogin();
//        List<UserRes> userRes =
//                dtbLoginList.stream()
//                            .map(
//                                    username -> {
//                                        UserRes userRes1 = new UserRes();
//                                        modelMapper.map(username,userRes1);
//                                        return userRes1;
//                                    }
//                            )
//                .collect(Collectors.toList());
        return ResponseEntity.ok(userRes);
    }
}
