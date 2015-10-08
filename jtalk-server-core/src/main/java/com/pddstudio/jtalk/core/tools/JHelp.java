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
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(calendar.get(Calendar.YEAR));
            stringBuilder.append("-");
            int month = calendar.get(Calendar.MONTH);
            month++;
            if(month < 10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(month);
            stringBuilder.append("-");
            if(calendar.get(Calendar.DAY_OF_MONTH) < 10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(calendar.get(Calendar.DAY_OF_MONTH));
            return stringBuilder.toString();
        }

        /**
         * Get the current system date and time as YYYY-MM-DD | hh:mm:ss
         * @return current system date and time as YYYY-MM-DD | hh:mm:ss
         */
        public static String getCurrentDateAndTime() {
            Calendar calendar = GregorianCalendar.getInstance();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(calendar.get(Calendar.YEAR));
            stringBuilder.append("-");
            int month = calendar.get(Calendar.MONTH);
            month++;
            if(month < 10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(month);
            stringBuilder.append("-");
            if(calendar.get(Calendar.DAY_OF_MONTH) < 10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(calendar.get(Calendar.DAY_OF_MONTH));
            stringBuilder.append(" | ");
            if(calendar.get(Calendar.HOUR_OF_DAY) < 10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(calendar.get(Calendar.HOUR_OF_DAY));
            stringBuilder.append(":");
            if(calendar.get(Calendar.MINUTE) < 10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(calendar.get(Calendar.MINUTE));
            stringBuilder.append(":");
            if(calendar.get(Calendar.SECOND) < 10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(calendar.get(Calendar.SECOND));
            return stringBuilder.toString();
        }

    }

}
