package org.example.expert.domain.log.service;

import lombok.AllArgsConstructor;
import org.example.expert.domain.log.entity.Log;
import org.example.expert.domain.log.repository.LogRepository;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.user.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class LogService {
    private final LogRepository logRepository;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveLog(User user, Todo todo){
        Long userId = user.getId();
        Long todoId = todo.getId();
        String msg = userId + "번 유저가" + todoId + "번 일정 등록했습니다.";
        System.out.println(msg);
        Log log = new Log(msg);
        logRepository.save(log);
    }
}