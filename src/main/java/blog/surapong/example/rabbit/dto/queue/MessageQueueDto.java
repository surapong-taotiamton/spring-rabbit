package blog.surapong.example.rabbit.dto.queue;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
public class MessageQueueDto implements Serializable {
    private String messageId;
    private int retry;
}
