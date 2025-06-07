package baitoantinchi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubjectDao {
	private Connection connection;

	public SubjectDao() {
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

	public boolean addSubject(Subject subject) {
		String query = "INSERT INTO tinchi.tbl_subject ( maMH,tenMH, soTC, diemGK, heSo1, heSo2, heSo3, diemCK) VALUES(?,?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, subject.getMaMH());
			stmt.setString(2, subject.getTenMH());
			stmt.setInt(3, subject.getSoTC());
			stmt.setFloat(4, subject.getDiemGK());
			stmt.setFloat(5, subject.getHeSo1());
			stmt.setFloat(6, subject.getHeSo2());
			stmt.setFloat(7, subject.getHeSo3());
			stmt.setFloat(8, subject.getDiemCK());	

			int rowInserted = stmt.executeUpdate();
			return rowInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateSubject(Subject subject) {
		String query = "UPDATE tinchi.tbl_subject SET tenMH=?,soTC=?,diemGK=?,heSo1=?,heSo2=?, heSo3=?,diemCK=?  WHERE maMH=?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, subject.getTenMH());
			stmt.setInt(2, subject.getSoTC());
			stmt.setFloat(3, subject.getDiemGK());
			stmt.setFloat(4, subject.getHeSo1());
			stmt.setFloat(5, subject.getHeSo2());
			stmt.setFloat(6, subject.getHeSo3());
			stmt.setFloat(7, subject.getDiemCK());
			stmt.setInt(8, subject.getMaMH());

			int rowsUpdate = stmt.executeUpdate();
			return rowsUpdate > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteSubject(int subjectId) {
		String query = "DELETE FROM tinchi.tbl_subject WHERE maMH =?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, subjectId);
			int rowDeleted = stmt.executeUpdate();
			return rowDeleted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

