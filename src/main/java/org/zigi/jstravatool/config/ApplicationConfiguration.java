package org.zigi.jstravatool.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:/opt/tomcat/latest/conf/strava.properties")
public class ApplicationConfiguration {
    @Value("${accessToken}")
    private String accessToken;

    @Value("${clientId}")
    private String clientId;

    public String getAccessToken() {
        return accessToken;
    }

    public String getClientId() {
        return clientId;
    }
}
