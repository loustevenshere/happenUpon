package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Location;

public interface LocationService {
    Location save(long userid, Location location);

    public void deleteAll();
}
