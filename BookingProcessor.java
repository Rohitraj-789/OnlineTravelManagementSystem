package util;

import service.BookingService;


public class BookingProcessor implements Runnable {
    private int userId;
    private int listingId;


    public BookingProcessor(int userId, int listingId) { this.userId = userId; this.listingId = listingId; }


    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " trying to book listing " + listingId + " for user " + userId);
            var booking = BookingService.book(userId, listingId);
            System.out.println(Thread.currentThread().getName() + " succeeded: booking id " + booking.getId());
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + " failed: " + e.getMessage());
        }
    }
}