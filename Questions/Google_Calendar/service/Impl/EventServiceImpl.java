package Questions.Google_Calendar.service.Impl;

import Questions.Google_Calendar.models.Event;
import Questions.Google_Calendar.models.Member;
import Questions.Google_Calendar.models.Participant;
import Questions.Google_Calendar.repository.EventAcceptanceRepo;
import Questions.Google_Calendar.repository.EventRepo;
import Questions.Google_Calendar.repository.Impl.EventAcceptanceRepoImpl;
import Questions.Google_Calendar.repository.Impl.EventRepoImpl;
import Questions.Google_Calendar.service.EventService;
import Questions.Google_Calendar.service.EventMemberService;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class EventServiceImpl implements EventService {
    private EventRepo eventRepo;
    private EventAcceptanceRepo eventAcceptanceRepo;
    public EventServiceImpl(){
        eventRepo = new EventRepoImpl();
        eventAcceptanceRepo = new EventAcceptanceRepoImpl();
    }
    @Override
    public List<Event> fetchEventsInTheRange(Member member, Long start, Long end) {
        Objects.requireNonNull(member);
        Objects.requireNonNull(start);
        Objects.requireNonNull(end);
        return this.eventRepo.getEventsInGivenRange(member, start, end);
    }

    @Override
    public Event createEvent(Event event) {
        Objects.requireNonNull(event);
        Objects.requireNonNull(event.getOrganizers());
        this.eventRepo.addEvent(event.getOrganizerAtLocation(0), event);
        return event;
    }

    @Override
    public void updateEvent(Event event) {
        Objects.requireNonNull(event);
        Set<Participant> participants = event.getParticipants();

        EventMemberService eventVisitor = new EventMemberServiceImpl(this.eventRepo);
        for(Participant participant: participants){
            participant.updateEvent(event, eventVisitor);
        }
    }

    @Override
    public void deleteEvent(Event event) {
        Objects.requireNonNull(event);
        Set<Participant> participants = event.getParticipants();

        EventMemberService eventVisitor = new EventMemberServiceImpl(this.eventRepo);
        for(Participant participant: participants){
            participant.deleteEvent(event, eventVisitor);
        }
    }

    @Override
    public void acceptEvent(Event event, Member member) {
        this.eventAcceptanceRepo.accept(event, member);
    }

    @Override
    public void rejectEvent(Event event, Member member) {
        this.eventAcceptanceRepo.reject(event, member);
    }
}
