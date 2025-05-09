package fita.vnua.hellomaven;

import java.util.ArrayList;
import java.util.List;

public class Thu {
	private int soThu;
	
	List<LichHoc> dsLich = new ArrayList<>();
	
	public Thu(int soThu) {
		this.soThu = soThu;
	}
	
	public int  getSoThu() {
        return soThu;
    }

    public void setSoThu(int soThu) {
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

}
