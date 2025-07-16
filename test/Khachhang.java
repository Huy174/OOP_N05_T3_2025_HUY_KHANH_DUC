public class Khachhang {
    private String MaKhachHang;
    private String TenKhachHang;
    private String DiaChi;
    private String SoDienThoai;
    private String Hang;
    public Khachhang() {}
    public void setMaKhachHang(String mkh) {
        MaKhachHang = mkh;
    }
    public String getMaKhachHang() {
        return MaKhachHang;
    }
    public void setTenKhachHang(String tkh) {
        TenKhachHang = tkh;
    }
    public String getTenKhachHang() {
        return TenKhachHang;
    }
    public void setDiaChi(String dc) {
        DiaChi = dc;
    }
    public String getDiaChi() {
        return DiaChi;
    }
    public void setSoDienThoai(String sdt) {
        SoDienThoai = sdt;
    }
    public String getSoDienThoai() {
        return SoDienThoai;
    }
    public void setHang(String h) {
        Hang = h;
    }
    public String getHang() {
        return Hang;
    }
    public void hienThiThongTin() {
        System.out.println("Ma KH: " + MaKhachHang);
        System.out.println("Ten KH: " + TenKhachHang);
        System.out.println("dia chi: " + DiaChi);
        System.out.println("So dien thoai: " + SoDienThoai);
        System.out.println("Hang: " + Hang);
    }
}
