package com.pddstudio.jtalk.core.modules;

/**
 * Created by pddstudio on 07.10.15.
 */

/**
 * The base module class which all Modules inherit from
 */
public abstract class BaseModule implements IModuleCallback {

    // Abstract methods used to identify the module and deliver informations
    public abstract String getModuleName();
    public abstract String getModuleDescription();
    public abstract String getModuleAuthor();
    public abstract String getModuleVersion();

    /**
     * Returns the module's tag
     * @return Module's tag as String
     */
    public String getModuleIdentifier() {
        return MODULE_TAG;
    }

    private String MODULE_TAG;

    public BaseModule(String moduleIdentifier) {
        this.MODULE_TAG = moduleIdentifier;
    }


}
