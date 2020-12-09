package com.goruslan.socialgeeking.service;


import com.goruslan.socialgeeking.domain.Post;
import com.goruslan.socialgeeking.domain.User;
import com.goruslan.socialgeeking.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {

   List<Post> findAll();

   Optional<Post> findById(Long id);

   Post save(Post post);

   Page<Post> getAllPostByAdmin(Pageable pageable, String search);

   void deletePost(Long id);

    boolean editPost(Post post);

    List<Post> findAllByUser(User user);

    boolean deletePostByUser(Long id);
}
