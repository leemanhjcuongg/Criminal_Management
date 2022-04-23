
import java.io.Serializable;
import java.util.Scanner;

/*
QUẢN LÝ CÁC ĐỐI TƯỢNG TRONG CÁC VỤ ÁN CỦA CÔNG AN THÀNH PHỐ
 */

/**
 *
 * @author cuong
 */
public class DOITUONG implements Serializable{
    private String hoTen, gioiTinh, soCCCD, diaChi;

    public DOITUONG() {
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoCCCD() {
        return soCCCD;
    }

    public void setSoCCCD(String soCCCD) {
        this.soCCCD = soCCCD;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap ho va ten doi tuong: ");
        hoTen=sc.nextLine();
        do{
            System.out.print("Nhap gioi tinh:\tnam \tnu: ");
            gioiTinh=sc.nextLine();
        }while(gioiTinh.equals("nam")!=true&&gioiTinh.equals("nu")!=true
            &&gioiTinh.equals("Nam")!=true&&gioiTinh.equals("Nu")!=true);
        do{
            System.out.print("Nhap so the CCCD (12 so): ");
            soCCCD=sc.nextLine();
        }while(soCCCD.length()!=12||soCCCD.startsWith("00")!=true);

        System.out.print("Nhap dia chi: ");
        diaChi=sc.nextLine();
    }
    public void xuat(){
        System.out.printf("\n%25s",hoTen);
        System.out.printf("%15s",gioiTinh);
        System.out.printf("%15s",soCCCD);
        System.out.printf("%15s",diaChi);
    }
}
