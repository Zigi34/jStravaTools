package org.zigi.jstravatool.service;

import org.zigi.jstravatool.model.DetailedActivity;
import org.zigi.jstravatool.model.SummaryActivity;
import org.zigi.jstravatool.model.TokenResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface StravaService {
    List<SummaryActivity> athleteActivities(String accessToken, LocalDateTime before, LocalDateTime after, Integer page, Integer perPage);
    DetailedActivity athleteActivity(String accessToken, Long id, Boolean includeAllEfforts);
    TokenResponse generateToken(String code);
}
