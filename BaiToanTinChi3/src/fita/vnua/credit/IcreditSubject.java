package fita.vnua.credit;

public interface IcreditSubject {
	public float calConversionMark();
	public String calGrade();
 	public float calSubjectMark();
 	public float calConversionMark(String grade);
	public int getCredit();
 	public String getSubjecCode();
 	public String getSubjectName();
}
