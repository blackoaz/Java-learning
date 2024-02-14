public class Main {
    public static void main(String[] args) {
        boolean seeMe = false;
        boolean feelMe = false;
        int index;

        loop: for (index = 0; index < args.length; index++) {
            String opt = args[index];
            switch (opt) {
                case "-c":
                    seeMe = true;
                    break;
                case "-f":
                    feelMe = true;
                    break;
                default:
                    if (!opt.isEmpty() && opt.charAt(0) == '-') {
                        error("Unknown option: '" + opt + "'");
                    }
                    // Additional handling for arguments after options
                    break loop;
            }
        }
        
        // Check for missing arguments after options
        if (index >= args.length) {
            error("Missing Argument(s)");
        }
        
        // Process additional arguments here
        for (; index < args.length; index++) {
            System.out.println("The value for seeMe is:" + seeMe);
            System.out.println("The value for feelMe is:" + feelMe);
        }
    }

    private static void error(String message) {
        if (message != null) {
            System.err.println(message);
        }
        System.err.println("usage: myapp [-f] [-c] [ <arg> ...]");
        System.exit(1);
    }
}
