package org.zigi.jstravatool.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zigi.jstravatool.config.ApplicationConfiguration;
import org.zigi.jstravatool.model.Athlete;

import java.io.InputStream;


@RestController
public class ApiController {

    private final ApplicationConfiguration applicationConfiguration;

    private final Logger LOG = LogManager.getLogger();

    public ApiController(ApplicationConfiguration applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration;
    }

    @GetMapping(name = "/api")
    public Athlete getLoggerAthlete() {
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpUriRequest request = RequestBuilder.get()
                    .setUri("https://www.strava.com/api/v3/athlete")
                    .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                    .setHeader(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", applicationConfiguration.getAccessToken()))
                    .build();
            HttpResponse response = client.execute(request);
            try (InputStream stream = response.getEntity().getContent()) {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(stream, Athlete.class);
            } catch(Exception e) {
                LOG.error("Fail read response stream", e);
            }
        } catch(Exception e) {
            LOG.error("Fail request", e);
        }
        return null;
    }
}
