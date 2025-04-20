package fita.vnua.credit;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public  class Student extends Human{
	private String class_;
	private Map<String, Subject> subjectList = new HashMap<>();
	//private List<Subject> subjectList = new ArrayList<Subject>();
	
	
	public Student() {}
	
	public Student(String code) {
		this.code = code;
	}
	
	public Student(String code, String fullname) {
		super(code, fullname);
	}
	
	public Student (String code, String fullname, String class_) {
		super(code, fullname);
		this.class_ = class_;
	}
	
	public Student (String code, String fullname, String class_, String address) {
		this(code, fullname, class_);
		this.address = address;
	}
	
	
	public void addSubject(String key, Subject sub) {
 		subjectList.put(key, sub);
 	}
 	
 	public void deleteSubject(String key) {
 		subjectList.remove(key);
 	}
 	
 	public float calTermAverageMark() {
 		float ts = 0;
 		int ms = 0;
 		for (Subject sub : subjectList.values()) {
 			ts += sub.getCredit() * sub.calConversionMark();
 			ms += sub.getCredit();
 		}
 
 		return ts / ms;
 	}
	
 	@Override
 	public String toString() {
 		return code + "-" + fullname + "-" + class_;
 	
 	}
 
	@Override
	
	public boolean equals(Object obj) {
		Student anotherStd = (Student)obj;
		float d = Math.abs(this.calTermAverageMark() - anotherStd.calTermAverageMark());
		return d < 0.3;
	}
	 
 	@Override
 	public void enterInfo(Scanner sc) {
 		System.out.println("Nhap ma: ");
 		this.code = sc.nextLine();
 		System.out.println("Nhap ho ten: ");
 		this.fullname = sc.nextLine();
 		System.out.println("Nhap dia chi: ");
 		this.address = sc.nextLine();
 		System.out.println("Nhap lop: ");
 		this.class_ = sc.nextLine();
 	}
 	public String getClass_() {
		 return class_;
	 }
	 
	 public void setClass_(String class_) {
		 this.class_ = class_;
	 }
 	
 }
	 
