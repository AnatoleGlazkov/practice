package logger;

import lombok.extern.slf4j.Slf4j;

/** The type HelloLogging */
@Slf4j
public class HelloLogging {

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
