package com.pddstudio.jtalk.core.db;

import com.pddstudio.jtalk.core.configuration.CoreConfig;
import com.pddstudio.jtalk.core.log.JLog;
import com.pddstudio.jtalk.core.tools.JHelp;
import com.pddstudio.jtalk.core.values.Log;
import org.iq80.leveldb.*;
import static org.fusesource.leveldbjni.JniDBFactory.*;
import java.io.*;

/**
 * Created by pddstudio on 06.10.15.
 */

/**
 * The Database class is used by JTalk's core. It saves and restores common values using LevelDB.
 */
public class Database {

    /**
     * This class is the wrapper for the LevelDB interface
     */

    private static Database database;

    private static final String DATABASE_LOCATION = CoreConfig.JTALK_ROOT_DIR + CoreConfig.JTALK_DB + CoreConfig.JTALK_CORE_DB_NAME;
    private static final String DATABASE_LOGFILE = CoreConfig.JTALK_ROOT_DIR + CoreConfig.JTALK_LOG_DIR + CoreConfig.JLog.DATABASE_LOGFILE;

    DB db;

    private PrintWriter printWriter;
    private BufferedWriter bufferedWriter;
    private FileWriter fileWriter;

    Logger logger = new Logger() {
        public void log(String s) {
            //if(printWriter != null) printWriter.println(s);
        }
    };

    private Database() {

        File databaseFile = new File(DATABASE_LOCATION);
        File databaseLogFile = new File(DATABASE_LOGFILE + JHelp.Date.getCurrentDate() + ".log");

        if(!databaseLogFile.exists()) {
            JLog.print("Created log file for the database.", Log.INFO);
        }

        Options options = new Options();
        options.createIfMissing(true);

        if(CoreConfig.JLog.CREATE_LOG_FILES) {
            try {
                fileWriter = new FileWriter(databaseLogFile, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                printWriter = new PrintWriter(bufferedWriter);
                options.logger(logger);
            } catch (IOException e) {
                JLog.print("Failed to open the database log file:\n" + e.getMessage(), Log.WARNING);
            }
        }

        try {
            db = factory.open(databaseFile, options);
            JLog.print("Successfully opened the database connection.", Log.INFO);
        } catch (IOException e) {
            JLog.print("An error occurred when trying to open the database connection:\n" + e.getMessage(), Log.ERROR);
        }

    }

    /**
     * Returns the current Database instance. In case it's not initialized yet, it'll do this before returning.
     * @return the current {@link Database} instance
     */
    public static Database getDatabase() {
        if(database == null) database = new Database();
        return database;
    }

    /**
     * Function to close the current database connection.
     */
    public void close() {
        try {
            db.close();
        } catch (IOException e) {
            JLog.print("An error occurred when trying to close the database:\n" + e.getMessage(), Log.ERROR);
        }
    }

    /**
     * Saves a Key Pair value to the database.
     * @param key key value
     * @param value the value for the key
     */
    public void save(String key, String value) {
        db.put(bytes(key), bytes(value));
    }

    /**
     * Returns the value for the given key
     * @param key key value
     * @return Returns the value for the given key
     */
    public String get(String key) {
        return asString(db.get(bytes(key)));
    }

}
