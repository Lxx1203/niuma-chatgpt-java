package niuma.com.chatgpt.entity;

import lombok.Data;

import java.util.List;

@Data
public class ChatGPTMessage {
    private String id;
    private String object;
    private Long created;
    private String model;
    private Usage usage;
    private List<Choice> choices;
}
