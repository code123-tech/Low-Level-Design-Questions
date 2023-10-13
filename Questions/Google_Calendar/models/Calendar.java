package Questions.Google_Calendar.models;

import Questions.Google_Calendar.enums.CalendarView;

import java.util.List;

public class Calendar {
    private Member member;
    private List<Event> events;
    CalendarView calendarView;
    public Calendar(Member member, List<Event> events, CalendarView calendarView) {
        this.member = member;
        this.events = events;
        this.calendarView = calendarView;
    }
    public Member getMember() {
        return member;
    }

    public List<Event> getEvents() {
        return events;
    }

    public CalendarView getCalendarView() {
        return calendarView;
    }

    public void setCalendarView(CalendarView calendarView) { // Ideally, this should be update at Service Layer
        this.calendarView = calendarView;
    }
}
