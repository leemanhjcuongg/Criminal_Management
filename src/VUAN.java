
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/*
QUẢN LÝ CÁC ĐỐI TƯỢNG TRONG CÁC VỤ ÁN CỦA CÔNG AN THÀNH PHỐ
 */

/**
 *
 * @author cuong
 */
public class VUAN implements Serializable{
    private String tenVuAn, ngayKhoiKien, ngayXetXu, diaChi;
    private int nam, SLBC, SLBH;
    ArrayList<BICAO> dsbc = new ArrayList<BICAO>();
    ArrayList<BIHAI> dsbh = new ArrayList<BIHAI>();

    public VUAN() {
    }

    public String getTenVuAn() {
        return tenVuAn;
    }

    public void setTenVuAn(String tenVuAn) {
        this.tenVuAn = tenVuAn;
    }

    public String getNgayKhoiKien() {
        return ngayKhoiKien;
    }

    public void setNgayKhoiKien(String ngayKhoiKien) {
        this.ngayKhoiKien = ngayKhoiKien;
    }

    public String getNgayXetXu() {
        return ngayXetXu;
    }

    public void setNgayXetXu(String ngayXetXu) {
        this.ngayXetXu = ngayXetXu;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getSLBC() {
        return SLBC;
    }

    public void setSLBC(int SLBC) {
        this.SLBC = SLBC;
    }

    public int getSLBH() {
        return SLBH;
    }

    public void setSLBH(int SLBH) {
        this.SLBH = SLBH;
    }
    
    public void nhapVA(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap ten vu an: ");
        tenVuAn=sc.nextLine();
        System.out.print("Nhap ngay khoi kien (dd/mm/yyyy): ");
        ngayKhoiKien=sc.nextLine();
        System.out.print("Nhap ngay xet xu (dd/mm/yyyy): ");
        ngayXetXu=sc.nextLine();
        System.out.print("Nhap dia chi xay ra vu an: ");
        diaChi=sc.nextLine();
        System.out.print("Nhap nam xay ra vu an: ");
        nam=sc.nextInt(); 
        do{
            System.out.print("\nNhap so luong bi hai: ");
            SLBH=sc.nextInt();
        }while(SLBH<0);
        for(int i = 0; i < SLBH; i++){
            BIHAI bh = new BIHAI();
            bh.nhap();
            dsbh.add(bh);
        }
//        float tiLeThuongTatMax=0;
//        float anPhatPhu=0, tongThietHai=0;
//        for(int i = 0; i < SLBH; i++){
//            if(dsbh.get(i).getTiLeThuongTat()>tiLeThuongTatMax){
//                tiLeThuongTatMax=dsbh.get(i).getTiLeThuongTat();
//            }
//            tongThietHai=tongThietHai+dsbh.get(i).getMucThietHai();
//        }
//        for(int i = 0; i < SLBH; i++){
//            if(tongThietHai<50000000){
//                anPhatPhu=anPhatPhu+3;
//            }else if(tongThietHai<100000000){
//                anPhatPhu=anPhatPhu+5;
//            }else if(tongThietHai>=100000000){
//                anPhatPhu=anPhatPhu+7;
//            }
//        }
        do{
            System.out.print("\nNhap so luong bi cao: ");
            SLBC=sc.nextInt();
        }while(SLBC<0);
        
        for(int i = 0; i < SLBC; i++){
            BICAO bc = new BICAO();
            bc.nhap();
//            for(int j = 0; j < SLBH; j++){
//                if(tiLeThuongTatMax<11){
//                    bc.setMucAnPhat(1+anPhatPhu);
//                }else if(tiLeThuongTatMax>=11&&tiLeThuongTatMax<31){
//                    bc.setMucAnPhat(5+anPhatPhu);
//                }else if(tiLeThuongTatMax>=31&&tiLeThuongTatMax<61){
//                    bc.setMucAnPhat(7+anPhatPhu);
//                }else if(tiLeThuongTatMax>=61&&tiLeThuongTatMax<100){
//                    bc.setMucAnPhat(99+anPhatPhu);
//                }else if(tiLeThuongTatMax==100){
//                    bc.setMucAnPhat(100+anPhatPhu);
//                }else bc.setMucAnPhat(0);
//            }
            dsbc.add(bc);
        }
    }
    public void xuatVA(){
        System.out.print("\nTen Vu An: " + tenVuAn);
        System.out.print("\nNgay khoi kien: " + ngayKhoiKien);
        System.out.print("\tNgay xet xu: " + ngayXetXu);
        System.out.print("\nDia chi: " + diaChi);
        System.out.print("\tNam: " + nam);
        System.out.printf("\n\nDANH SACH %2d BI CAO",SLBC);
        System.out.printf("\n%25s","HO TEN");
        System.out.printf("%15s","GIOI TINH");
        System.out.printf("%15s","SO CCCD");
        System.out.printf("%15s","DIA CHI");
        System.out.printf("%25s","TOI DANH");
        System.out.printf("%15s","MUC AN(*)");
        for(BICAO bc:dsbc){
            bc.xuat();
        }
        System.out.printf("\n\nDANH SACH %2d BI HAI",SLBH);
        System.out.printf("\n%25s","HO TEN");
        System.out.printf("%15s","GIOI TINH");
        System.out.printf("%15s","SO CCCD");
        System.out.printf("%15s","DIA CHI");
        System.out.printf("%15s","TL THUONG TAT");
        System.out.printf("%15s","THIET HAI");
        System.out.printf("%15s","BOI THUONG");
        for(BIHAI bh:dsbh){
            bh.xuat();
        }
    }
    public float tongThietHai(){
        float tongThietHai=0;
        for(int i = 0; i < SLBH; i++){
            tongThietHai=tongThietHai+dsbh.get(i).getMucThietHai();
        }
        return tongThietHai;
    }
}
