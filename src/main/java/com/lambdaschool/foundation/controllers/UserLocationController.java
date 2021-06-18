package com.lambdaschool.foundation.controllers;


import com.lambdaschool.foundation.models.Location;
import com.lambdaschool.foundation.models.User;
import com.lambdaschool.foundation.models.UserLocation;
import com.lambdaschool.foundation.services.LocationService;
import com.lambdaschool.foundation.services.UserLocationService;
import com.lambdaschool.foundation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Entry point for clients to access userlocation data
 */

@RestController
@RequestMapping("/userlocation")
public class UserLocationController {

    @Autowired
    private UserLocationService userLocationService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private UserService userService;

    /**
     * Return a list of all userlocations to display on map
     * Example: <a href="http://localhost:2019/users/userlocations
     *
     * @return list of userlocations
     */
    @GetMapping(value = "/userlocations", produces = {"application/json"})
    public ResponseEntity<?> listAllUserLocations()
    {
        List<UserLocation> allUserLocations = userLocationService.findAll();
        return new ResponseEntity<>(allUserLocations, HttpStatus.OK);
    }

    /**
     * User to post location onto map
     * Example: <a href="http://localhost:2019/users/postuserlocation
     */

    @PostMapping(value = "/postuserlocation", produces = {"application/json"})
    public ResponseEntity<?> addUserLocation(@Valid @RequestBody Location location)
    {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentuser = userService.findByName(username);

        location.setLocationid(0);
        location = locationService.save(currentuser.getUserid(), location);

        return new ResponseEntity<>(location, HttpStatus.CREATED);
    }

}
