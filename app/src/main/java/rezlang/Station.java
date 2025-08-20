/**
 * @author: Rezvee Rahman
 * @date:   08/19/2025
 *
 * @description: This class is responsible taking input an input file
 *               and reading the file, It is used by the parser.
 *
 *               I couldn't come up with a better name. So stationer
 *               will work for now.
 *
 *               As a design choice we'll pick non-blocking input / output
 *               (nio) for our file handling framework. The reason is
 *               straight forward:
 *
 *               (1) - We want to have greater control over the
 *                     filesystem. Java IO does have a good selection
 *                     of methods to choose from, Java NIO has a better
 *                     set of tools we can fully use.
 *
 *               (2) - Future proofing for asynchronous coding.
 *
 *               With all that being said, we still use Java IO for
 *               certain situations.
 */

package rezlang;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Queue;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.InstanceAlreadyExistsException;

public class Station {

    private static final String CLASS_STRING = Station.class.getName();

    private static ConsoleHandler   ch;
    private static Logger           stationLogger;
    private static ArrayList<Path> filePaths;

    private static Station instance;

    /* -----------------------------------------------------------------
     * -- constructor methods
     * ----------------------------------------------------------------- */

    /**
     * This is the default constructor of our class.
     */
    private Station() {
        stationLogger = Logger.getLogger(CLASS_STRING);
        stationLogger.setLevel(Level.ALL);
        stationLogger.addHandler(ch);
    }

    /* -----------------------------------------------------------------
     * -- public methods
     * ----------------------------------------------------------------- */

    /**
     * Initializes the station singleton for parsing through files.s
     * @throws InstanceAlreadyExistsException
     */
    public static void iniitalize() throws InstanceAlreadyExistsException {
        if (instance != null)
            throw new InstanceAlreadyExistsException
                    (CLASS_STRING + " an instance already exists");
        instance = new Station();
    }


    /* -----------------------------------------------------------------
     * -- private methods
     * ----------------------------------------------------------------- */

    /**
     * Add file to queue to be then filtered and checked.
     * @param filepath
     */
    private void addToQueue(String[] filepath) throws InvalidPathException {
        stationLogger.entering(CLASS_STRING, "addToQueue");
        stationLogger.info("create queue the size of the filepaths");
        filePaths = new ArrayList<Path>(filepath.length);
        for (String f : filepath) {
            stationLogger.info("adding: " + f);
            filePaths.add(Paths.get(f));
        }
    }

    /**
     * We will use UN*X based file paths. Avoid follow soft links. We s
     * @param filepath
     */
    private void doesFileExist(Path path) throws FileNotFoundException {
        if (!Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            stationLogger.log(Level.SEVERE, "The file wasn't found!");
            throw new FileNotFoundException(CLASS_STRING);
        }
    }

    /**
     * This method is responsible for reading the file permission before
     * attempting to perform any sort of execution.
     * @param p - Path
     */
    private void readFilePermissions(Path p) {
        try {
        } catch (Exception e) {

        }
    }

    /* -----------------------------------------------------------------
     * -- inner classes
     * ----------------------------------------------------------------- */

}
