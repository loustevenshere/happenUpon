package com.lambdaschool.foundation.services;


import com.lambdaschool.foundation.models.UserLocation;
import com.lambdaschool.foundation.repository.UserLocationRepository;
import com.lambdaschool.foundation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userLocationService")
public class UserLocationServiceImpl implements UserLocationService {

    @Autowired
    private UserLocationRepository userLocationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserLocation> findAll() {
        List<UserLocation> userLocationList = new ArrayList<>();
        userLocationRepository.findAll()
                .iterator()
                .forEachRemaining(userLocationList::add);
        return userLocationList;
    }
}
