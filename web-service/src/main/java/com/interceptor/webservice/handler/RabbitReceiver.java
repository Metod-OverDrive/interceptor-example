package com.interceptor.webservice.handler;

import com.interceptor.webservice.web.dto.TechWorkMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitReceiver {

    @RabbitListener(queues = {"techWorkQueue"})
    public void receive(TechWorkMessage message) {
        log.info(message.toString());
    }
}
