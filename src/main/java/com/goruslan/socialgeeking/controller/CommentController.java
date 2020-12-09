package com.goruslan.socialgeeking.controller;

import com.goruslan.socialgeeking.domain.Comment;
import com.goruslan.socialgeeking.domain.Post;
import com.goruslan.socialgeeking.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{id}/comments")
    public ResponseEntity<Void> addComment(@PathVariable Long id, @Valid @RequestBody Comment comment) {
        try {
            commentService.save(comment, id);
            logger.info("New comment was saved.");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/comment/{id}")
    public ResponseEntity<Void> deleteCommentByUser(@PathVariable("id") Long id) {
        try {
            if (commentService.deleteCommentByUser(id)) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/comment")
    public ResponseEntity<Void> editComment(@Valid @RequestBody Comment comment) {
        try {
            if (commentService.editComment(comment)) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/admin/post/comment/{idPost}", params = {"page", "size"})
    public ResponseEntity<Page<Comment>> getAllCommentByIdPostAdmin(@RequestParam("page") int page,
                                                                    @RequestParam("size") int size,
                                                                    @PathVariable("idPost") Long idPost) {
        try {
            Page<Comment> comments = commentService.getAllCommentByIdPostAdmin(PageRequest.of(page, size, Sort.by("creationDate").descending()), idPost);
            if (comments.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(comments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/admin/post/comment/{id}")
    public ResponseEntity<Void> deleteCommentByAdmin(@PathVariable Long id) {
        try {
            this.commentService.deleteCommentByAdmin(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
