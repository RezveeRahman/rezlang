/**
 * @author: Rezvee Rahman
 * @date:   08/24/2025
 *
 * @description: This class is the main entry point of our program.
 */
package com.rez.rezlang;

import com.rez.utils.LoggerSettings;

public class Main {

    private static final String ARGUMENT_PRINTOUT =
    "\033[1mRezlang Programming language\n\033[0m"
    + "\tUsage:\n"
    + "\t" + Usage.HELP.flag + "\t" + Usage.HELP.usage + "\n"
    + "\t" + Usage.INPUT.flag + "\t" + Usage.INPUT.usage + "\n"
    + "\t" + Usage.OUTPUT.flag + "\t" + Usage.OUTPUT.usage + "\n"
    + "\n\t" + "Simple Example: " + Usage.EXAMPLE.usage + "\n"
    + "";

    /* -----------------------------------------------------------------
     * -- public methods
     * ----------------------------------------------------------------- */

     /**
      * This method is the main entry point of the program. It is
      * responsible for taking
      * @param args - Arguments passed
      */
    public static void main(String[] args) {
        System.out.println(ARGUMENT_PRINTOUT);
    }

    /* -----------------------------------------------------------------
     * -- private methods
     * ----------------------------------------------------------------- */

    /* -----------------------------------------------------------------
     * -- inner classes
     * ----------------------------------------------------------------- */

}
