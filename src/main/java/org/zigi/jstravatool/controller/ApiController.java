package org.zigi.jstravatool.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zigi.jstravatool.config.ApplicationConfiguration;
import org.zigi.jstravatool.model.Athlete;

import java.io.IOException;
import java.io.InputStream;


@RestController
@RequestMapping(name = "/api")
public class ApiController {

    private final ApplicationConfiguration applicationConfiguration;

    public ApiController(ApplicationConfiguration applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration;
    }

    @GetMapping(name = "/")
    public Athlete getLoggerAthlete() throws IOException {
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
            }
        }
    }
}
