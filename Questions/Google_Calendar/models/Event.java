package Questions.Google_Calendar.models;

import Questions.Google_Calendar.enums.EventStatus;
import Questions.Google_Calendar.enums.EventType;

import java.util.*;

public class Event {
    private String eventId;
    private String title;
    private String description;
    private Set<Member> organizers; // as multiple organizer can be there
    private String location;
    private Long startTime;
    private Long endTime;
    private Set<Participant> participants;
    private EventType eventType;
    private EventStatus eventStatus;
    private Event(){ // We will let user force to use Builder mechanism to crate an instance.
        organizers = new HashSet<>();
    }

    public static class EventBuilder{
        private Event event;
        public EventBuilder(){
            event = new Event();
        }
        public EventBuilder withTitle(String title){
            event.title = title;
            return this;
        }
        public EventBuilder withDescription(String description){
            event.description = description;
            return this;
        }
        public EventBuilder withOrganizer(Member organizer){
            event.organizers.add(organizer);
            return this;
        }
        public EventBuilder withLocation(String location){
            event.location = location;
            return this;
        }
        public EventBuilder withStartTime(Long startTime){
            event.startTime = startTime;
            return this;
        }
        public EventBuilder withEndTime(Long endTime){
            event.endTime = endTime;
            return this;
        }
        public EventBuilder withParticipants(Set<Participant> participants){
            event.participants = participants;
            return this;
        }
        public EventBuilder withEventType(EventType eventType){
            event.eventType = eventType;
            return this;
        }
        public Event build(){
            event.eventId = UUID.randomUUID().toString();
            event.eventStatus = EventStatus.CREATED;
            return event;
        }
    }

    public String getEventId() {
        return eventId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Set<Member> getOrganizers() {
        return organizers;
    }

    public String getLocation() {
        return location;
    }

    public Long getStartTime() {
        return startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public EventType getEventType() {
        return eventType;
    }

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void addOrganizer(Member organizer){
        if(this.organizers == null){
            this.organizers = new HashSet<>();
        }
        if(this.organizers.contains(organizer)){
            System.out.println(organizer.getName() + " is already organizer of event: " + title);
            return;
        }
        this.organizers.add(organizer);
    }

    public void setOrganizers(Set<Member> organizers){  // updating all organizers.
        this.organizers = organizers;
    }

    public void setLocation(String location){this.location=location;}
    public void setStartTime(Long startTime){this.startTime=startTime;}
    public void setEndTime(Long endTime){this.startTime=endTime;}
    public void addParticipants(Participant participant){
        if(this.participants == null){
            this.participants = new HashSet<>();
        }
        if(this.participants.contains(participant)){
            System.out.println(participant.getName() + " is already participated in event: " + title);
            return;
        }
        this.participants.add(participant);
    }
    public void setParticipants(Set<Participant> newParticipants){
        this.participants = newParticipants;
    }
    public void setEventType(EventType eventType){
        this.eventType = eventType;
    }
    public void setEventStatus(EventStatus eventStatus){
        this.eventStatus = eventStatus;
    }
}
