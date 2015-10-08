package com.pddstudio.jtalk.core.configuration;

/**
 * Created by pddstudio on 06.10.15.
 */
public interface IJTalkConfig {

    void onLoadConfiguration();
    void onModuleLoaded();
    void onModuleDestroyed();
    void onCoreDestroyed();
    String getConfigPath();

}
