import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Khachhang kh = new Khachhang();
        System.out.println("=== NHAP THONG TIN KHACH HANG ===");
        System.out.print("Ma KH: "); kh.setMaKhachHang(sc.nextLine());
        System.out.print("Ten KH: "); kh.setTenKhachHang(sc.nextLine());
        System.out.print("Dia chi: "); kh.setDiaChi(sc.nextLine());
        System.out.print("So dien thoai: "); kh.setSoDienThoai(sc.nextLine());
        System.out.print("Hang: "); kh.setHang(sc.nextLine());

        Nhanvien nv = new Nhanvien();
        System.out.println("\n=== NHAP THONG TIN NHAN VIEN ===");
        System.out.print("Ma NV: "); nv.setMaNhanVien(sc.nextLine());
        System.out.print("Ten NV: "); nv.setTenNhanVien(sc.nextLine());
        System.out.print("Luong: "); nv.setLuong(Double.parseDouble(sc.nextLine()));

        System.out.print("\nNhap so luong san pham: ");
        int soSanPham = Integer.parseInt(sc.nextLine());
        Sanpham[] danhSachSP = new Sanpham[soSanPham];

        for (int i = 0; i < soSanPham; i++) {
            System.out.println("\n--- San pham " + (i + 1) + " ---");
            danhSachSP[i] = new Sanpham();
            System.out.print("Ma SP: "); danhSachSP[i].setMaSanPham(sc.nextLine());
            System.out.print("Ten SP: "); danhSachSP[i].setTenSanPham(sc.nextLine());
            System.out.print("Gia ban: "); danhSachSP[i].setGia(Double.parseDouble(sc.nextLine()));
            System.out.print("Ton kho: "); danhSachSP[i].setTonKho(Integer.parseInt(sc.nextLine()));
            System.out.print("Ten NCC: "); danhSachSP[i].setTenNhaCungCap(sc.nextLine());
            System.out.print("Gia cung cap: "); danhSachSP[i].setGiaCungCap(Double.parseDouble(sc.nextLine()));
            System.out.print("So luong NCC cung cap: "); danhSachSP[i].setSoLuongCungCap(Integer.parseInt(sc.nextLine()));
        }

        Giaodich gd = new Giaodich();
        System.out.println("\n=== NHAP GIAO DICH ===");
        System.out.print("Ma GD: "); gd.setMaGiaoDich(sc.nextLine());
        gd.setTenKhachHang(kh.getTenKhachHang());

        for (int i = 0; i < soSanPham; i++) {
            System.out.print("Nhap so luong mua san pham \"" + danhSachSP[i].getTenSanPham() + "\": ");
            int sl = Integer.parseInt(sc.nextLine());
            if (sl > 0) {
                gd.themSanPham(new ChiTietGiaoDich(
                    danhSachSP[i].getTenSanPham(), sl, danhSachSP[i].getGia()
                ));
            }
        }

        System.out.println("\n========== KET QUA ==========");
        System.out.println("\n> Thong tin khach hang:");
        kh.hienThiThongTin();

        System.out.println("\n> Thong tin nhan vien:");
        nv.hienThiThongTin();

        System.out.println("\n> Danh sach san pham:");
        for (Sanpham sp : danhSachSP) {
            sp.hienThiThongTin();
            System.out.println();
        }

        System.out.println("> Thong tin giao dich:");
        gd.hienThiThongTin();

        sc.close();
    }
}

