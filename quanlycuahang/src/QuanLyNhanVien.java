import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyNhanVien {
    private ArrayList<Nhanvien> danhSach = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // CREATE
    public void themNhanVien() {
        System.out.print("Nhap ma nhan vien: ");
        String ma = sc.nextLine();
        System.out.print("Nhap ten nhan vien: ");
        String ten = sc.nextLine();
        System.out.print("Nhap luong: ");
        double luong = Double.parseDouble(sc.nextLine());

        Nhanvien nv = new Nhanvien();
        nv.setMaNhanVien(ma);
        nv.setTenNhanVien(ten);
        nv.setLuong(luong);

        danhSach.add(nv);
        System.out.println("=> Da them nhan vien.");
    }

    // READ
    public void hienThiTatCa() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach nhan vien trong.");
            return;
        }
        for (Nhanvien nv : danhSach) {
            nv.hienThiThongTin();
            System.out.println("-----------------------------");
        }
    }

    // UPDATE
    public void suaNhanVien() {
        System.out.print("Nhap ma nhan vien can sua: ");
        String ma = sc.nextLine();

        for (Nhanvien nv : danhSach) {
            if (nv.getMaNhanVien().equalsIgnoreCase(ma)) {
                System.out.print("Nhap ten moi: ");
                nv.setTenNhanVien(sc.nextLine());
                System.out.print("Nhap luong moi: ");
                nv.setLuong(Double.parseDouble(sc.nextLine()));
                System.out.println("=> Da cap nhat thong tin nhan vien.");
                return;
            }
        }

        System.out.println("Khong tim thay nhan vien.");
    }

    // DELETE
    public void xoaNhanVien() {
        System.out.print("Nhap ma nhan vien can xoa: ");
        String ma = sc.nextLine();

        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaNhanVien().equalsIgnoreCase(ma)) {
                danhSach.remove(i);
                System.out.println("=> Da xoa nhan vien.");
                return;
            }
        }

        System.out.println("Khong tim thay nhan vien.");
    }
}
