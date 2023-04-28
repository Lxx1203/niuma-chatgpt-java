package niuma.com.chatgpt;

import niuma.com.chatgpt.entity.Model;

public class ChatGPTClientBuilder {

    private GPTClient gptClient;

    public ChatGPTClientBuilder() {
        gptClient=new GPTClient();
        gptClient.setUrl("https://api.openai.com/v1/chat/completions");
        gptClient.setModel(Model.GPT3_5);
        gptClient.setStream(false);
        gptClient.setProxyStatus(false);
    }

    public ChatGPTClientBuilder url(String url) {
        gptClient.setUrl(url);
        return this;
    }

    public ChatGPTClientBuilder key(String key) {
        gptClient.setKey(key);
        return this;
    }

    public ChatGPTClientBuilder steam(boolean steam) {
        gptClient.setStream(steam);
        return this;
    }

    public ChatGPTClientBuilder model(String model) {
        gptClient.setModel(model);
        return this;
    }

    public ChatGPTClientBuilder proxy(String host, Integer port){
        gptClient.setProxyHost(host);
        gptClient.setProxyPort(port);
        gptClient.setProxyStatus(true);
        return this;
    }

    public GPTClient builder() {
        return gptClient;
    }
}
