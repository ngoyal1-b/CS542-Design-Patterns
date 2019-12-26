package courseplanner.state;

import courseplanner.context.CoursePlanner;
import courseplanner.data.Student;

public class Electives implements CoursePlannerStateI {

	CoursePlanner coursePlanner;
	private final String groupE="E";
	int count=0;

	public Electives(CoursePlanner CoursePlannerIn) {
		coursePlanner = CoursePlannerIn;
	}

	public void requiredCoursesCheck(Student student) {
		for(int i=student.getPreferencePointer();i<student.getPreferredCourses().size();i++) {

			Character currentPreferredCourse=student.getPreferredCourses().get(i);
			if((currentPreferredCourse=='Q' || currentPreferredCourse=='R' || currentPreferredCourse=='S' || currentPreferredCourse=='T' || 
					currentPreferredCourse=='U' || currentPreferredCourse=='V' || currentPreferredCourse=='W' || currentPreferredCourse=='X' ||
					currentPreferredCourse=='Y' || currentPreferredCourse=='Z') &&  !student.getCompletedCourses().contains(currentPreferredCourse)){
				student.getCompletedCourses().add(currentPreferredCourse);
				count++;
			}else {
				if(student.getCompletedCourses().contains(currentPreferredCourse))
					student.setPreferencePointer(i+1);
				else
					student.setPreferencePointer(i);
				coursePlanner.setCoursePlannerState(coursePlanner.getState1());
				break;
			}

			if(student.getCompletedCourses().size()%3==0) {
				coursePlanner.setCoursePlannerState(coursePlanner.getGraduateState());
				break;
			}

			if(i==student.getPreferredCourses().size()-1) {
				coursePlanner.setCoursePlannerState(coursePlanner.getGraduateState());
				break;
			}
		}

		if(student.getCompletedCourses().size()%3==0)
			student.setSemesterCount(student.getCompletedCourses().size()/3);
		else
			student.setSemesterCount(student.getCompletedCourses().size()/3+1);

		if(count>student.getStateCount()) {
			student.setStateCount(count);
			if(student.getSubjectGroup()!=groupE)
				student.setStateChanges(student.getStateChanges()+1);
			student.setSubjectGroup(groupE);
		}

	}

}
