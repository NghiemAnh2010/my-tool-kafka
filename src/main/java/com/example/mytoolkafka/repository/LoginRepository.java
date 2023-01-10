package com.example.mytoolkafka.repository;

import com.example.mytoolkafka.entity.DtbLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LoginRepository extends JpaRepository<DtbLogin, UUID>, JpaSpecificationExecutor<DtbLogin> {
    List<DtbLogin> findAllByUsername(String username);
}
