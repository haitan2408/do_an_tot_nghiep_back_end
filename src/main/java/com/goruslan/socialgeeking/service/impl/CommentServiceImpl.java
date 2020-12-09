package com.goruslan.socialgeeking.service.impl;

import com.goruslan.socialgeeking.domain.Comment;
import com.goruslan.socialgeeking.domain.Post;
import com.goruslan.socialgeeking.repository.CommentRepository;
import com.goruslan.socialgeeking.repository.PostRepository;
import com.goruslan.socialgeeking.repository.UserRepository;
import com.goruslan.socialgeeking.service.CommentService;
import com.goruslan.socialgeeking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    @Override
    public void save(Comment comment, Long id) {
        Optional<Post> post = postRepository.findById(id);
        comment.setPost(post.get());
        comment.setUser(userService.findByEmail(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()));
        commentRepository.save(comment);
    }

    @Override
    public boolean deleteCommentByUser(Long id) {
        String email = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        Comment comment = commentRepository.findById(id).orElse(null);
        if (email.equals(comment.getUser().getEmail())) {
            commentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean editComment(Comment comment) {
        Comment temp = commentRepository.findById(comment.getId()).orElse(null);
        if (comment.getId() == null || temp == null) {
            return false;
        } else {
            if (userService.findByEmail(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()).getEmail() != temp.getUser().getEmail()) {
                return false;
            } else {
                temp.setBody(comment.getBody());
                commentRepository.save(temp);
                return true;
            }
        }
    }

    @Override
    public Page<Comment> getAllCommentByIdPostAdmin(Pageable pageable, Long idPost) {
        return commentRepository.findAllByPost_Id(idPost,pageable);
    }

    @Override
    public void deleteCommentByAdmin(Long id) {
        this.commentRepository.deleteById(id);
    }
}
