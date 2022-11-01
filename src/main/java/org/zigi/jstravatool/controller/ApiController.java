package org.zigi.jstravatool.controller;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zigi.jstravatool.model.Athlete;
import org.zigi.jstravatool.model.DetailedActivity;
import org.zigi.jstravatool.model.SummaryActivity;
import org.zigi.jstravatool.model.TokenResponse;
import org.zigi.jstravatool.service.StravaService;
import org.zigi.jstravatool.util.Constants;

import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ApiController {

    private final StravaService stravaService;

    private static final Logger LOG = LogManager.getLogger(ApiController.class);

    public ApiController(StravaService stravaService) {
        this.stravaService = stravaService;
    }

    @ResponseBody
    @GetMapping("/me")
    public ResponseEntity<Athlete> getLoggerAthlete(@RequestParam(name = "code", required = false) String code,
                                                    @RequestParam(name = "scope", required = false) String scope,
                                                    @RequestParam(name = "accessToken", required = false) String accessToken) {
        // after authorize
        if(code != null) {
            TokenResponse tokenResponse = stravaService.generateToken(code);
            LOG.info(tokenResponse.toString());

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

    @ResponseBody
    @GetMapping("/activities")
    public ResponseEntity<List<SummaryActivity>> athleteActivities(@RequestParam(name = "code", required = false) String code,
                                                                  @RequestParam(name = "scope", required = false) String scope,
                                                                  @RequestParam(name = "accessToken", required = false) String accessToken) {
        // after authorize
        if(code != null) {
            TokenResponse tokenResponse = stravaService.generateToken(code);
            LOG.info(tokenResponse.toString());

            //redirect to authorize and generate access token
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", String.format("http://194.182.70.42/jStravaTools/api/activities?accessToken=%s", tokenResponse.getAccessToken()));
            return new ResponseEntity<>(headers, HttpStatus.PERMANENT_REDIRECT);
        }

        // empty access token
        if(accessToken == null || accessToken.isEmpty()) {
            String redirectUri = URLEncoder.encode("http://194.182.70.42/jStravaTools/api/activities", StandardCharsets.UTF_8);

            //redirect to authorize and generate access token
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", String.format("http://194.182.70.42/jStravaTools/oauth2/authorize?redirectUri=%s", redirectUri));
            return new ResponseEntity<>(headers, HttpStatus.PERMANENT_REDIRECT);
        }

        return ResponseEntity.ok(stravaService.athleteActivities(accessToken, null, null, 1, 30));
    }

    @ResponseBody
    @GetMapping("/activities/{id}")
    public ResponseEntity<DetailedActivity> athleteActivities(
            @PathVariable(value = "id", required = true) Long id,
            @RequestParam(name = "code", required = false) String code, @RequestParam(name = "scope", required = false) String scope,
            @RequestParam(name = "accessToken", required = false) String accessToken) {

        // after authorize
        if(code != null) {
            TokenResponse tokenResponse = stravaService.generateToken(code);
            LOG.info(tokenResponse.toString());

            //redirect to authorize and generate access token
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", String.format("http://194.182.70.42/jStravaTools/api/activities/%s?accessToken=%s", id, tokenResponse.getAccessToken()));
            return new ResponseEntity<>(headers, HttpStatus.PERMANENT_REDIRECT);
        }

        // empty access token
        if(accessToken == null || accessToken.isEmpty()) {
            String redirectUri = URLEncoder.encode("http://194.182.70.42/jStravaTools/api/activities/" + id, StandardCharsets.UTF_8);

            //redirect to authorize and generate access token
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", String.format("http://194.182.70.42/jStravaTools/oauth2/authorize?redirectUri=%s", redirectUri));
            return new ResponseEntity<>(headers, HttpStatus.PERMANENT_REDIRECT);
        }

        return ResponseEntity.ok(stravaService.athleteActivity(accessToken, id, false));
    }
}