package com.lambdaschool.foundation.repository;

import com.lambdaschool.foundation.models.UserLocation;
import org.springframework.data.repository.CrudRepository;

public interface UserLocationRepository
        extends CrudRepository<UserLocation, Long> {
}
