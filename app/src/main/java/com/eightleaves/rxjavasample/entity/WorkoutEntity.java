package com.eightleaves.rxjavasample.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkoutEntity{
    private int id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Total Time")
    @Expose
    private String totalTime;
    @SerializedName("Warm-Up")
    @Expose
    private String warmup;
    @SerializedName("Terrain")
    @Expose
    private String terrain;
    @SerializedName("Training Zone")
    @Expose
    private String trainingZone;
    @SerializedName("Level")
    @Expose
    private String trainingLevel;
    @SerializedName("Workout Time")
    @Expose
    private String workoutTime;
    @SerializedName("Cool Down")
    @Expose
    private String coolDownTime;
    @SerializedName("Type")
    @Expose
    private String workoutType;
    @SerializedName("Notes")
    @Expose
    private String intervals;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getWarmup() {
        return warmup;
    }

    public void setWarmup(String warmup) {
        this.warmup = warmup;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getTrainingZone() {
        return trainingZone;
    }

    public void setTrainingZone(String trainingZone) {
        this.trainingZone = trainingZone;
    }

    public String getTrainingLevel() {
        return trainingLevel;
    }

    public void setTrainingLevel(String trainingLevel) {
        this.trainingLevel = trainingLevel;
    }

    public String getWorkoutTime() {
        return workoutTime;
    }

    public void setWorkoutTime(String workoutTime) {
        this.workoutTime = workoutTime;
    }

    public String getCoolDownTime() {
        return coolDownTime;
    }

    public void setCoolDownTime(String coolDownTime) {
        this.coolDownTime = coolDownTime;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    public String getIntervals() {
        return intervals;
    }

    public void setIntervals(String intervals) {
        this.intervals = intervals;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
