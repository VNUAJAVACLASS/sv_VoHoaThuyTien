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
 	
 	public float getMajorAssignment() {
 		return majorAssignment;
 	}
 
 	public void setMajorAssignment(float majorAssignment) {
 		this.majorAssignment = majorAssignment;
 	}
 	
 	public float getFinalExamMark() {
 		return finalExamMark;
 	}
 
 	public void setFinalExamMark(float finalExamMark) {
 		this.finalExamMark = finalExamMark;
 	}
 	
 	public float calConversionMark() {
		float subjectMark = calSubjectMark();
		float conversionMark = 0;
		if ((subjectMark <= 3.9) && (subjectMark >= 0)) {
			conversionMark = 0;
		} else if (subjectMark <= 4.9) {
			conversionMark = 1;
		} else if (subjectMark <= 5.4) {
			conversionMark = 1.5f;
		} else if (subjectMark <= 6.4) {
			conversionMark = 2;
		} else if (subjectMark <= 6.9) {
			conversionMark = 2.5f;
		} else if (subjectMark <= 7.9) {
			conversionMark = 3;
		} else if (subjectMark <= 8.4) {
			conversionMark = 3.5f;
		} else if (subjectMark <= 10) {
			conversionMark = 4;
		} else {
			conversionMark = -1;
		}

		return conversionMark;
	}

 	public String calGrade() {
		float subjectMark = calSubjectMark();
		String grade = null;
		if (subjectMark < 0) {
			grade = "Error";
		} else if ((subjectMark <= 3.9) && (subjectMark >= 0)) {
			grade = "F";
		} else if (subjectMark <= 4.9) {
			grade = "D";
		} else if (subjectMark <= 5.4) {
			grade = "D+";
		} else if (subjectMark <= 6.4) {
			grade = "C";
		} else if (subjectMark <= 6.9) {
			grade = "C+";
		} else if (subjectMark <= 7.9) {
			grade = "B";
		} else if (subjectMark <= 8.4) {
			grade = "B+";
		} else if (subjectMark <= 10) {
			grade = "A";
		}

		return grade;
	}

 	public float calConversionMark(String grade) {
		float conversionMark = 0;
		switch (grade) {
		case "F":
			conversionMark = 0;
			break;
		case "D":
			conversionMark = 1;
			break;
		case "D+":
			conversionMark = 1.5f;
			break;
		case "C":
			conversionMark = 2;
			break;
		case "C+":
			conversionMark = 2.5f;
			break;
		case "B":
			conversionMark = 3;
			break;
		case "B+":
			conversionMark = 3.5f;
			break;
		case "A":
			conversionMark = 4;
		default:
			conversionMark = -1;
		}

		return conversionMark;

	}

	@Override
	public float calSubjectMark() {
		float subjectMark = (attendanceMark + majorAssignment + 3 * midExamMark + 6 * finalExamMark) / 10;
		return subjectMark;
	}

}
