package dao;

import model.User;
import java.sql.*;


public class UserDAO {
    public static void createUser(User u) throws SQLException {
        String sql = "INSERT INTO users (id, name, email, role) VALUES (?, ?, ?, ?)";
        try (Connection c = DBConnection.getConnection(); PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, u.getId()); p.setString(2, u.getName()); p.setString(3, u.getEmail()); p.setString(4, u.getRole().name());
            p.executeUpdate();
        }
    }
}