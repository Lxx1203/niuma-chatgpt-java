package niuma.com.chatgpt.entity;

import lombok.Data;

@Data
public class Usage {
    private Long promptTokens;
    private Long completionTokens;
    private Long totalTokens;
}
