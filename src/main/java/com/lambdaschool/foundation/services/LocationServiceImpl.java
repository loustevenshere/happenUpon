package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Location;
import com.lambdaschool.foundation.models.User;
import com.lambdaschool.foundation.repository.LocationRepository;
import com.lambdaschool.foundation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "locationservice")
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;


    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void deleteAll() {
        locationRepository.deleteAll();
    }
}
