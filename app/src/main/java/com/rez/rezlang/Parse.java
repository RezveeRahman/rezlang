/**
 * @author: Rezvee Rahman
 * @date:   08/26/2025
 *
 * @description: This file is responsible for taking input from the file
 *               and parsing it.
 */
package com.rez.rezlang;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;

import com.rez.utils.FileHelper;

public class Parse {

    private static Parse instance;

    private static final Path   currPath = Paths.get
            (System.getProperty("user.dir"));
    private static final String CLASS_NAME = Parse.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /* -----------------------------------------------------------------
     * -- public methods
     * ----------------------------------------------------------------- */

    /**
     * This method initializes the parse singleton.
     * @throws InstanceAlreadyExistsException
     */
    public static void initialize() throws InstanceAlreadyExistsException {
        logger.entering(CLASS_NAME, "Parse");
        if (instance != null)
            throw new InstanceAlreadyExistsException
                    ("Parse is already initialized");
        instance = new Parse();
        logger.exiting(CLASS_NAME, "Parse");
    }

    /**
     * This method returns the singleton. If instance does not exist
     * then return null.
     * @return
     * @throws InstanceNotFoundException
     */
    public static Parse getInstance() throws InstanceNotFoundException {
        logger.entering(CLASS_NAME, "getInstance");
        if (instance == null)
            throw new InstanceNotFoundException("Parse does not exist.");
        logger.exiting(CLASS_NAME, "getInstance");
        return (instance);
    }

    public static void receiveInputFile(ArrayList<String> listOfFiles) {
        logger.entering(CLASS_NAME, "receiveInputFile");
        try {
            FileHelper instance = FileHelper.getInstance();
            for (String strFile : listOfFiles) {
                instance.readFile(Path.of(currPath.toString(), strFile));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            logger.exiting(CLASS_NAME, "receiveInputFile");
        }
    }

    /* -----------------------------------------------------------------
     * -- private methods
     * ----------------------------------------------------------------- */



    /* -----------------------------------------------------------------
     * -- inner classes
     * ----------------------------------------------------------------- */
}
