package org.zigi.jstravatool.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DetailedActivity extends SummaryActivity {
    private String description;
    private PhotosSummary photos;
    private SummaryGear gear;
    private Double calories;

    @JsonProperty("segment_efforts")
    private List<DetailedSegmentEffort> segmentEfforts;

    @JsonProperty("device_name")
    private String devideName;

    @JsonProperty("embed_token")
    private String embedToken;

    private List<Lap> laps;

    @JsonProperty("best_efforts")
    private List<DetailedSegmentEffort> bestEfforts;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PhotosSummary getPhotos() {
        return photos;
    }

    public void setPhotos(PhotosSummary photos) {
        this.photos = photos;
    }

    public SummaryGear getGear() {
        return gear;
    }

    public void setGear(SummaryGear gear) {
        this.gear = gear;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public List<DetailedSegmentEffort> getSegmentEfforts() {
        return segmentEfforts;
    }

    public void setSegmentEfforts(List<DetailedSegmentEffort> segmentEfforts) {
        this.segmentEfforts = segmentEfforts;
    }

    public String getDevideName() {
        return devideName;
    }

    public void setDevideName(String devideName) {
        this.devideName = devideName;
    }

    public String getEmbedToken() {
        return embedToken;
    }

    public void setEmbedToken(String embedToken) {
        this.embedToken = embedToken;
    }

    public List<Lap> getLaps() {
        return laps;
    }

    public void setLaps(List<Lap> laps) {
        this.laps = laps;
    }

    public List<DetailedSegmentEffort> getBestEfforts() {
        return bestEfforts;
    }

    public void setBestEfforts(List<DetailedSegmentEffort> bestEfforts) {
        this.bestEfforts = bestEfforts;
    }

    @Override
    public String toString() {
        return "DetailedActivity{" +
                "description='" + description + '\'' +
                ", photos=" + photos +
                ", gear=" + gear +
                ", calories=" + calories +
                ", segmentEfforts=" + segmentEfforts +
                ", devideName='" + devideName + '\'' +
                ", embedToken='" + embedToken + '\'' +
                ", laps=" + laps +
                ", bestEfforts=" + bestEfforts +
                '}';
    }
}
