package com.goruslan.socialgeeking.controller;

import com.goruslan.socialgeeking.DTO.JwtResponse;
import com.goruslan.socialgeeking.DTO.UpdatePassword;
import com.goruslan.socialgeeking.DTO.UserDTO;
import com.goruslan.socialgeeking.DTO.UserUpdateDTO;
import com.goruslan.socialgeeking.Security.JwtTokenUtil;
import com.goruslan.socialgeeking.Security.UserDetailsServiceImpl;
import com.goruslan.socialgeeking.domain.Post;
import com.goruslan.socialgeeking.domain.User;
import com.goruslan.socialgeeking.service.PostService;
import com.goruslan.socialgeeking.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private UserService userService;

    @Autowired(required = false)
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired(required = false)
    private UserDetailsServiceImpl userServiceImpl;

    @Autowired
    private PostService postService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );
            UserDetails userDetails = userServiceImpl
                    .loadUserByUsername(authentication.getName());
            String jwtToken = jwtTokenUtil.generateToken(userDetails);
            User user1 = userService.findByEmail(user.getEmail());
            JwtResponse jwtResponse = new JwtResponse(jwtToken, user1.getUsername(),user1.getEmail(),userDetails.getAuthorities());
            return ResponseEntity.ok(jwtResponse);
        } catch (Exception e) {
            logger.error("Lỗi đăng nhập");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/profile/{email}")
    public ResponseEntity<List<Post>> profile(@PathVariable("email")String email) {
        try {
            User user = this.userService.getProfile(email);
            List<Post> posts = this.postService.findAllByUser(user);
            if(user==null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(posts, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/profile/information/{email}")
    public ResponseEntity<User> profileInformation(@PathVariable("email")String email) {
        try {
            User user = this.userService.getProfile(email);
            if(user==null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerNewUser(@Valid @RequestBody User user) {
        try {
            userService.register(user);
            logger.info("New user was saved successfully.");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-information")
    public ResponseEntity<Void> updateInformation(@Valid @RequestBody UserUpdateDTO user) {
        try {
            if(userService.updateInformation(user)){
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            logger.info("Update "+user.getEmail()+" error!");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateImg")
    public ResponseEntity<Void> changeImg(@RequestParam("email")String email, @RequestParam("url")String url) {
        try {
            if(userService.changeImg(email, url)) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
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

    @GetMapping(value = "/admin/user",  params = {"page", "size", "search"})
    public ResponseEntity<Page<User>> getAllPostByAdmin(@RequestParam("page") int page,
                                                        @RequestParam("size") int size,
                                                        @RequestParam("search") String search) {
        try {
            Page<User> users = userService.getAllUserByAdmin(PageRequest.of(page, size), search);
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/admin/user/{id}")
    public ResponseEntity<Void> deleteUserByAdmin(@PathVariable("id") Long id) {
        try {
            if(userService.deleteUserByAdmin(id)){
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping(value = "/admin/user/{id}")
    public ResponseEntity<Void> lockOrUnlockUserByAdmin(@PathVariable("id") Long id) {
        try {
            if(userService.lockOrUnlockUserByAdmin(id)){
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update-password/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable(value = "id") Long idUser,
                                            @RequestBody UpdatePassword updatePassword) {
        try {
            if (userService.updatePassword(idUser, updatePassword)) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            logger.error("Lỗi update passwird");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
