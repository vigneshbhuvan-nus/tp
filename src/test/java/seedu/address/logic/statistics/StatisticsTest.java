package seedu.address.logic.statistics;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class StatisticsTest {

    @Test
    void testTimesOpened_ShouldBeInitially0_ForNoArgsConstructor() {
        Statistics statistics = new Statistics();
        assertEquals(statistics.getTimesOpened(), 0);
    }

    @Test
    void testEventLog_ShouldInitiallyBeEmpty_ForNoArgsConstructor() {
        Statistics statistics = new Statistics();
        assertEquals(statistics.getEventLog().size(), 0);
    }

    @Test
    void testTimesOpened_ShouldBeCorrect_ForConstructorWithArgs() {
        List<Event> eventLog = new ArrayList<>();
        eventLog.add(new Event(EventType.LOGIN));
        eventLog.add(new Event(EventType.LOGIN));
        eventLog.add(new Event(EventType.LOGIN));
        eventLog.add(new Event(EventType.LOGIN));
        eventLog.add(new Event(EventType.LOGIN));
        eventLog.add(new Event(EventType.LOGIN));
        eventLog.add(new Event(EventType.LOGIN));
        int timesOpened = 999;
        Statistics statistics = new Statistics(timesOpened, eventLog);
        assertEquals(statistics.getTimesOpened(), timesOpened);
    }

    @Test
    void testEventLog_ShouldBeCorrect_ForConstructorWithArgs() {
        List<Event> eventLog = new ArrayList<>();
        eventLog.add(new Event(EventType.LOGIN));
        eventLog.add(new Event(EventType.LOGIN));
        eventLog.add(new Event(EventType.LOGIN));
        eventLog.add(new Event(EventType.LOGIN));
        eventLog.add(new Event(EventType.LOGIN));
        eventLog.add(new Event(EventType.LOGIN));
        eventLog.add(new Event(EventType.LOGIN));
        int timesOpened = 999;
        Statistics statistics = new Statistics(timesOpened, eventLog);
        assertEquals(statistics.getEventLog(), eventLog);
    }

    @Test
    void testTimesOpened_ShouldBeCorrect_For1RegisterLogin() {
        Statistics statistics = new Statistics();
        assertEquals(statistics.getEventLog().size(), 0);
        statistics.registerAppLogin();
        assertEquals(statistics.getEventLog().size(), 1);
        assertEquals(statistics.getEventLog().get(0).getEventType(), EventType.LOGIN);
    }

    @Test
    void testTimesOpened_ShouldBeCorrect_For1RegisterLoginLogout() {
        Statistics statistics = new Statistics();
        assertEquals(statistics.getEventLog().size(), 0);
        statistics.registerAppLogin();
        assertEquals(statistics.getEventLog().size(), 1);
        statistics.registerAppLogout();
        assertEquals(statistics.getEventLog().size(), 2);
        assertEquals(statistics.getEventLog().get(0).getEventType(), EventType.LOGIN);
    }

    @Test
    void testTimesOpened_ShouldBeCorrect_ForMultipleLoginLogouts() {
        Statistics statistics = new Statistics();
        assertEquals(statistics.getEventLog().size(), 0);
        statistics.registerAppLogin();
        assertEquals(statistics.getEventLog().size(), 1);
        statistics.registerAppLogout();
        assertEquals(statistics.getEventLog().size(), 2);
        assertEquals(statistics.getEventLog().get(0).getEventType(), EventType.LOGIN);
        for(int i=0;i<5;++i){
            statistics.registerAppLogin();
        }
        for(int i=0;i<3;++i){
            statistics.registerAppLogout();
        }
        assertEquals(statistics.getEventLog().stream().filter(event -> event.getEventType() == EventType.LOGIN).count(), 6);
    }
}