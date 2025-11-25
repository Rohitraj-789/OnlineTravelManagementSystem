package service;

import model.Booking;
import model.Listing;
import dao.BookingDAO;

public class BookingService {

    public static Booking book(int userId, int listingId) throws Exception {

        Listing<?> listing = ListingService.find(listingId);
        if (listing == null) throw new Exception("Listing not found");

        synchronized (listing) {
            if (!listing.isApproved()) throw new Exception("Listing not approved");
            if (listing.getAvailableUnits() <= 0) throw new Exception("No units available");

            boolean reserved = listing.reserveOne();
            if (!reserved) throw new Exception("Failed to reserve");

            // Create booking WITHOUT ID — DB generates the ID automatically
            Booking booking = new Booking(userId, listingId);

            try {
                BookingDAO.save(booking);   // DB auto-generates id here
            } catch (Exception e) {
                // rollback local reserve because DB failed
                listing.incrementUnits();
                throw new Exception("DB error: " + e.getMessage());
            }

            return booking;
        }
    }
}
