import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetingServiceTest {

    @Test
    public void it_greets_people() {
        GreetingService service = new GreetingService();

        String message = service.greet("Ivo");

        assertEquals("Hello Ivo!", message);
    }

    @Test
    public void it_generates_an_error_message_when_name_is_empty() {
        GreetingService service = new GreetingService();

        String message = service.greet("");

        assertEquals("Hello stranger! What's your name", message);
    }

}
