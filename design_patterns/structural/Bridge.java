interface NotificationSender {
    void send(String message);
}

class EmailNotificationSender implements NotificationSender {
    public void send(String message) {
        System.out.println("Email Notification :: " + message);
    }
}

class SmsNotificationSender implements NotificationSender {
    public void send(String message) {
        System.out.println("SMS Notification :: " + message);
    }
}

abstract class Message {
    protected NotificationSender sender;
    
    public Message(NotificationSender sender) {
        this.sender = sender;
    }
    
    public abstract void sendMessage(String content);
}

class AlertMessage extends Message {
    
    public AlertMessage(NotificationSender sender) {
        super(sender);
    }
    
    public void sendMessage(String content) {
        sender.send("[ALERT] " + content);
    }
}

class MarketingMessage extends Message {
    
    public MarketingMessage(NotificationSender sender) {
        super(sender);
    }
    
    public void sendMessage(String content) {
        sender.send("[MARKETING] " + content);
    }
}

class Bridge {
    public static void main(String[] args) {
        NotificationSender sender = new EmailNotificationSender();
        Message message = new AlertMessage(sender);
        message.sendMessage("Server Down");
    }
}
