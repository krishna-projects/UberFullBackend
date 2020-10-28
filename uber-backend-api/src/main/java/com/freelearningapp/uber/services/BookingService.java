package com.freelearningapp.uber.services;

import com.freelearningapp.uber.models.Booking;
import com.freelearningapp.uber.models.Driver;
import com.freelearningapp.uber.repositories.BookingRepository;
import com.freelearningapp.uber.repositories.DriverRepository;

public class BookingService {
    BookingRepository bookingRepository;
    DriverRepository driverRepository;

    public void requestBooking(Booking booking) {
        // find the start location of the booking
        // search drivers near that location
        // send push notifications to those drivers
    }

    public synchronized boolean acceptBooking(Booking booking, Driver driver) {
        // incomplete, because
        // this enforces only 1 driver can be accepting a booking
        // 1 driver can accept 1 booking
        // multiple drivers can book different bookings at the same time
        if(driver.getCurrentlyActiveBooking() != null) {
            return false;
        }
        if(!driver.getIsAvailable()) {
            return false;
        }
        // calculate the distance b/w the driver and the passenger
        // make sure that it is within a limit
        // estimate ETA from eta service, and ensure that is is within limit
        driver.setCurrentlyActiveBooking(booking);
        booking.setDriver(driver);
        bookingRepository.save(booking);
        driverRepository.save(driver);
        return true;
    }
}
