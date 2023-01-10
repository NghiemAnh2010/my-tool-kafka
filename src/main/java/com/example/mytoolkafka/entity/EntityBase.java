package com.example.mytoolkafka.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DynamicInsert
public abstract class EntityBase implements Serializable {

    //  @Version
    @Column(columnDefinition = "integer default 0")
    private Integer version;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedBy
    private String createdUser;

    @LastModifiedBy
    private String updatedUser;

    @Builder.Default private boolean isDeleted = false;

    @PostPersist
    public void onPostPersist() {
        log.info("PostPersist: " + this.toString());
    }

    @PostUpdate
    public void onPostUpdate() {
        //    log.info("PostUpdate: " + this.toString());
    }

    @PostRemove
    public void onPostRemove() {
        log.info("PostRemove: " + this.toString());
    }
}
