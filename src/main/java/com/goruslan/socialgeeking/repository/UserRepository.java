package com.goruslan.socialgeeking.repository;

import com.goruslan.socialgeeking.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE user  set  url_img =:imgUrl where email = :email and enabled = true",
            nativeQuery = true)
    void updateImg(@Param("imgUrl") String imgUrl, @Param("email") String email);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user set  full_name =:fullName, education=:education, skills=:skills, experience=:experience, username=:username where email = :email and enabled = true",
            nativeQuery = true)
    void updateInformation(@Param("fullName") String fullName, @Param("username") String username, @Param("education") String education,
                           @Param("skills") String skills, @Param("experience") String experience, @Param("email") String email);

    User findByEmailAndEnabledIsTrue(String email);

    Page<User> findAllByUsernameContainingOrEmailContainingOrEducationContainingOrFullNameContaining(Pageable pageable, String username, String email, String education, String fullName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user  set  enabled =:enabled where id = :id",
            nativeQuery = true)
    void lockOrUnlockUser(@Param("id") Long id,@Param("enabled")boolean enabled);
}
