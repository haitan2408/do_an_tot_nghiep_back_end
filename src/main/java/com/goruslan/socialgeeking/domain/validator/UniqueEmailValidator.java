package com.goruslan.socialgeeking.domain.validator;

import com.goruslan.socialgeeking.domain.User;
import com.goruslan.socialgeeking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        User user1 = userRepository.findByEmailAndEnabledIsTrue(email);
        if(user1!=null) {
            return false;
        }
        return true;
    }
}
