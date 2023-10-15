package Questions.Google_Calendar.repository.Impl;

import Questions.Google_Calendar.models.DistributedList;
import Questions.Google_Calendar.models.Event;
import Questions.Google_Calendar.models.Member;
import Questions.Google_Calendar.repository.EventRepo;

import java.util.*;

public class EventRepoImpl implements EventRepo {
    private Map<Member, TreeMap<Long, List<Event>>> membersEvents;
    public EventRepoImpl(){
        this.membersEvents = new HashMap<>();
    }

    @Override
    public void addEvent(Member member, Event event) {
        this.membersEvents.putIfAbsent(member, new TreeMap<>());
        this.membersEvents.get(member).putIfAbsent(event.getStartTime(), new ArrayList<>());
        this.membersEvents.get(member).get(event.getStartTime()).add(event);
    }

    @Override
    public List<Event> getEventsInGivenRange(Member member, Long start, Long end) {
        Collection<List<Event>> events = this.membersEvents.getOrDefault(member, new TreeMap<>()).subMap(start, end).values();
        List<Event> result = new ArrayList<>();
        for(List<Event> subEvents: events){
            result.addAll(subEvents);
        }
        return result;
    }

    @Override
    public void updateEvent(Member member, Event event) {
        TreeMap<Long, List<Event>> events = this.membersEvents.getOrDefault(member, new TreeMap<>());
        List<Event> subEvents = events.get(event.getStartTime());
        if(subEvents != null){
            subEvents.removeIf(e -> e.equals(event));
            subEvents.add(event);
        }
    }

    @Override
    public void updateEvent(DistributedList distributedList, Event event) {
        for(Member member: distributedList.getMembers()){
            updateEvent(member, event);
        }
    }

    @Override
    public void deleteEvent(Member member, Event event) {
        TreeMap<Long, List<Event>> events = this.membersEvents.getOrDefault(member, new TreeMap<>());
        List<Event> subEvents = events.get(event.getStartTime());
        if(subEvents != null){
            subEvents.removeIf(e -> e.equals(event));
        }
    }

    @Override
    public void deleteEvent(DistributedList distributedList, Event event) {
        for(Member member: distributedList.getMembers()){
            deleteEvent(member, event);
        }
    }
}
