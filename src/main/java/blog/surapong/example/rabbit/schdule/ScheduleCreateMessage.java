package blog.surapong.example.rabbit.schdule;

import blog.surapong.example.rabbit.dto.queue.MessageQueueDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleCreateMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedRate  = 5000)
    public void run() {

        ObjectMapper objectMapper = new ObjectMapper();

        MessageQueueDto messageQueueDto = new MessageQueueDto().setMessageId(java.util.UUID.randomUUID().toString()).setRetry(0);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        //rabbitTemplate.convertAndSend("samander", messageQueueDto);

        rabbitTemplate.convertAndSend("samander", messageQueueDto);

//        try {
//
//            rabbitTemplate.convertAndSend("samander", messageQueueDto );
//        } catch (JsonProcessingException ex) {
//            ex.printStackTrace();
//        }


    }

}
