package com.pddstudio.jtalk.core.db;

import com.pddstudio.jtalk.core.configuration.CoreConfig;
import com.pddstudio.jtalk.core.log.JLog;
import com.pddstudio.jtalk.core.values.Log;
import org.iq80.leveldb.*;
import static org.fusesource.leveldbjni.JniDBFactory.*;
import java.io.*;

/**
 * Created by pddstudio on 06.10.15.
 */

public class Database {

    /**
     * This class is the wrapper for the LevelDB interface
     */

    private static Database database;

    private static final String DATABASE_LOCATION = "";

    DB db;

    private Database() {
        Options options = new Options();
        options.createIfMissing(true);
        try {
            db = factory.open(new File(DATABASE_LOCATION), options);
        } catch (IOException e) {
            JLog.print("An error occurred when trying to open the database:\n" + e.getMessage(), Log.ERROR);
        }

    }

    public static Database getDatabase() {
        if(database == null) database = new Database();
        return database;
    }

}
