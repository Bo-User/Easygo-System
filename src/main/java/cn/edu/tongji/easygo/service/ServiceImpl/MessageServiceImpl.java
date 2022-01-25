package cn.edu.tongji.easygo.service.ServiceImpl;

import cn.edu.tongji.easygo.model.Message;
import cn.edu.tongji.easygo.repository.MessageRepository;
import cn.edu.tongji.easygo.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    MessageRepository messageRepository;

    @Override
    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void deleteMessage(Long messageId) {
        messageRepository.deleteByMessageId(messageId);
    }

    @Override
    public Message showConcreteMessage(Long messageId) {
        return messageRepository.findMessageByMessageId(messageId);
    }

    @Override
    public List<Message> showAllMessageByUser(Long userId) {
        return messageRepository.findMessagesByMessageUserId(userId);
    }

    @Override
    public void readMessage(Long messageId) {
        Message message = messageRepository.findMessageByMessageId(messageId);
        message.setMessageRead(true);
        messageRepository.save(message);
    }
}
