//package com.system.movieticketbooking.controller;
//
//import com.system.movieticketbooking.entity.Booking;
//import com.system.movieticketbooking.repo.BookingRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.ArrayList;
//
//@Controller
//public class BookingController {
//    @Autowired
//    private BookingRepo bookingRepo;
//
//    @GetMapping("/")
//    public String showBookingPage(Model model) {
//        List<Row> rows = createRows();
//        model.addAttribute("rows", rows);
//        model.addAttribute("booking", new Booking());
//        return "Booking";
//    }
//
//    @PostMapping("/")
//    public String processBooking(@ModelAttribute Booking booking, Model model) {
//        for (Seat seat : booking.getSeats()) {
//            seat.setBooked(true);
//        }
//        bookingRepo.save(booking);
//        return "redirect:/";
//    }
//
//    private List<Row> createRows() {
//        List<Row> rows = new ArrayList<>();
//        for (int i = 1; i <= 10; i++) {
//            Row row = new Row();
//            List<Seat> seats = new ArrayList<>();
//            for (int j = 1; j <= 10; j++) {
//                Seat seat = new Seat(i + "-" + j);
//                seats.add(seat);
//            }
//            row.setSeats(seats);
//            rows.add(row);
//        }
//        return rows;
//    }
//}