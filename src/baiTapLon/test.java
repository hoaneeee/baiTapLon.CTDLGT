package baiTapLon;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        quanLiNhanSu ql= new quanLiNhanSu();
        int choice;
        do {
            System.out.println("-----Menu-----");
            System.out.println("1. Tạo danh sách cán bộ");
            System.out.println("2. Thêm cán bộ vào danh sách");
            System.out.println("3. Liệt kê danh sách cán bộ");
            System.out.println("4. Thống kê số lượng cán bộ theo phòng ban");
            System.out.println("5. In cán bộ có tổng lương >= 5000000");
            System.out.println("6. Tìm vị trí cán bộ theo mã số");
            System.out.println("7. Tìm kiếm cán bộ theo tên");
            System.out.println("8. Sắp xếp danh sách cán bộ theo tổng lương giảm dần");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    ql. taoDanhSachCanBo();
                    break;
                case 2:
                    ql.themCanBo();
                    break;
                case 3:
                    ql.lietKeDanhSach();
                    break;
                case 4:
                    ql.thongKeCanBo();
                    break;
                case 5:
                    ql.luongLonHon1Jack();
                    break;
                case 6:
                    ql.searchMCB();
                    break;
                case 7:
                    ql.searchTCB();
                    break;
                case 8:
                    ql.sortLuongGiamDan();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }while (choice!=0);
    }
}
