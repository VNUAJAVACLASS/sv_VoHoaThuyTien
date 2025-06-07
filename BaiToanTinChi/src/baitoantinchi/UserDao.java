package baitoantinchi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
	private Connection connection;
	
	public UserDao() {
		try {
			String driverName = "com.mysql.cj.jdbc.Driver";
			String URL = "jdbc:mysql://localhost:3306/tinchi";
			String user = "SAPIO";
			String pass = "conga0505";
			connection = DriverManager.getConnection(URL, user, pass);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean addUser(User user) {
		String query = "INSERT INTO tinchi.tbl_users ( maND,hoTen,lop, diaChi, matKhau, loai) VALUES(?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, user.getMaND());
			stmt.setString(2, user.getHoTen());
			stmt.setString(3, user.getLop());
			stmt.setString(4, user.getDiaChi());
			stmt.setString(5, user.getMatKhau());
			stmt.setString(6, user.getLoai());

			int rowInserted = stmt.executeUpdate();
			return rowInserted > 0;
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUser(User user) {
		String query = "UPDATE tinchi.tbl_users SET hoTen =?,lop=?, diaChi=?,matKhau=?,loai=? WHERE maND=?";
		try (PreparedStatement stmt=connection.prepareStatement(query)){
			stmt.setString(1, user.getHoTen());
			stmt.setString(2, user.getLop());
			stmt.setString(3, user.getDiaChi());
			stmt.setString(4, user.getMatKhau());
			stmt.setString(5, user.getLoai());
			stmt.setInt(6, user.getMaND());
			
			int rowsUpdate = stmt.executeUpdate();
			return rowsUpdate >0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteUser(int userId) {
		String query = "DELETE FROM tinchi.bl_users WHERE maND =?";
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
