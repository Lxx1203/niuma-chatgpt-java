# NiuMa ChatGPT Java API
OpenAI ChatGPT 的 SDK。如果觉得不错的可以在右上角点个Star，蟹蟹！</br>
**qq群讨论群：719537921**
## 基本使用
```java
public class Demo {
    public static void main(String[] args) {
        String url = "https://api.openai.com/v1/chat/completions";
        String key = "";
        ChatGPTClientBuilder builder = new ChatGPTClientBuilder();
        GPTClient client = builder
                .url(url) // 设置 url，默认设置为 https://api.openai.com/v1/chat/completions，可以省略
                .key(key) // 设置 key，必备
                .proxy("127.0.0.1", 7890).builder();
        // 核心参数，要发送的消息
        List<Message> list = new ArrayList<>();
        Message message = new Message();
        message.setRole(Role.USER);
        message.setContent("你好 chatgpt");
        list.add(message);
        try{
            ChatGPTMessage send = client.send(list);
            System.out.println(send);
        }catch (BaseException e){
            e.printStackTrace();
        }
    }
}
```