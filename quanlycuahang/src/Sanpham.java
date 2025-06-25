public class Sanpham {
    private String MaSanPham;
    private String TenSanPham;
    private double Gia;
    private int TonKho;

    private String TenNhaCungCap;
    private double GiaCungCap;
    private int SoLuongCungCap;

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
    public void setTenNhaCungCap(String ten) {
        TenNhaCungCap = ten;
    }

    public String getTenNhaCungCap() {
        return TenNhaCungCap;
    }

    public void setGiaCungCap(double gia) {
        GiaCungCap = gia;
    }

    public double getGiaCungCap() {
        return GiaCungCap;
    }

    public void setSoLuongCungCap(int sl) {
        SoLuongCungCap = sl;
    }

    public int getSoLuongCungCap() {
        return SoLuongCungCap;
    }

    // In thông tin chi tiết sản phẩm
    public void hienThiThongTin() {
        System.out.println("Ma SP       : " + MaSanPham);
        System.out.println("Ten SP      : " + TenSanPham);
        System.out.println("Gia ban     : " + Gia + " VND");
        System.out.println("Ton kho     : " + TonKho + " san pham");

        System.out.println("--- Nha cung cap ---");
        System.out.println("Ten NCC     : " + TenNhaCungCap);
        System.out.println("Gia NCC     : " + GiaCungCap + " VND");
        System.out.println("So luong NCC: " + SoLuongCungCap);
    }
}

