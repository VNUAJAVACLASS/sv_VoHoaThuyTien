package baitoantinchi;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		UserDao userDao=new UserDao();
		SubjectDao subjectDao= new SubjectDao();
		UserSubjectDao userSubjectDao = new UserSubjectDao();
		UserSubjectView userSubjectView = new UserSubjectView();
		
		while(true) {
			System.out.println("\n---Danh sach chon---");
			System.out.println("1.Them user");
			System.out.println("2.Them subject");
			System.out.println("3.Gan mon hoc vua roi cho user(va nhap 3 diem)");
			System.out.println("4.Xem user hoc mon gi va diem");
			System.out.println("Chon: ");
			
			int choice = Integer.parseInt(sc.nextLine());
			
			switch(choice) {
			case 1:
				System.out.println("Nhap ma nguoi dung: ");
				int maND=sc.nextInt();
				System.out.println("Nhap ho ten: ");
				String hoTen=sc.nextLine();
				System.out.println("Nhap lop: ");
				String lop=sc.nextLine();
				System.out.println("Nhap dia chi: ");
				String diachi=sc.nextLine();
				System.out.println("Nhap mat khau: ");
				String matkhau = sc.nextLine();
				System.out.println("Nhap loai:");
				String loai=sc.nextLine();
				User user= new User(maND,hoTen,lop, diachi,matkhau, loai);
				userDao.addUser(user);
				break;
			
			case 2:
				System.out.println("Nhap ma mon hoc: ");
				int maMH=sc.nextInt();sc.nextLine();
				System.out.println("Nhap ten mon hoc: ");
				String tenMH=sc.nextLine();
				System.out.println("Nhap so tin chi: ");
				int soTC = sc.nextInt();
				System.out.println("Nhap diem giua ki:");
				float diemGK=sc.nextFloat();
				System.out.println("Nhap he so 1:");
				float heSo1=sc.nextFloat();
				System.out.println("Nhap he so 2:");
				float heSo2=sc.nextFloat();
				System.out.println("Nhap he so 3:");
				float heSo3=sc.nextFloat();
				System.out.println("Nhap diem cuoi ki:");
				float diemCK=sc.nextFloat();sc.nextLine();
				
				Subject subject = new Subject(maMH,tenMH,soTC,diemGK, heSo1, heSo2, heSo3, diemCK);
				subjectDao.addSubject(subject);
				break;
				
			case 3:
				System.out.println("Nhap ma nguoi dung_mon hoc: ");
				int maND_MH=sc.nextInt();
				System.out.println("Nhap ma nguoi dung: ");
				int maND1=sc.nextInt();
				System.out.println("Nhap ma mon hoc: ");
				int maMH1 = sc.nextInt();
				System.out.println("Nhap diem giua ki:");
				float diemGK1=sc.nextFloat();
				System.out.println("Nhap diem 1:");
				float diem1=sc.nextFloat();
				System.out.println("Nhap diem 2:");
				float diem2=sc.nextFloat();
				System.out.println("Nhap diem 3:");
				float diem3=sc.nextFloat();
				System.out.println("Nhap diem cuoi ki:");
				float diemCK1=sc.nextFloat();sc.nextLine();
				
				UserSubject userSubject = new UserSubject(maND_MH,maND1, maMH1,diemGK1, diem1, diem2, diem3, diemCK1);
				userSubjectDao.addUserSubject(userSubject);
				break;
				
			case 4:
				userSubjectView.showUserSubject();
				break;
			}
		}
	}
}
