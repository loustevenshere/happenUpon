package com.lambdaschool.foundation.models;

import java.io.Serializable;
import java.util.Objects;

public class UserLocationId implements Serializable {
    private long user;
    private long location;

    public UserLocationId() {
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public long getLocation() {
        return location;
    }

    public void setLocation(long location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLocationId that = (UserLocationId) o;
        return user == that.user && location == that.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, location);
    }
}
