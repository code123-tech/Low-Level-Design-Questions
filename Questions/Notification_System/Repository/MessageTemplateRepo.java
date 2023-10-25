package Questions.Notification_System.Repository;


import Questions.Notification_System.enums.MessageType;
import Questions.Notification_System.models.MessageTemplate;

public interface MessageTemplateRepo {
    MessageTemplate createMessageTemplate(MessageType messageType, String templateString);
    MessageTemplate getTemplate(String id);
}
