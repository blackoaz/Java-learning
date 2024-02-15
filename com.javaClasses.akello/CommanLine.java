public class CommanLine {
     
    // Command line use without arguments

    // public static void main(String[] args) {
    // if (args.length > 0) { System.err.println("usage: myapp"); System.exit(1);
    // }
    // // Run the application
    // System.out.println("It worked");
    // }

    // Command line with arguments
    public static void main(String[] args) {
        char heart = '\u2764';
        if (args.length != 2) {
            System.err.println("usage: myapp <arg1> <arg2>");
            System.exit(1);
        }
        // Run the application
        System.out.println("It worked: " + args[0] + ", " + args[1]);
        System.out.println(heart);
    }
    
}
