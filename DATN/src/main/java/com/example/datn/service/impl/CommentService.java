//package com.example.datn.service.impl;
//
//import com.example.datn.dto.CommentDTO;
//import com.example.datn.entity.CommentEntity;
//import com.example.datn.repository.CommentRepository;
//import com.example.datn.repository.NewRepository;
//import com.example.datn.repository.UserRepository;
//import com.example.datn.service.ICommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class CommentService implements ICommentService {
//
//    private CommentRepository commentRepository;
//
//    private UserRepository userRepository;
//
//    private NewRepository newRepository;
//
//    public CommentService(CommentRepository commentReponsitory) {
//        this.commentRepository = commentRepository;
//    }
//
//    @Autowired
//    public CommentService(UserRepository userRepository, NewRepository newRepository) {
//        this.userRepository = userRepository;
//        this.newRepository = newRepository;
//    }
//
//    @Override
//    public CommentEntity save(CommentDTO commentDTO) {
//        if(commentDTO.getId()!=null){
//            CommentEntity oldCommentEntity = commentRepository.findById(commentDTO.getId()).get();
//            oldCommentEntity.setContent(commentDTO.getContent());
//            oldCommentEntity.setModifiedDate(LocalDateTime.now());
//            commentRepository.save(oldCommentEntity);
//            return commentRepository.findById(oldCommentEntity.getId()).get();
//        }
//        else{
//            CommentEntity commentEntity = new CommentEntity();
//            commentEntity.setContent(commentDTO.getContent());
//            commentEntity.setCreatedDate(LocalDateTime.now());
//            commentEntity.setNewEntity(newRepository.findById(commentDTO.getNewsId()).get());
//            commentEntity.setUserEntity(userRepository.findById(commentDTO.getUserId()).get());
//            commentRepository.save(commentEntity);
//            return commentRepository.findById(commentEntity.getId()).get();
//        }
//    }
//
//    @Override
//    public void delete(Long id) {
//        commentRepository.deleteById(id);
//    }
//
//    @Override
//    public List<CommentEntity> findAllByNewEntityId(Long newId) {
//        return commentRepository.findAllByNewEntityId(newId);
//    }
//}
