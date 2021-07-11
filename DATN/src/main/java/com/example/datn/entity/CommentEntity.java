package com.example.datn.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "newsid")
    private NewEntity newEntity;
    @Column(name = "content")
    private String content;
    @Column(name = "createddate")
    private Date createdDate;

    @Column(name = "modifieddate")
    private Date modifiedDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public NewEntity getNewEntity() {
        return newEntity;
    }

    public void setNewEntity(NewEntity newEntity) {
        this.newEntity = newEntity;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
