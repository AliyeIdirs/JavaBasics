package com.unitedcoder.jsonfile.serilization;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MainJson {
    @JsonProperty("squadName")
    private String squadName;
    @JsonProperty("homeTown")
    private String hometown;
    @JsonProperty("formed")
    private int formed;
    @JsonProperty("secretBase")
    private String secretBase;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("members")
    private List<Members> members;

    public MainJson() {
    }

    public MainJson(String squadName, String hometown, int formed, String secretBase, Boolean active, List<Members> members) {
        this.squadName = squadName;
        this.hometown = hometown;
        this.formed = formed;
        this.secretBase = secretBase;
        this.active = active;
        this.members = members;
    }

    public String getSquadName() {
        return squadName;
    }

    public String getHometown() {
        return hometown;
    }

    public int getFormed() {
        return formed;
    }

    public String getSecretBase() {
        return secretBase;
    }

    public Boolean getActive() {
        return active;
    }

    public List<Members> getMembers() {
        return members;
    }
}
