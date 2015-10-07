package com.pddstudio.jtalk.core.values;

/**
 * Created by pddstudio on 07.10.15.
 */

/**
 * Enumeration for the status of a log message
 */
public enum Log {
    DEFAULT,
    INFO,
    WARNING,
    ERROR;

    public void printOnRelatedStream(String message) {
        switch (this) {
            case DEFAULT:
            case INFO:
            case WARNING:
                System.out.println(message);
                break;
            case ERROR:
                System.err.println(message);
                break;
        }
    }

    public String forLogMessage() {
        return "[" + name() + "]";
    }
}
