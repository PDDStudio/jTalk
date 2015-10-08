package com.pddstudio.jtalk.core.modules;

/**
 * Created by pddstudio on 07.10.15.
 */

import com.pddstudio.jtalk.core.log.JLog;
import com.pddstudio.jtalk.core.values.Log;
import com.pddstudio.jtalk.core.values.ModuleStatus;

import java.util.HashMap;

/**
 * The ModuleManager (un)registers modules which the {@link com.pddstudio.jtalk.core.JTCore} should load or determinate
 */
public class ModuleManager {

    private final HashMap<String, BaseModule> moduleList;

    private ModuleManager() {
        moduleList = new HashMap<String, BaseModule>();
        JLog.print("ModuleManager initialized.", Log.INFO);
    }

    /**
     * Returns a new ModuleManager instance
     * @return ModuleManager instance
     */
    public static ModuleManager start() {
        return new ModuleManager();
    }

    /**
     * Called when the JTCore is about to shutdown. Disconnects all modules and saves relevant data.
     */
    public void destroy() {
        if(moduleList.isEmpty()) {
            JLog.print("ModuleManager : No attached modules to disconnect. Skipping...", Log.INFO);
        } else {
            JLog.print("ModuleManager : Disconnecting all modules.", Log.INFO);
            for(BaseModule module : moduleList.values()) {
                JLog.print("Disconnecting Module : " + module.getModuleName() + " (Version: " + module.getModuleVersion() + ")", Log.INFO);
                module.onModuleStop();
                moduleList.remove(module.getModuleIdentifier());
            }
        }
    }

    /**
     * Loads the given BaseModule
     * @param module - The module which should be loaded
     */
    public void loadModule(BaseModule module) {
        JLog.print("Trying to load Module: " + module.getModuleName() + " (Version: " + module.getModuleVersion() + ") [IDENT:" + module.getModuleIdentifier() + "]", Log.INFO);
        if(module.onModuleStart().equals(ModuleStatus.READY)) {
            JLog.print("Module successfully loaded!", Log.INFO);
            moduleList.put(module.getModuleIdentifier(), module);
        } else {
            JLog.print("An error occurred when trying to load module " + module.getModuleName() + " [STATUS: " + module.getModuleStatus().name() + "]", Log.ERROR);
        }
    }

    /**
     * Returns the Module object with the given identifier or null
     * @param moduleIdentifier - identifier for the module
     * @return The module or null
     */
    public BaseModule getModule(String moduleIdentifier) {
        return moduleList.get(moduleIdentifier);
    }

    /**
     * Returns the number of modules attached to the ModuleManager
     * @return number of modules
     */
    public int getModulesCount() {
        return moduleList.size();
    }

}
