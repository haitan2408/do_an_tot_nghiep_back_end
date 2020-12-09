package com.goruslan.socialgeeking.repository;

import com.goruslan.socialgeeking.domain.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

   @Modifying
   @Transactional
   @Query(value = "delete from comment where comment.post_id=?1",nativeQuery = true)
   int deleteAllByPost_Id(Long id);

   Page<Comment> findAllByPost_Id(Long idPost, Pageable pageable);

   @Modifying
   @Transactional
   @Query(value = "delete from comment where comment.user_id=?1",nativeQuery = true)
   void deleteByIdUser(Long id);
}
