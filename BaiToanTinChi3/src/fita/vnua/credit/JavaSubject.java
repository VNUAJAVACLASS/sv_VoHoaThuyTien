package fita.vnua.credit;
	
public abstract class JavaSubject extends Subject {

	private float attendanceMark;
	private float midExamMark;
	private float finalExamMark;

	public JavaSubject() {}

	public JavaSubject(float attendanceMark,float midExamMark, float finalExamMark) {
		this.attendanceMark = attendanceMark;
		this.midExamMark = midExamMark;
		this.finalExamMark = finalExamMark;
	}
 	
 	public float getAttendaceMark() {
 		return attendanceMark;
 	}
 
 	public void setAttendaceMark(float attendanceMark) {
 		this.attendanceMark = attendanceMark;
 	}
 	
 	public float getMidExamMark() {
 		return midExamMark;
 	}
 
 	public void setMidExamMark(float midExamMark) {
 		this.midExamMark = midExamMark;
 	}
 	
 	public float getFinalExamMark() {
 		return finalExamMark;
 	}
 
 	public void setFinalExamMark(float finalExamMark) {
 		this.finalExamMark = finalExamMark;
 	}
 	
	@Override
	public float calSubjectMark() {
		float subjectMark = (attendanceMark + 3 * midExamMark + 6 * finalExamMark) / 10;
		return subjectMark;
	}

}
