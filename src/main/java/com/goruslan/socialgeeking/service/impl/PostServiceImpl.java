package com.goruslan.socialgeeking.service.impl;

import com.goruslan.socialgeeking.domain.Post;
import com.goruslan.socialgeeking.repository.CommentRepository;
import com.goruslan.socialgeeking.repository.PostRepository;
import com.goruslan.socialgeeking.service.PostService;
import com.goruslan.socialgeeking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserService userService;

    public List<Post> findAll() {
        return postRepository.findAllOderByCreationDate();
    }

    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    public Post save(Post post) {
        post.setUser(userService.findByEmail(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()));
        return postRepository.save(post);
    }

    @Override
    public Page<Post> getAllPostByAdmin(Pageable pageable, String search) {
        Page<Post> posts = postRepository.findAllByTitleContainingOrContentContainingOrUser_UsernameContainingOrderByCreationDateDesc(pageable,
                search, search, search);
        return posts;
    }

    @Override
    public void deletePost(Long id) {
        commentRepository.deleteAllByPost_Id(id);
        postRepository.deleteById(id);
    }

    @Override
    public boolean editPost(Post post) {
        Post temp = postRepository.findById(post.getId()).orElse(null);
        if (post.getId() == null || temp == null) {
            return false;
        } else {
            if (userService.findByEmail(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()).getEmail() != temp.getUser().getEmail()) {
                return false;
            } else {
                temp.setTitle(post.getTitle());
                temp.setContent(post.getContent());
                postRepository.save(temp);
                return true;
            }
        }
    }

    @Override
    public List<Post> findAllByUser(com.goruslan.socialgeeking.domain.User user) {
        return this.postRepository.findAllByUser_Email(user.getEmail());
    }

    @Override
    public boolean deletePostByUser(Long id) {
        String email = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        Post post = postRepository.findById(id).orElse(null);
        if (email.equals(post.getUser().getEmail())) {
            commentRepository.deleteAllByPost_Id(id);
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
