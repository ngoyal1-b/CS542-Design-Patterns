package courseplanner.state;

import courseplanner.context.CoursePlanner;
import courseplanner.data.Student;

public class DataAnalytics implements CoursePlannerStateI {

	CoursePlanner coursePlanner;
	String groupDA="DA";
	int count=0;

	public DataAnalytics(CoursePlanner CoursePlannerIn) {
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
			if(currentPreferredCourse=='M' && !student.getCompletedCourses().contains(currentPreferredCourse)) {
				student.getCompletedCourses().add(currentPreferredCourse);
				courseAdded=true;
				count++;
			}else if(currentPreferredCourse=='N' && !student.getCompletedCourses().contains(currentPreferredCourse)){

				if(student.getCompletedCourses().size()%3==0) {
					if(student.getCompletedCourses().contains('M')) {
						student.getCompletedCourses().add(currentPreferredCourse);
						courseAdded=true;
						count++;
					}
				}else {
					if(student.getCompletedCourses().size()%3==1) {
						int lastIndex=student.getCompletedCourses().size()-1;
						char lastCompletedCourse = student.getCompletedCourses().get(lastIndex);
						if(lastCompletedCourse!='M' && lastCompletedCourse!='N' && lastCompletedCourse!='O' && lastCompletedCourse!='P'){
							if(student.getCompletedCourses().contains('M')) {
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
						if(lastCompletedCourse!='M' && lastCompletedCourse!='N' && lastCompletedCourse!='O' && lastCompletedCourse!='P'
								&&  secondLastCompletedCourse!='M' && secondLastCompletedCourse!='N' && secondLastCompletedCourse!='O' && secondLastCompletedCourse!='P') {
							if(student.getCompletedCourses().contains('M')) {
								student.getCompletedCourses().add(currentPreferredCourse);
								courseAdded=true;
								count++;
							}
						}
					}
				}
			}else if(currentPreferredCourse=='O' && !student.getCompletedCourses().contains(currentPreferredCourse)){

				if(student.getCompletedCourses().size()%3==0) {
					if(student.getCompletedCourses().contains('N')) {
						student.getCompletedCourses().add(currentPreferredCourse);
						courseAdded=true;
						count++;
					}
				}else {
					if(student.getCompletedCourses().size()%3==1) {
						int lastIndex=student.getCompletedCourses().size()-1;
						char lastCompletedCourse = student.getCompletedCourses().get(lastIndex);
						if(lastCompletedCourse!='M' && lastCompletedCourse!='N' && lastCompletedCourse!='O' && lastCompletedCourse!='P'){
							if(student.getCompletedCourses().contains('N')) {
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
						if(lastCompletedCourse!='M' && lastCompletedCourse!='N' && lastCompletedCourse!='O' && lastCompletedCourse!='P'
								&&  secondLastCompletedCourse!='M' && secondLastCompletedCourse!='N' && secondLastCompletedCourse!='O' && secondLastCompletedCourse!='P') {
							if(student.getCompletedCourses().contains('N')) {
								student.getCompletedCourses().add(currentPreferredCourse);
								courseAdded=true;
								count++;
							}
						}
					}
				}
			}else if(currentPreferredCourse=='P' && !student.getCompletedCourses().contains(currentPreferredCourse)){

				if(student.getCompletedCourses().size()%3==0) {
					if(student.getCompletedCourses().contains('O')) {
						student.getCompletedCourses().add(currentPreferredCourse);
						courseAdded=true;
						count++;
					}
				}else {
					if(student.getCompletedCourses().size()%3==1) {
						int lastIndex=student.getCompletedCourses().size()-1;
						char lastCompletedCourse = student.getCompletedCourses().get(lastIndex);
						if(lastCompletedCourse!='M' && lastCompletedCourse!='N' && lastCompletedCourse!='O' && lastCompletedCourse!='P'){
							if(student.getCompletedCourses().contains('O')) {
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
						if(lastCompletedCourse!='M' && lastCompletedCourse!='N' && lastCompletedCourse!='O' && lastCompletedCourse!='P'
								&&  secondLastCompletedCourse!='M' && secondLastCompletedCourse!='N' && secondLastCompletedCourse!='O' && secondLastCompletedCourse!='P') {
							if(student.getCompletedCourses().contains('O')) {
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
				coursePlanner.setCoursePlannerState(coursePlanner.getState5());
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
			if(student.getSubjectGroup()!=groupDA)
				student.setStateChanges(student.getStateChanges()+1);
			student.setSubjectGroup(groupDA);
		}
	}
}
