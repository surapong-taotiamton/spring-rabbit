package blog.surapong.example.rabbit.queue;

import blog.surapong.example.rabbit.dto.queue.MessageQueueDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class SamanderConsumer {

    @RabbitListener(queues = {"samander"})
    public void handleQueue(final MessageQueueDto message) {
        System.out.println("MessageId : " + message.getMessageId());
        System.out.println("Retry : " + message.getRetry());
    }
}
