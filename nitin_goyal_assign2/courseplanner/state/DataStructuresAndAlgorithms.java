package courseplanner.state;

import courseplanner.context.CoursePlanner;
import courseplanner.data.Student;

public class DataStructuresAndAlgorithms implements CoursePlannerStateI {

	CoursePlanner coursePlanner;
	String groupDSA="DSA";
	int count=0;

	public DataStructuresAndAlgorithms(CoursePlanner CoursePlannerIn) {
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
			if(currentPreferredCourse=='E' && !student.getCompletedCourses().contains(currentPreferredCourse)) {
				student.getCompletedCourses().add(currentPreferredCourse);
				courseAdded=true;
				count++;
			}else if(currentPreferredCourse=='F' && !student.getCompletedCourses().contains(currentPreferredCourse)){

				if(student.getCompletedCourses().size()%3==0) {
					if(student.getCompletedCourses().contains('E')) {
						student.getCompletedCourses().add(currentPreferredCourse);
						courseAdded=true;
						count++;
					}
				}else {
					if(student.getCompletedCourses().size()%3==1) {
						int lastIndex=student.getCompletedCourses().size()-1;
						char lastCompletedCourse = student.getCompletedCourses().get(lastIndex);
						if(lastCompletedCourse!='E' && lastCompletedCourse!='F' && lastCompletedCourse!='G' && lastCompletedCourse!='H'){
							if(student.getCompletedCourses().contains('E')) {
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
						if(lastCompletedCourse!='E' && lastCompletedCourse!='F' && lastCompletedCourse!='G' && lastCompletedCourse!='H'
								&&  secondLastCompletedCourse!='E' && secondLastCompletedCourse!='F' && secondLastCompletedCourse!='G' && secondLastCompletedCourse!='H') {
							if(student.getCompletedCourses().contains('E')) {
								student.getCompletedCourses().add(currentPreferredCourse);
								courseAdded=true;
								count++;
							}
						}
					}
				}
			}else if(currentPreferredCourse=='G'  && !student.getCompletedCourses().contains(currentPreferredCourse)){

				if(student.getCompletedCourses().size()%3==0) {
					if(student.getCompletedCourses().contains('F')) {
						student.getCompletedCourses().add(currentPreferredCourse);
						courseAdded=true;
						count++;
					}
				}else {
					if(student.getCompletedCourses().size()%3==1) {
						int lastIndex=student.getCompletedCourses().size()-1;
						char lastCompletedCourse = student.getCompletedCourses().get(lastIndex);
						if(lastCompletedCourse!='E' && lastCompletedCourse!='F' && lastCompletedCourse!='G' && lastCompletedCourse!='H'){
							if(student.getCompletedCourses().contains('F')) {
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
						if(lastCompletedCourse!='E' && lastCompletedCourse!='F' && lastCompletedCourse!='G' && lastCompletedCourse!='H'
								&&  secondLastCompletedCourse!='E' && secondLastCompletedCourse!='F' && secondLastCompletedCourse!='G' && secondLastCompletedCourse!='H') {
							if(student.getCompletedCourses().contains('F')) {
								student.getCompletedCourses().add(currentPreferredCourse);
								courseAdded=true;
								count++;
							}
						}
					}
				}
			}else if(currentPreferredCourse=='H' && !student.getCompletedCourses().contains(currentPreferredCourse)){

				if(student.getCompletedCourses().size()%3==0) {
					if(student.getCompletedCourses().contains('G')) {
						student.getCompletedCourses().add(currentPreferredCourse);
						courseAdded=true;
						count++;
					}
				}else {
					if(student.getCompletedCourses().size()%3==1) {
						int lastIndex=student.getCompletedCourses().size()-1;
						char lastCompletedCourse = student.getCompletedCourses().get(lastIndex);
						if(lastCompletedCourse!='E' && lastCompletedCourse!='F' && lastCompletedCourse!='G' && lastCompletedCourse!='H'){
							if(student.getCompletedCourses().contains('G')) {
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
						if(lastCompletedCourse!='E' && lastCompletedCourse!='F' && lastCompletedCourse!='G' && lastCompletedCourse!='H'
								&&  secondLastCompletedCourse!='E' && secondLastCompletedCourse!='F' && secondLastCompletedCourse!='G' && secondLastCompletedCourse!='H') {
							if(student.getCompletedCourses().contains('G')) {
								student.getCompletedCourses().add(currentPreferredCourse);
								courseAdded=true;
								count++;
							}
						}
					}
				}
			}else{
				if(student.getCompletedCourses().contains(currentPreferredCourse))
					student.setPreferencePointer(i+1);
				else
					student.setPreferencePointer(i);
				coursePlanner.setCoursePlannerState(coursePlanner.getState3());
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
			if(student.getSubjectGroup()!=groupDSA)
				student.setStateChanges(student.getStateChanges()+1);
			student.setSubjectGroup(groupDSA);
		}
	}
}
