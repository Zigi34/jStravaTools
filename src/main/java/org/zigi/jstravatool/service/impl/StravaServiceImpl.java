package org.zigi.jstravatool.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.zigi.jstravatool.config.ApplicationConfiguration;
import org.zigi.jstravatool.model.ActivityPhoto;
import org.zigi.jstravatool.model.DetailedActivity;
import org.zigi.jstravatool.model.SummaryActivity;
import org.zigi.jstravatool.model.TokenResponse;
import org.zigi.jstravatool.service.StravaService;
import org.zigi.jstravatool.util.Constants;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StravaServiceImpl implements StravaService {

    private static final Logger LOG = LogManager.getLogger(StravaServiceImpl.class);

    private final ApplicationConfiguration applicationConfiguration;

    public StravaServiceImpl(ApplicationConfiguration applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration;
    }

    @Override
    public List<SummaryActivity> activities(String accessToken, LocalDateTime before, LocalDateTime after, Integer page, Integer perPage) {
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpGet get = new HttpGet("https://www.strava.com/api/v3/athlete/activities");
            get.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            get.setHeader(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", accessToken));

            List nameValuePairs = new ArrayList();
            if(before != null) {
                nameValuePairs.add(new BasicNameValuePair("before", String.valueOf(before)));
            }
            if(after != null) {
                nameValuePairs.add(new BasicNameValuePair("after", String.valueOf(after)));
            }
            if(page != null) {
                nameValuePairs.add(new BasicNameValuePair("page", String.valueOf(page)));
            }
            if(perPage != null) {
                nameValuePairs.add(new BasicNameValuePair("per_page", String.valueOf(perPage)));
            }

            URI uri = new URIBuilder(get.getURI()).addParameters(nameValuePairs).build();
            get.setURI(uri);

            HttpResponse response = client.execute(get);
            try (InputStream stream = response.getEntity().getContent()) {
                return Constants.MAPPER.readValue(stream, new TypeReference<List<SummaryActivity>>() {});
            } catch(Exception e) {
                LOG.error("Fail read response stream", e);
            }
        } catch(Exception e) {
            LOG.error("Fail request", e);
        }
        return null;
    }

    @Override
    public DetailedActivity activity(String accessToken, Long id, Boolean includeAllEfforts) {
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpGet get = new HttpGet(String.format("https://www.strava.com/api/v3/activities/%s", id));
            get.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            get.setHeader(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", accessToken));

            List nameValuePairs = new ArrayList();
            if(includeAllEfforts != null) {
                nameValuePairs.add(new BasicNameValuePair("include_all_efforts", String.valueOf(includeAllEfforts)));
            }

            URI uri = new URIBuilder(get.getURI()).addParameters(nameValuePairs).build();
            get.setURI(uri);

            HttpResponse response = client.execute(get);
            try (InputStream stream = response.getEntity().getContent()) {
                String text = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
                LOG.info(text);
                return Constants.MAPPER.readValue(text, DetailedActivity.class);
            } catch(Exception e) {
                LOG.error("Fail read response stream", e);
            }
        } catch(Exception e) {
            LOG.error("Fail request", e);
        }
        return null;
    }

    @Override
    public List<ActivityPhoto> photos(String accessToken, Long id) {
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpGet get = new HttpGet(String.format("https://www.strava.com/api/v3/activities/%s/photos", id));
            get.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            get.setHeader(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", accessToken));

            HttpResponse response = client.execute(get);
            try (InputStream stream = response.getEntity().getContent()) {
                String text = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
                LOG.info(text);
                return Constants.MAPPER.readValue(text, new TypeReference<List<ActivityPhoto>>() {});
            } catch(Exception e) {
                LOG.error("Fail read response stream", e);
            }
        } catch(Exception e) {
            LOG.error("Fail request", e);
        }
        return null;
    }

    @Override
    public TokenResponse generateToken(String code) {
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