package com.rez.utils;

import java.util.regex.Pattern;

public enum Token {
    /**
     * This section contains all valid lexems (tokens?) of Rezlang.
     */


    /* data type keywords */
    CHAR("\s:\s[cC][hH][Aa][rR];"),
    FLOAT("\s:\s([fF][lL][tT]|[fF][lL][oO][aA][tT]);\s"),
    INT("\s:\s[iI][nN][tT];\s"),


    /* container data type */

    /* ARRAY */
    /* TBD */
    /* ARR_BEGIN(""), */
    /* ARR_END(""), */


    /* function keywords */
    FUNC("\s[fF][uU][nN][cC]\s"),
    RETURN(""),


    /* conditional keywords */
    CASE(""),
    DEFAULT(""),
    ELIF(""),
    ELSE(""),
    ENDIF(""),
    IF(""),
    SWITCH(""),


    /* loop keywords */
    DO(""),
    FOR(""),
    WHILE(""),



    /* special keywords */
    BEGIN(""),
    BREAK(""),
    CONTINUE(""),
    END(""),




    ; /* end of enums */

    // private Pattern pattern;
    private String RegexPat;

    /* -----------------------------------------------------------------
     * -- constructor methods
     * ----------------------------------------------------------------- */

    private Token(String pattern) {}
}
