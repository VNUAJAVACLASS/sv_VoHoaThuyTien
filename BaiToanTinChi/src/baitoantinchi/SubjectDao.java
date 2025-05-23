package baitoantinchi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubjectDao {
	private Connection connection;

	public SubjectDao() {
		try {
			String URL = "jdbc:ucanaccess://lib/QLNS.accdb";
			connection = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean addSubject(Subject subject) {
		String query = "INSERT INTO Subject ( TenMH, SoTC, HeSo1, HeSo2, HeSo3, HeSo4, HeSo5) VALUES(?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, subject.getTenMH());
			stmt.setInt(2, subject.getSoTC());
			stmt.setInt(3, subject.getHeSo1());
			stmt.setInt(4, subject.getHeSo2());
			stmt.setInt(5, subject.getHeSo3());
			stmt.setInt(6, subject.getHeSo4());
			stmt.setInt(7, subject.getHeSo5());

			int rowInserted = stmt.executeUpdate();
			return rowInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateSubject(Subject subject) {
		String query = "UPDATE Subject SET TenMH =?,SoTC=?,HeSo1=?,HeSo2=?, HeSo3=?,HeSo4=?,HeSo5=?  WHERE MaMH=?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, subject.getTenMH());
			stmt.setInt(2, subject.getSoTC());
			stmt.setInt(3, subject.getHeSo1());
			stmt.setInt(4, subject.getHeSo2());
			stmt.setInt(5, subject.getHeSo3());
			stmt.setInt(6, subject.getHeSo4());
			stmt.setInt(7, subject.getHeSo5());
			stmt.setInt(8, subject.getMaMH());

			int rowsUpdate = stmt.executeUpdate();
			return rowsUpdate > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteSubject(int subjectId) {
		String query = "DELETE FROM Subject WHERE MaMH =?";
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

