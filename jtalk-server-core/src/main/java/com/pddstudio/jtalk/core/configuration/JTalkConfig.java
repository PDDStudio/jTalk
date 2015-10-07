package com.pddstudio.jtalk.core.configuration;

/**
 * Created by pddstudio on 06.10.15.
 */
public abstract class JTalkConfig  implements IJTalkConfig {

    public abstract void onLoadConfiguration();

    public abstract String getConfigPath();

    public abstract void onModuleLoaded();

    public JTalkConfig() {}

}
