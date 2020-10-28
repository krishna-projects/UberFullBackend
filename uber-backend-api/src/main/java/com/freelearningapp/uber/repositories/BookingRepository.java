package com.freelearningapp.uber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freelearningapp.uber.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
