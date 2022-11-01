package org.zigi.jstravatool.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SummaryGear {
    private String id;
    @JsonProperty("resource_state")
    private Integer resourceState;
    private Boolean primary;
    private String name;
    private Double distance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getResourceState() {
        return resourceState;
    }

    public void setResourceState(Integer resourceState) {
        this.resourceState = resourceState;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
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

    @Override
    public String toString() {
        return "SummaryGear{" +
                "id='" + id + '\'' +
                ", resourceState=" + resourceState +
                ", primary=" + primary +
                ", name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}
