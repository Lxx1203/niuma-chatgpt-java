package niuma.com.chatgpt.entity;

import lombok.Data;

@Data
public class Message {
    private String role;
    private String content;
}
