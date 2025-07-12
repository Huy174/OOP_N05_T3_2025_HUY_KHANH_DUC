import java.util.ArrayList;

public class Giaodich {
    private String maGiaoDich;
    private String tenKhachHang;
    private ArrayList<ChiTietGiaoDich> danhSachSP = new ArrayList<>();

    public Giaodich() {}

    public void setMaGiaoDich(String ma) {
        maGiaoDich = ma;
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    public void setTenKhachHang(String ten) {
        tenKhachHang = ten;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void themSanPham(ChiTietGiaoDich ctd) {
        danhSachSP.add(ctd);
    }

    public double tinhTongTien() {
        double tong = 0;
        for (ChiTietGiaoDich ctd : danhSachSP) {
            tong += ctd.tinhTien();
        }
        return tong;
    }

    public void hienThiThongTin() {
        System.out.println("Ma GD  : " + maGiaoDich);
        System.out.println("Ten KH : " + tenKhachHang);
        System.out.println("Danh sach san pham:");
        for (ChiTietGiaoDich ctd : danhSachSP) {
            ctd.hienThi();
        }
        System.out.println("TONG TIEN: " + tinhTongTien() + " VND");
    }
    public void xoaTatCaSanPham() {
    danhSachSP.clear();
}

}
