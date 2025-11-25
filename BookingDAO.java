package dao;

import model.Booking;
import java.sql.*;

public class BookingDAO {
    // Save booking and retrieve auto-generated ID from DB
    public static void save(Booking b) throws SQLException {
        String sql = "INSERT INTO bookings (user_id, listing_id, time) VALUES (?, ?, ?)";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement p = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            p.setInt(1, b.getUserId());
            p.setInt(2, b.getListingId());
            p.setTimestamp(3, Timestamp.valueOf(b.getTime()));

            int affected = p.executeUpdate();
            if (affected == 0) {
                throw new SQLException("Creating booking failed, no rows affected.");
            }

            // get generated id and set on booking
            try (ResultSet keys = p.getGeneratedKeys()) {
                if (keys.next()) {
                    b.setId(keys.getInt(1));
                }
            }
        }
    }
}

