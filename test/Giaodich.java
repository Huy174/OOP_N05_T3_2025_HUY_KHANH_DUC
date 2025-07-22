import java.util.ArrayList;

public class Giaodich {
    private String maGiaoDich;
    private String tenKhachHang;
    private ArrayList<ChiTietGiaoDich> danhSachSP = new ArrayList<>();

    public Giaodich() {}

    // Constructor moi
    public Giaodich(String maGD, String tenKH, String tenSP, int soLuong) {
        this.maGiaoDich = maGD;
        this.tenKhachHang = tenKH;

        ChiTietGiaoDich ctd = new ChiTietGiaoDich(tenSP, soLuong, 0); // Giá mặc định là 0
        danhSachSP.add(ctd);
    }

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

    public void xoaTatCaSanPham() {
        danhSachSP.clear();
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

    public ArrayList<ChiTietGiaoDich> getDanhSachSanPham() {
        return danhSachSP;
    }
}
