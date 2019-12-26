package courseplanner.state;

import courseplanner.context.CoursePlanner;
import courseplanner.data.Student;

public class LongProgrammingAndDesign implements CoursePlannerStateI {

	CoursePlanner coursePlanner;
	String groupLPD="LPD";
	int count=0;

	public LongProgrammingAndDesign(CoursePlanner CoursePlannerIn) {
		coursePlanner = CoursePlannerIn;
	}
	public void requiredCoursesCheck(Student student) {
		Boolean courseAdded=false;

		for(int i=student.getPreferencePointer();i<student.getPreferredCourses().size();i++) {
			if(courseAdded) {
				coursePlanner.setCoursePlannerState(coursePlanner.getGraduateState());
				break;
			}
			Character currentPreferredCourse=student.getPreferredCourses().get(i);



			if(currentPreferredCourse=='A' && !student.getCompletedCourses().contains(currentPreferredCourse)) {
				student.getCompletedCourses().add(currentPreferredCourse);
				courseAdded=true;
				count++;
			}else if(currentPreferredCourse=='B' && !student.getCompletedCourses().contains(currentPreferredCourse)){
				if(student.getCompletedCourses().size()%3==0) {
					if(student.getCompletedCourses().contains('A')) {
						student.getCompletedCourses().add(currentPreferredCourse);
						courseAdded=true;
						count++;
					}
				}else {
					if(student.getCompletedCourses().size()%3==1) {
						int lastIndex=student.getCompletedCourses().size()-1;
						char lastCompletedCourse = student.getCompletedCourses().get(lastIndex);
						if(lastCompletedCourse!='A' && lastCompletedCourse!='B' && lastCompletedCourse!='C' && lastCompletedCourse!='D'){
							if(student.getCompletedCourses().contains('A')) {
								student.getCompletedCourses().add(currentPreferredCourse);
								courseAdded=true;
								count++;
							}
						}
					}else if(student.getCompletedCourses().size()%3==2) {
						int lastIndex=student.getCompletedCourses().size()-1;
						int secondLastIndex=student.getCompletedCourses().size()-2;
						char lastCompletedCourse = student.getCompletedCourses().get(lastIndex);
						char secondLastCompletedCourse = student.getCompletedCourses().get(secondLastIndex);
						if(lastCompletedCourse!='A' && lastCompletedCourse!='B' && lastCompletedCourse!='C' && lastCompletedCourse!='D'
								&&  secondLastCompletedCourse!='A' && secondLastCompletedCourse!='B' && secondLastCompletedCourse!='C' && secondLastCompletedCourse!='D') {
							if(student.getCompletedCourses().contains('A')) {
								student.getCompletedCourses().add(currentPreferredCourse);
								courseAdded=true;
								count++;
							}
						}
					}
				}
			}else if(currentPreferredCourse=='C' && !student.getCompletedCourses().contains(currentPreferredCourse)){
				if(student.getCompletedCourses().size()%3==0) {
					if(student.getCompletedCourses().contains('B')) {
						student.getCompletedCourses().add(currentPreferredCourse);
						courseAdded=true;
						count++;
					}
				}else {
					if(student.getCompletedCourses().size()%3==1) {
						int lastIndex=student.getCompletedCourses().size()-1;
						char lastCompletedCourse = student.getCompletedCourses().get(lastIndex);
						if(lastCompletedCourse!='A' && lastCompletedCourse!='B' && lastCompletedCourse!='C' && lastCompletedCourse!='D'){
							if(student.getCompletedCourses().contains('B')) {
								student.getCompletedCourses().add(currentPreferredCourse);
								courseAdded=true;
								count++;
							}
						}
					}else if(student.getCompletedCourses().size()%3==2) {
						int lastIndex=student.getCompletedCourses().size()-1;
						int secondLastIndex=student.getCompletedCourses().size()-2;
						char lastCompletedCourse = student.getCompletedCourses().get(lastIndex);
						char secondLastCompletedCourse = student.getCompletedCourses().get(secondLastIndex);
						if(lastCompletedCourse!='A' && lastCompletedCourse!='B' && lastCompletedCourse!='C' && lastCompletedCourse!='D'
								&&  secondLastCompletedCourse!='A' && secondLastCompletedCourse!='B' && secondLastCompletedCourse!='C' && secondLastCompletedCourse!='D') {
							if(student.getCompletedCourses().contains('B')) {
								student.getCompletedCourses().add(currentPreferredCourse);
								courseAdded=true;
								count++;
							}
						}
					}
				}
			}else if(currentPreferredCourse=='D' && !student.getCompletedCourses().contains(currentPreferredCourse)){
				if(student.getCompletedCourses().size()%3==0) {
					if(student.getCompletedCourses().contains('C')) {
						student.getCompletedCourses().add(currentPreferredCourse);
						courseAdded=true;
						count++;
					}
				}else {
					if(student.getCompletedCourses().size()%3==1) {
						int lastIndex=student.getCompletedCourses().size()-1;
						char lastCompletedCourse = student.getCompletedCourses().get(lastIndex);
						if(lastCompletedCourse!='A' && lastCompletedCourse!='B' && lastCompletedCourse!='C' && lastCompletedCourse!='D'){
							if(student.getCompletedCourses().contains('C')) {
								student.getCompletedCourses().add(currentPreferredCourse);
								courseAdded=true;
								count++;
							}
						}
					}else if(student.getCompletedCourses().size()%3==2) {
						int lastIndex=student.getCompletedCourses().size()-1;
						int secondLastIndex=student.getCompletedCourses().size()-2;
						char lastCompletedCourse = student.getCompletedCourses().get(lastIndex);
						char secondLastCompletedCourse = student.getCompletedCourses().get(secondLastIndex);
						if(lastCompletedCourse!='A' && lastCompletedCourse!='B' && lastCompletedCourse!='C' && lastCompletedCourse!='D'
								&&  secondLastCompletedCourse!='A' && secondLastCompletedCourse!='B' && secondLastCompletedCourse!='C' && secondLastCompletedCourse!='D') {
							if(student.getCompletedCourses().contains('C')) {
								student.getCompletedCourses().add(currentPreferredCourse);
								courseAdded=true;
								count++;
							}
						}
					}
				}
			}else {
				if(student.getCompletedCourses().contains(currentPreferredCourse))
					student.setPreferencePointer(i+1);
				else
					student.setPreferencePointer(i);
				coursePlanner.setCoursePlannerState(coursePlanner.getState2());
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
			if(student.getSubjectGroup()!=groupLPD)
				student.setStateChanges(student.getStateChanges()+1);
			student.setSubjectGroup(groupLPD);
		}
	}
}
