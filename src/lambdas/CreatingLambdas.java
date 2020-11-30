class CreatingLambdas {
    interface Greeting {
        public String hello(String name);
    }

    static void testGeeting(String s, Greeting g) {
        System.out.println("Result: " + g.hello(s));
    }

    public static void main(String[] args) {

        testGeeting("Ram", (String name) -> "Hey, " + name + "!");

        testGeeting("Chiku", (String name) -> "Howdy, " + name + "!");

        testGeeting("Chiku", (String name) -> name.isEmpty() ? "Name missing" : "Hey, " + name + "!");
        testGeeting("",
            (String name) -> name.isEmpty() ? "Name missing!" : "Hey, " + name + "!");
    }
}
