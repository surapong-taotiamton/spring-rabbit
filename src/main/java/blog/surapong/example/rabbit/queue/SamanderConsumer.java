package blog.surapong.example.rabbit.queue;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class SamanderConsumer {

    @RabbitListener(queues = {"samander"})
    public void handleQueue(final Message message) {
        System.out.println(message.toString());
    }
}
