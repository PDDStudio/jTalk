package com.pddstudio.jtalk.core.configuration;

/**
 * This class serves the core config and required values
 */
public final class CoreConfig {

    /**
     * This sub class serves the required values for the JLog class.
     */
    public static final class JLog {

        /**
         * Defines weather to create logs or not
         */
        public static final boolean CREATE_LOG_FILES = true;

        /**
         * Defines weather to print the created log messages to the System.out or not.
         */
        public static final boolean PRINT_LOGS = true;
    }

}
