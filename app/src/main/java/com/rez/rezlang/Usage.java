package com.rez.rezlang;

public enum Usage {

    HELP("-h", "Prints out usage."),
    INPUT("-i", "Path to input file (example: /home/<user>/main.rez)"),
    OUTPUT("-o", "Output name (example: main.rezo)"),
    EXAMPLE("ex1", "java -jar rezlang -i ~/main.rez -o ~/main.rezo");

    public String flag;
    public String usage;

    /* -----------------------------------------------------------------
     * -- constructor methods
     * ----------------------------------------------------------------- */

    private Usage(String f, String u) {
        flag = f;
        usage = u;
    }
}
