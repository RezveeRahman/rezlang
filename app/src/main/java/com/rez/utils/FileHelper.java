/**
 * @author: Rezvee Rahman
 * @date:   08/23/2025
 *
 * @description: This class contains the structure of reading and writing
 *               files. We will use this to help us assist breaking down
 *               the file for our parser. We will also use this class to
 *               help us write intermediate output files.
 */
package com.rez.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;

public class FileHelper {

    private static final String CLASS_NAME = FileHelper.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    private static FileHelper instance;


    /* -----------------------------------------------------------------
     * -- constructor methods
     * ----------------------------------------------------------------- */

    /**
     * This constructor creates a new FileHelper instance.
     */
    private FileHelper() { }


    /* -----------------------------------------------------------------
     * -- public methods
     * ----------------------------------------------------------------- */

    /**
     * This method is responsible for initializing the FileHelper
     * singleton. This method is synchronized, in the case that multiple
     * calls are made to this method.
     * @throws InstanceAlreadyExistsException
     */
    public synchronized static void initialize()
            throws InstanceAlreadyExistsException {
        logger.entering(CLASS_NAME, "initialize");
        if (instance != null) {
            throw new InstanceAlreadyExistsException
                    (CLASS_NAME + " already exists");
        }
        instance = new FileHelper();
        logger.exiting(CLASS_NAME, "initialize");
    }

    /**
     * This method is responsible for getting the instance of
     * `FileHelper`
     * @return FileHelper instance
     */
    public static FileHelper getInstance() throws InstanceNotFoundException {
        logger.entering(CLASS_NAME, "getInstance");
        if (instance == null)
            throw new InstanceNotFoundException();
        logger.exiting(CLASS_NAME, "getInstance");
        return (instance);
    }


    public synchronized void readFile(Path filePath) {
        File f;

        logger.entering(CLASS_NAME, "readFile");
        try {
            f = resolvePath(filePath);
            readFileData(f);
        } catch (FileNotFoundException ffe) {
            logger.log(Level.SEVERE, ffe.getMessage());
        } catch (IOException ioe) {
            logger.log(Level.SEVERE, ioe.getMessage());
        }
        logger.exiting(CLASS_NAME, "readFile");
    }


    /* -----------------------------------------------------------------
     * -- private methods
     * ----------------------------------------------------------------- */

     /**
      * This method is responsible for resolving the file path. It will
      * check if the `filepath` in question is a file. We do not want to
      * deal with symbolic links, so we throw an exception if we find one.
      *
      * @param filePath
      * @return
      * @throws FileNotFoundException
      */
    private File resolvePath(Path filePath) throws FileNotFoundException {
        logger.entering(CLASS_NAME, "resolvePath");
        if (!Files.exists(filePath, LinkOption.NOFOLLOW_LINKS)
                || Files.isSymbolicLink(filePath)) {
            throw new FileNotFoundException("The \"file\" is not found"
                + " or is a symbolic link!");
        } else if (Files.isDirectory(filePath, LinkOption.NOFOLLOW_LINKS)) {
            throw new FileNotFoundException("The \"file\" is a directory");
        } else {
            return (filePath.toFile());
        }
    }

    private void readFileData(File file) throws FileNotFoundException,
            IOException{
        BufferedReader br;
        FileReader     fr;
        Stream<String> streamStr;

        logger.entering(CLASS_NAME, "readFileData");
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            streamStr = br.lines();
        } catch (FileNotFoundException fnfe) {
            throw new FileNotFoundException("file was not found!");
        } catch (IOException ioe) {
            throw new IOException("Couldn't open or close streams properly!");
        }

        streamStr.forEach(System.out::println);
        br.close();
        fr.close();
        logger.exiting(CLASS_NAME, "readFileData");
    }

    /* -----------------------------------------------------------------
     * -- inner classes
     * ----------------------------------------------------------------- */
}
