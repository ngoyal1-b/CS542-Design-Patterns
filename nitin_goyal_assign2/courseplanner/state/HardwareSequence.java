package courseplanner.state;

import courseplanner.context.CoursePlanner;
import courseplanner.data.Student;

public class HardwareSequence implements CoursePlannerStateI {

	CoursePlanner coursePlanner;
	String groupHS="HS";
	int count=0;

	public HardwareSequence(CoursePlanner CoursePlannerIn) {
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
			if(currentPreferredCourse=='I' && !student.getCompletedCourses().contains(currentPreferredCourse)) {
				student.getCompletedCourses().add(currentPreferredCourse);
				courseAdded=true;
				count++;
			}else if(currentPreferredCourse=='J' && !student.getCompletedCourses().contains(currentPreferredCourse)){
				if(student.getCompletedCourses().size()%3==0) {
					if(student.getCompletedCourses().contains('I')) {
						student.getCompletedCourses().add(currentPreferredCourse);
						courseAdded=true;
						count++;
					}
				}else {
					if(student.getCompletedCourses().size()%3==1) {
						int lastIndex=student.getCompletedCourses().size()-1;
						char lastCompletedCourse = student.getCompletedCourses().get(lastIndex);
						if(lastCompletedCourse!='I' && lastCompletedCourse!='J' && lastCompletedCourse!='K' && lastCompletedCourse!='L'){
							if(student.getCompletedCourses().contains('I')) {
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
						if(lastCompletedCourse!='I' && lastCompletedCourse!='J' && lastCompletedCourse!='K' && lastCompletedCourse!='L'
								&&  secondLastCompletedCourse!='I' && secondLastCompletedCourse!='J' && secondLastCompletedCourse!='K' && secondLastCompletedCourse!='L') {
							if(student.getCompletedCourses().contains('I')) {
								student.getCompletedCourses().add(currentPreferredCourse);
								courseAdded=true;
								count++;
							}
						}
					}
				}
			}else if(currentPreferredCourse=='K' && !student.getCompletedCourses().contains(currentPreferredCourse)){
				if(student.getCompletedCourses().size()%3==0) {
					if(student.getCompletedCourses().contains('J')) {
						student.getCompletedCourses().add(currentPreferredCourse);
						courseAdded=true;
						count++;
					}
				}else {
					if(student.getCompletedCourses().size()%3==1) {
						int lastIndex=student.getCompletedCourses().size()-1;
						char lastCompletedCourse = student.getCompletedCourses().get(lastIndex);
						if(lastCompletedCourse!='I' && lastCompletedCourse!='J' && lastCompletedCourse!='K' && lastCompletedCourse!='L'){
							if(student.getCompletedCourses().contains('J')) {
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
						if(lastCompletedCourse!='I' && lastCompletedCourse!='J' && lastCompletedCourse!='K' && lastCompletedCourse!='L'
								&&  secondLastCompletedCourse!='I' && secondLastCompletedCourse!='J' && secondLastCompletedCourse!='K' && secondLastCompletedCourse!='L') {
							if(student.getCompletedCourses().contains('J')) {
								student.getCompletedCourses().add(currentPreferredCourse);
								courseAdded=true;
								count++;
							}
						}
					}
				}
			}else if(currentPreferredCourse=='L' && !student.getCompletedCourses().contains(currentPreferredCourse)){
				if(student.getCompletedCourses().size()%3==0) {
					if(student.getCompletedCourses().contains('K')) {
						student.getCompletedCourses().add(currentPreferredCourse);
						courseAdded=true;
						count++;
					}
				}else {
					if(student.getCompletedCourses().size()%3==1) {
						int lastIndex=student.getCompletedCourses().size()-1;
						char lastCompletedCourse = student.getCompletedCourses().get(lastIndex);
						if(lastCompletedCourse!='I' && lastCompletedCourse!='J' && lastCompletedCourse!='K' && lastCompletedCourse!='L'){
							if(student.getCompletedCourses().contains('K')) {
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
						if(lastCompletedCourse!='I' && lastCompletedCourse!='J' && lastCompletedCourse!='K' && lastCompletedCourse!='L'
								&&  secondLastCompletedCourse!='I' && secondLastCompletedCourse!='J' && secondLastCompletedCourse!='K' && secondLastCompletedCourse!='L') {
							if(student.getCompletedCourses().contains('K')) {
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
				coursePlanner.setCoursePlannerState(coursePlanner.getState4());
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
			if(student.getSubjectGroup()!=groupHS)
				student.setStateChanges(student.getStateChanges()+1);
			student.setSubjectGroup(groupHS);
		}
	}
}
