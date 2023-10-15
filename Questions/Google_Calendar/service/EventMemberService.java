package Questions.Google_Calendar.service;

import Questions.Google_Calendar.models.DistributedList;
import Questions.Google_Calendar.models.Event;
import Questions.Google_Calendar.models.Member;

public interface EventMemberService {
    void updateEvent(Member member, Event event);
    void updateEvent(DistributedList distributedList, Event event);
    void deleteEvent(Member member, Event event);
    void deleteEvent(DistributedList distributedList, Event event);
}
