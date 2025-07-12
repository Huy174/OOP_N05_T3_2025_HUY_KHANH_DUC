import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyGiaoDich {
    private ArrayList<Giaodich> danhSachGD = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // CREATE
    public void themGiaoDich() {
        Giaodich gd = new Giaodich();

        System.out.print("Nhap ma giao dich: ");
        gd.setMaGiaoDich(sc.nextLine());

        System.out.print("Nhap ten khach hang: ");
        gd.setTenKhachHang(sc.nextLine());

        System.out.print("Nhap so san pham: ");
        int soSP = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < soSP; i++) {
            System.out.println("San pham thu " + (i + 1) + ":");
            System.out.print(" - Ten san pham: ");
            String ten = sc.nextLine();
            System.out.print(" - So luong: ");
            int sl = Integer.parseInt(sc.nextLine());
            System.out.print(" - Gia: ");
            double gia = Double.parseDouble(sc.nextLine());

            ChiTietGiaoDich ctd = new ChiTietGiaoDich(ten, sl, gia);
            gd.themSanPham(ctd);
        }

        danhSachGD.add(gd);
        System.out.println("=> Da them giao dich.");
    }

    // READ
    public void hienThiTatCa() {
        if (danhSachGD.isEmpty()) {
            System.out.println("Danh sach giao dich trong.");
            return;
        }
        for (Giaodich gd : danhSachGD) {
            gd.hienThiThongTin();
            System.out.println("----------------------------");
        }
    }

    // UPDATE
    public void suaGiaoDich() {
        System.out.print("Nhap ma giao dich can sua: ");
        String ma = sc.nextLine();

        for (Giaodich gd : danhSachGD) {
            if (gd.getMaGiaoDich().equalsIgnoreCase(ma)) {
                System.out.print("Nhap ten khach hang moi: ");
                gd.setTenKhachHang(sc.nextLine());

                // Clear và thêm lại danh sách sản phẩm
                System.out.print("Nhap lai so san pham: ");
                int soSP = Integer.parseInt(sc.nextLine());
                gd.xoaTatCaSanPham();


                for (int i = 0; i < soSP; i++) {
                    System.out.println("San pham thu " + (i + 1) + ":");
                    System.out.print(" - Ten: ");
                    String ten = sc.nextLine();
                    System.out.print(" - So luong: ");
                    int sl = Integer.parseInt(sc.nextLine());
                    System.out.print(" - Gia: ");
                    double gia = Double.parseDouble(sc.nextLine());

                    ChiTietGiaoDich ctd = new ChiTietGiaoDich(ten, sl, gia);
                    gd.themSanPham(ctd);
                }

                System.out.println("=> Da cap nhat giao dich.");
                return;
            }
        }

        System.out.println("Khong tim thay giao dich.");
    }

    // DELETE
    public void xoaGiaoDich() {
        System.out.print("Nhap ma giao dich can xoa: ");
        String ma = sc.nextLine();

        for (int i = 0; i < danhSachGD.size(); i++) {
            if (danhSachGD.get(i).getMaGiaoDich().equalsIgnoreCase(ma)) {
                danhSachGD.remove(i);
                System.out.println("=> Da xoa giao dich.");
                return;
            }
        }

        System.out.println("Khong tim thay giao dich.");
    }
}
