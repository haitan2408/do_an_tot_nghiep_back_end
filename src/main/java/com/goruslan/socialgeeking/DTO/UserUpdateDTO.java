package com.goruslan.socialgeeking.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.goruslan.socialgeeking.domain.Role;
import com.goruslan.socialgeeking.domain.validator.PasswordsMatch;
import com.goruslan.socialgeeking.domain.validator.UniqueEmail;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserUpdateDTO {
    @NonNull
    @Size(min = 8, max = 100)
    @Column(nullable = false, unique = true)
    private String email;

    @NonNull
    @NotEmpty(message = "Full Name is required.")
    private String fullName;

    @NonNull
    @NotEmpty(message = "Education is required.")
    private String education;

    @NonNull
    @NotEmpty(message = "Experience is required.")
    private String experience;

    @NonNull
    @NotEmpty(message = "Summary of skills is required.")
    private String skills;

    @NonNull
    @NotEmpty(message = "Username is required.")
    @Column(nullable = false, unique = true)
    private String username;

}
