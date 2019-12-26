package courseplanner.state;

import courseplanner.context.CoursePlanner;
import courseplanner.data.Student;

public class Graduate implements CoursePlannerStateI {

	CoursePlanner coursePlanner;
	private final char[] coreSubjects = {'A', 'B', 'E', 'F', 'I', 'J', 'M', 'N'};
	private final char[] electives = {'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

	public Graduate(CoursePlanner CoursePlannerIn) {
		coursePlanner = CoursePlannerIn;
	}


	public void requiredCoursesCheck(Student student) {

		int electiveCount=0;
		int count1=0, count2=0;
		Boolean flag=false, finalFlag=false;
		int toggle=0;

		flag = student.getCompletedCourses().contains('A') && student.getCompletedCourses().contains('B') &&
				student.getCompletedCourses().contains('E') && student.getCompletedCourses().contains('F') &&
				student.getCompletedCourses().contains('I') && student.getCompletedCourses().contains('J') &&
				student.getCompletedCourses().contains('M') && student.getCompletedCourses().contains('N');

		if(flag) {
			for(char elective: electives) {
				if(student.getCompletedCourses().contains(elective))
					electiveCount++;
				if(electiveCount==2) {
					student.setGraduateCheck("GradOK");
					break;
				}

			}

			if(electiveCount<2){
				for(Character elective: electives) {
					if(student.getPreferredCourses().contains(elective) && !student.getCompletedCourses().contains(elective)) {
						student.setPreferencePointer(student.getPreferredCourses().indexOf(elective));
						coursePlanner.setCoursePlannerState(coursePlanner.getState5());
						break;
					}
				}
			}
		}

		if(!(flag && electiveCount==2)){
			String lpd="ABCD";
			String dsa="EFGH";
			String hs="IJKL";
			String da="MNOP";

			for(Character character: coreSubjects) {
				if(student.getPreferredCourses().contains(character) && !student.getCompletedCourses().contains(character)) {
					student.setPreferencePointer(student.getPreferredCourses().indexOf(character));

					if(lpd.contains(character.toString()))
						coursePlanner.setCoursePlannerState(coursePlanner.getState1());
					else if(dsa.contains(character.toString()))
						coursePlanner.setCoursePlannerState(coursePlanner.getState2());
					else if(hs.contains(character.toString()))
						coursePlanner.setCoursePlannerState(coursePlanner.getState3());
					else if(da.contains(character.toString()))
						coursePlanner.setCoursePlannerState(coursePlanner.getState4());
					toggle=1;
					break;
				}
			}

			if(toggle==0) {
				for(Character character: coreSubjects) {
					if(student.getCompletedCourses().contains(character))
						continue;
					else {
						toggle=2;
						break;
					}
				}

				if(toggle==2) {	
					coursePlanner.setCoursePlannerState(coursePlanner.getNotGraduateState());
				}else {
					for(Character character: electives) {
						if(student.getPreferredCourses().contains(character)) {
							student.setPreferencePointer(student.getPreferredCourses().indexOf(character));
							coursePlanner.setCoursePlannerState(coursePlanner.getState5());
							toggle=3;
							break;
						}
					}

					if(toggle!=3) {
						int count=0;

						for(Character character: electives) {
							if(student.getCompletedCourses().contains(character))
								count++;
						}
						if(count<2)
							coursePlanner.setCoursePlannerState(coursePlanner.getNotGraduateState());
					}
				}
			}
		}
		for(Character character:coreSubjects) {
			if(student.getCompletedCourses().contains(character)) {
				count1++;
				continue;
			}else{
				finalFlag=true;
				break;
			}
		}

		if(!finalFlag) {
			for(Character character:electives) {
				if(student.getCompletedCourses().contains(character)) {
					count2++;
				}
				if(count2==2) {
					break;
				}
			}

		}
		if(count1>=8 && count2==2) {
			student.setGraduateCheck("GradOk");
		}else {
			Boolean tempFlag=false;

			for(Character character:coreSubjects) {
				if(student.getPreferredCourses().contains(character)) {
					tempFlag=true;
					break;
				}
			}

			if(student.getPreferencePointer()==student.getPreferredCourses().size()-1 
					&& !tempFlag)
				coursePlanner.setCoursePlannerState(coursePlanner.getNotGraduateState());
		}
	}
}
