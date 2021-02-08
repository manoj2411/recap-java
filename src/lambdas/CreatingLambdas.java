class CreatingLambdas {
    interface Greeting {
        public String hello(String name);
    }

    static void testGeeting(String s, Greeting g) {
        System.out.println("Result: " + g.hello(s));
    }

    public static void main(String[] args) {

        testGeeting("laddu", (String name) -> "Hey, " + name + "!");

        testGeeting("daggu", (String name) -> "Howdy, " + name + "!");

        testGeeting("Chiku",
            (String name) -> name.isEmpty() ? "Name missing" : "Hey, " + name + "!");

        testGeeting("",
            (String name) -> name.isEmpty() ? "Name missing!" : "Hey, " + name + "!");
    }
}
