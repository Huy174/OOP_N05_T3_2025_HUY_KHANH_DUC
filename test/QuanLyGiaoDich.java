import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyGiaoDich {
    private ArrayList<Giaodich> danhSachGD = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // CREATE
    public void themGiaoDich(QuanLyKhachHang qlKH, QuanLySanPham qlSP) {
        System.out.print("Nhap ma khach hang: ");
        String maKH = sc.nextLine();

        Khachhang kh = qlKH.timKhachHangTheoMa(maKH);
        if (kh == null) {
            System.out.println("Khach hang chua ton tai. Them moi khach hang:");
            qlKH.themKhachHang();
            kh = qlKH.timKhachHangTheoMa(maKH);
        }

        String tenKH = kh.getTenKhachHang();

        System.out.print("Nhap ma giao dich: ");
        String maGD = sc.nextLine();

        Giaodich gd = new Giaodich();
        gd.setMaGiaoDich(maGD);
        gd.setTenKhachHang(tenKH);

        System.out.print("Nhap so san pham muon them: ");
        int soSP = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < soSP; i++) {
            System.out.println("San pham thu " + (i + 1) + ":");
            System.out.print(" - Ten: ");
            String tenSP = sc.nextLine();

            Sanpham sp = qlSP.timTheoTen(tenSP); // tìm theo tên sản phẩm
            if (sp == null) {
                System.out.println("San pham khong ton tai.");
                i--;
                continue;
            }

            System.out.print(" - So luong: ");
            int sl = Integer.parseInt(sc.nextLine());

            if (sp.getTonKho() < sl) {
                System.out.println("Khong du hang. Ton kho: " + sp.getTonKho());
                i--;
                continue;
            }

            sp.setTonKho(sp.getTonKho() - sl);
            double gia = sp.getGia();

            ChiTietGiaoDich ctd = new ChiTietGiaoDich(tenSP, sl, gia);
            gd.themSanPham(ctd);
        }

        danhSachGD.add(gd);
        System.out.println("=> Da them giao dich.");
        System.out.printf("=> Tong tien giao dich: %.2f VND\n", gd.tinhTongTien());
    }

    // READ
    public void hienThiTatCa() {
        if (danhSachGD.isEmpty()) {
            System.out.println("Danh sach giao dich trong.");
            return;
        }
        for (Giaodich gd : danhSachGD) {
            gd.hienThiThongTin();
            System.out.printf("Tong tien: %.2f VND\n", gd.tinhTongTien());
            System.out.println("----------------------------");
        }
    }

    // UPDATE
    public void suaGiaoDich(QuanLySanPham qlSP) {
        System.out.print("Nhap ma giao dich can sua: ");
        String ma = sc.nextLine();

        for (Giaodich gd : danhSachGD) {
            if (gd.getMaGiaoDich().equalsIgnoreCase(ma)) {
                System.out.print("Nhap ten khach hang moi: ");
                gd.setTenKhachHang(sc.nextLine());

                // Hoàn kho lại các sản phẩm cũ
                for (ChiTietGiaoDich ctd : gd.getDanhSachSanPham()) {
                    Sanpham sp = qlSP.timTheoTen(ctd.getTenSanPham());
                    if (sp != null) {
                        sp.setTonKho(sp.getTonKho() + ctd.getSoLuong());
                    }
                }

                gd.xoaTatCaSanPham();

                System.out.print("Nhap lai so san pham: ");
                int soSP = Integer.parseInt(sc.nextLine());

                for (int i = 0; i < soSP; i++) {
                    System.out.println("San pham thu " + (i + 1) + ":");
                    System.out.print(" - Ten: ");
                    String tenSP = sc.nextLine();

                    Sanpham sp = qlSP.timTheoTen(tenSP);
                    if (sp == null) {
                        System.out.println("San pham khong ton tai.");
                        i--;
                        continue;
                    }

                    System.out.print(" - So luong: ");
                    int sl = Integer.parseInt(sc.nextLine());

                    if (sp.getTonKho() < sl) {
                        System.out.println("Khong du hang. Ton kho: " + sp.getTonKho());
                        i--;
                        continue;
                    }

                    sp.setTonKho(sp.getTonKho() - sl);
                    double gia = sp.getGia();

                    ChiTietGiaoDich ctd = new ChiTietGiaoDich(tenSP, sl, gia);
                    gd.themSanPham(ctd);
                }

                System.out.println("=> Da cap nhat giao dich.");
                System.out.printf("=> Tong tien moi: %.2f VND\n", gd.tinhTongTien());
                return;
            }
        }

        System.out.println("Khong tim thay giao dich.");
    }

    // DELETE
    public void xoaGiaoDich(QuanLySanPham qlSP) {
        System.out.print("Nhap ma giao dich can xoa: ");
        String ma = sc.nextLine();

        for (int i = 0; i < danhSachGD.size(); i++) {
            Giaodich gd = danhSachGD.get(i);
            if (gd.getMaGiaoDich().equalsIgnoreCase(ma)) {
                // Hoàn trả tồn kho trước khi xóa
                for (ChiTietGiaoDich ctd : gd.getDanhSachSanPham()) {
                    Sanpham sp = qlSP.timTheoTen(ctd.getTenSanPham());
                    if (sp != null) {
                        sp.setTonKho(sp.getTonKho() + ctd.getSoLuong());
                    }
                }
                danhSachGD.remove(i);
                System.out.println("=> Da xoa giao dich.");
                return;
            }
        }

        System.out.println("Khong tim thay giao dich.");
    }
// KIEM TRA TON KHO
public void kiemTraTonKhoVaGiaoDich(QuanLySanPham qlSP) {
    System.out.println("=== KIEM TRA TON KHO SAU GIAO DICH ===");
    for (Sanpham sp : qlSP.getDanhSachSanPham()) {
        System.out.printf("San pham: %s | Ton kho: %d\n", sp.getTenSanPham(), sp.getTonKho());
    }
}
}
