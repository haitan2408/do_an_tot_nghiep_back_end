package com.goruslan.socialgeeking.controller;

import com.goruslan.socialgeeking.domain.Comment;
import com.goruslan.socialgeeking.domain.Post;
import com.goruslan.socialgeeking.repository.CommentRepository;
import com.goruslan.socialgeeking.repository.PostRepository;
import com.goruslan.socialgeeking.service.CommentService;
import com.goruslan.socialgeeking.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public ResponseEntity<List<Post>> listPost() {
        try {
            List<Post> postList = postService.findAll();
            if (postList.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(postList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Post> readPostById(@PathVariable Long id) {
        try {
            Optional<Post> post = postService.findById(id);
                if (post.isPresent()) {
                    Collections.sort(post.get().getComments());
                return new ResponseEntity<>(post.get(),HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/post/submit")
    public ResponseEntity<Void> createPost(@Valid @RequestBody Post post) {
        try {
            postService.save(post);
            logger.info("New Post was saved successfully.");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    @GetMapping(value = "/admin/post",  params = {"page", "size", "search"})
    public ResponseEntity<Page<Post>> getAllPostByAdmin(@RequestParam("page") int page,
                                                                    @RequestParam("size") int size,
                                                                    @RequestParam("search") String search) {
        try {
            Page<Post> posts = postService.getAllPostByAdmin(PageRequest.of(page, size), search);
            if (posts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(posts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping(value = "/admin/post/{id}")
    public ResponseEntity<Void> deletePostByAdmin(@PathVariable("id") Long id) {
        try {
            postService.deletePost(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/post/{id}")
    public ResponseEntity<Void> deletePostByUser(@PathVariable("id") Long id) {
        try {
            if(postService.deletePostByUser(id)){
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/post")
    public ResponseEntity<Void> editPost(@Valid @RequestBody Post post) {
        try {
            if(postService.editPost(post)) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
