package Questions.Google_Calendar.service;

import Questions.Google_Calendar.models.Event;
import Questions.Google_Calendar.models.Member;

import java.util.List;

public interface EventService {
    List<Event> fetchEventsInTheRange(Member member, Long start, Long end);
    Event createEvent(Event event);
    void updateEvent(Event event);
    void deleteEvent(Event event);

    void acceptEvent(Event event, Member member);
    void rejectEvent(Event event, Member member);
}
