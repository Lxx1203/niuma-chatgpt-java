package niuma.com.chatgpt;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSON;
import lombok.Data;
import niuma.com.chatgpt.entity.ChatGPTMessage;
import niuma.com.chatgpt.entity.Message;
import niuma.com.chatgpt.exception.BaseException;

import java.util.*;


@Data
public class GPTClient {
    private String url;
    private String key;
    private String model;
    private boolean stream;
    private String proxyHost;
    private Integer proxyPort;
    private Boolean proxyStatus;
    Map<String, Object> queryMap = new HashMap<>();

    private HttpRequest httpRequest() {
        HttpRequest request = HttpRequest.post(url)
                .header("Authorization", "Bearer " + key)
                .header("Content-Type", "application/json")
                .header("Accept", "*/*");
        queryMap.put("model", "gpt-3.5-turbo");
        queryMap.put("stream", false);
        if (proxyStatus) {
            request.setHttpProxy(proxyHost, proxyPort);
        }
        return request;
    }

    public ChatGPTMessage send(List<Message> list) throws BaseException {
        ChatGPTMessage message = null;
        HttpRequest request = httpRequest();
        queryMap.put("messages", list);
        request.body(JSON.toJSONString(queryMap));
        // 发送请求获取 JSON 串
        String res = request.execute().body();
        message = JSON.parseObject(res, ChatGPTMessage.class);
        if (message.getId() == null) {
            throw JSON.parseObject(res, BaseException.class);
        }
        return message;
    }
}
