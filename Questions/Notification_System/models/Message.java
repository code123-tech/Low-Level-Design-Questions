package Questions.Notification_System.models;

import Questions.Notification_System.enums.MessageType;

public class Message {
    private String message;
    private MessageType messageType;

    public Message(String message, MessageType messageType) {
        this.message = message;
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }
    public MessageType getMessageType() {
        return messageType;
    }
}
