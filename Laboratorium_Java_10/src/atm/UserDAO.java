package atm;

import java.security.MessageDigest;
import java.sql.*;

public class UserDAO {

    public User getUser(String login, String pin) throws Exception {
        String query = "SELECT * FROM users WHERE login = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String hashedPin = hashPin(pin);
                if (rs.getString("pin_hash").equals(hashedPin)) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setLogin(rs.getString("login"));
                    user.setPinHash(rs.getString("pin_hash"));
                    user.setBalance(rs.getDouble("balance"));
                    user.setRole(rs.getString("role"));
                    return user;
                }
            }
        }
        return null;
    }

    public void createUser(String login, String pin, String role) throws Exception {
        String query = "INSERT INTO users (login, pin_hash, role) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, login);
            stmt.setString(2, hashPin(pin));
            stmt.setString(3, role);
            stmt.executeUpdate();
        }
    }

    public void updateBalance(int userId, double newBalance) throws Exception {
        String query = "UPDATE users SET balance = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, newBalance);
            stmt.setInt(2, userId);
            stmt.executeUpdate();
        }
    }

    public void changePin(int userId, String newPin) throws Exception {
        String query = "UPDATE users SET pin_hash = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, hashPin(newPin));
            stmt.setInt(2, userId);
            stmt.executeUpdate();
        }
    }

    private String hashPin(String pin) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(pin.getBytes("UTF-8"));
        StringBuilder hex = new StringBuilder();
        for (byte b : hash) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    }
}
