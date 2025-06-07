package baitoantinchi;

public class UserSubject {
	private int maND_MH;
	private int maND1;
	private int maMH1;
	private float diemGK1;
	private float diem1;
	private float diem2;
	private float diem3;
	private float diemCK1;
	
	public UserSubject(int maND1, int maMH1, float diemGK1,float diem1, float diem2, float diem3, float diemCK1) {
		this.maND1 = maND1;
		this.maMH1 = maMH1;
		this.diemGK1 = diemGK1;
		this.diem1 = diem1;
		this.diem2 = diem2;
		this.diem3 = diem3;
		this.diemCK1 = diemCK1;
	}
	
	public UserSubject(int maND_MH,int maND1, int maMH1, float diemGK1, float diem1, float diem2, float diem3, float diemCK1) {
		this.maND_MH = maND_MH;
		this.maND1 = maND1;
		this.maMH1 = maMH1;
		this.diemGK1 = diemGK1;
		this.diem1 = diem1;
		this.diem2 = diem2;
		this.diem3 = diem3;
		this.diemCK1 = diemCK1;
		
	}

	public int getND_MH() {
		return maND_MH;
	}

	public void setND_MH(int maND_MH) {
		this.maND_MH = maND_MH;
	}

	public int getMaND1() {
		return maND1;
	}

	public void setMaND1(int maND1) {
		this.maND1 = maND1;
	}

	public int getMaMH1() {
		return maMH1;
	}

	public void setMaMH1(int maMH1) {
		this.maMH1 = maMH1;
	}
	
	public float getDiemGK1() {
		return diemGK1;
	}

	public void setDiemGK1(float diemGK1) {
		this.diemGK1 = diemGK1;
	}

	public float getDiem1() {
		return diem1;
	}

	public void setDiem1(float diem1) {
		this.diem1 = diem1;
	}

	public float getDiem2() {
		return diem2;
	}

	public void setDiem2(float diem2) {
		this.diem2 = diem2;
	}

	public float getDiem3() {
		return diem3;
	}

	public void setDiem3(float diem3) {
		this.diem3 = diem3;
	}

	public float getDiemCK1() {
		return diemCK1;
	}

	public void setDiemCK1(float diemCK1) {
		this.diemCK1 = diemCK1;
	}
}

