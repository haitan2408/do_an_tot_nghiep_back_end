package com.goruslan.socialgeeking.service.impl;

import com.goruslan.socialgeeking.DTO.UserUpdateDTO;
import com.goruslan.socialgeeking.domain.Post;
import com.goruslan.socialgeeking.domain.User;
import com.goruslan.socialgeeking.repository.CommentRepository;
import com.goruslan.socialgeeking.repository.PostRepository;
import com.goruslan.socialgeeking.repository.UserRepository;
import com.goruslan.socialgeeking.service.CommentService;
import com.goruslan.socialgeeking.service.PostService;
import com.goruslan.socialgeeking.service.RoleService;
import com.goruslan.socialgeeking.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private RoleService roleService;

    public void register(User user) {
        String secret = encoder.encode(user.getPassword());
        user.setPassword(secret);
        user.setConfirmPassword(secret);
        user.setEnabled(true);
        user.addRole(roleService.findByName("ROLE_USER"));
        user.setUrlImg("https://firebasestorage.googleapis.com/v0/b/do-an-tot-nghiep-b1345.appspot.com/o/avatar%2Favatar.jpg?alt=media&token=cb1c88e3-d058-448f-b441-c3d521cf98b0");
        userRepository.save(user);
        sendActivationEmail(user);
    }

    @Transactional
    public void saveUsers(User... users) {
        for (User user : users) {
            logger.info("Saving User: " + user.getEmail());
            userRepository.save(user);
        }
    }

    public void sendActivationEmail(User user) {
        // Send the email

    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmailAndEnabledIsTrue(email);
    }

    @Override
    public User getProfile(String email) {
        return this.findByEmail(email);
    }

    @Override
    public boolean changeImg(String email, String url) {
        String emailUser = ((org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        if (emailUser.equals(email)) {
            url = url.replace("avatar/", "avatar%2F");
            userRepository.updateImg(url, email);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateInformation(UserUpdateDTO user) {
        String emailUser = ((org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        if (user.getEmail().equals(emailUser)) {
            userRepository.updateInformation(user.getFullName(), user.getUsername(), user.getEducation(), user.getSkills(),
                    user.getExperience(), emailUser);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Page<User> getAllUserByAdmin(Pageable pageable, String search) {
        Page<User> users = userRepository.findAllByUsernameContainingOrEmailContainingOrEducationContainingOrFullNameContaining(pageable,
                search, search, search, search);
        return users;
    }

    @Override
    public boolean deleteUserByAdmin(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return false;
        } else {
            List<Post> postList = postService.findAllByUser(user);
            for(Post post: postList) {
                postService.deletePost(post.getId());
            }
            commentRepository.deleteByIdUser(id);
            userRepository.delete(user);
            return true;
        }
    }

    @Override
    public boolean lockOrUnlockUserByAdmin(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return false;
        } else {
            userRepository.lockOrUnlockUser(id, !(user.isEnabled()));
            return true;
        }
    }
}
