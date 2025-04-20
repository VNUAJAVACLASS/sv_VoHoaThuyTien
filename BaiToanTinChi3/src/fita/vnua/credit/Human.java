package fita.vnua.credit;

import java.util.Scanner;

public abstract class Human {
	protected String address;
	protected String code;
	protected String fullname;
		
	public Human() {}
	
	public Human(String code) {
		this.code = code;
	}
	
	public Human(String code, String fullname) {
		this.code = code;
		this.fullname = fullname;
	}
	public Human(String code, String fullname, String address) {
		this(code, fullname);
		this.address = address;
	}
	
	public void enterInfo(Scanner sc) {
 		System.out.println("Nhap Ma: ");
 		code = sc.nextLine();
 		System.out.println("Nhap ho va ten: ");
 		fullname = sc.nextLine();
 		System.out.println("Nhap dia chi: ");
 		address = sc.nextLine();
 	}
 	
 	@Override
 	public String toString() {
 		return code + "-" + fullname + "-" + address;
 	}
	
	@Override
	public boolean equals(Object obj) {
		Human anotherHuman = (Human)obj;
		return this.code.equals(anotherHuman.code);
	}

}
