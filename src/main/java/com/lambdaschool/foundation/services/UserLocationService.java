package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Location;
import com.lambdaschool.foundation.models.UserLocation;

import java.util.List;

public interface UserLocationService {

    /**
     *
     * @return List of UserLocation, if none: an empty list
     */
    List<UserLocation> findAll();

//    UserLocation save(long userid, Location location);
}
