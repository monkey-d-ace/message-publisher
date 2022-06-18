package org.onepiece.message.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class MessageSender {
    @Autowired
    private RedisTemplate<String, ?> redisTemplate;

    @Scheduled(fixedRate = 10000)
    public void send() {
        redisTemplate.convertAndSend("email", "sending an email");
        redisTemplate.convertAndSend("short message", "sending a short message");
    }
}
