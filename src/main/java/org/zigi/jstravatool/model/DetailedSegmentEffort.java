package org.zigi.jstravatool.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class DetailedSegmentEffort {
    private Long id;

    @JsonProperty("activity_id")
    private Long activityId;

    @JsonProperty("elapsed_time")
    private Integer elapsedTime;

    @JsonProperty("start_date")
    private LocalDateTime startDate;

    @JsonProperty("start_date_local")
    private LocalDateTime startDateLocal;

    private Double distance;

    @JsonProperty("is_kom")
    private Boolean isKom;

    private String name;

    /*
    activity
    athlete
     */
    @JsonProperty("moving_time")
    private Integer movindTime;

    @JsonProperty("start_index")
    private Integer startIndex;

    @JsonProperty("end_index")
    private Integer endIndex;

    @JsonProperty("average_cadence")
    private Double averageCadence;

    @JsonProperty("average_watts")
    private Double averageWatts;

    @JsonProperty("device_watts")
    private Boolean deviceWatts;

    @JsonProperty("average_heartrate")
    private Double averageHeartRate;

    @JsonProperty("max_heartrate")
    private Double maxHeartRate;

    /*
    segment
     */
    @JsonProperty("kom_rank")
    private Integer komRank;

    @JsonProperty("pr_rank")
    private Integer prRank;

    private Boolean hidden;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Integer getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getStartDateLocal() {
        return startDateLocal;
    }

    public void setStartDateLocal(LocalDateTime startDateLocal) {
        this.startDateLocal = startDateLocal;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Boolean getKom() {
        return isKom;
    }

    public void setKom(Boolean kom) {
        isKom = kom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMovindTime() {
        return movindTime;
    }

    public void setMovindTime(Integer movindTime) {
        this.movindTime = movindTime;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    public Double getAverageCadence() {
        return averageCadence;
    }

    public void setAverageCadence(Double averageCadence) {
        this.averageCadence = averageCadence;
    }

    public Double getAverageWatts() {
        return averageWatts;
    }

    public void setAverageWatts(Double averageWatts) {
        this.averageWatts = averageWatts;
    }

    public Boolean getDeviceWatts() {
        return deviceWatts;
    }

    public void setDeviceWatts(Boolean deviceWatts) {
        this.deviceWatts = deviceWatts;
    }

    public Double getAverageHeartRate() {
        return averageHeartRate;
    }

    public void setAverageHeartRate(Double averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
    }

    public Double getMaxHeartRate() {
        return maxHeartRate;
    }

    public void setMaxHeartRate(Double maxHeartRate) {
        this.maxHeartRate = maxHeartRate;
    }

    public Integer getKomRank() {
        return komRank;
    }

    public void setKomRank(Integer komRank) {
        this.komRank = komRank;
    }

    public Integer getPrRank() {
        return prRank;
    }

    public void setPrRank(Integer prRank) {
        this.prRank = prRank;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public String toString() {
        return "DetailedSegmentEffort{" +
                "id=" + id +
                ", activityId=" + activityId +
                ", elapsedTime=" + elapsedTime +
                ", startDate=" + startDate +
                ", startDateLocal=" + startDateLocal +
                ", distance=" + distance +
                ", isKom=" + isKom +
                ", name='" + name + '\'' +
                ", movindTime=" + movindTime +
                ", startIndex=" + startIndex +
                ", endIndex=" + endIndex +
                ", averageCadence=" + averageCadence +
                ", averageWatts=" + averageWatts +
                ", deviceWatts=" + deviceWatts +
                ", averageHeartRate=" + averageHeartRate +
                ", maxHeartRate=" + maxHeartRate +
                ", komRank=" + komRank +
                ", prRank=" + prRank +
                ", hidden=" + hidden +
                '}';
    }
}
