package com.example.smspr2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Entity
@Getter
@ToString
public class AuditingFields {
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

}
