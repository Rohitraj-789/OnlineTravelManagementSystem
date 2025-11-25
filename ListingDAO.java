package dao;

import model.Listing;
import java.sql.*;
import java.util.*;


public class ListingDAO {
    // simple generic DAO: store only metadata; item details should be serialized if needed
    public static void saveListing(Listing<?> listing) throws SQLException {
        String sql = "INSERT INTO listings (id, title, approved, units) VALUES (?, ?, ?, ?)";
        try (Connection c = DBConnection.getConnection(); PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, listing.getId()); p.setString(2, listing.getTitle()); p.setBoolean(3, listing.isApproved()); p.setInt(4, listing.getAvailableUnits());
            p.executeUpdate();
        }
    }


    public static Optional<Integer> getAvailableUnits(int listingId) throws SQLException {
        String sql = "SELECT units FROM listings WHERE id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, listingId);
            try (ResultSet rs = p.executeQuery()) {
                if (rs.next()) return Optional.of(rs.getInt(1));
            }
        }
        return Optional.empty();
    }
}