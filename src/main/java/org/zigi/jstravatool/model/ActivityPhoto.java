package org.zigi.jstravatool.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Map;

public class ActivityPhoto {
    @JsonProperty("unique_id")
    private String uniqueId;

    @JsonProperty("athlete_id")
    private Long athleteId;

    @JsonProperty("activity_id")
    private Long activityId;

    @JsonProperty("activity_name")
    private String activityName;

    @JsonProperty("resource_state")
    private Integer resourceState;

    private String caption;

    private Integer type;

    private Integer source;

    private Integer status;

    @JsonProperty("uploaded_at")
    private LocalDateTime uploadedAt;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("created_at_local")
    private LocalDateTime createdAtLocal;

    private Map<String, String> urls;

    @JsonProperty("default_photo")
    private Boolean defaultPhoto;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Long getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(Long athleteId) {
        this.athleteId = athleteId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getResourceState() {
        return resourceState;
    }

    public void setResourceState(Integer resourceState) {
        this.resourceState = resourceState;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAtLocal() {
        return createdAtLocal;
    }

    public void setCreatedAtLocal(LocalDateTime createdAtLocal) {
        this.createdAtLocal = createdAtLocal;
    }

    public Map<String, String> getUrls() {
        return urls;
    }

    public void setUrls(Map<String, String> urls) {
        this.urls = urls;
    }

    public Boolean getDefaultPhoto() {
        return defaultPhoto;
    }

    public void setDefaultPhoto(Boolean defaultPhoto) {
        this.defaultPhoto = defaultPhoto;
    }

    @Override
    public String toString() {
        return "ActivityPhoto{" +
                "uniqueId='" + uniqueId + '\'' +
                ", athleteId=" + athleteId +
                ", activityId=" + activityId +
                ", activityName='" + activityName + '\'' +
                ", resourceState=" + resourceState +
                ", caption='" + caption + '\'' +
                ", type=" + type +
                ", source=" + source +
                ", status=" + status +
                ", uploadedAt=" + uploadedAt +
                ", createdAt=" + createdAt +
                ", createdAtLocal=" + createdAtLocal +
                ", urls=" + urls +
                ", defaultPhoto=" + defaultPhoto +
                '}';
    }
}
