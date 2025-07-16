import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyKhachHang {
    private ArrayList<Khachhang> danhSach = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // CREATE
    public void themKhachHang() {
        System.out.print("Nhap ma khach hang: ");
        String ma = sc.nextLine();
        System.out.print("Nhap ten khach hang: ");
        String ten = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        String diaChi = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        String sdt = sc.nextLine();
        System.out.print("Nhap hang khach hang (Vi du: Vang/Bac/Thuong): ");
        String hang = sc.nextLine();

        Khachhang kh = new Khachhang();
        kh.setMaKhachHang(ma);
        kh.setTenKhachHang(ten);
        kh.setDiaChi(diaChi);
        kh.setSoDienThoai(sdt);
        kh.setHang(hang);

        danhSach.add(kh);
        System.out.println("=> Da them khach hang.");
    }

    // READ
    public void hienThiTatCa() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach khach hang trong.");
            return;
        }

        for (Khachhang kh : danhSach) {
            kh.hienThiThongTin();
            System.out.println("----------------------------");
        }
    }

    // UPDATE
    public void suaKhachHang() {
        System.out.print("Nhap ma KH can sua: ");
        String ma = sc.nextLine();

        for (Khachhang kh : danhSach) {
            if (kh.getMaKhachHang().equalsIgnoreCase(ma)) {
                System.out.print("Nhap ten moi: ");
                kh.setTenKhachHang(sc.nextLine());
                System.out.print("Nhap dia chi moi: ");
                kh.setDiaChi(sc.nextLine());
                System.out.print("Nhap so dien thoai moi: ");
                kh.setSoDienThoai(sc.nextLine());
                System.out.print("Nhap hang moi: ");
                kh.setHang(sc.nextLine());
                System.out.println("=> Da cap nhat thong tin.");
                return;
            }
        }

        System.out.println("Khong tim thay khach hang.");
    }

    // DELETE
    public void xoaKhachHang() {
        System.out.print("Nhap ma KH can xoa: ");
        String ma = sc.nextLine();

        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaKhachHang().equalsIgnoreCase(ma)) {
                danhSach.remove(i);
                System.out.println("=> Da xoa khach hang.");
                return;
            }
        }

        System.out.println("Khong tim thay khach hang.");
    }

    // SEARCH
    public Khachhang timKhachHangTheoMa(String maKH) {
        for (Khachhang kh : danhSach) {
            if (kh.getMaKhachHang().equalsIgnoreCase(maKH)) {
                return kh;
            }
        }
        return null;
    }
}



