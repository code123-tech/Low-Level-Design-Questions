package Questions.Notification_System.Service;

import Questions.Notification_System.enums.MessageType;
import Questions.Notification_System.models.MessageTemplate;

public interface MessageTemplateService {
    MessageTemplate createTemplate(MessageType messageType, String template);
    MessageTemplate getTemplate(String templateId);
}
