package com.lambdaschool.foundation.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "location")
public class Location extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long locationid;

    @Column(nullable = false)
    private long latitude;

    @Column(nullable = false)
    private long longitude;

    private String locationname;

    private String description;

    @OneToMany(mappedBy = "location",
    cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "location", allowSetters = true)
    private Set<UserLocation> userLocation = new HashSet<>();

    public Location() {
    }

    public Location(long latitude, long longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location(long latitude, long longitude, String locationname, String description) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationname = locationname;
        this.description = description;
    }

    public long getLocationid() {
        return locationid;
    }

    public void setLocationid(long locationid) {
        this.locationid = locationid;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public String getLocationname() {
        return locationname;
    }

    public void setLocationname(String locationname) {
        this.locationname = locationname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<UserLocation> getUserLocations() {
        return userLocation;
    }

    public void setUserLocations(Set<UserLocation> userLocations) {
        this.userLocation = userLocations;
    }
}
