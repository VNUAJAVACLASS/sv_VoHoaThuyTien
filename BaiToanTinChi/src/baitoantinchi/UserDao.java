package baitoantinchi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
	private Connection connection;
	
	public UserDao() {
		try {
			String URL = "jdbc:ucanaccess://lib/QLNS.accdb";
			connection = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean addUser(User user) {
		String query = "INSERT INTO User ( HoTen, DiaChi, MatKhau, Loai) VALUES(?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, user.getHoTen());
			stmt.setString(2, user.getDiaChi());
			stmt.setString(3, user.getMatKhau());
			stmt.setString(4, user.getLoai());

			int rowInserted = stmt.executeUpdate();
			return rowInserted > 0;
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUser(User user) {
		String query = "UPDATE User SET HoTen =?,DiaChi=?,MatKhau=?,Loai=? WHERE MaND=?";
		try (PreparedStatement stmt=connection.prepareStatement(query)){
			stmt.setString(1, user.getHoTen());
			stmt.setString(2, user.getDiaChi());
			stmt.setString(3, user.getMatKhau());
			stmt.setString(4, user.getLoai());
			stmt.setInt(5, user.getMaND());
			
			int rowsUpdate = stmt.executeUpdate();
			return rowsUpdate >0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteUser(int userId) {
		String query = "DELETE FROM User WHERE MaND =?";
		try (PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setInt(1, userId);
			int rowDeleted = stmt.executeUpdate();
			return rowDeleted >0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
