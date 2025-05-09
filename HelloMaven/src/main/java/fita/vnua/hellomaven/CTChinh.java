package fita.vnua.hellomaven;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class CTChinh {
	Map<Integer, Tuan> dsTuan = new HashMap<>();
	private static final LocalDate ngayBatDau = LocalDate.of(2025, 1, 13); // Ngày bắt đầu học kỳ
   
    public void hienThiTheoNgay(LocalDate ngay) {
    	int tuan = (int) ChronoUnit.WEEKS.between(ngayBatDau, ngay) + 1;
    	int soThu = ngay.getDayOfWeek().getValue() + 1; // Thứ 2 là 2, Chủ nhật là 8
    	Tuan t = dsTuan.get(tuan);
    	 if (t != null) {
	            Thu thuObj = t.getDsThu().get(soThu);
	            if (thuObj != null) {
	                System.out.println("Lịch học ngày " + ngay + ":");
	                thuObj.getDsLich().forEach(System.out::println);
	            } else {
	                System.out.println("Không có lịch học ngày " + ngay);
	            }
	        } else {
	            System.out.println("Không có lịch học tuần " + tuan);
	        }
	    }
	       

    public void hienThiTheoTuan(int tuan) {
    	Tuan t = dsTuan.get(tuan);
    	if (t != null) {
            System.out.println("Thời khóa biểu tuần " + tuan + ":");
            for (int i = 2; i <= 8; i++) {
                Thu thu = t.getDsThu().get(i);
                if (thu != null) {
                    System.out.println("Thứ " + i + ":");
                    thu.getDsLich().forEach(System.out::println);
                }
            }
        } else {
            System.out.println("Không có dữ liệu tuần " + tuan);
        }
    }
	        
}
