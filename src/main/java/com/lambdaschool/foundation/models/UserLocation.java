package com.lambdaschool.foundation.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "userlocation")
@IdClass(UserLocation.class)
public class UserLocation extends Auditable implements Serializable {

    /**
     * Half of the primary key for userlocation
     * Also a foreign key into users table
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "userLocation", allowSetters = true)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "locationid")
    @JsonIgnoreProperties(value = "userLocation", allowSetters = true)
    private Location location;

    public UserLocation() {
    }

    public UserLocation(User user, Location location) {
        this.user = user;
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof UserLocation)) return false;

        UserLocation that = (UserLocation) o;
        return Objects.equals(user, that.user) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return 37;
    }
}
