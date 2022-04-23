
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*
QUẢN LÝ CÁC ĐỐI TƯỢNG TRONG CÁC VỤ ÁN CỦA CÔNG AN THÀNH PHỐ
 */

/**
 *
 * @author cuong
 */
public class Main {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        DSVA d = new DSVA();
        
        d.docFile();
        
        int chon,n;
        Scanner sc = new Scanner(System.in); 
        do{
            System.out.println("\n\n---PHAN MEM QUAN LY DOI TUONG TRONG CAC VU AN CUA CATP---");
            System.out.println("1. Nhap Danh sach Vu An va Luu File");
            System.out.println("2. Doc File va Hien Danh sach cac Vu An");
            System.out.println("3. Tim Vu An theo Ten Vu An");
            System.out.println("4. Dem so Vu An theo Nam");
            System.out.println("5. Sap xep Vu An theo Nam Giam dan");
            System.out.println("6. Thong ke cac Vu An theo Nam");
            System.out.println("7. Thong ke tong muc Thiet hai cua Vu an");
            System.out.println("8. Thong ke So luong Bi cao va Bi hai da ghi nhan");
            System.out.println("9. Xoa Vu An");
            System.out.println("10.Sua Vu An");
            System.out.println("0.Thoat");
            System.out.print("\nMoi ban chon: ");
            chon=sc.nextInt();
            switch(chon){
                case 1:
//                    d.docFile();
                    d.nhapDSVA();
                    d.luuFile();
                    break;
                case 2:
//                    d.docFile();
                    d.xuatDSVA();
                    break;
                case 3:
                    d.timVAtheoTen();
                    break;
                case 4:
                    d.demVAtheoNam();
                    break;
                case 5:
                    d.sxVAtheoNam();
                    break;
                case 6:
                    d.thongKeVAtheoNam();
                    break;
                case 7:
                    d.thongKeThietHai();
                    break;
                case 8:
                    d.thongKeSLBCvaSLBH();
                    break;
                case 9:
                    d.xoa();
//                    d.xuatDSVA();
                    d.luuFile();
                    break;
                case 10:
                    d.sua();
                    d.luuFile();
                    break;
                case 0: System.exit(0);
                default: System.out.println("Nhap sai!");
            }
        }while(chon!=0);
    }
}
