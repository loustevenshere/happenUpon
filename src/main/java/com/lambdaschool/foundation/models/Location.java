package com.lambdaschool.foundation.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "locations")
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

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties(value = "locations", allowSetters = true)
    private User user;

//    @OneToMany(mappedBy = "location",
//    cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnoreProperties(value = "location", allowSetters = true)
//    private Set<UserLocation> userLocation = new HashSet<>();

    public Location() {
    }

    public Location(long latitude, long longitude, String locationname, User user) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationname = locationname;
        this.user = user;
    }

    public Location(long latitude, long longitude, String locationname, String description, User user) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationname = locationname;
        this.description = description;
        this.user = user;
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

    /**
     * For userlocation join table(deprecated)
     */
//    public Set<UserLocation> getUserLocations() {
//        return userLocation;
//    }
//
//    public void setUserLocation(Set<UserLocation> userLocations) {
//        this.userLocation = userLocations;
//    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
