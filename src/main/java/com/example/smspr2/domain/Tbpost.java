package com.example.smspr2.domain;

import com.example.smspr2.dto.TbpostDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Getter
@Table(indexes = {
        @Index(columnList = "deleted")
        ,@Index(columnList = "process")
        ,@Index(columnList = "createdAt")
        ,@Index(columnList = "modifiedAt")
})
@Entity
public class Tbpost extends AuditingFields{

    @Setter @Column (nullable = false,length=400)private String title;
    @Setter @Column (nullable=false,length=400) private String author;
    @Setter @Column(nullable = false,length=4000) String content;

    private Tbpost(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    protected Tbpost() {
    }

    public static Tbpost of(String title, String author, String content) {
        return new Tbpost(title, author, content);
    }
    public TbpostDto.CreateResDto toCreateResDto() {
        TbpostDto.CreateResDto create = new TbpostDto.CreateResDto();
        create.setId(create.getId());
        return create;
    }


}
