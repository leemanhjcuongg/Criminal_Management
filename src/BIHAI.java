
import java.io.Serializable;
import java.util.Scanner;

/*
QUẢN LÝ CÁC ĐỐI TƯỢNG TRONG CÁC VỤ ÁN CỦA CÔNG AN THÀNH PHỐ
 */

/**
 *
 * @author cuong
 */
public class BIHAI extends DOITUONG implements Serializable{
    private float tiLeThuongTat, mucThietHai, boiThuong;

    public BIHAI() {
        super();
    }

    public float getTiLeThuongTat() {
        return tiLeThuongTat;
    }

    public void setTiLeThuongTat(float tiLeThuongTat) {
        this.tiLeThuongTat = tiLeThuongTat;
    }

    public float getMucThietHai() {
        return mucThietHai;
    }

    public void setMucThietHai(float mucThietHai) {
        this.mucThietHai = mucThietHai;
    }

    public float getBoiThuong() {
        return boiThuong;
    }

    public void setBoiThuong(float boiThuong) {
        this.boiThuong = boiThuong;
    }
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Nhap ti le thuong tat (0 -> 100%): ");
            tiLeThuongTat=sc.nextFloat();
        }while(tiLeThuongTat<0||tiLeThuongTat>100);
        do{
            System.out.print("Nhap muc thiet hai: ");
            mucThietHai=sc.nextFloat();
        }while(mucThietHai<0);
//        do{
//            System.out.print("Nhap muc boi thuong: ");
//            boiThuong=sc.nextFloat();
//        }while(boiThuong<0);
        System.out.println("\n* Chu y: Bi hai duoc boi thuong 1.5 lan so voi muc thiet hai");
        boiThuong=(float) (mucThietHai*1.5);
    }
    public void xuat(){
        super.xuat();
        System.out.printf("%15.2f",tiLeThuongTat);
        System.out.printf("%15.0f",mucThietHai);
        System.out.printf("%15.0f",boiThuong);
    }
}
