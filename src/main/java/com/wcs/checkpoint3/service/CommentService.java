package com.wcs.checkpoint3.service;

import com.wcs.checkpoint3.entity.Comment;
import com.wcs.checkpoint3.entity.Post;
import com.wcs.checkpoint3.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Comment getComment(Long id) {
        return commentRepository.findById(id).get();
    }

    public Comment createComment(Comment comment) throws Exception {
        try {
            Comment newComment = new Comment();
        }
    }
}
