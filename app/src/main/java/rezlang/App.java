/**
 * @author:     Rezvee Rahman
 * @version:    21.08 (OpenJDK)
 */
package rezlang;

import java.util.logging.Level;

public class App {

    private final static String USAGE =
"""
\t\033[38;5;3mRezlang Compiler (c)\033[0m\n
Description:\tThis is a Java based compiler for Rezlang. It will take in
\t\t*.rez files and output the appropriate intermediate representation (*.rah).

Options:
\t\033[38;5;2mcommonly used options\033[0m
\t\t-i\tinput file
\t\t-o\toutput file
\t\t\033[1mExample 1: \033[0m$ java -jar rezlang -i main.rez -o main.rah
\n
\t\033[38;5;3madvanced options\033[0m

\033[0m
""";

    private static Level logLvl;

    /* -----------------------------------------------------------------
     * -- public methods
     * ----------------------------------------------------------------- */

    /**
     * This method is the main entry of the program. It is responsible
     * for compiling our code and spitting out the appropriate outputs.
     * @param args
     */
    public static void main(String[] args) {
        boolean Unknown;
        int     i;
        String  argument;
        String  flag;

        flag = null;
        argument = null;
        Unknown = false;
        for (i = 0; i < args.length; i++) {
            try {
                switch (args[i]) {
                case "-i":
                    i++;
                    break;
                case "-o":
                    i++;
                    break;
                case "-h":
                    /* stop execution */
                default:
                    throw new IndexOutOfBoundsException("Print help");
                }
            } catch (IndexOutOfBoundsException outOfBounds) {
                printUsage();
            }
        }
    }

    /* -----------------------------------------------------------------
     * -- private methods
     * ----------------------------------------------------------------- */

    /**
     * This method is responsible for printing out the proper usage of
     * the program.
     */
    private static void printUsage() {
        System.out.println(USAGE);
    }

    /* -----------------------------------------------------------------
     * -- inner classes
     * ----------------------------------------------------------------- */


}
