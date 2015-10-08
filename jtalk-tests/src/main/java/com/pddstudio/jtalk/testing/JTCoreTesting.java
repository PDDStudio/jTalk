package com.pddstudio.jtalk.testing;

/**
 * Created by pddstudio on 07.10.15.
 */

import com.pddstudio.jtalk.core.JTCore;
import com.pddstudio.jtalk.core.configuration.JTalkConfig;
import com.pddstudio.jtalk.core.log.JLog;
import com.pddstudio.jtalk.core.values.Log;

import java.util.Scanner;

/**
 * Used to test several JTalk core functions
 */
public class JTCoreTesting {

    private final JTalkConfig jTalkConfig = new JTalkConfig() {
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

    private final JTCore jtCore;

    public JTCoreTesting() {
        jtCore = new JTCore(jTalkConfig);
    }

    public static void main(String[] args) {
        JTCoreTesting jtCoreTesting = new JTCoreTesting();
        Scanner scanner = new Scanner(System.in);
        String input;
        while(scanner.hasNext()) {
            input = scanner.nextLine();
            if(input.toLowerCase().equals("exit")) {
                jtCoreTesting.onExit();
            }
        }

    }

    private void onExit() {
        System.out.println("onExit() called. Shutting down JTCore...");
        jtCore.destroy();
        System.out.println("Finished. Leaved main().");
        System.exit(0);
    }

}
