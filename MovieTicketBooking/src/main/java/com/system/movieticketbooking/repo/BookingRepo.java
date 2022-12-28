package com.system.movieticketbooking.repo;

import com.system.movieticketbooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {

    @Query(value = "SELECT * FROM booking where user_id=?1", nativeQuery = true)
    List<Booking> findBookingById(Integer id);
}
