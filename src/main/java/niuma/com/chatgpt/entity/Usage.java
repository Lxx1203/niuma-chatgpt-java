package niuma.com.chatgpt.entity;

import lombok.Data;

@Data
public class Usage {
    private Long prompt_tokens;
    private Long completion_tokens;
    private Long total_tokens;
}
