package fita.vnua.tkb;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Tuan {
	private int soTuan;
	Map<String, Thu> dsThu = new HashMap<>(); // thứ 2 đến CN
	
	public Tuan(int soTuan) {
        this.soTuan = soTuan;
    }
	
	public int getSoTuan() {
        return soTuan;
    }

    public void setSoTuan(int soTuan) {
        this.soTuan = soTuan;
    }

    public Map<String, Thu> getDsThu() {
        return dsThu;
    }

    public Thu getThu(String soThu) {
        return dsThu.get(soThu);
    }
    
    public void themLich( String thu, LichHoc lich) {
		dsThu.putIfAbsent(thu, new Thu(thu));
		dsThu.get(thu).themLich(lich);
    }
    
    public void hienThiThoiKhoaBieu() {
        for (Entry<String, Thu> entry : dsThu.entrySet()) {
            System.out.println("Thứ " + entry.getKey() + ":");
            entry.getValue().hienThiLichHoc();
        	}
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tuần ").append(soTuan).append(":\n");
        for (String thu : dsThu.keySet()) {
            sb.append("  Thứ ").append(thu).append(":\n");
            sb.append(dsThu.get(thu)).append("\n");
        }
        return sb.toString();
    }

}
