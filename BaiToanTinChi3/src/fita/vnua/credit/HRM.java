package fita.vnua.credit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HRM  {
	private List<Human> hrList;
	
	public HRM () {
		hrList = new ArrayList<Human>();
	}
	
	public void addHR(Human hm) {
		hrList.add(hm);
	}
	
	public void addHR(Scanner sc) {
		int loai ;
		System.out.println("Chon loai nhan su (sv: 0, gv:1): ");
		loai = sc.nextInt(); sc.nextLine();
		
		Human human = null;
		if(loai == 0) {
			human = new Student();
		}else if(loai == 1) {
			human = new Lecturer();
		}
		
		human.enterInfo(sc);
		
		addHR(human);
	}
	
	public void printHRList() {
		for(Human human :hrList) {
			System.out.println(human.toString());
		}
	}
	
	public void printStudentList() {
		for(Human human: hrList) {
			if(human instanceof Student) {
				Student std = (Student)human;
				System.out.println(std.getClass_());
			}
		}
	}
	
	public void initDemoData() {
		Human h1 = new Student("687823","Vo Hoang Thien Nhi","K68CNTTA");
		Human h2 = new Lecturer("687778", "Vo Hoang Thien Binh","Ha Noi");
		
		addHR(h1);
		addHR(h2);
	}
	
	public void initDemoData(Scanner sc) {
		String chon;
		do {
			addHR(sc);
			
			System.out.println("Ban muon nhap tiep (c/k): ");
			chon = sc.nextLine();
		}while("c".equalsIgnoreCase(chon));
	}
	
	public  List<Human> searchHuman(String code){
		List<Human> humanList = new ArrayList<Human>();
		for(Human human: hrList) {
			if(human.code.contains(code)) {
				humanList.add(human);
			}
		}
		
		return humanList;
	}
	
	public static void main(String[] args) {
		HRM hrm = new HRM ();
		hrm.initDemoData();
		Scanner sc = new Scanner(System.in);
		hrm.initDemoData(sc);
		hrm.printHRList();
		hrm.searchHuman("68");
	}
}
