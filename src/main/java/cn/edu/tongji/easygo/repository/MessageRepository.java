package cn.edu.tongji.easygo.repository;

import cn.edu.tongji.easygo.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    @Transactional
    void deleteByMessageId(Long messageId);

    Message findMessageByMessageId(Long messageId);

    List<Message> findMessagesByMessageUserId(Long userId);
}
