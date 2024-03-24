package baiTapLon;

import java.util.*;

public class quanLiNhanSu {
    private LinkedList<canBo> listCanBo;

    public quanLiNhanSu() {
        this.listCanBo = new LinkedList<>();
    }

    public void taoDanhSachCanBo(){
        Scanner sc=new Scanner(System.in);
        System.out.println("-------tạo danh sách cán bộ-------- ");
        int maCanBo;
        String tenCanBo;
        String phongBan;
        double tongLuong;
        do {
            System.out.println("nhập mã cán bộ ");
            maCanBo=sc.nextInt();
            if(maCanBo<=0){
                break;
            }else {
                sc.nextLine();
                System.out.println("họ tên cán bộ :  ");
                tenCanBo=sc.nextLine();
                System.out.println("phòng ban : ");
                phongBan=sc.nextLine();
                System.out.println("tổng lương ");
                tongLuong=sc.nextDouble();
                themCanBo(new canBo(maCanBo,tenCanBo,phongBan,tongLuong));
            }
        }while (true);


    }

    public void themCanBo() {
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
        if(viTri<0|| viTri>listCanBo.size()){
            System.out.println("vị trí không hợp lệ ! ");
        }
        listCanBo.add(viTri,new canBo(maCanBo,tenCanBo,phongBan,tongLuong));
        System.out.println("Cán bộ đã được thêm vào vị trí " + viTri + " trong danh sách.");

    }
    public void themCanBo(canBo canBo) {
        listCanBo.add(canBo);
    }
    public void lietKeDanhSach(){
        for (canBo cb:listCanBo) {
            cb.output();
            System.out.println();
        }
    }
    public void thongKeCanBo(){

        Scanner sc= new Scanner(System.in);
        System.out.println("------danh sách cán bộ theo phòng ban ------");
        if(listCanBo.isEmpty()){
            System.out.println("danh sách trống");
        }
        System.out.println("phòng ban : ");
        String phongBan= sc.nextLine();
        int count=0;
        for (canBo cb:listCanBo) {
            if(cb.phongBan.equalsIgnoreCase(phongBan)){
                count++;
            }
        }
        System.out.println("Số lượng cán bộ trong phòng " + phongBan + " là: " + count);
        for (canBo cb:listCanBo) {
            cb.output();
            System.out.println();
        }
    }
    public void luongLonHon1Jack(){
        System.out.println("-------danh sách cán bộ lương lớn hơn 1 jack--------");
        if(listCanBo.isEmpty()){
            System.out.println("danh sách rỗng ");
        }
        int jack=5000000;
        for (canBo cb:listCanBo) {
            if (cb.getTongLuong()>jack){
                System.out.println("Mã số: " + cb.maCanBo + ", Tên: " + cb.tenCanBo+ ", Phòng ban: " + cb.phongBan + ", Tổng lương: " + cb.tongLuong);
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
        boolean seach= false;
        Iterator<canBo> iterator= listCanBo.iterator();
        int vitri=0;
        while (iterator.hasNext()){
            canBo cb= iterator.next();
            vitri++;
            if (cb.maCanBo==maCanBo){
                System.out.println("Vị trí của cán bộ có mã số " + maCanBo + " là: " + vitri);
                seach=true;
                break;

            }
        }
        if (!seach){
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
    public void sortLuongGiamDan(){
        Collections.sort(listCanBo,new sortLuongGiamDan());
        System.out.println("danh sách sắp xếp lương cán bộ giảm dần là : ");
        for (canBo cb:listCanBo) {
            cb.output();
            System.out.println();
        }
    }
}
class sortLuongGiamDan implements Comparator<canBo>{

    @Override
    public int compare(canBo cb1, canBo cb2) {
        return Double.compare(cb2.tongLuong,cb1.tongLuong);
    }
}