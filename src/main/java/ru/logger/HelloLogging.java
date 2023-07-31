package ru.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** The type HelloLogging */
public class HelloLogging {

    Logger log = LoggerFactory.getLogger(HelloLogging.class);

    public static void main(String[] args) {
        new HelloLogging().log();
    }

    private void log() {
        var value = "test";

        //Современный вариант
        log.info("Hello logging:{}", value);

        try {
            throw new RuntimeException("exception for log");
        } catch (Exception e) {
            log.error("exception log:", e);
        }
    }
}
