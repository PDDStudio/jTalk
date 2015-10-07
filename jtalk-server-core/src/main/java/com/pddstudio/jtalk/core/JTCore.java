package com.pddstudio.jtalk.core;

import com.pddstudio.jtalk.core.configuration.JTalkConfig;
import com.pddstudio.jtalk.core.db.Database;
import com.pddstudio.jtalk.core.log.JLog;
import com.pddstudio.jtalk.core.values.Log;

/**
 * Created by pddstudio on 06.10.15.
 */

public class JTCore {

    /**
     * jTalk server core class
     */

    private final JTalkConfig jTalkConfig;

    public JTCore(JTalkConfig jTalkConfig) {
        this.jTalkConfig = jTalkConfig;
        JLog.print("Starting JTCore Module...", Log.INFO);
        Database.getDatabase();
    }

}
