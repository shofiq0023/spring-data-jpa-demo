package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.UserPersonalInfo;

public interface UserPersonalInfoRepo extends JpaRepository<UserPersonalInfo, Long> {

}
