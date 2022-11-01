package org.zigi.jstravatool.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class SummaryActivity {

    private Long id;
    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("upload_id")
    private Long uploadId;

    private String name;

    private Double distance;

    @JsonProperty("moving_time")
    private Integer movindTime;

    @JsonProperty("elapsed_time")
    private Integer elapsedTime;

    @JsonProperty("total_elevation_gain")
    private Double totalElevationGain;

    @JsonProperty("elev_high")
    private Double elevHigh;

    @JsonProperty("elev_low")
    private Double elevLow;

    @JsonProperty("sport_type")
    private SportType sportType;

    @JsonProperty("start_date")
    private LocalDateTime startDate;

    @JsonProperty("start_date_local")
    private LocalDateTime startDateLocal;

    private String timezone;

    /*
    @JsonProperty("start_latlng")
    private LatLng startLatLng;

    @JsonProperty("end_latlng")
    private LatLng endLatLng;
 */
    @JsonProperty("achievement_count")
    private Integer achievementCount;

    @JsonProperty("kudos_count")
    private Integer kudosCount;

    @JsonProperty("comment_count")
    private Integer commentCount;

    @JsonProperty("athlete_count")
    private Integer athleteCount;

    @JsonProperty("photo_count")
    private Integer photoCount;

    @JsonProperty("total_photo_count")
    private Integer totalPhotoCount;

    /*
    private PolylineMap	map;*/

    private Boolean trainer;
    private Boolean commute;
    private Boolean	manual;

    @JsonProperty("private")
    private Boolean isPrivate;
    private Boolean flagged;

    @JsonProperty("workout_type")
    private Integer workoutType;

    @JsonProperty("upload_id_str")
    private String uploadIdStr;

    @JsonProperty("average_speed")
    private Double averageSpeed;

    @JsonProperty("max_speed")
    private Double maxSpeed;

    @JsonProperty("has_kudoed")
    private Boolean hasKudos;

    @JsonProperty("hide_from_home")
    private Boolean hideFromHome;

    @JsonProperty("gear_id")
    private String gearId;

    private Double kilojoules;

    @JsonProperty("average_watts")
    private Double averageWatts;

    @JsonProperty("device_watts")
    private Boolean deviceWats;

    @JsonProperty("max_watts")
    private Integer maxWatts;

    @JsonProperty("weighted_average_watts")
    private Integer weightAverageWatts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Long getUploadId() {
        return uploadId;
    }

    public void setUploadId(Long uploadId) {
        this.uploadId = uploadId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getMovindTime() {
        return movindTime;
    }

    public void setMovindTime(Integer movindTime) {
        this.movindTime = movindTime;
    }

    public Integer getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public Double getTotalElevationGain() {
        return totalElevationGain;
    }

    public void setTotalElevationGain(Double totalElevationGain) {
        this.totalElevationGain = totalElevationGain;
    }

    public Double getElevHigh() {
        return elevHigh;
    }

    public void setElevHigh(Double elevHigh) {
        this.elevHigh = elevHigh;
    }

    public Double getElevLow() {
        return elevLow;
    }

    public void setElevLow(Double elevLow) {
        this.elevLow = elevLow;
    }

    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
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

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Integer getAchievementCount() {
        return achievementCount;
    }

    public void setAchievementCount(Integer achievementCount) {
        this.achievementCount = achievementCount;
    }

    public Integer getKudosCount() {
        return kudosCount;
    }

    public void setKudosCount(Integer kudosCount) {
        this.kudosCount = kudosCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getAthleteCount() {
        return athleteCount;
    }

    public void setAthleteCount(Integer athleteCount) {
        this.athleteCount = athleteCount;
    }

    public Integer getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(Integer photoCount) {
        this.photoCount = photoCount;
    }

    public Integer getTotalPhotoCount() {
        return totalPhotoCount;
    }

    public void setTotalPhotoCount(Integer totalPhotoCount) {
        this.totalPhotoCount = totalPhotoCount;
    }

    public Boolean getTrainer() {
        return trainer;
    }

    public void setTrainer(Boolean trainer) {
        this.trainer = trainer;
    }

    public Boolean getCommute() {
        return commute;
    }

    public void setCommute(Boolean commute) {
        this.commute = commute;
    }

    public Boolean getManual() {
        return manual;
    }

    public void setManual(Boolean manual) {
        this.manual = manual;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Boolean getFlagged() {
        return flagged;
    }

    public void setFlagged(Boolean flagged) {
        this.flagged = flagged;
    }

    public Integer getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(Integer workoutType) {
        this.workoutType = workoutType;
    }

    public String getUploadIdStr() {
        return uploadIdStr;
    }

    public void setUploadIdStr(String uploadIdStr) {
        this.uploadIdStr = uploadIdStr;
    }

    public Double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(Double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public Double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Boolean getHasKudos() {
        return hasKudos;
    }

    public void setHasKudos(Boolean hasKudos) {
        this.hasKudos = hasKudos;
    }

    public Boolean getHideFromHome() {
        return hideFromHome;
    }

    public void setHideFromHome(Boolean hideFromHome) {
        this.hideFromHome = hideFromHome;
    }

    public String getGearId() {
        return gearId;
    }

    public void setGearId(String gearId) {
        this.gearId = gearId;
    }

    public Double getKilojoules() {
        return kilojoules;
    }

    public void setKilojoules(Double kilojoules) {
        this.kilojoules = kilojoules;
    }

    public Double getAverageWatts() {
        return averageWatts;
    }

    public void setAverageWatts(Double averageWatts) {
        this.averageWatts = averageWatts;
    }

    public Boolean getDeviceWats() {
        return deviceWats;
    }

    public void setDeviceWats(Boolean deviceWats) {
        this.deviceWats = deviceWats;
    }

    public Integer getMaxWatts() {
        return maxWatts;
    }

    public void setMaxWatts(Integer maxWatts) {
        this.maxWatts = maxWatts;
    }

    public Integer getWeightAverageWatts() {
        return weightAverageWatts;
    }

    public void setWeightAverageWatts(Integer weightAverageWatts) {
        this.weightAverageWatts = weightAverageWatts;
    }

    @Override
    public String toString() {
        return "SummaryActivity{" +
                "id=" + id +
                ", externalId='" + externalId + '\'' +
                ", uploadId=" + uploadId +
                ", name='" + name + '\'' +
                ", distance=" + distance +
                ", movindTime=" + movindTime +
                ", elapsedTime=" + elapsedTime +
                ", totalElevationGain=" + totalElevationGain +
                ", elevHigh=" + elevHigh +
                ", elevLow=" + elevLow +
                ", sportType=" + sportType +
                ", startDate=" + startDate +
                ", startDateLocal=" + startDateLocal +
                ", timezone='" + timezone + '\'' +
                ", achievementCount=" + achievementCount +
                ", kudosCount=" + kudosCount +
                ", commentCount=" + commentCount +
                ", athleteCount=" + athleteCount +
                ", photoCount=" + photoCount +
                ", totalPhotoCount=" + totalPhotoCount +
                ", trainer=" + trainer +
                ", commute=" + commute +
                ", manual=" + manual +
                ", isPrivate=" + isPrivate +
                ", flagged=" + flagged +
                ", workoutType=" + workoutType +
                ", uploadIdStr='" + uploadIdStr + '\'' +
                ", averageSpeed=" + averageSpeed +
                ", maxSpeed=" + maxSpeed +
                ", hasKudos=" + hasKudos +
                ", hideFromHome=" + hideFromHome +
                ", gearId='" + gearId + '\'' +
                ", kilojoules=" + kilojoules +
                ", averageWatts=" + averageWatts +
                ", deviceWats=" + deviceWats +
                ", maxWatts=" + maxWatts +
                ", weightAverageWatts=" + weightAverageWatts +
                '}';
    }
}
