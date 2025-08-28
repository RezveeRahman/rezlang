package com.rez.rezlang;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;

public enum Usage {

    /*
     *  Flag Tracker:
     *      Flags - 4
     */
    HELP("-h", "Prints out usage."),
    INPUT("-i", "Path to input file (example: /home/<user>/main.rez)"),
    OUTPUT("-o", "Output name (example: main.rezo)"),
    DEBUG("-d", "Debug level:"
            + "[1 - Info]"
            + "[2 - Warning]"
            + "[3 - Sever]"
            + "[4 - All]");


    private static final EnumSet<Usage> USAGE_ENUM_SET =
            EnumSet.allOf(Usage.class);
    private static final int USAGE_SIZE =
            USAGE_ENUM_SET.size();

    public static final String EXAMPLE =
            "\033[1mExample 1: \033[0m java -jar rezlang-xxx.jar -i"
            + "main.rez -o main.rezo";

    public String flag;
    public String usage;


    /* -----------------------------------------------------------------
     * -- constructor methods
     * ----------------------------------------------------------------- */

    private Usage(String f, String u) {
        flag = f;
        usage = u;
    }

    /* -----------------------------------------------------------------
     * -- public methods
     * ----------------------------------------------------------------- */

    /**
     * This getter is responsible for creating a list of flags that is
     * from usage.
     *
     * @return
     */
    public static ArrayList<String> getUsageFlags() {
        final ArrayList<String> USAGE_FLAG_ARRAY;
        Iterator<Usage> iter;
        Usage           usage;

        USAGE_FLAG_ARRAY = new ArrayList<String>(USAGE_SIZE);
        iter = USAGE_ENUM_SET.iterator();
        while (iter.hasNext()) {
            usage = iter.next();
            USAGE_FLAG_ARRAY.add(usage.flag);
        }

        return (USAGE_FLAG_ARRAY);
    }
}
