package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Location;

public interface LocationService {
    static void save(Location l1) {
    }

    Location save(long userid, Location location);

    public void deleteAll();
}
