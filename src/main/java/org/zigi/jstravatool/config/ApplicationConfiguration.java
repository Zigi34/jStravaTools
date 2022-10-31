package org.zigi.jstravatool.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:/opt/tomcat/latest/conf/strava.properties")
public class ApplicationConfiguration {
    @Value("${clientId}")
    private String clientId;

    @Value("${clientSecret}")
    private String clientSecret;

    @Value("${refreshToken}")
    private String refreshToken;

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
