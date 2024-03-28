package baiTapLon;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class canBo {
     int maCanBo;
     String tenCanBo;
     String phongBan;
     double tongLuong;
     //class để chuyển tiền cho đẹp thôi chứ đ qtrong đâu .
    Locale locate= new Locale("vn","VN");
    NumberFormat nf= NumberFormat.getCurrencyInstance(locate);

    public canBo(int maCanBo, String tenCanBo, String phongBan, double tongLuong) {
        this.maCanBo = maCanBo;
        this.tenCanBo = tenCanBo;
        this.phongBan = phongBan;
        this.tongLuong = tongLuong;
    }

    public canBo() {
    }

    public int getMaCanBo() {
        return maCanBo;
    }

    public void setMaCanBo(int maCanBo) {
        this.maCanBo = maCanBo;
    }

    public String getTenCanBo() {
        return tenCanBo;
    }

    public void setTenCanBo(String tenCanBo) {
        this.tenCanBo = tenCanBo;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public double getTongLuong() {
        return tongLuong;
    }

    public void setTongLuong(double tongLuong) {
        this.tongLuong = tongLuong;
    }
    public void output(){
        System.out.println(maCanBo);
        System.out.println(tenCanBo);
        System.out.println(phongBan);
        System.out.println(nf.format(tongLuong));
    }

}
