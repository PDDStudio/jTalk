package com.pddstudio.jtalk.core.modules;

/**
 * Created by pddstudio on 07.10.15.
 */

import com.pddstudio.jtalk.core.values.ModuleStatus;

/**
 * Interface used by {@link BaseModule}
 */
public interface IModuleCallback {
    ModuleStatus onModuleStart();
    void onModuleStop();
    ModuleStatus getModuleStatus();
    String getModuleErrorReport();
}
