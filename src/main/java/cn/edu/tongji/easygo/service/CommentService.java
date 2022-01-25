package cn.edu.tongji.easygo.service;

import cn.edu.tongji.easygo.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    Comment addComment(Comment comment);

    void deleteComment(Long commentID);

    List<Comment> showCommentByInformation(Long informationId);

    Comment showComment(Long commentId);
}
