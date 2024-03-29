package Questions.Google_Calendar.models;

import Questions.Google_Calendar.service.EventMemberService;

import java.util.ArrayList;
import java.util.List;

public class DistributedList extends Participant{
    private List<Member> members;

    public DistributedList(String name, String email, Company company){
        super(name, email, company);
        members = new ArrayList<>();
    }
    public List<Member> getMembers(){
        return this.members;
    }
    public void addMember(Member member){
        this.members.add(member);
    }
    @Override
    public void updateEvent(Event event,  EventMemberService eventVisitor) {
        eventVisitor.updateEvent(this, event);
    }
    @Override
    public void deleteEvent(Event event,  EventMemberService eventVisitor) {
        eventVisitor.deleteEvent(this, event);
    }
}
