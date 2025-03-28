package fita.vnua.credit;

import java.util.ArrayList;
import java.util.List;

public class Student extends Human{
	private String class_;
	private List<Subject> subjectList = new ArrayList<Subject>();
	
	public Student() {}
	
	public Student(String code) {
		super(code);
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
	
	public void addSubject(Subject sub) {
		subjectList.add(sub);
	}
	
	public float calTermAverageMark() {
		float ts = 0;
		int ms = 0;
		for(Subject sub: subjectList) {
			ts += sub.getCredit() * sub.calConversionMark();
			ms += sub.getCredit();
		}
		
		return ts/ms;
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
	 public String getClass_() {
		 return class_;
	 }
	 
	 public void setClass_(String class_) {
		 this.class_ = class_;
	 }
	 
	 public static void main(String[] args) {
		Student std = new Student("687823","Vo Hoang Thien Minh", "K68CNTTA");
		
		Subject sub1 = new Subject ("TH03111","Lap trinh Java",3);
		sub1.setAttendanceMark(9.5f);
		sub1.setMidExamMark(8.5f);
		sub1.setFinalExamMark(9);
		
		Subject sub2 = new Subject("TH04222","Ki Thuat Lap Trinh",2);
		sub2.setAttendanceMark(8);
		sub2.setMidExamMark(7);
		sub2.setFinalExamMark(6);
		
		std.addSubject(sub1);
		std.addSubject(sub2);
		
		System.out.println("TBHK:" + std.calTermAverageMark());
	}
}
