package Questions.Google_Calendar.models;

import Questions.Google_Calendar.service.EventMemberService;

public abstract class Participant {
    protected String name;
    protected String email;
    protected Company company;
    public Participant(String name, String email, Company company){
        this.name = name;
        this.email = email;
        this.company = company;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public Company getCompany() {
        return company;
    }

    // Since a Participant is a member only, of event is created by any one of the participant,
    // that can update/delete event.
    public abstract void updateEvent(Event event, EventMemberService eventVisitor);
    public abstract void deleteEvent(Event event, EventMemberService eventVisitor);
}
