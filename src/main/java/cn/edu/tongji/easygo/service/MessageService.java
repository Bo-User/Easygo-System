package cn.edu.tongji.easygo.service;

import cn.edu.tongji.easygo.model.Message;
import cn.edu.tongji.easygo.repository.MessageRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public interface MessageService {
    Message sendMessage(Message message);

    void deleteMessage(Long messageId);

    Message showConcreteMessage(Long messageId);

    List<Message> showAllMessageByUser(Long userId);

    void readMessage(Long messageId);
}
