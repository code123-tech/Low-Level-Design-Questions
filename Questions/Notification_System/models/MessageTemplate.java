package Questions.Notification_System.models;

import Questions.Notification_System.enums.MessageType;

import java.util.UUID;

public class MessageTemplate {
    private String id;
    private MessageType messageType;
    private String template;

    public MessageTemplate(MessageType messageType, String template) {
        this.id = UUID.randomUUID().toString();
        this.messageType = messageType;
        this.template = template;
    }

    public String getId() {
        return id;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getTemplate() {
        return template;
    }
}
