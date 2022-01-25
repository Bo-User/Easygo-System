package cn.edu.tongji.easygo.repository;

import cn.edu.tongji.easygo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Transactional
    void deleteByCommentId(Long commentId);

    List<Comment> findCommentsByCommentBelongId(Long commentInformationId);

    Comment findByCommentId(Long commentId);
}
