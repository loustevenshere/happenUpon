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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


// Todo: Start here
    @Override
    public Location save(long userid, Location location) {

        Location saveLocation = new Location();

        saveLocation.setLocationname(location.getLocationname());
        saveLocation.setDescription(location.getDescription());
        saveLocation.setLatitude(location.getLatitude());
        saveLocation.setLongitude(location.getLongitude());

        return saveLocation;
    }

    @Override
    public void deleteAll() {
        locationRepository.deleteAll();
    }
}
