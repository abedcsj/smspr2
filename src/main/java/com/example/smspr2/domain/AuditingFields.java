package com.example.smspr2.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@EntityListeners(AuditingEntityListener.class)
@Getter
@ToString
@MappedSuperclass
public abstract class AuditingFields {
    @Id
    private String id;

    @Column(nullable = false)@Setter
    protected String deleted;

    @Column(nullable = true)@Setter
    protected String process;

    @Column(nullable = false)@Setter
    @DateTimeFormat
    @CreatedDate
    protected LocalDateTime createdAt;

    @DateTimeFormat
    @LastModifiedDate
    @Column(nullable = false)@Setter
    protected LocalDateTime updatedAt;

    @DateTimeFormat
    @LastModifiedDate
    @Column(nullable = false)@Setter
    protected LocalDateTime modifiedAt;

}
