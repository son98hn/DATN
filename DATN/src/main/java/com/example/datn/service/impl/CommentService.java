package com.example.datn.service.impl;

import com.example.datn.dto.CommentDTO;
import com.example.datn.entity.CommentEntity;
import com.example.datn.repository.CommentReponsitory;
import com.example.datn.repository.NewRepository;
import com.example.datn.repository.UserRepository;
import com.example.datn.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentReponsitory commentReponsitory;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NewRepository newRepository;

    @Override
    public CommentEntity save(CommentDTO commentDTO) {
        if(commentDTO.getId()!=null){
            CommentEntity oldCommentEntity = commentReponsitory.findById(commentDTO.getId()).get();
            oldCommentEntity.setContent(commentDTO.getContent());
            oldCommentEntity.setModifiedDate(new Timestamp(System.currentTimeMillis()));
            commentReponsitory.save(oldCommentEntity);
            return commentReponsitory.findById(oldCommentEntity.getId()).get();
        }
        else{
            CommentEntity commentEntity = new CommentEntity();
            commentEntity.setContent(commentDTO.getContent());
            commentEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
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
