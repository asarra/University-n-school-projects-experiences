public class HelloWorld {
    private static String prefix = "Hallo,";
    private static String postfix = "!";
    /**
     * Constructs a greeting line.
     **
     @param receiver is the receiver of the greeting.
     */
    private static String buildGreeting(String receiver) {
        String greeting = HelloWorld.prefix + " " + receiver
                + HelloWorld.postfix;
        return greeting;
    }
    /**
     * The main method is the entry point to our program.
     **
     @param args list of program arguments.
     */
    public static void main(String[] args) {
        String greeting = args.length>0 ? HelloWorld.buildGreeting(args[0]) : HelloWorld.buildGreeting("Welt");
        System.out.println(greeting);
    }
}