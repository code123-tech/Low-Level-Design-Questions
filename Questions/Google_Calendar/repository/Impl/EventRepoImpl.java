package Questions.Google_Calendar.repository.Impl;

import Questions.Google_Calendar.models.DistributedList;
import Questions.Google_Calendar.models.Event;
import Questions.Google_Calendar.models.Member;
import Questions.Google_Calendar.repository.EventRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EventRepoImpl implements EventRepo {
    private Map<Event, TreeMap<Long, List<Member>>> eventMembers;
    public EventRepoImpl(){
        this.eventMembers = new HashMap<>();
    }

    @Override
    public void addEvent(Member member, Event event) {

    }

    @Override
    public List<Event> getEventsInGivenRange(Member member, Long start, Long end) {
        return null;
    }

    @Override
    public void updateEvent(Member member, Event event) {

    }

    @Override
    public void updateEvent(DistributedList distributedList, Event event) {

    }

    @Override
    public void deleteEvent(Member member, Event event) {

    }

    @Override
    public void deleteEvent(DistributedList distributedList, Event event) {

    }
}
