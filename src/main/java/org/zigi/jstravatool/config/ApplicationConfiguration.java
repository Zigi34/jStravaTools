package org.zigi.jstravatool.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("file:/opt/tomcat/latest/conf/strava.properties")
public class ApplicationConfiguration {
    @Value("${accessToken}")
    private String accessToken;

    private final Environment env;

    public ApplicationConfiguration(Environment env) {
        this.env = env;
    }

    public String getAccessToken() {
        return env.getProperty("accessToken");
    }
}
