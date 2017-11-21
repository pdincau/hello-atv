class GreetingService {

    public static final String NO_ONE = "";

    public String greet(String name) {
        if (NO_ONE.equals(name)) {
            return "Hey! Who are you?";
        } else {
            return "Hello " + name + "!";
        }
    }

}