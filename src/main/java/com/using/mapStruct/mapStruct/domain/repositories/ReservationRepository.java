package com.using.mapStruct.mapStruct.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.using.mapStruct.mapStruct.domain.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, String> {

}
