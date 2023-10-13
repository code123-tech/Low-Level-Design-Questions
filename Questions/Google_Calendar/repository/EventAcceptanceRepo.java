package Questions.Google_Calendar.repository;

import Questions.Google_Calendar.enums.MemberAcceptanceStatus;
import Questions.Google_Calendar.models.Event;
import Questions.Google_Calendar.models.Member;

public interface EventAcceptanceRepo {
    void accept(Event event, Member member);
    void reject(Event event, Member member);

    public MemberAcceptanceStatus status(Event event, Member member);
}
