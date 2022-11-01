package org.zigi.jstravatool.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SportType {
    ALPINE_SKI("AlpineSki"),
    BACKCOUNTRY_SKI("BackcountrySki"),
    CANOEING("Canoeing"),
    CROSSFIT("Crossfit"),
    EBIKE_RIDE("EBikeRide"),
    ELLIPTICAL("Elliptical"),
    EMOOUNTAIN_BIKE_RIDE("EMountainBikeRide"),
    GOLD("Golf"),
    GRAVEL_RIDE("GravelRide"),
    HANDCYCLE("Handcycle"),
    HIKE("Hike"),
    ICE_SKATE("IceSkate"),
    INLINE_SKATE("InlineSkate"),
    KAYAKING("Kayaking"),
    KITESURF("Kitesurf"),
    MOUNTAIN_BIKE_RIDE("MountainBikeRide"),
    NORDIC_SKI("NordicSki"),
    RIDE("Ride"),
    ROCK_CLIMBING("RockClimbing"),
    ROLLER_SKI("RollerSki"),
    ROWING("Rowing"),
    RUN("Run"),
    SAIL("Sail"),
    SKATEBOARD("Skateboard"),
    SNOWBOARD("Snowboard"),
    SNOW_SHOE("Snowshoe"),
    SOCCER("Soccer"),
    STAIR_STEPPER("StairStepper"),
    STANDUP_PADDLING("StandUpPaddling"),
    SURFING("Surfing"),
    SWIM("Swim"),
    TRAIL_RUN("TrailRun"),
    VELOMOBILE("Velomobile"),
    VIRTUAL_RIDE("VirtualRide"),
    VIRTUAL_RUN("VirtualRun"),
    WALK("Walk"),
    WEIGHT_TRAINING("WeightTraining"),
    WHEELCHAIR("Wheelchair"),
    WINDSURF("Windsurf"),
    WORKOUT("Workout"),
    YOGA("Yoga");

    private final String name;

    SportType(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }
}
