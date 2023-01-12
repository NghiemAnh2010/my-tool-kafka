package com.example.mytoolkafka.repository;

import com.example.mytoolkafka.entity.DtbLogin;
import com.example.mytoolkafka.payload.UserRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LoginRepository extends JpaRepository<DtbLogin, UUID> {
    List<DtbLogin> findAllByUsername(String username);
//    List<DtbLogin> findAllBy
    @Query(value = "SELECT new com.example.mytoolkafka.payload.UserRes(e.username,count (e.username)) FROM DtbLogin e GROUP BY e.username HAVING count(e.username) > 1")
    List<UserRes> findAllByNubmerLogin();
}
