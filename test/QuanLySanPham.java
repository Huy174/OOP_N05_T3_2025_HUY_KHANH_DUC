import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySanPham {
    private ArrayList<Sanpham> danhSach = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // CREATE
    public void themSanPham() {
        System.out.print("Nhap ma san pham: ");
        String ma = sc.nextLine();
        System.out.print("Nhap ten san pham: ");
        String ten = sc.nextLine();
        System.out.print("Nhap gia ban: ");
        double gia = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap so luong ton kho: ");
        int ton = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap ten nha cung cap: ");
        String tenNCC = sc.nextLine();
        System.out.print("Nhap gia cung cap: ");
        double giaNCC = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap so luong cung cap: ");
        int slNCC = Integer.parseInt(sc.nextLine());

        Sanpham sp = new Sanpham();
        sp.setMaSanPham(ma);
        sp.setTenSanPham(ten);
        sp.setGia(gia);
        sp.setTonKho(ton);
        sp.setTenNhaCungCap(tenNCC);
        sp.setGiaCungCap(giaNCC);
        sp.setSoLuongCungCap(slNCC);

        danhSach.add(sp);
        System.out.println("=> Da them san pham.");
    }

    // READ
    public void hienThiTatCa() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach san pham trong.");
            return;
        }
        for (Sanpham sp : danhSach) {
            sp.hienThiThongTin();
            System.out.println("---------------------------");
        }
    }

    // UPDATE
    public void suaSanPham() {
        System.out.print("Nhap ma SP can sua: ");
        String ma = sc.nextLine();

        for (Sanpham sp : danhSach) {
            if (sp.getMaSanPham().equalsIgnoreCase(ma)) {
                System.out.print("Nhap ten moi: ");
                sp.setTenSanPham(sc.nextLine());
                System.out.print("Nhap gia ban moi: ");
                sp.setGia(Double.parseDouble(sc.nextLine()));
                System.out.print("Nhap ton kho moi: ");
                sp.setTonKho(Integer.parseInt(sc.nextLine()));

                System.out.print("Nhap ten NCC moi: ");
                sp.setTenNhaCungCap(sc.nextLine());
                System.out.print("Nhap gia NCC moi: ");
                sp.setGiaCungCap(Double.parseDouble(sc.nextLine()));
                System.out.print("Nhap SL NCC moi: ");
                sp.setSoLuongCungCap(Integer.parseInt(sc.nextLine()));

                System.out.println("=> Da cap nhat san pham.");
                return;
            }
        }

        System.out.println("Khong tim thay san pham.");
    }

    // DELETE
    public void xoaSanPham() {
        System.out.print("Nhap ma SP can xoa: ");
        String ma = sc.nextLine();

        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaSanPham().equalsIgnoreCase(ma)) {
                danhSach.remove(i);
                System.out.println("=> Da xoa san pham.");
                return;
            }
        }

        System.out.println("Khong tim thay san pham.");
    }

    public Sanpham timTheoTen(String ten) {
        for (Sanpham sp : danhSach) {
            if (sp.getTenSanPham().equalsIgnoreCase(ten)) {
                return sp;
            }
        }
        return null;
    }
    public ArrayList<Sanpham> getDanhSachSanPham() {
    return danhSach;
}

}
