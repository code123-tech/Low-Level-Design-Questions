### What is Notification System, and its applications?
- Notification Systems are like information system that are used to notify/tell a user about an event only if user allows System.
- Now, System can inform user on his mobile/email/whatsapp/facebook/slack/Instagram/SMS/webPush etc.
- For ex: Suppose an application wants to use our service to send notification to its user via channels/mediums for which user agrees.
  - Inside application, if user signup, then application want to send en email to user, for welcome message.
  - If user gets OTP, then application sends otp message either through SMS or Email.
  - If Application wants to send some promotional/offer message to its user, then also it can send through those channels.


### Requirements
- Notification Service should be supporting Multiple channels/client for notifications.
- mobile, email, whatsapp, facebook, slack, Instagram, SMS, webPush etc.
- User will get a notification only through those channels for which user has subscribed.
- There are some messages like marketing message, and in same manner some messages are like Important (OTP, Bank Statement or others)
  So, what will be important for a user to get first? Obviously Important Message. So, Messages can be of some type, so we can put their
  priority to send.
- User can enable/disable a channel to be notified.
- System can have different templates for different type of message like OTP, Promotional etc.

### Questions (With Scope of improvement)
- can user also select which type of message notification it wants to enable? user can disable promotional type of messages.
- Do we have to put limit on Message Size?
- Does our message contains high size files/video files?
- What if two different threads want to notify for same user for two different messages?
- Some client might fail to send message so all other client will be failed or what?


### Possible Use cases
1. User First Register/Subscribe to a channel. --> subscribe()
2. Other System/Service asks our service to notify given user with given message. --> notifyToUser
3. System identifies all channels on which user is subscribed, one by one notifies user through each channel. 
4. System Initially establish connection/configuration with each channel/medium.
5. Admin/We can set template also in the system for each type of message.  --> setTemplate(), getTemplate()
   1. For Otp message, system can have one template
   2. For Promotional messages, system can have one template.

### Models/Entities
1. **Message**:  Message Body, type of message.
2. **MessageTemplate**: template of a message, messageType.
3. **User**: end user which is to be notified.

### Application Classes
1. **enums**: Some Constants defined here Like MessageType, PriorityHandlerType.
2. **Factory**: factory pattern to fetch type of notifier based on channel type, and take channel priority based on
                Message Type.
3. **NotificationChannelClient**: All client which interact with their respective external service to send notification
    For example, slackClient will interact with Slack to send message.
4. **Repository**: repository layer for storing user's subscribed channels, and Message templates.
5. **Service**
   1. **MessageTemplateService**: for creating template based on message type.
   2. **NotificationService**: through this, user subscribes to channel, and send message/notification.
   3. **Notifier**: Notifier is actual place which interact with each channel's respective client. Each notifier
      has next notifier in chain if message is being sent to a user's subscribed channel list.
      For ex: user has subscribed for 4 channels, then a chain will be created as follows
      ```txt
        (Kind of Chain of Respoonsibility Principle)
      
                    nextNotifier               nextNotifier                  nextNotifier
        C4Notifier --------------> C3Notifier -----------------> C2Notifier -----------------> C1Notifier
        
        Each notifer also consist a priority handler to indicate if current message is of priority
        message or not through this channel.
        
        BaseNotifier is abstract class which is implemented by each of the respective channelNotifier.
      ```
   4. **PriorityHandler**: These are the Priority Handlers which handles a particular priority channel.

### Diagram
1. Use Case Diagram

![Use Case](UseCase.png)

2. Basic Flow Diagram

![Basic Flow](BasicFlow.png)