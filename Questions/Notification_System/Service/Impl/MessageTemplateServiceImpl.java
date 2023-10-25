package Questions.Notification_System.Service.Impl;

import Questions.Notification_System.Repository.Impl.MessageTemplateRepoImpl;
import Questions.Notification_System.Repository.MessageTemplateRepo;
import Questions.Notification_System.Service.MessageTemplateService;
import Questions.Notification_System.enums.MessageType;
import Questions.Notification_System.models.MessageTemplate;

public class MessageTemplateServiceImpl implements MessageTemplateService {
    private MessageTemplateRepo messageTemplateRepo;
    public MessageTemplateServiceImpl() {
        this.messageTemplateRepo = new MessageTemplateRepoImpl();
    }
    @Override
    public MessageTemplate createTemplate(MessageType messageType, String template) {
        return messageTemplateRepo.createMessageTemplate(messageType,template);
    }

    @Override
    public MessageTemplate getTemplate(String templateId) {
        return this.messageTemplateRepo.getTemplate(templateId);
    }
}
