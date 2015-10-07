package com.pddstudio.jtalk.core.configuration;

/**
 * This class serves the core config and required values
 */
public final class CoreConfig {

    /**
     * The root directory of JTalk and all it's files.
     */
    public static final String JTALK_ROOT_DIR = "/opt/jTalk";

    /**
     * JTalk's log directory
     */
    public static final String JTALK_LOG_DIR = "/logs";

    /**
     * JTalk's database directory
     */
    public static final String JTALK_DB = "/database";

    /**
     * JTalk's core db file name
     */
    public static final String JTALK_CORE_DB_NAME = "core.db";

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

        public static final String DATABASE_LOGFILE = JTALK_LOG_DIR + "/db_logs/db_log_";

    }

}
