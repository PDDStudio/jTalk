package com.pddstudio.jtalk.core.configuration;

import com.pddstudio.jtalk.core.db.Database;
import com.pddstudio.jtalk.core.log.JLog;
import com.pddstudio.jtalk.core.values.Log;

/**
 * Created by pddstudio on 06.10.15.
 */
public abstract class JTalkConfig  implements IJTalkConfig {

    public abstract void onLoadConfiguration();

    public abstract String getConfigPath();

    public abstract void onModuleLoaded();

    public void onModuleDestroyed() {

    }

    public void onCoreDestroyed() {
        JLog.print("Core determination incoming. Closing database connection.", Log.INFO);
        Database.getDatabase().close();
    }

    public JTalkConfig() {}

}
