package org.zigi.jstravatool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JStravaToolApplication {

    private static final Logger LOG = LogManager.getLogger(JStravaToolApplication.class);
    public static void main(String[] args) {
        LOG.info("Info level log message");
        LOG.debug("Debug level log message");
        LOG.error("Error level log message");

        SpringApplication.run(JStravaToolApplication.class, args);
    }
}
