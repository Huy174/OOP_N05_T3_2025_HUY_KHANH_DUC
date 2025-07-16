public class ChiTietGiaoDich {
    private String tenSanPham;
    private int soLuong;
    private double gia;

    public ChiTietGiaoDich() {}

    public ChiTietGiaoDich(String ten, int sl, double g) {
        tenSanPham = ten;
        soLuong = sl;
        gia = g;
    }

    public void setTenSanPham(String ten) { tenSanPham = ten; }
    public String getTenSanPham() { return tenSanPham; }

    public void setSoLuong(int sl) { soLuong = sl; }
    public int getSoLuong() { return soLuong; }

    public void setGia(double g) { gia = g; }
    public double getGia() { return gia; }

    public double tinhTien() {
        return soLuong * gia;
    }

    public void hienThi() {
        System.out.println("- " + tenSanPham + " | SL: " + soLuong + " | Gia: " + gia + " | Thanh tien: " + tinhTien());
    }
}
