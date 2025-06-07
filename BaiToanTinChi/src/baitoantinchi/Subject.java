package baitoantinchi;

public class Subject {
	private int maMH;
	private String tenMH;
	private int soTC;
	private float diemGK;
	private float heSo1;
	private float heSo2;
	private float heSo3;
	private float diemCK;
	
	public Subject(String tenMH, int soTC, float diemGK,float heSo1, float heSo2, float heSo3, float diemCK) {
		this.tenMH = tenMH;
		this.soTC = soTC;
		this.diemGK = diemGK;
		this.heSo1 = heSo1;
		this.heSo2 = heSo2;
		this.heSo3 = heSo3;
		this.diemCK = diemCK;

	}
	
	public Subject(int maMH,String tenMH, int soTC, float diemGK,float heSo1, float heSo2, float heSo3, float diemCK) {
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.soTC = soTC;
		this.diemGK = diemGK;
		this.heSo1 = heSo1;
		this.heSo2 = heSo2;
		this.heSo3 = heSo3;
		this.diemCK = diemCK;
	}

	public int getMaMH() {
		return maMH;
	}

	public void setMaMH(int maMH) {
		this.maMH = maMH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public int getSoTC() {
		return soTC;
	}

	public void setSoTC(int soTC) {
		this.soTC = soTC;
	}
	
	public float getDiemGK() {
		return diemGK;
	}

	public void setDiemGK(float diemGK) {
		this.diemGK = diemGK;
	}

	public float getHeSo1() {
		return heSo1;
	}

	public void setHeSo1(float heSo1) {
		this.heSo1 = heSo1;
	}

	public float getHeSo2() {
		return heSo2;
	}

	public void setHeSo2(float heSo2) {
		this.heSo2 = heSo2;
	}

	public float getHeSo3() {
		return heSo3;
	}

	public void setHeSo3(float heSo3) {
		this.heSo3 = heSo3;
	}

	public float getDiemCK() {
		return diemCK;
	}

	public void setDiemCK(float diemCK) {
		this.diemCK = diemCK;
	}

}

