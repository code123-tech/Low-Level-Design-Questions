package Questions.Google_Calendar.service.Impl;

import Questions.Google_Calendar.models.Event;
import Questions.Google_Calendar.models.Member;
import Questions.Google_Calendar.service.EventService;

import java.util.List;

public class EventServiceImpl implements EventService {
    @Override
    public List<Event> fetchEventsInTheRange(Member member, Long start, Long end) {
        return null;
    }

    @Override
    public Event createEvent(Event event) {
        return null;
    }

    @Override
    public void updateEvent(Event event) {

    }

    @Override
    public void deleteEvent(Event event) {

    }

    @Override
    public void acceptEvent(Event event, Member member) {

    }

    @Override
    public void rejectEvent(Event event, Member member) {

    }
}
