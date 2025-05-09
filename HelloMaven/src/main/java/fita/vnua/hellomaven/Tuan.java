package fita.vnua.hellomaven;

import java.util.HashMap;
import java.util.Map;

public class Tuan {
	private int soTuan;
	Map<Integer, Thu> dsThu = new HashMap<>(); // thứ 2 đến CN
	
	public Tuan(int soTuan) {
        this.soTuan = soTuan;
    }
	
	public int getSoTuan() {
        return soTuan;
    }

    public void setSoTuan(int soTuan) {
        this.soTuan = soTuan;
    }

    public Map<Integer, Thu> getDsThu() {
        return dsThu;
    }

    public Thu getThu(int soThu) {
        return dsThu.get(soThu);
    }
}
