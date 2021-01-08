package com.wcs.checkpoint3.controller;

import com.wcs.checkpoint3.entity.Comment;
import com.wcs.checkpoint3.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://javangular-checkpoint3.jsrover.wilders.dev", maxAge = 3600)
@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> readAll() {
        return commentService.getComments();
    }

    @GetMapping("/{id}")
    public Comment read(Long id) {
        return commentService.getComment(id);
    }

    @PostMapping
    public ResponseEntity<Comment> create(@RequestBody Comment comment) throws Exception {
        Comment newComment = commentService.createComment(comment);
        return new ResponseEntity<Comment>(newComment, HttpStatus.OK);
    }

}
