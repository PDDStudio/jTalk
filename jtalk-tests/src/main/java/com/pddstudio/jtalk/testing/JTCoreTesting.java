package com.pddstudio.jtalk.testing;

/**
 * Created by pddstudio on 07.10.15.
 */

import com.pddstudio.jtalk.core.JTCore;
import com.pddstudio.jtalk.core.configuration.JTalkConfig;
import com.pddstudio.jtalk.core.log.JLog;
import com.pddstudio.jtalk.core.values.Log;

/**
 * Used to test several JTalk core functions
 */
public class JTCoreTesting {

    private static final JTalkConfig jTalkConfig = new JTalkConfig() {
        @Override
        public void onLoadConfiguration() {

        }

        @Override
        public String getConfigPath() {
            return null;
        }

        @Override
        public void onModuleLoaded() {
            JLog.print("JTCoreTesting:onModuleLoaded() completed.", Log.INFO);
        }
    };

    public static void main(String[] args) {
        JTCore jtCore = new JTCore(jTalkConfig);
        System.out.println("Finished. Leaved main().");
    }

}
