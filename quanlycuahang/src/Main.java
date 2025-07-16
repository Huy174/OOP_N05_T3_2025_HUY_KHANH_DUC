import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        QuanLyKhachHang qlKH = new QuanLyKhachHang();
        QuanLyNhanVien qlNV = new QuanLyNhanVien();
        QuanLySanPham qlSP = new QuanLySanPham();
        QuanLyGiaoDich qlGD = new QuanLyGiaoDich();

        int chon;

        do {
            System.out.println("\n========== MENU CHINH ==========");
            System.out.println("1. Quan ly Khach Hang");
            System.out.println("2. Quan ly Nhan Vien");
            System.out.println("3. Quan ly San Pham");
            System.out.println("4. Quan ly Giao Dich");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    menuKhachHang(qlKH, sc);
                    break;
                case 2:
                    menuNhanVien(qlNV, sc);
                    break;
                case 3:
                    menuSanPham(qlSP, sc);
                    break;
                case 4:
                    menuGiaoDich(qlGD, qlKH, sc);  // ✅ Gọi đúng với qlKH
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Chuc nang khong hop le.");
            }
        } while (chon != 0);

        sc.close();
    }

    public static void menuKhachHang(QuanLyKhachHang qlKH, Scanner sc) {
        int chon;
        do {
            System.out.println("\n=== MENU KHACH HANG ===");
            System.out.println("1. Them");
            System.out.println("2. Hien thi");
            System.out.println("3. Sua");
            System.out.println("4. Xoa");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1: qlKH.themKhachHang(); break;
                case 2: qlKH.hienThiTatCa(); break;
                case 3: qlKH.suaKhachHang(); break;
                case 4: qlKH.xoaKhachHang(); break;
            }
        } while (chon != 0);
    }

 
    public static void menuNhanVien(QuanLyNhanVien qlNV, Scanner sc) {
        int chon;
        do {
            System.out.println("\n=== MENU NHAN VIEN ===");
            System.out.println("1. Them");
            System.out.println("2. Hien thi");
            System.out.println("3. Sua");
            System.out.println("4. Xoa");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1: qlNV.themNhanVien(); break;
                case 2: qlNV.hienThiTatCa(); break;
                case 3: qlNV.suaNhanVien(); break;
                case 4: qlNV.xoaNhanVien(); break;
            }
        } while (chon != 0);
    }

   
    public static void menuSanPham(QuanLySanPham qlSP, Scanner sc) {
        int chon;
        do {
            System.out.println("\n=== MENU SAN PHAM ===");
            System.out.println("1. Them");
            System.out.println("2. Hien thi");
            System.out.println("3. Sua");
            System.out.println("4. Xoa");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1: qlSP.themSanPham(); break;
                case 2: qlSP.hienThiTatCa(); break;
                case 3: qlSP.suaSanPham(); break;
                case 4: qlSP.xoaSanPham(); break;
            }
        } while (chon != 0);
    }

    public static void menuGiaoDich(QuanLyGiaoDich qlGD, QuanLyKhachHang qlKH, Scanner sc) {
        int chon;
        do {
            System.out.println("\n=== MENU GIAO DICH ===");
            System.out.println("1. Them");
            System.out.println("2. Hien thi");
            System.out.println("3. Sua");
            System.out.println("4. Xoa");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1: qlGD.themGiaoDich(qlKH); break;  
                case 2: qlGD.hienThiTatCa(); break;
                case 3: qlGD.suaGiaoDich(); break;
                case 4: qlGD.xoaGiaoDich(); break;
            }
        } while (chon != 0);
    }
}
