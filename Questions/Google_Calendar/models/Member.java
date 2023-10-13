package Questions.Google_Calendar.models;

public class Member extends Participant{
    public Member(String name, String email, Company company){
        super(name, email, company);
    }

    @Override
    public void updateEvent(Event event) {

    }

    @Override
    public void deleteEvent(Event event) {

    }

}
