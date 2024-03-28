package baiTapLon2;

import java.text.NumberFormat;
import java.util.Locale;

public class canBo {
    int maCanBo;
    String hoDem;
    String tenCanBo;
    String phongBan;
    double tongLuong;

    canBo next;


    Locale locate= new Locale("vn","VN");
    NumberFormat nf= NumberFormat.getCurrencyInstance(locate);

    public canBo(int maCanBo,String hoDem, String tenCanBo, String phongBan, double tongLuong) {
        this.maCanBo = maCanBo;
        this.tenCanBo = tenCanBo;
        this.phongBan = phongBan;
        this.tongLuong = tongLuong;
        this.hoDem=hoDem;
        this.next =null;
    }

    public void output(){
        System.out.println(maCanBo);
        System.out.println(tenCanBo);
        System.out.println(phongBan);
        System.out.println(nf.format(tongLuong));
    }
}
