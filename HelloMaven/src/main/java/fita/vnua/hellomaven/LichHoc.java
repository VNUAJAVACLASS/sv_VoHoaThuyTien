package fita.vnua.hellomaven;

public class LichHoc {
	 String tenMon;
	 String tiet;
	 String phong;
	 String giangVien;

	 public LichHoc(String tenMon, String tiet, String phong, String giangVien) {
		 this.tenMon = tenMon;
	     this.tiet = tiet;
	     this.phong = phong;
	     this.giangVien = giangVien;
	 }
	 
	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	 
	public String getTiet() {
		return tiet;
	}

	public void setTiet(String tiet) {
		this.tiet = tiet;
	}
	
	public String getPhong() {
		return phong;
	}

	public void setPhong(String phong) {
		this.phong = phong;
	}
	
	public String getGiangVien() {
			return giangVien;
	}

	public void setGiangVien(String giangVien) {
		this.giangVien = giangVien;
	}

	 @Override
	 public String toString() {
		 return String.format("%s | %s | %s | %s", tenMon, tiet, Tiet.doiTietRaGio(tiet), phong);
	 }

	public enum Tiet {
	    TIET1("07:00", "07:50"),
	    TIET2("07:50", "08:40"),
	    TIET3("08:40", "09:30"),
	    TIET4("09:30", "10:20"),
	    TIET5("10:20", "11:10"),
	    TIET6("13:00", "13:50"),
	    TIET7("13:50", "14:40"),
	    TIET8("14:40", "15:30"),
	    TIET9("15:30", "16:20"),
	    TIET10("16:20", "17:10");

	    public final String batDau, ketThuc;

	    Tiet(String batDau, String ketThuc) {
	        this.batDau = batDau;
	        this.ketThuc = ketThuc;
	    }

	    public static String doiTietRaGio(String tietStr) {
	        String[] tietArr = tietStr.split("-");
	        int bd = Integer.parseInt(tietArr[0].replace("Tiết", "").trim());
	        int kt = Integer.parseInt(tietArr[1].trim());
	        return Tiet.values()[bd - 1].batDau + " - " + Tiet.values()[kt - 1].ketThuc;
	    }
	}
}
