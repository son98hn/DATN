package com.example.datn.service;

import com.example.datn.dto.CommentDTO;
import com.example.datn.entity.CommentEntity;

import java.util.List;

public interface ICommentService {
    CommentEntity save(CommentDTO commentDTO);

    void delete(Long id);

    List<CommentEntity> findAllByNewEntityId(Long newId);
}
