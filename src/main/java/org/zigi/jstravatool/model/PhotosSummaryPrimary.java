package org.zigi.jstravatool.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class PhotosSummaryPrimary {
    private Long id;
    private Integer source;
    @JsonProperty("unique_id")
    private String uniqueId;
    private Map<String, String> urls;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Map<String, String> getUrls() {
        return urls;
    }

    public void setUrls(Map<String, String> urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "PhotosSummaryPrimary{" +
                "id=" + id +
                ", source=" + source +
                ", uniqueId='" + uniqueId + '\'' +
                ", urls='" + urls + '\'' +
                '}';
    }
}
