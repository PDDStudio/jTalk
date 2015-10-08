package com.pddstudio.jtalk.core.log;

import com.pddstudio.jtalk.core.JTCore;
import com.pddstudio.jtalk.core.configuration.CoreConfig;
import com.pddstudio.jtalk.core.tools.JHelp;
import com.pddstudio.jtalk.core.values.Log;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by pddstudio on 06.10.15.
 */

/**
 * The Logger class used by {@link JTCore} and commons.
 */
public final class JLog {

    /**
     * Creates a new log message with {@link Log#DEFAULT}
     * @param logMessage
     */
    public static void print(String logMessage) {
        addMessage(logMessage, Log.DEFAULT);
    }

    /**
     * Creates a new log message with the given {@link Log} value
     * @param logMessage
     * @param logType
     */
    public static void print(String logMessage, Log logType) {
        addMessage(logMessage, logType);
    }

    private static void addMessage(String message, Log importance) {

        String logMessage = datePrefix()
                + importance.forLogMessage()
                + " : "
                + message;

        if(CoreConfig.JLog.PRINT_LOGS) {
            importance.printOnRelatedStream(logMessage);
        }

        if(CoreConfig.JLog.CREATE_LOG_FILES) {
            //TODO: write log to logfile
        }

    }

    /**
     * function to get the current system time in a formatted {@link String}
     * @return Current system date as formatted String: [YYYY-MM-DD | hh:mm:ss]
     */
    private static String datePrefix() {
        return "[" + JHelp.Date.getCurrentDate() + "]";
    }

}
