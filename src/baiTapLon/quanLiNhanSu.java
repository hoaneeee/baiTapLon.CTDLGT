package baiTapLon;

import java.util.*;

public class quanLiNhanSu {
    private LinkedList<canBo> listCanBo;//khai báo danh sách chứa các đối tượng được tạo ra từ canBo

    public quanLiNhanSu() {
        this.listCanBo = new LinkedList<>();
    }//constructor của nó để khởi tạo đối tượng

    public void themCanBo(canBo canBo) {// method để thêm cán bộ vào danh sách
        listCanBo.add(canBo);
    }

    public void taoDanhSachCanBo(){//method để tạo danh sách cán bộ
        Scanner sc=new Scanner(System.in);
        System.out.println("-------tạo danh sách cán bộ-------- ");
        int maCanBo;
        String tenCanBo;
        String phongBan;
        double tongLuong;
        do {//dùng vòng do while để nhập vào cán bộ , lặp vô hạn .
            System.out.println("nhập mã cán bộ ");
            maCanBo=sc.nextInt();
            if(maCanBo<=0){//nếu mã cán bộ <=0 thì break khỏi chương trình , trở lại menu
                break;
            }else {
                sc.nextLine();
                System.out.println("họ tên cán bộ :  ");
                tenCanBo=sc.nextLine();
                System.out.println("phòng ban : ");
                phongBan=sc.nextLine();
                System.out.println("tổng lương ");
                tongLuong=sc.nextDouble();
                //gọi đến phương thức cán bộ là viết tắt của
                // canBo newCanBo = new canBo(maCanBo, tenCanBo, phongBan, tongLuong);
                //themCanBo(newCanBo);
                themCanBo(new canBo(maCanBo,tenCanBo,phongBan,tongLuong));
            }
        }while (true);


    }
    public void themCanBo() {//method thêm cán bộ vào vị trí do người dùng chọn .
        Scanner scanner= new Scanner(System.in);
        System.out.println("===== Thêm cán bộ vào danh sách =====");
        System.out.println("Nhập mã cán bộ: ");
        int maCanBo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập họ đệm và tên: ");
        String tenCanBo = scanner.nextLine();
        System.out.println("Nhập phòng ban: ");
        String phongBan = scanner.nextLine();
        System.out.println("Nhập tổng lương: ");
        double tongLuong = scanner.nextDouble();

        System.out.print("Nhập vị trí muốn thêm cán bộ (0 - " + listCanBo.size() + "): ");
        int viTri = scanner.nextInt();
        scanner.nextLine();
        if(viTri<0|| viTri>listCanBo.size()){//nếu vị trí <0 và lớn hơn kích thước của danh sách return về....
            System.out.println("vị trí không hợp lệ ! ");
        }
        //thêm cán bộ và vị trí chọn
        // canBo newCanBo = new canBo(maCanBo, tenCanBo, phongBan, tongLuong);
        //listCanBo.add(viTri, newCanBo);
        listCanBo.add(viTri,new canBo(maCanBo,tenCanBo,phongBan,tongLuong));
        System.out.println("Cán bộ đã được thêm vào vị trí " + viTri + " trong danh sách.");

    }
    public void lietKeDanhSach(){
        //in danh sách ra màn hình . dùng foreach để duyệt qua các phần tử
        //gọi đến method output
        for (canBo cb:listCanBo) {
            cb.output();
            System.out.println();
        }
    }
    public void thongKeCanBo(){

        Scanner sc= new Scanner(System.in);
        System.out.println("------danh sách cán bộ theo phòng ban ------");
        //nếu danh sách trống thì return....
        if(listCanBo.isEmpty()){
            System.out.println("danh sách trống");
        }
        System.out.println("phòng ban : ");
        String phongBan= sc.nextLine();
        int count=0;
        for (canBo cb:listCanBo) {
            //sử dụng method equalsIgnoreCase để so sánh phòng ban nhập vào và phòng ban trong danh sách
            //nếu bằng nhau thì count tăng
            if(cb.phongBan.equalsIgnoreCase(phongBan)){
                count++;
            }
            cb.output();//in ra những cán bộ phòng ban đó
        }
        System.out.println("Số lượng cán bộ trong phòng " + phongBan + " là: " + count);

    }
    public void luongLonHon1Jack(){
        System.out.println("-------danh sách cán bộ lương lớn hơn 1 jack--------");
        if(listCanBo.isEmpty()){
            System.out.println("danh sách rỗng ");
        }
        int jack=5000000;
        for (canBo cb:listCanBo) {
            if (cb.getTongLuong()>jack){
                cb.output();
            }
        }
    }
    public void searchMCB(){
        Scanner sc= new Scanner(System.in);
        System.out.println("----------tìm kiếm cán bộ qua mã cán bộ------------");
        if(listCanBo.isEmpty()){
            System.out.println("danh sách cán bộ trống ");
        }
        System.out.println("mã số cán bộ cần tìm: ");
        int maCanBo=sc.nextInt();
        boolean search= false;
        //iterator là 1 interface , dùng để duyệt qua các collections
        //tạo 1 đối tượng iterator để duyệt qua listcanbo
        Iterator<canBo> iterator= listCanBo.iterator();
        int vitri=0;
        while (iterator.hasNext()){//duyệt đến khi hasNext==false tức là hết các element trong list
            canBo cb= iterator.next();//di chuyển đến phần tử tiếp theo r gán cho cb
            vitri++;//tăng vị trí lên 1 sau khi lấy phần tử tiếp theo của iterator
            if (cb.maCanBo==maCanBo){//nếu macanbo nhap vao = voi ma can bo trong danh sach thi in ra
                System.out.println("Vị trí của cán bộ có mã số " + maCanBo + " là: " + vitri);
                search=true;//chuyển search về true khi tìm thấy và break ra ngoài
                break;

            }
        }
        if (!search){
            System.out.println("Không tìm thấy cán bộ có mã số " + maCanBo);
        }
    }
    public void searchTCB(){
        System.out.println("-----------tìm kiếm cán bộ theo tên------------");
        Scanner sc= new Scanner(System.in);
        if(listCanBo.isEmpty()){
            System.out.println("danh sách cán bộ trống ");
        }
        System.out.println("tên cán bộ cần tìm : ");
        String tenCanBo= sc.nextLine();
        boolean search= false;
        Iterator<canBo> iterator= listCanBo.iterator();
        while (iterator.hasNext()){
            canBo cb= iterator.next();
            if (cb.tenCanBo.equalsIgnoreCase(tenCanBo)){
                cb.output();
                search=true;
                break;
            }
        }
        if(!search){
            System.out.println("không tìm thấy cán bộ có tên : "+tenCanBo);
        }
    }

    //sử dụng collections để sắp xếp . có thể dùng comparable hoặc comparator . cái này tự tìm hiểu
    public void sortLuongGiamDan(){
        Collections.sort(listCanBo,new sortLuongGiamDan());
        System.out.println("danh sách sắp xếp lương cán bộ giảm dần là : ");
        for (canBo cb:listCanBo) {
            cb.output();
            System.out.println();
        }
    }
}
class  sortLuongGiamDan implements Comparator<canBo>{

    @Override
    public int compare(canBo cb1, canBo cb2) {
        return Double.compare(cb2.tongLuong,cb1.tongLuong);
    }
}