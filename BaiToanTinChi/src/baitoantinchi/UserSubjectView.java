package baitoantinchi;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserSubjectView {
	private Connection connection;

	public UserSubjectView() {
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

	public void showUserSubject() {
		String query = 
				"SELECT u.hoTen, s.tenMH, us.diemGK1, us.diem1, us.diem2, us.diem3, us.diemCK1 " +
	            "FROM tinchi.tbl_users u " + 
				"INNER JOIN tinchi.tbl_userSubject us ON u.maND = us.maND1 " +
				"INNER JOIN tinchi.tbl_subject s ON s.maMH = us.maMH1";
		
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				String hoTen = rs.getString("hoTen");
				String tenMH = rs.getString("tenMH");
				
				float diemGK1 = rs.getFloat("diemGK1");
				float diem1 = rs.getFloat("diem1");
				float diem2 = rs.getFloat("diem2");
				float diem3 = rs.getFloat("diem3");
				float diemCK1 = rs.getFloat("diemCK1");
				
				System.out.println("Họ tên: " + hoTen + "Môn: " + tenMH + "| Diểm: " + diemGK1 + "," + diem1 + "," + diem2 + "," + diem3
						+ "," + diemCK1 );
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
