package fr.yghore.dyglib;

public class Logger {


    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    private static Logger logger;

    private String prefix;

    public static void setLogger(Logger logger)
    {
        Logger.logger = logger;
    }

    public Logger(String prefix)
    {
        this.prefix = prefix;
        Logger.setLogger(this);
    }

    public static Logger getLogger()
    {
        if(Logger.logger == null){return new Logger("DygLib");}
        return Logger.logger;
    }


    public void sendPrint(String[] messages)
    {
        for (String message : messages) {
            this.sendPrint(message);
        }
    }
    public void sendPrint(String message)
    {
        String sb = GREEN +
                "[" +
                RESET +
                this.prefix +
                GREEN +
                "] " +
                RESET +
                message + "\n";

        System.out.println(sb);
    }


    public void sendError(String[] messages)
    {
        for (String message : messages) {
            this.sendError(message);
        }
    }

    public void sendError(String message)
    {
        String sb = RED +
                "ERROR[" +
                RESET +
                this.prefix +
                RED +
                "] " +
                RESET +
                message + "\n";

        System.out.print(sb);
    }

    public void sendDebug(String message)
    {
        String sb = RED +
                "DEBUG[" +
                RESET +
                this.prefix +
                RED +
                "] " +
                RESET +
                message + "\n";

        System.out.print(sb);
    }

}
