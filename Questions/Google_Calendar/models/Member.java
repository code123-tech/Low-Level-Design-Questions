package Questions.Google_Calendar.models;

import Questions.Google_Calendar.service.EventMemberService;

public class Member extends Participant{
    public Member(String name, String email, Company company){
        super(name, email, company);
    }

    @Override
    public void updateEvent(Event event, EventMemberService eventVisitor) {
        eventVisitor.updateEvent(this, event);
    }

    @Override
    public void deleteEvent(Event event, EventMemberService eventVisitor) {
        eventVisitor.deleteEvent(this, event);
    }

}
