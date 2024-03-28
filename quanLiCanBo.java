package baiTapLon2;

import java.util.Scanner;

public class quanLiCanBo {
    private canBo first;

    public quanLiCanBo() {
        this.first = null;
    }
    //=======================1. Tạo danh sách cán bộ: Quá trình nhập danh sách sẽ dừng lại khi nhập mã số <=0==================
    public void taoDanhSach() {
        System.out.println("---------tạo danh sách cán bộ----------");
        Scanner sc = new Scanner(System.in);

        int maCanBo;
        String tenCanBo;
        String phongBan;
        double tongLuong;
        do {
            System.out.println("mã cán bộ(nếu mã cán bộ <0 thoát chương trình) : ");
            maCanBo = sc.nextInt();
            if(maCanBo<=0){
                break;
            }
            sc.nextLine();
            System.out.println("tên cán bộ : ");
            tenCanBo = sc.nextLine();
            System.out.println("phòng ban : ");
            phongBan=sc.nextLine();
            System.out.println("tổng lương : ");
            tongLuong = sc.nextDouble();
            canBo cb = new canBo(maCanBo, tenCanBo, phongBan, tongLuong);
            if (first == null) {
                first = cb;
            } else {
                canBo cr = first;
                while (cr.next != null) {
                    cr = cr.next;
                }
                cr.next = cb;
            }

        }while (true);
    }
    //===================2. Thêm 1 cán bộ vào danh sách, vị trí thêm vào do ta chọn.=====================
    public void addCanBo(){
        Scanner sc= new Scanner(System.in);
        int maCanBo;
        String tenCanBo, phongBan;
        double tongLuong;
        System.out.println("===== Thêm cán bộ vào danh sách =====");
        System.out.print("Nhập mã cán bộ: ");
        maCanBo = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập họ đệm và tên: ");
        tenCanBo= sc.nextLine();
        System.out.println("Nhập phòng ban: ");
        phongBan = sc.nextLine();
        System.out.println("Nhập tổng lương: ");
        tongLuong = sc.nextDouble();
        System.out.print("Nhập vị trí muốn thêm cán bộ : ");
        int viTri = sc.nextInt();
        canBo cb= new canBo(maCanBo,tenCanBo,phongBan,tongLuong);
        if (viTri == 1) {
            cb.next = first;
            first= cb;
        } else {
            canBo cr=first;
            for (int i = 1; i < viTri - 1 && cr != null; i++) {
                cr = cr.next;
            }
            if (cr != null) {
                cb.next = cr.next;
                cr.next = cb;
            } else {
                System.out.println("Không tìm thấy vị trí.");
            }
        }
    }
    //==========================3. Liệt kê danh sách cán bộ trên màn hình.=======================
    public void lietkeDanhSach(){
        System.out.println("-------Liệt kê danh sách-------");
        if(first==null){
            System.out.println("danh sách trống ");
        }else {
            canBo cr=first;
            while (cr!=null){
                cr.output();
                cr=cr.next;
            }
        }
    }
    //=============================4. Thống kê số lượng cán bộ theo từng phòng ban (tên phòng ban do người dùng nhập)
    // . In ra màn hình bảng số lượng cán  bộ theo tên phòng ban================
    public void thongkeCacBan(){
        Scanner sc= new Scanner(System.in);
        System.out.println("----------thống kê cán bộ----------");
        int count=0;
        canBo cr= first;
        System.out.println("phòng ban : ");
        String phongBan=sc.nextLine();
        while (cr!=null){
            if(cr.phongBan.equalsIgnoreCase(phongBan)){
                count++;
            }
            cr=cr.next;
        }
        System.out.println("Số lượng cán bộ trong phòng " + phongBan + " là: " + count);
    }
    //====================================5. In lên màn hình tất cả cán bộ có tổng lương>=5000000. =========================================
    public void luongLonHon1Jack(){
        System.out.println("--------cán bộ có lương lớn hơn 1 jack----------");
        int jack=5000000;
        canBo cr=first;
        while (cr!=null){
            if (cr.tongLuong>jack){
                cr.output();
            }
            cr=cr.next;
        }
    }
    //=============6. Nhập vào mã số cán bộ, sau đó in ra vị trí của cán bộ đó trong danh sách.=============
    public void searchMCB(){
        System.out.println("------------------Tìm vị trí cán bộ bằng MCB-----------");
        Scanner sc= new Scanner(System.in);
        System.out.println("nhập mã cán bộ cần tìm vị trí : ");
        int maCanBo = sc.nextInt();
        int viTri=0;
        canBo cr=first;
        while (cr!=null){
            viTri++;
            if(cr.maCanBo==maCanBo){
                System.out.println("vi tri ma can bo da nhap la : "+ viTri);
            }
            cr=cr.next;
        }
    }
    //===========7. Tìm kiếm cán bộ theo tên.==========
    public void searchTCB(){
        System.out.println("----------tìm kiếm theo tên cán bộ -------------");
        Scanner sc= new Scanner(System.in);
        System.out.println("tên cán bộ cần tìm : ");
        String tenCanBo= sc.nextLine();
        canBo cr=first;
        while (cr!=null){
            if (cr.tenCanBo.contains(tenCanBo)){
                cr.output();
            }
            cr=cr.next;
        }
    }
    public void sortLuongGiamDan(){
        canBo cr= first;
        canBo nextNode;
        double temp;
        boolean bl= false;
        if(cr==null){
            System.out.println("danh sách trống ");
        }
       do {
           cr=first;
           nextNode=null;
           while (nextNode.next!=cr.next){
               if (cr.tongLuong<nextNode.tongLuong){
                   temp= cr.tongLuong;
                   cr.tongLuong= nextNode.tongLuong;
                   nextNode.tongLuong=temp;
                   bl=true;
               }
               cr=cr.next;
           }
           nextNode=nextNode.next;
       }while (bl);
    }


}
