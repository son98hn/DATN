package com.example.datn.service.impl;

import com.example.datn.dto.CommentDTO;
import com.example.datn.entity.CommentEntity;
import com.example.datn.repository.CommentReponsitory;
import com.example.datn.repository.NewRepository;
import com.example.datn.repository.UserRepository;
import com.example.datn.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService implements ICommentService {

    private CommentReponsitory commentReponsitory;

    private UserRepository userRepository;

    private NewRepository newRepository;

    public CommentService(CommentReponsitory commentReponsitory) {
        this.commentReponsitory = commentReponsitory;
    }

    @Autowired
    public CommentService(UserRepository userRepository, NewRepository newRepository) {
        this.userRepository = userRepository;
        this.newRepository = newRepository;
    }

    @Override
    public CommentEntity save(CommentDTO commentDTO) {
        if(commentDTO.getId()!=null){
            CommentEntity oldCommentEntity = commentReponsitory.findById(commentDTO.getId()).get();
            oldCommentEntity.setContent(commentDTO.getContent());
            oldCommentEntity.setModifiedDate(LocalDateTime.now());
            commentReponsitory.save(oldCommentEntity);
            return commentReponsitory.findById(oldCommentEntity.getId()).get();
        }
        else{
            CommentEntity commentEntity = new CommentEntity();
            commentEntity.setContent(commentDTO.getContent());
            commentEntity.setCreatedDate(LocalDateTime.now());
            commentEntity.setNewEntity(newRepository.findById(commentDTO.getNewsId()).get());
            commentEntity.setUserEntity(userRepository.findById(commentDTO.getUserId()).get());
            commentReponsitory.save(commentEntity);
            return commentReponsitory.findById(commentEntity.getId()).get();
        }
    }

    @Override
    public void delete(Long id) {
        commentReponsitory.deleteById(id);
    }

    @Override
    public List<CommentEntity> findAllByNewEntityId(Long newId) {
        return commentReponsitory.findAllByNewEntityId(newId);
    }
}
