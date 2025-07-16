public class Nhanvien {
    private String tenNhanVien;
    private String maNhanVien;
    private double luong;
    public Nhanvien() {}

    public void setTenNhanVien(String ten) {
        tenNhanVien = ten;
    }
    public String getTenNhanVien() {
        return tenNhanVien;
    }
    public void setMaNhanVien(String ma) {
        maNhanVien = ma;
    }
    public String getMaNhanVien() {
        return maNhanVien;
    }
    public void setLuong(double l) {
        luong = l;
    }
    public double getLuong() {
        return luong;
    }
    public void hienThiThongTin() {
        System.out.println("Ten nhan vien : " + tenNhanVien);
        System.out.println("Ma nhan vien  : " + maNhanVien);
        System.out.println("Luong         : " + luong + " VND");
    }
}
