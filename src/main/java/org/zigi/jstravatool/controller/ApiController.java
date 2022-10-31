package org.zigi.jstravatool.controller;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zigi.jstravatool.config.ApplicationConfiguration;
import org.zigi.jstravatool.model.Athlete;
import org.zigi.jstravatool.model.TokenResponse;
import org.zigi.jstravatool.util.Constants;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class ApiController {

    private final ApplicationConfiguration applicationConfiguration;

    private static final Logger LOG = LogManager.getLogger(ApiController.class);

    public ApiController(ApplicationConfiguration applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration;
    }

    @ResponseBody
    @GetMapping("/me")
    public ResponseEntity<Athlete> getLoggerAthlete(@RequestParam(name = "code", required = false) String code,
                                                    @RequestParam(name = "scope", required = false) String scope,
                                                    @RequestParam(name = "accessToken", required = false) String accessToken) {
        LOG.info("Code: " + code);
        LOG.info("Scope: " + scope);
        LOG.info("AccessToken:" + accessToken);

        // after authorize
        if(code != null) {
            TokenResponse tokenResponse = generateToken(code);

            //redirect to authorize and generate access token
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", String.format("http://194.182.70.42/jStravaTools/api/me?accessToken=%s", tokenResponse.getAccessToken()));
            return new ResponseEntity<>(headers, HttpStatus.PERMANENT_REDIRECT);
        }

        // empty access token
        if(accessToken == null || accessToken.isEmpty()) {
            String redirectUri = URLEncoder.encode("http://194.182.70.42/jStravaTools/api/me", StandardCharsets.UTF_8);

            //redirect to authorize and generate access token
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", String.format("http://194.182.70.42/jStravaTools/oauth2/authorize?redirectUri=%s", redirectUri));
            return new ResponseEntity<>(headers, HttpStatus.PERMANENT_REDIRECT);
        }

        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpUriRequest request = RequestBuilder.get()
                    .setUri("https://www.strava.com/api/v3/athlete")
                    .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                    .setHeader(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", accessToken))
                    .build();
            HttpResponse response = client.execute(request);
            try (InputStream stream = response.getEntity().getContent()) {
                return ResponseEntity.ok(Constants.MAPPER.readValue(stream, Athlete.class));
            } catch(Exception e) {
                LOG.error("Fail read response stream", e);
            }
        } catch(Exception e) {
            LOG.error("Fail request", e);
        }
        return ResponseEntity.notFound().build();
    }

    private TokenResponse generateToken(String code) {
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpPost post = new HttpPost("https://www.strava.com/api/v3/oauth/token");

            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("client_id", String.valueOf(applicationConfiguration.getClientId())));
            params.add(new BasicNameValuePair("client_secret", applicationConfiguration.getClientSecret()));
            params.add(new BasicNameValuePair("code", code));
            params.add(new BasicNameValuePair("grant_type", "authorization_code"));
            post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

            HttpResponse response = client.execute(post);
            try (InputStream stream = response.getEntity().getContent()) {
                String text = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
                LOG.info(text);
                return Constants.MAPPER.readValue(stream, TokenResponse.class);
            } catch(Exception e) {
                LOG.error("Fail read response stream", e);
            }
        } catch(Exception e) {
            LOG.error("Fail request", e);
        }
        return null;
    }
}
