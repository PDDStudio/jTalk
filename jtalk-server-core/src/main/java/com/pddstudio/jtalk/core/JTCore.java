package com.pddstudio.jtalk.core;

import com.pddstudio.jtalk.core.configuration.JTalkConfig;
import com.pddstudio.jtalk.core.coremodules.HTTPModule;
import com.pddstudio.jtalk.core.db.Database;
import com.pddstudio.jtalk.core.log.JLog;
import com.pddstudio.jtalk.core.modules.ModuleManager;
import com.pddstudio.jtalk.core.tools.JHelp;
import com.pddstudio.jtalk.core.values.Log;

/**
 * Created by pddstudio on 06.10.15.
 */

public class JTCore {

    /**
     * jTalk server core class
     */

    private final JTalkConfig jTalkConfig;
    private final ModuleManager moduleManager;

    private static final String LAST_START = "JTCORE_LAST_START";

    public JTCore(JTalkConfig jTalkConfig) {
        this.jTalkConfig = jTalkConfig;
        this.moduleManager = ModuleManager.start();
        JLog.print("Starting JTCore...", Log.INFO);
        Database.getDatabase();
        moduleManager.loadModule(new HTTPModule());
        JLog.print("Last JTCore start: " + Database.getDatabase().get(LAST_START), Log.INFO);
        Database.getDatabase().save(LAST_START, JHelp.Date.getCurrentDateAndTime());
    }

    public void destroy() {
        jTalkConfig.onCoreDestroyed();
        moduleManager.destroy();
    }

}
