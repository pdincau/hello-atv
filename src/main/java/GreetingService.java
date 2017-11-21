class GreetingService {

    public String greet(String name) {

        if ("".equals(name)) {
            return "Hello! Who are you?";
        } else {
            return "Hello " + name + "!";
        }
    }

}