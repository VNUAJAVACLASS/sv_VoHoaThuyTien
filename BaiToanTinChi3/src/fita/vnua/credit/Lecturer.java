package fita.vnua.credit;

import java.util.Scanner;

public class Lecturer extends Human {
	private String password;
	
	public String getpassword() {
 		return password;
 	}
	
	public void setpassword(String password) {
 		this.password = password;
 	}
	
	public Lecturer() {
		
	}
	
	public Lecturer(String code, String password) {
		this.code = code;
		this.password = password;
	}
	
	public Lecturer(String code, String fullname, String address) {
		this(code, fullname);
		this.address = address;
	}

	@Override
 	public void enterInfo(Scanner sc) {
 		System.out.println("Nhap ma: ");
 		code=sc.nextLine();
 		System.out.println("Nhap vao ho ten: ");
 		fullname=sc.nextLine();
 		System.out.println("Nhap vao dia chi: ");
 		address=sc.nextLine();
 		System.out.println("Nhap mat khau: ");
 		password=sc.nextLine();
 	}
}

