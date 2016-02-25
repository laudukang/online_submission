package me.laudukang.persistence.service.impl;

import me.laudukang.persistence.model.OsMessage;
import me.laudukang.persistence.repository.MessageRepository;
import me.laudukang.persistence.service.IMessageService;
import me.laudukang.spring.domain.OsMessageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * <p>Created with IDEA
 * <p>Author: laudukang
 * <p>Date: 2016/2/24
 * <p>Time: 21:15
 * <p>Version: 1.0
 */
@Service
@Transactional
public class MessageService implements IMessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void save(OsMessage osMessage) {
        messageRepository.save(osMessage);
    }

    @Override
    public void deleteById(int id) {
        messageRepository.delete(id);
    }

    @Override
    public List<OsMessageDomain> findAllByUserId(int id) {
        return messageRepository.findAllByUserId(id);
    }

    @Override
    public List<OsMessageDomain> findAllByAdminId(int id) {
        return messageRepository.findAllByAdminId(id);
    }
}
