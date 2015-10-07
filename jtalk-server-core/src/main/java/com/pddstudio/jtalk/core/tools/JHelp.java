package com.pddstudio.jtalk.core.tools;

/**
 * Created by pddstudio on 07.10.15.
 */

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class which contains several helper methods used by JTalk and it's modules.
 */
public final class JHelp {

    public static class Date {

        /**
         * Returns the current system's date.
         * @return Date as String in YYYY-MM-DD format
         */
        public static String getCurrentDate() {
            Calendar calendar = GregorianCalendar.getInstance();
            return String.valueOf(calendar.get(Calendar.YEAR)) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
        }

    }

}
