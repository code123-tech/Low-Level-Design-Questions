package Questions.Notification_System.Repository.Impl;

import Questions.Notification_System.Repository.MessageTemplateRepo;
import Questions.Notification_System.enums.MessageType;
import Questions.Notification_System.models.MessageTemplate;

import java.util.HashMap;
import java.util.Map;


public class MessageTemplateRepoImpl implements MessageTemplateRepo {
    Map<String, MessageTemplate> messageTemplates;
    public MessageTemplateRepoImpl(){
        this.messageTemplates = new HashMap<>();
    }
    @Override
    public MessageTemplate createMessageTemplate(MessageType messageType, String templateString) {
        MessageTemplate messageTemplate = new MessageTemplate(messageType, templateString);
        this.messageTemplates.put(messageTemplate.getId(), messageTemplate);
        return messageTemplate;
    }

    @Override
    public MessageTemplate getTemplate(String id) {
        return this.messageTemplates.get(id);
    }
}
