package Questions.Google_Calendar.service.Impl;

import Questions.Google_Calendar.models.DistributedList;
import Questions.Google_Calendar.models.Event;
import Questions.Google_Calendar.models.Member;
import Questions.Google_Calendar.repository.EventRepo;
import Questions.Google_Calendar.service.EventMemberService;

public class EventMemberServiceImpl implements EventMemberService {
    private EventRepo eventRepo;
    public EventMemberServiceImpl(EventRepo eventRepo){
        this.eventRepo = eventRepo;
    }

    @Override
    public void updateEvent(Member member, Event event) {
        this.eventRepo.updateEvent(member, event);
    }

    @Override
    public void updateEvent(DistributedList distributedList, Event event) {
        this.eventRepo.updateEvent(distributedList, event);
    }

    @Override
    public void deleteEvent(Member member, Event event) {
        this.eventRepo.deleteEvent(member, event);
    }

    @Override
    public void deleteEvent(DistributedList distributedList, Event event) {
        this.eventRepo.deleteEvent(distributedList, event);
    }
}
