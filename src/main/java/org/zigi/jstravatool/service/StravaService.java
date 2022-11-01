package org.zigi.jstravatool.service;

import org.zigi.jstravatool.model.ActivityPhoto;
import org.zigi.jstravatool.model.DetailedActivity;
import org.zigi.jstravatool.model.SummaryActivity;
import org.zigi.jstravatool.model.TokenResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface StravaService {
    List<SummaryActivity> activities(String accessToken, LocalDateTime before, LocalDateTime after, Integer page, Integer perPage);
    DetailedActivity activity(String accessToken, Long id, Boolean includeAllEfforts);

    List<ActivityPhoto> photos(String accessToken, Long id);
    TokenResponse generateToken(String code);
}
