package Questions.Google_Calendar;

import Questions.Google_Calendar.enums.EventType;
import Questions.Google_Calendar.models.Company;
import Questions.Google_Calendar.models.Event;
import Questions.Google_Calendar.models.Member;
import Questions.Google_Calendar.service.EventService;
import Questions.Google_Calendar.service.Impl.EventServiceImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        testData1();
        testData2();
        testData3();
    }

    private static Event buildEvent(){
        Company company = new Company("Test Company");
        Member m1 = new Member("m1", "m1@org.com", company);
        Member m2 = new Member("m2", "m2@org.com", company);
        Member m3 = new Member("m3", "m3@org.com", company);
        Member m4 = new Member("m4", "m4@org.com", company);
        Member m5 = new Member("m5", "m5@org.com", company);

        return new Event.EventBuilder()
                .withTitle("Test Event")
                .withDescription("Test Description")
                .withOrganizer(m1)
                .withLocation("Test Location")
                .withStartTime(1693671272L)
                .withEndTime(1693678472L)
                .withParticipants(new HashSet<>(Arrays.asList(m1, m2, m3, m4, m5)))
                .withEventType(EventType.MEETING)
                .build();
    }
    private static void testData3() {
        EventService eventService = new EventServiceImpl();
        Event event = eventService.createEvent(buildEvent());
        List<Event> events = eventService.fetchEventsInTheRange((Member) event.getParticipantAtLocation(3), 1693671271L, 1693678472L);

        System.out.println("Event count for the organizer: " + events.size()); // 1
    }

    private static void testData2() {
        EventService eventService = new EventServiceImpl();
        Event event = eventService.createEvent(buildEvent());
        List<Event> events = eventService.fetchEventsInTheRange(event.getOrganizerAtLocation(0), 1693671271L, 1693678472L);

        System.out.println("Event count for the organizer: " + events.size()); // 1
    }

    private static void testData1() {
        EventService eventService = new EventServiceImpl();
        Event newEvent = buildEvent();
        List<Event> events = eventService.fetchEventsInTheRange(newEvent.getOrganizerAtLocation(0), 1693671271L, 1693678472L);
        System.out.println("Event count for the organizer: " + events.size()); // 0
    }
}
