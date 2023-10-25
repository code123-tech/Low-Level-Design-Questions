package Questions.Notification_System;

import Questions.Notification_System.Service.Impl.MessageTemplateServiceImpl;
import Questions.Notification_System.Service.Impl.NotificationServiceImpl;
import Questions.Notification_System.Service.MessageTemplateService;
import Questions.Notification_System.Service.NotificationService;
import Questions.Notification_System.enums.Channel;
import Questions.Notification_System.enums.MessageType;
import Questions.Notification_System.models.Message;
import Questions.Notification_System.models.MessageTemplate;
import Questions.Notification_System.models.User;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        test1();
        System.out.println("--------------------------");
        test2();
        System.out.println("--------------------------");
        test3();
    }

    private static void test1(){
        MessageTemplateService messageTemplateService = new MessageTemplateServiceImpl();

        String strTemplate = "Get straight %s rupee discount on ABC today. Special offer.";
        MessageTemplate messageTemplate = messageTemplateService.createTemplate(MessageType.INFORMATIONAL, strTemplate);

        String formattedMessage = String.format(messageTemplate.getTemplate(), "100");
        User user = new User("test1", "test1@test.com");

        NotificationService notificationService = new NotificationServiceImpl();
        notificationService.subscribeChannel(user,
                Arrays.asList(Channel.EMAIL, Channel.INSTAGRAM, Channel.WHATSAPP));
        notificationService.sendMessage(user, new Message(formattedMessage, messageTemplate.getMessageType()));
    }

    private static void test2() {
        MessageTemplateService messageTemplateService = new MessageTemplateServiceImpl();

        String strTemplate = "Your OTP for transaction amount of INR %s is %s";
        MessageTemplate template = messageTemplateService.createTemplate(MessageType.OTP, strTemplate);

        String formattedMessage = String.format(template.getTemplate(), "100000", "6839");
        User endUser = new User("test2", "test2@test.com");

        NotificationService notificationService = new NotificationServiceImpl();
        notificationService.subscribeChannel(endUser,
                Arrays.asList(Channel.SMS, Channel.EMAIL));
        notificationService.sendMessage(endUser, new Message(formattedMessage, template.getMessageType()));
    }

    private static void test3(){
        MessageTemplateService messageTemplateService = new MessageTemplateServiceImpl();

        String strTemplate = "Get straight %s rupee discount on ABC today. Special offer.";
        MessageTemplate messageTemplate = messageTemplateService.createTemplate(MessageType.INFORMATIONAL, strTemplate);

        String formattedMessage = String.format(messageTemplate.getTemplate(), "100");
        User user = new User("test1", "test1@test.com");

        NotificationService notificationService = new NotificationServiceImpl();
        notificationService.subscribeChannel(user,
                Arrays.asList(Channel.EMAIL, Channel.INSTAGRAM, Channel.WHATSAPP));
        System.out.println("Before disabling Channel: " + Channel.WHATSAPP.name());
        notificationService.sendMessage(user, new Message(formattedMessage, messageTemplate.getMessageType()));

        System.out.println("After disabling Channel: " + Channel.WHATSAPP.name());
        notificationService.disableUserSubscribedChannel(user, Channel.WHATSAPP);
        notificationService.sendMessage(user, new Message(formattedMessage, messageTemplate.getMessageType()));

        System.out.println("After enabling Channel: " + Channel.WHATSAPP.name());
        notificationService.enableUserSubscribedChannel(user, Channel.WHATSAPP);
        notificationService.sendMessage(user, new Message(formattedMessage, messageTemplate.getMessageType()));
    }
}
