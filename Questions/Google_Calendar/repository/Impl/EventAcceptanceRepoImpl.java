package Questions.Google_Calendar.repository.Impl;

import Questions.Google_Calendar.enums.MemberAcceptanceStatus;
import Questions.Google_Calendar.models.Event;
import Questions.Google_Calendar.models.Member;
import Questions.Google_Calendar.repository.EventAcceptanceRepo;

import java.util.HashMap;
import java.util.Map;

public class EventAcceptanceRepoImpl implements EventAcceptanceRepo {
    private Map<Event, Map<Member, MemberAcceptanceStatus>> acceptanceStatus;

    public EventAcceptanceRepoImpl(){
        this.acceptanceStatus = new HashMap<>();
    }
    @Override
    public void accept(Event event, Member member) {
        this.acceptanceStatus.putIfAbsent(event, new HashMap<>());
        this.acceptanceStatus.get(event).put(member, MemberAcceptanceStatus.ACCEPTED);
    }

    @Override
    public void reject(Event event, Member member) {
        this.acceptanceStatus.putIfAbsent(event, new HashMap<>());
        this.acceptanceStatus.get(event).put(member, MemberAcceptanceStatus.REJECTED);
    }

    @Override
    public MemberAcceptanceStatus status(Event event, Member member) {
        this.acceptanceStatus.putIfAbsent(event, new HashMap<>());
        return this.acceptanceStatus.get(event).getOrDefault(member, MemberAcceptanceStatus.PENDING);
    }
}
