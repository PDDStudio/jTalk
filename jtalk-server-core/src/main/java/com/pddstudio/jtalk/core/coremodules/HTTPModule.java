package com.pddstudio.jtalk.core.coremodules;

import com.pddstudio.jtalk.core.log.JLog;
import com.pddstudio.jtalk.core.modules.BaseModule;
import com.pddstudio.jtalk.core.values.Log;
import com.pddstudio.jtalk.core.values.ModuleStatus;
import fi.iki.elonen.NanoHTTPD;

import java.io.IOException;

/**
 * Created by pddstudio on 08.10.15.
 */
public class HTTPModule extends BaseModule {

    public static final String MODULE_IDENTIFIER = "TALK_CORE_HTTP_MODULE";

    private static final String MODULE_NAME = "JTCore HTTP Module";
    private static final String MODULE_DESC = "JTCore's internal HTTP Module. Required for serving external communication.";
    private static final String MODULE_AUTHOR = "Patrick J | PDDStudio";
    private static final String MODULE_VERSION = "0.1DEV";

    private HTTPServer httpServer;
    private ModuleStatus moduleStatus = ModuleStatus.UNKNOWN;

    public HTTPModule() {
        super(MODULE_IDENTIFIER);
    }
    @Override
    public String getModuleName() {
        return MODULE_NAME;
    }

    @Override
    public String getModuleDescription() {
        return MODULE_DESC;
    }

    @Override
    public String getModuleAuthor() {
        return MODULE_AUTHOR;
    }

    @Override
    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public ModuleStatus onModuleStart() {
        this.httpServer = new HTTPServer(9999);
        httpServer.startServer();
        if(httpServer.hasFailure()) {
            moduleStatus = ModuleStatus.FAILED;
        } else {
            moduleStatus = ModuleStatus.READY;
        }
        return moduleStatus;
    }

    public void onModuleStop() {
        if(httpServer != null) {
            httpServer.stopServer();
            moduleStatus = ModuleStatus.IDLE;
        }
        JLog.print(MODULE_NAME + ": Stopped module [" + moduleStatus.name() + "]", Log.INFO);
    }

    public ModuleStatus getModuleStatus() {
        return moduleStatus;
    }

    public String getModuleErrorReport() {
        if(httpServer != null && httpServer.hasFailure()) {
            return httpServer.getExceptionString();
        }
        return "NO MESSAGE FOUND";
    }

    private static class HTTPServer extends NanoHTTPD {

        private boolean hasException = false;
        private String exceptionString = "";

        HTTPServer(int port) {
            super(port);
        }

        public void startServer() {
            try {
                HTTPServer.this.start();
            } catch (IOException e) {
                hasException = true;
                exceptionString = e.getMessage();
            }
        }

        @Override
        public Response serve(IHTTPSession session) {
            return new Response("I'm running.");
            //TODO: add API support for HTTPModule
        }

        public void stopServer() {
            HTTPServer.this.stop();
        }

        public boolean hasFailure() {
            return hasException;
        }

        public String getExceptionString() {
            return exceptionString;
        }

    }
}
