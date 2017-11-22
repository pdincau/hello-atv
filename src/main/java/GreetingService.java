class GreetingService {

    public String greet(String name) {
        if ("".equals(name)) {
            return "Hello stranger! What's your name";
        }
        return "Hello " + name + "!";
    }

}