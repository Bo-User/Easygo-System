package cn.edu.tongji.easygo.service.ServiceImpl;

import cn.edu.tongji.easygo.model.Comment;
import cn.edu.tongji.easygo.repository.CommentRepository;
import cn.edu.tongji.easygo.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentRepository commentRepository;

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteByCommentId(commentId);
    }

    @Override
    public List<Comment> showCommentByInformation(Long informationId) {
        return commentRepository.findCommentsByCommentBelongId(informationId);
    }

    @Override
    public Comment showComment(Long commentId) {
        return commentRepository.findByCommentId(commentId);
    }
}
