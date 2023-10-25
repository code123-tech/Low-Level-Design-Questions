package Questions.Notification_System.Factory;

import Questions.Notification_System.Service.PriorityHandler.Impl.HighPriorityHandler;
import Questions.Notification_System.Service.PriorityHandler.PriorityHandler;
import Questions.Notification_System.enums.MessageType;

import java.util.Objects;

public class PriorityHandlerFactory {
    public static PriorityHandler getHandler(MessageType messageType) {
        if (Objects.requireNonNull(messageType) == MessageType.OTP) {
            return new HighPriorityHandler();
        }
        return null;
    }
}
