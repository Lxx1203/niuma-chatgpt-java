package niuma.com.chatgpt.exception;

import lombok.Data;

@Data
public class ExceptionMessage {
    private String message;
    private String type;
    private String param;
    private String code;
}
