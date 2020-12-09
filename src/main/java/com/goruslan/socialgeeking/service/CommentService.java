package com.goruslan.socialgeeking.service;

import com.goruslan.socialgeeking.domain.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    void save(Comment comment, Long id);

    boolean deleteCommentByUser(Long id);

    boolean editComment(Comment comment);

    Page<Comment> getAllCommentByIdPostAdmin(Pageable pageable, Long idPost);

    void deleteCommentByAdmin(Long id);
}
