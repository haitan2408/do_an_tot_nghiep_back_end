package com.goruslan.socialgeeking.service;

import com.goruslan.socialgeeking.DTO.UserUpdateDTO;
import com.goruslan.socialgeeking.domain.User;
import com.goruslan.socialgeeking.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserService {

   void register(User user);

    void saveUsers(User... users);

   void sendActivationEmail(User user);

    User findByEmail(String email);

    User getProfile(String email);

    boolean changeImg(String email, String url);

    boolean updateInformation(UserUpdateDTO user);

    Page<User> getAllUserByAdmin(Pageable pageable, String search);

    boolean deleteUserByAdmin(Long id);

    boolean lockOrUnlockUserByAdmin(Long id);
}
