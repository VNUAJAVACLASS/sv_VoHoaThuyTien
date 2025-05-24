package fita.vnua.tkb;

import java.util.ArrayList;
import java.util.List;

public class Thu {
	private String soThu;
	
	List<LichHoc> dsLich = new ArrayList<>();
	
	public Thu(String soThu) {
		this.soThu = soThu;
	}
	
	public String  getSoThu() {
        return soThu;
    }

    public void setSoThu(String soThu) {
        this.soThu = soThu;
    }

    public void themLich(LichHoc lich) {
        dsLich.add(lich);
    }

    public List<LichHoc> getDsLich() {
        return dsLich;
    }
    
    public void hienThiLichHoc() {
        for (LichHoc lichHoc : dsLich) {
            System.out.println(lichHoc);
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Lịch học Thứ " + soThu + ":\n");
        if (dsLich.isEmpty()) {
            sb.append("  (Không có lịch học)\n");
        } else {
            for (LichHoc lh : dsLich) {
                sb.append("  - ").append(lh.toString()).append("\n");
            }
        }
        return sb.toString();
    }
    

}
