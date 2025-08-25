/**
 * @author: Rezvee Rahman
 * @date:   08/24/2025
 *
 * @description: This class is the main entry point of our program.
 */
package com.rez.rezlang;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Main {

    private static final ArrayList<String> USAGE_FLAG_ARR_LIST =
            Usage.getUsageFlags();
    private static final String CLASS_NAME = Main.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS_NAME);
    private static final String ARGUMENT_PRINTOUT =
    "\033[1mRezlang Programming language\n\033[0m"
    + "\tUsage:\n"
    + "\t" + Usage.HELP.flag + "\t" + Usage.HELP.usage + "\n"
    + "\t" + Usage.INPUT.flag + "\t" + Usage.INPUT.usage + "\n"
    + "\t" + Usage.OUTPUT.flag + "\t" + Usage.OUTPUT.usage + "\n"
    + "\n\t" + "Simple Example: " + Usage.EXAMPLE + "\n"
    + "";

    /* Start with 10, expand by 10 if necessary. */
    private static ArrayList<String> inputFiles = new ArrayList<String>(10);

    /* -----------------------------------------------------------------
     * -- public methods
     * ----------------------------------------------------------------- */

     /**
      * This method is the main entry point of the program. It is
      * responsible for taking
      * @param args - Arguments passed
      */
    public static void main(String[] args) {
        int     i;

        logger.entering(CLASS_NAME, "main");
        /* forced to use if-else statements :-( */
        for (i = 0; i < args.length; i++) {
            try {
                if (Usage.INPUT.flag.equals(args[i])) {
                    /*
                     * Note: Edge case if we have `-i` only,
                     * IndexOutOfBoundsException will be thrown
                     */
                    i++;
                    if (!USAGE_FLAG_ARR_LIST.contains(args[i])) {
                        inputFiles.add(args[i]);
                        logger.log(new LogRecord(Level.INFO, "added "
                                + args[i]));
                    }
                } else if (Usage.HELP.flag.equals(args[i])) {
                    System.out.println(ARGUMENT_PRINTOUT);
                }
            } catch (Exception e) {
                System.out.println(ARGUMENT_PRINTOUT);
            }
        }

        logger.exiting(CLASS_NAME, "main");
    }

    /* -----------------------------------------------------------------
     * -- private methods
     * ----------------------------------------------------------------- */

    /* -----------------------------------------------------------------
     * -- inner classes
     * ----------------------------------------------------------------- */

}
