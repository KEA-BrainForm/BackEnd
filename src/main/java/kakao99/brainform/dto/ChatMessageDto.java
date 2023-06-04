package kakao99.brainform.dto;

import lombok.Data;

@Data
public class ChatMessageDto {
    private MessageType type;
    private String content;
    private String sender;

    public enum MessageType {
        CHAT, JOIN, LEAVE
    }

}
