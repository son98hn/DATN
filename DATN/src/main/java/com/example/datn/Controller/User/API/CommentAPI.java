//package com.example.datn.Controller.User.API;
//
//import com.example.datn.dto.CommentDTO;
//import com.example.datn.dto.NewDTO;
//import com.example.datn.entity.CommentEntity;
//import com.example.datn.entity.NewEntity;
//import com.example.datn.service.ICommentService;
//import com.example.datn.service.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import java.security.Principal;
//
//@RestController
//public class CommentAPI {
//
//    private final ICommentService commentService;
//
//    private final IUserService userService;
//
//    public CommentAPI(ICommentService commentService, IUserService userService) {
//        this.commentService = commentService;
//        this.userService = userService;
//    }
//
//    @PostMapping(value = "/api-user-comment", produces = "application/json;charset=UTF-8")
//        public CommentEntity createComment(@RequestBody CommentDTO model,
//                                           @RequestParam Long newId,
//                                           HttpServletRequest request, Principal principal) {
//            String userName = principal.getName();
//            model.setUserId(userService.findByUserName(userName).getId());
//            model.setNewsId(newId);
//            return commentService.save(model);
//        }
//
//        @PutMapping(value = "/api-user-comment", produces = "application/json;charset=UTF-8")
//        public CommentEntity updateComment(@RequestBody CommentDTO model, Principal principal) {
//            return commentService.save(model);
//        }
//
//        @DeleteMapping(value = "/api-user-comment", produces = "application/json;charset=UTF-8")
//        public void deleteComment(@RequestBody Long id) {
//            commentService.delete(id);
//        }
//    }
//
