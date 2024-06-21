package com.using.mapStruct.mapStruct.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.using.mapStruct.mapStruct.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
