package fita.vnua.tkb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CTRChinh {
	private List<Tuan> dsTuan;
    private final LocalDate ngayBatDau;

    public CTRChinh() {
        this.dsTuan = new ArrayList<>();
        this.ngayBatDau = LocalDate.of(2025, 1, 13);
    }

    private Tuan getOrCreateTuan(int soTuan) {
        for (Tuan tuan : dsTuan) {
            if (tuan.getSoTuan() == soTuan) {
                return tuan;
            }
        }
        Tuan tuanMoi = new Tuan(soTuan);
        dsTuan.add(tuanMoi);
        System.out.println("Tạo tuần mới: " + soTuan);
        return tuanMoi;
    }

    public void themLich(LichHoc lichHoc) {
        String thoiGianHoc = lichHoc.getThoiGianHoc();
        if (thoiGianHoc == null || thoiGianHoc.isEmpty()) {
            return;
        }
        for (int i = 0; i < thoiGianHoc.length() && i < 20; i++) {
            char c = thoiGianHoc.charAt(i);
            if (Character.isDigit(c) && c != '0') {
                int soTuan = i + 1;
                Tuan tuan = getOrCreateTuan(soTuan);
                // Cần thêm lichHoc vào đúng thứ của tuần, lấy thứ từ lichHoc.getThu() giả sử
                String soThu = lichHoc.getThu(); // VD: "2" - Thứ Hai, "3" - Thứ Ba, ...
                tuan.themLich(soThu, lichHoc);
            }
        }
    }

    public void hienThiThoiKhoaBieu() {
        if (dsTuan.isEmpty()) {
            System.out.println("Thời khóa biểu trống.");
            return;
        }
        dsTuan.sort((t1, t2) -> Integer.compare(t1.getSoTuan(), t2.getSoTuan()));
        for (Tuan tuan : dsTuan) {
            System.out.println(tuan);
        }
    }

    // Tìm lịch học theo thứ
    public List<LichHoc> timLichHocTheoThu(String soThu) {
        List<LichHoc> ketQua = new ArrayList<>();
        for (Tuan tuan : dsTuan) {
            Map<String, Thu> dsThu = tuan.getDsThu();
            Thu thu = dsThu.get(soThu);
            if (thu != null) {
                ketQua.addAll(thu.getDsLich());
            }
        }
        return ketQua;
    }

    public Tuan timLichHocTheoTuan(int soTuan) {
        for (Tuan tuan : dsTuan) {
            if (tuan.getSoTuan() == soTuan) {
                System.out.println("Tìm thấy tuần " + soTuan + " với " + tuan.getDsThu().size() + " thứ.");
                return tuan;
            }
        }
        System.out.println("Không tìm thấy tuần " + soTuan);
        return null;
    }

    // Tìm lịch học theo ngày cụ thể
    public List<LichHoc> timLichHocTheoNgay(LocalDate date) {
        List<LichHoc> ketQua = new ArrayList<>();

        int dayOfWeek = date.getDayOfWeek().getValue(); // 1=Monday...7=Sunday
        if (dayOfWeek == 7) return ketQua; // Chủ Nhật không có lịch học

        // Theo chuẩn dữ liệu, "2" là Thứ Hai, nên ta cộng thêm 1
        String soThu = String.valueOf(dayOfWeek + 1);

        long daysSinceStart = java.time.temporal.ChronoUnit.DAYS.between(ngayBatDau, date);
        int soTuan = (int)(daysSinceStart / 7) + 1;

        if (soTuan < 1 || soTuan > 20) return ketQua;

        Tuan tuan = timLichHocTheoTuan(soTuan);
        if (tuan != null) {
            Thu thu = tuan.getThu(soThu);
            if (thu != null) {
                ketQua.addAll(thu.getDsLich());
            }
        }
        return ketQua;
    }

    // Lấy tuần hiện tại từ ngày
    public int getCurrentWeek(LocalDate date) {
        long daysSinceStart = java.time.temporal.ChronoUnit.DAYS.between(ngayBatDau, date);
        int soTuan = (int) (daysSinceStart / 7) + 1;
        if (soTuan < 1) {
            System.out.println("Cảnh báo: Ngày " + date + " trước ngày bắt đầu học kỳ.");
        } else if (soTuan > 20) {
            System.out.println("Cảnh báo: Ngày " + date + " ngoài phạm vi học kỳ.");
        }
        return Math.max(1, Math.min(20, soTuan));
    }

}
