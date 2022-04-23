
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
QUẢN LÝ CÁC ĐỐI TƯỢNG TRONG CÁC VỤ ÁN CỦA CÔNG AN THÀNH PHỐ
 */

/**
 *
 * @author cuong
 */
public class DSVA {
    ArrayList<VUAN> dsva = new ArrayList<VUAN>();
    int n; //NEU DOC GHI FILE LOI THI DO n CHUA DUOC KHOI TAO GIA TRI

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public void nhapDSVA(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.printf("\nSo luong vu an muon nhap: ");
            n=sc.nextInt();
        }while(n<0);
        for(int i = 0; i < n; i++){
            VUAN v = new VUAN();
            v.nhapVA();
            dsva.add(v);
        }
    }
    public void xuatDSVA(){
        System.out.println("\n------DANH SACH VU AN-------");
        for(VUAN v:dsva){
            System.out.println("----------");
            v.xuatVA();
            System.out.println("");
        System.out.println("\n(*) Muc an phat tinh theo so nam tu giam (hoac cai tao khong giam giu): "
                + "\nMuc an phat < 99 nam, ap dung theo so nam tu giam tuong ung."
                + "\nMuc an phat: 99 nam tuong duong voi 'Tu Chung Than'"
                + "\nMuc an phat >= 100 nam tuong duong voi 'Tu Hinh'");
        }
    }
    public void timVAtheoTen(){
        String keyword;
        boolean status = true;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap ten vu an can tim: ");
        keyword=sc.nextLine();
        for(VUAN v:dsva){
            if(v.getTenVuAn().contains(keyword)==true){
                v.xuatVA();
            }else{
                status = false;
            }
        }
        if(status == false){
            System.out.println("\nKhong tim thay vu an nao!");
        }
    }
    public void demVAtheoNam(){
        int key, count=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap nam can dem so vu an: ");
        key=sc.nextInt();
        for(VUAN v:dsva){
            if(v.getNam()==key){
                count++;
            }
        }
        System.out.printf("So vu an xay ra vao nam %4d: ",key);
        System.out.print(count);
    }
    public void sxVAtheoNam(){
        Collections.sort(dsva, new Comparator<VUAN>(){
            @Override
            public int compare(VUAN t, VUAN t1) {
                if(t.getNam()<t1.getNam()){
                    return 1;
                }else if(t.getNam()==t1.getNam())
                    return 0;
                else return -1;
            }
        });
        System.out.println("\n------DANH SACH VU AN SAP XEP THEO NAM GIAM DAN-------");
        for(VUAN v:dsva){
            v.xuatVA();
        }
    }
    public void thongKeVAtheoNam(){
        int key, count=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("\n-----THONG KE CAC VU AN THEO NAM");
        System.out.print("\nNhap nam can thong ke vu an: ");
        key=sc.nextInt();
        for(VUAN v:dsva){
            if(v.getNam()==key){
                count++;
                v.xuatVA();
            }
        }
        System.out.printf("\nSo vu an xay ra vao nam %4d: ",key);
        System.out.print(count);
    }
    public void thongKeThietHai(){
        System.out.println("\n-----THONG KE CAC VU AN THEO MUC THIET HAI");
        float max=dsva.get(0).tongThietHai(), min=dsva.get(0).tongThietHai();
        String TenVAMax = dsva.get(0).getTenVuAn(), TenVAMin = dsva.get(0).getTenVuAn();
        for(int i = 0; i < n; i++){
            if(max<=dsva.get(i).tongThietHai()){
                max=dsva.get(i).tongThietHai();
                TenVAMax=dsva.get(i).getTenVuAn();
            }
        }
        System.out.printf("\nVu an '%s' co tong thiet hai lon nhat: %.0f",TenVAMax,max);
        for(int i = 0; i < n; i++){
            if(min>=dsva.get(i).tongThietHai()){
                min=dsva.get(i).tongThietHai();
                TenVAMin=dsva.get(i).getTenVuAn();
            }
        }
        System.out.printf("\nVu an '%s' co tong thiet hai nho nhat: %.0f",TenVAMin,min);
    }
    public void thongKeSLBCvaSLBH(){
        System.out.print("\n-----THONG KE TONG SL BI CAO VA SL BI HAI DA GHI NHAN");
        int tongSLBC = 0, tongSLBH = 0;
        for(int i = 0; i < n; i++){
            tongSLBC = tongSLBC + dsva.get(i).getSLBC();
            tongSLBH = tongSLBH + dsva.get(i).getSLBH();
        }
        System.out.printf("\nTong so ghi nhan:\nBi cao: %d doi tuong\nBi hai: %d doi tuong",tongSLBC,tongSLBH);
    }
    public void luuFile() throws FileNotFoundException, IOException{
        File f = new File("DSVuAn.dat");
        FileOutputStream fout = new FileOutputStream(f);
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(dsva);
        oout.close();
        fout.close();
//        System.out.println("\nLuu file thanh cong!");
    }
    public void docFile() throws FileNotFoundException, IOException, ClassNotFoundException{
        File f = new File("DSVuAn.dat");
        FileInputStream fin = new FileInputStream(f);
        ObjectInputStream oin = new ObjectInputStream(fin);
        dsva = (ArrayList) oin.readObject();
        n=dsva.size();
        fin.close();
        oin.close();
        //test
//        System.out.println("\nDoc file thanh cong!");
    }
    public void xoa(){
        String key;
        boolean status = true;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap ten vu an muon xoa: ");
        key=sc.nextLine();
        for(int i=0;i<dsva.size();i++){
            if(dsva.get(i).getTenVuAn().contains(key)==true){
                dsva.remove(i);
                System.out.print("\n-----Da xoa vu an thanh cong!");
            }else{
                status = false;
            }
        }
        if(status == false){
            System.out.println("\nXoa vu an that bai, khong tim thay ten vu an!");
        }
    }
    public void sua(){
        System.out.println("\nMuon sua thong tin vu an, Ban hay chon chuc nang '9. Xoa Vu An' va nhap lai vu an moi!"
                + "\n* Luu y: Chuc nang nay chi cho phep sua 'Ngay xet xu'");
        String key, ngayXXmoi = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap ten vu an muon sua: ");
        key=sc.nextLine();
        for(VUAN v:dsva){
            if(v.getTenVuAn().contains(key)==true){
                System.out.print("Nhap ngay xet xu moi (dd/mm/yyyy): ");
                ngayXXmoi=sc.nextLine();
                v.setNgayXetXu(ngayXXmoi);
            }
        }
    }
}
