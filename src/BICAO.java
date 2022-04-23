
import java.io.Serializable;
import java.util.Scanner;

/*
QUẢN LÝ CÁC ĐỐI TƯỢNG TRONG CÁC VỤ ÁN CỦA CÔNG AN THÀNH PHỐ
 */

/**
 *
 * @author cuong
 */
public class BICAO extends DOITUONG implements Serializable{
    private String toiDanh;
    private float mucAnPhat;

    public BICAO() {
        super();
    }    

    public String getToiDanh() {
        return toiDanh;
    }

    public void setToiDanh(String toiDanh) {
        this.toiDanh = toiDanh;
    }

    public float getMucAnPhat() {
        return mucAnPhat;
    }

    public void setMucAnPhat(float mucAnPhat) {
        this.mucAnPhat = mucAnPhat;
    }
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap toi danh: ");
        toiDanh=sc.nextLine();
//        System.out.print("\nMuc an phat (so Nam tu giam) xet theo Ti Le Thuong Tat TOI DA (TLTTTD) + TONG Muc Thiet Hai (TMTH) cua cac bi hai nhu sau:");
//        System.out.print("\nTLTTTD duoi 11%: 1 (Nam tu giam hoac cai tao khong giam giu)");
//        System.out.print("\nTLTTTD tu 11 den 30%: 5 (Nam tu giam)");
//        System.out.print("\nTLTTTD tu 31 den 60%: 7 (Nam tu giam)");
//        System.out.print("\nTLTTTD tu 61 den 99%: 99 (Nam tu giam: Tu Chung Than )");
//        System.out.print("\nTLTTTD = 100% (thiet mang): 100 (Nam: Tu Hinh)");
//        System.out.print("\nTMTH duoi 50.000.000VND: 3 (Nam tu giam hoac cai tao khong giam giu)");
//        System.out.print("\nTMTH tu 50.000.000VND den 100.000.000VND: 5 (Nam tu giam hoac cai tao khong giam giu)");
//        System.out.print("\nTMTH tren 100.000.000VND: 7 (Nam tu giam)\n");
        do{
            System.out.print("Nhap muc an phat (so Nam tu giam): ");
            mucAnPhat=sc.nextFloat();
        }while(mucAnPhat<0);
    }
    public void xuat(){
        super.xuat();
        System.out.printf("%25s",toiDanh);
        System.out.printf("%15.2f",mucAnPhat);
    } 
}
