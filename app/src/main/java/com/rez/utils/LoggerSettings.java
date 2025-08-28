/**
 * @author: Rezvee Rahman
 * @date:   08/24/2025
 *
 * @description: This class is responsible for settig the log level of
 *               of the system.
 */
package com.rez.utils;

import java.util.logging.Level;

public class LoggerSettings {

    private static Level logLevel;

    /* -----------------------------------------------------------------
     * -- public methods
     * ----------------------------------------------------------------- */

    /**
     * This setter sets the log level.
     * @param level
     */
    public void setLogLevel(Level level) {
        logLevel = level;
    }

    /**
     * This getter returns the log Level.
     * @return
     */
    public Level getLogLevel() {
        return (logLevel);
    }

}
