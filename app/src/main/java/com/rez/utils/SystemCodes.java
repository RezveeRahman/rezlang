/**
 * @author: Rezvee Rahman
 * @date:   08/23/2025
 *
 *
 */
package com.rez.utils;

public enum SystemCodes {
    FILE_FAILURE (1),
    SINGLETON_FAILURE (2);


    private int code;

    /* -----------------------------------------------------------------
     * -- enum constructor
     * ----------------------------------------------------------------- */

    /**
     * This method creates a SystemCodes enum type.
     * @param ExitCode
     */
    private SystemCodes(int ExitCode) {
        code = ExitCode;
    }

    /* -----------------------------------------------------------------
     * -- public enum methods
     * ----------------------------------------------------------------- */

    /**
     * This getter returns the exit code of the SystemCodes enum type.
     * @return code (int)
     */
    public int getCode() {
        return (code);
    }


}
