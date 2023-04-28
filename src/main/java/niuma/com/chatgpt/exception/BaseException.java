package niuma.com.chatgpt.exception;

import com.alibaba.fastjson2.JSON;
import lombok.Data;

@Data
public class BaseException extends RuntimeException {
    private ExceptionMessage error;

    @Override
    public void printStackTrace() {
        System.out.println(JSON.toJSONString(error));
    }
}
