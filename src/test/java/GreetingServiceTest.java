import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetingServiceTest {

    @Test
    public void it_greets_people() {
        GreetingService service = new GreetingService();

        String greetingMessage = service.greet("Ivo");

        assertEquals("Hello Ivo!", greetingMessage);
    }

    @Test
    public void it_asks_name_when_name_is_missing() {
        GreetingService service = new GreetingService();

        String greetingMessage = service.greet("");

        assertEquals("Hello! Who are you?", greetingMessage);
    }

}
