package fita.vnua.credit;

public abstract class PythonSubject extends Subject{
	private float attendanceMark;
	private float midExamMark;
	private float majorAssignment;
	private float finalExamMark;
	
	public PythonSubject() {}
	
	public PythonSubject(float attendanceMark,float midExamMark,float majorAssignment, float finalExamMark) {
		this.attendanceMark = attendanceMark;
		this.midExamMark = midExamMark;
		this.majorAssignment = majorAssignment;
		this.finalExamMark = finalExamMark;
	}
	
	@Override
	public float calSubjectMark() {
		float subjectMark = (attendanceMark + majorAssignment + 3 * midExamMark + 6 * finalExamMark) / 10;
		return subjectMark;
	}

}
