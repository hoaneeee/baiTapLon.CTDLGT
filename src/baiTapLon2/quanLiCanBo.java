package baiTapLon2;

import java.util.Scanner;

public class quanLiCanBo {
    private canBo first;//đại diện cho giá trị đầu tiên trong danh sách

    public quanLiCanBo() {
        this.first = null;
    }//khởi tạo giá trị == null
    //=======================1. Tạo danh sách cán bộ: Quá trình nhập danh sách sẽ dừng lại khi nhập mã số <=0==================
    public void taoDanhSach() {
        System.out.println("---------tạo danh sách cán bộ----------");
        Scanner sc = new Scanner(System.in);

        int maCanBo;
        String hoDem;
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
            System.out.println("họ đệm cán bộ : ");
            hoDem=sc.nextLine();
            System.out.println("tên cán bộ : ");
            tenCanBo = sc.nextLine();
            System.out.println("phòng ban : ");
            phongBan=sc.nextLine();
            System.out.println("tổng lương : ");
            tongLuong = sc.nextDouble();
            canBo cb = new canBo(maCanBo,hoDem, tenCanBo, phongBan, tongLuong);//tạo đối tượng canBo
            if (first == null) {//nếu giá trị đầu =null thì first sẽ = cb được tạo ra
                first = cb;
            } else {
                canBo cr = first;//gán biến cho first đế khi duyệt không làm thay đổi giá trị ban đầu
                while (cr.next != null) {//duyệt đến khi nào con trỏ trỏ đến giá trị null
                    cr = cr.next;//trỏ đến vị trí tiếp theo
                }
                cr.next = cb;//gán vị trí đó cho đối tượng được tạo ra
            }

        }while (true);
    }
    //===================2. Thêm 1 cán bộ vào danh sách, vị trí thêm vào do ta chọn.=====================
    public void addCanBo(){
        Scanner sc= new Scanner(System.in);
        int maCanBo;
        String hoDem,tenCanBo, phongBan;
        double tongLuong;
        System.out.println("===== Thêm cán bộ vào danh sách =====");
        System.out.print("Nhập mã cán bộ: ");
        maCanBo = sc.nextInt();
        sc.nextLine();
        System.out.println("nhập họ đệm cán bộ :");
        hoDem=sc.nextLine();
        System.out.println("Nhập họ đệm và tên: ");
        tenCanBo= sc.nextLine();
        System.out.println("Nhập phòng ban: ");
        phongBan = sc.nextLine();
        System.out.println("Nhập tổng lương: ");
        tongLuong = sc.nextDouble();
        System.out.print("Nhập vị trí muốn thêm cán bộ : ");
        int viTri = sc.nextInt();
        canBo cb= new canBo(maCanBo,hoDem,tenCanBo,phongBan,tongLuong);

        if (viTri == 1) {//cho vị trí danh sách ban đầu =1
            cb.next = first;//nếu trỏ trỏ tới first thì cán bộ được thêm sẽ ở vị trí 1 đẩy cán bộ có sẵn xuống 2
            first= cb;
        } else if (viTri==0) {
            System.out.println("danh sách bắt đầu từ 1 , vui lòng nhập lại ");
        } else {
            canBo cr=first;
            for (int i = 1; i < viTri - 1 && cr != null; i++) {
                //vị trí được thêm không lớn hơn độ dài danh sách , thí dụ
                // danh sách có 3 cbo chạy từ 1 , chúng ta muốn thêm vào vị trí thứ 4 thì cần -1 để có thể
                //gán vào vị trí thứ 3 đó ->1 2 3 4 ->null
                //cr != null và trỏ đến null thì dừng
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
        boolean Boolean= false;
        canBo cr=first;
        while (cr!=null){
            viTri++;
            if(cr.maCanBo==maCanBo){
                System.out.println("vi tri ma can bo da nhap la : "+ viTri);
                Boolean=true;
            }
            cr=cr.next;
        }
        if (!Boolean){
            System.out.println("không tìm thấy cán bộ có mã "+maCanBo);
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
            }else {
                System.out.println("không tìm thấy tên cán bộ trong danh sách . Vui Lòng nhập lại");
            }
            cr=cr.next;
        }
    }
    //so sánh này t dùng bubble sort mn có thể tìm hiểu qua
    public void sortLuongGiamDan() {
        if (first == null) {
            return;
        }
        canBo cr;
        canBo nextNode;
        double temp;
        boolean bl;
        do {
            bl = false;
            cr = first;//gán giá trị để không làm thay đổi giá trị ban đầu first
            nextNode = cr.next;// gán nextNode = trỏ tới vị trí tiếp theo để so sánh lương

            while (nextNode != null) {
                if (nextNode.tongLuong > cr.tongLuong) {//nếu lương của vị trí con trỏ tiếp theo lớn hơn vị trí trước
                    // đoạn này chắc ae biết r
                    temp = cr.tongLuong;
                    cr.tongLuong = nextNode.tongLuong;
                    nextNode.tongLuong = temp;
                    bl = true;//dùng boolean ở đây để khi so sánh chúng ta không cần lặp lại nhiều lần
                    //nếu đã được so sánh thì bl trả về true và bỏ qua nó
                }
                nextNode = nextNode.next;//tăng biến con trỏ trỏ tới vị trí tiếp theo
                cr = cr.next;//tăng biến con trỏ trỏ tới vị trí tiếp theo
            }
        } while (bl);//duyệt đến khi nào bl= false tức là không còn cụm so sánh nào
        /*canBo cr= first;
        canBo nextNode;
        double temp;
        if(cr==null){
            System.out.println("danh sách trống ");
        }
       while (cr!=null){
           nextNode=cr.next;
           while (nextNode!=null){
               if (cr.tongLuong< nextNode.tongLuong){
                   temp=cr.tongLuong;
                   cr.tongLuong= nextNode.tongLuong;
                   nextNode.tongLuong=temp;
               }
               nextNode=nextNode.next;
           }
           cr=cr.next;
       }
    }*/
    }
}
