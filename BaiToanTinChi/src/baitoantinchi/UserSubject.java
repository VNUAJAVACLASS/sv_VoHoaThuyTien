package baitoantinchi;

public class UserSubject {
	private int maND_MH;
	private int maND;
	private int maMH;
	private float diem1;
	private float diem2;
	private float diem3;
	private float diem4;
	private float diem5;
	
	public UserSubject(int maND, int maMH, float diem1, float diem2, float diem3, float diem4, float diem5) {
		this.maND = maND;
		this.maMH = maMH;
		this.diem1 = diem1;
		this.diem2 = diem2;
		this.diem3 = diem3;
		this.diem4 = diem4;
		this.diem5 = diem5;
	}
	
	public UserSubject(int maND_MH,int maND, int maMH, float diem1, float diem2, float diem3, float diem4, float diem5) {
		this.maND_MH = maND_MH;
		this.maND = maND;
		this.maMH = maMH;
		this.diem1 = diem1;
		this.diem2 = diem2;
		this.diem3 = diem3;
		this.diem4 = diem4;
		this.diem5 = diem5;
	}

	public int getND_MH() {
		return maND_MH;
	}

	public void setND_MH(int maND_MH) {
		this.maND_MH = maND_MH;
	}

	public int getMaND() {
		return maND;
	}

	public void setMaND(int maND) {
		this.maND = maND;
	}

	public int getMaMH() {
		return maMH;
	}

	public void setMaMH(int maMH) {
		this.maMH = maMH;
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

	public float getDiem4() {
		return diem4;
	}

	public void setDiem4(float diem4) {
		this.diem4 = diem4;
	}

	public float getDiem5() {
		return diem5;
	}

	public void setDiem5(float diem5) {
		this.diem5 = diem5;
	}
	
	
}

