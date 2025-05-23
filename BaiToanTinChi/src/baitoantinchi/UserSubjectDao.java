package baitoantinchi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserSubjectDao {
private Connection connection;
	
	public UserSubjectDao() {
		try {
			String URL = "jdbc:ucanaccess://lib/QLNS.accdb";
			connection = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean addUserSubject(UserSubject userSubject) {
		String query = "INSERT INTO UserSubject ( MaND,MaMH,Diem1,Diem2,Diem3,Diem4,Diem5) VALUES(?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, userSubject.getMaND());
			stmt.setInt(2, userSubject.getMaMH());
			stmt.setFloat(3, userSubject.getDiem1());
			stmt.setFloat(4, userSubject.getDiem2());
			stmt.setFloat(5, userSubject.getDiem3());
			stmt.setFloat(6, userSubject.getDiem4());
			stmt.setFloat(7, userSubject.getDiem5());

			int rowInserted = stmt.executeUpdate();
			return rowInserted > 0;
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUserSubject(UserSubject userSubject) {
		String query = "UPDATE UserSubject SET MaND =?,MaMH=?,Diem1=?,Diem2=?,Diem3=?,Diem4=?,Diem5=? WHERE MaMhNguoiDung=?";
		try (PreparedStatement stmt=connection.prepareStatement(query)){
			stmt.setInt(1, userSubject.getMaND());
			stmt.setInt(2, userSubject.getMaMH());
			stmt.setFloat(3, userSubject.getDiem1());
			stmt.setFloat(4, userSubject.getDiem2());
			stmt.setFloat(5, userSubject.getDiem3());
			stmt.setFloat(6, userSubject.getDiem4());
			stmt.setFloat(7, userSubject.getDiem5());
			stmt.setInt(8, userSubject.getND_MH());
			
			int rowsUpdate = stmt.executeUpdate();
			return rowsUpdate >0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteUserSubject(int userSubjectId) {
		String query = "DELETE FROM UserSubject WHERE MaMhNguoiDung =?";
		try (PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setInt(1, userSubjectId);
			int rowDeleted = stmt.executeUpdate();
			return rowDeleted >0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

