package baitoantinchi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserSubjectDao {
private Connection connection;
	
	public UserSubjectDao() {
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
	
	public boolean addUserSubject(UserSubject userSubject) {
		String query = "INSERT INTO tinchi.tbl_usersubject ( maND_MH,maND1,maMH1,diemGK1,diem1,diem2,diem3,diemCK1) VALUES(?,?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, userSubject.getND_MH());
			stmt.setInt(2, userSubject.getMaND1());
			stmt.setInt(3, userSubject.getMaMH1());
			stmt.setFloat(4, userSubject.getDiemGK1());
			stmt.setFloat(5, userSubject.getDiem1());
			stmt.setFloat(6, userSubject.getDiem2());
			stmt.setFloat(7, userSubject.getDiem3());
			stmt.setFloat(8, userSubject.getDiemCK1());

			int rowInserted = stmt.executeUpdate();
			return rowInserted > 0;
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUserSubject(UserSubject userSubject) {
		String query = "UPDATE tinchi.tbl_subject SET maND1 =?,maMH1?,diemGK1=?,diem1=?,diem2=?,diem3=?,diemCK1=? WHERE maND_MH=?";
		try (PreparedStatement stmt=connection.prepareStatement(query)){
			stmt.setInt(1, userSubject.getMaND1());
			stmt.setInt(2, userSubject.getMaMH1());
			stmt.setFloat(3, userSubject.getDiemGK1());
			stmt.setFloat(4, userSubject.getDiem1());
			stmt.setFloat(5, userSubject.getDiem2());
			stmt.setFloat(6, userSubject.getDiem3());
			stmt.setFloat(7, userSubject.getDiemCK1());
			stmt.setInt(8, userSubject.getND_MH());
			
			int rowsUpdate = stmt.executeUpdate();
			return rowsUpdate >0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteUserSubject(int userSubjectId) {
		String query = "DELETE FROM tinchi.tbl_subject WHERE maND_MH =?";
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

