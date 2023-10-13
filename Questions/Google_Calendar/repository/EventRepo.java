package Questions.Google_Calendar.repository;

import Questions.Google_Calendar.models.DistributedList;
import Questions.Google_Calendar.models.Event;
import Questions.Google_Calendar.models.Member;

import java.util.List;

public interface EventRepo {
    void addEvent(Member member, Event event);
    List<Event> getEventsInGivenRange(Member member, Long start, Long end);
    void updateEvent(Member member, Event event);
    void updateEvent(DistributedList distributedList, Event event);
    void deleteEvent(Member member, Event event);
    void deleteEvent(DistributedList distributedList, Event event);
}
