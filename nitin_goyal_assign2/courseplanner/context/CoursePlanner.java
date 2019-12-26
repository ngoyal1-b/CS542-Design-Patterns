package courseplanner.context;

import courseplanner.data.Student;
import courseplanner.state.CoursePlannerStateI;
import courseplanner.state.DataAnalytics;
import courseplanner.state.DataStructuresAndAlgorithms;
import courseplanner.state.Electives;
import courseplanner.state.Graduate;
import courseplanner.state.HardwareSequence;
import courseplanner.state.LongProgrammingAndDesign;
import courseplanner.state.NotGraduated;

public class CoursePlanner {
	
	CoursePlannerStateI coursePlannerStateI;
	
	CoursePlannerStateI coursePlannerState1;
	CoursePlannerStateI coursePlannerState2;
	CoursePlannerStateI coursePlannerState3;
	CoursePlannerStateI coursePlannerState4;
	CoursePlannerStateI coursePlannerState5;
	CoursePlannerStateI studentGraduated;
	CoursePlannerStateI studentNotGraduated;
	
	
	public CoursePlanner() {
		coursePlannerState1 = new LongProgrammingAndDesign(this);
		coursePlannerState2 = new DataStructuresAndAlgorithms(this);
		coursePlannerState3 = new HardwareSequence(this);
		coursePlannerState4 = new DataAnalytics(this);
		coursePlannerState5 = new Electives(this);
		studentGraduated 	= new Graduate(this);
		studentNotGraduated = new NotGraduated(this);
		coursePlannerStateI = coursePlannerState1;
	}
	
	public void setCoursePlannerState(CoursePlannerStateI inCoursePlannerStateI) {
		coursePlannerStateI=inCoursePlannerStateI;
	}
	
	public CoursePlannerStateI getCoursePlannerState() {
		return coursePlannerStateI;
	}
	
	public void requiredCoursesCheck(Student student) {
		coursePlannerStateI.requiredCoursesCheck(student);
	}
	
	public CoursePlannerStateI getState1() {
		return coursePlannerState1;
	}
	
	public CoursePlannerStateI getState2() {
		return coursePlannerState2;
	}
	
	public CoursePlannerStateI getState3() {
		return coursePlannerState3;
	}
	
	public CoursePlannerStateI getState4() {
		return coursePlannerState4;
	}
	
	public CoursePlannerStateI getState5() {
		return coursePlannerState5;
	}
	
	public CoursePlannerStateI getGraduateState() {
		return studentGraduated;
	}
	public CoursePlannerStateI getNotGraduateState() {
		return studentNotGraduated;
	}
}
