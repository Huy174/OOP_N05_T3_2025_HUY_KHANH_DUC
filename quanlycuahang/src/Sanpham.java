public class Sanpham {
    private String MaSanPham;
    private String TenSanPham;
    private double Gia;
    private int TonKho;
    public Sanpham() {}
    public void setMaSanPham(String msp) {
        MaSanPham = msp;
    }
    public String getMaSanPham() {
        return MaSanPham;
    }
    public void setTenSanPham(String tsp) {
        TenSanPham = tsp;
    }
    public String getTenSanPham() {
        return TenSanPham;
    }
    public void setGia(double g) {
        Gia = g;
    }
    public double getGia() {
        return Gia;
    }
    public void setTonKho(int ton) {
        TonKho = ton;
    }
    public int getTonKho() {
        return TonKho;
    }
    public void hienThiThongTin() {
        System.out.println("Ma SP: " + MaSanPham);
        System.out.println("Ten SP: " + TenSanPham);
        System.out.println("Gia: " + Gia + " VND");
        System.out.println("Ton kho: " + TonKho + " san pham");
    }
}

