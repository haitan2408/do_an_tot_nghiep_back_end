package com.goruslan.socialgeeking.repository;

import com.goruslan.socialgeeking.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "select * from Post order by creation_date desc",nativeQuery = true)
    List<Post> findAllOderByCreationDate();
   List<Post> findAllByUser_Email(String email);
    Page<Post> findAllByTitleContainingOrContentContainingOrUser_UsernameContainingOrderByCreationDateDesc(Pageable pageable, String title,
                                                                                    String content, String username);
}
