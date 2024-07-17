package com.example.smspr2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
//Id는 set하지 못하게 하기 위해서 @setter는 따로따로 지정
public class DefaultDomain {

    @Id
    private int id;
    @Setter private String title;
    @Setter private String author;
    @Setter private String content;

}
