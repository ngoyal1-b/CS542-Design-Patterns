package courseplanner.data;

import java.util.ArrayList;
import java.util.List;

public class Student {

	int id;
	int stateChanges;
	int semesterCount;
	int preferencePointer;
	String graduateCheck;
	int stateCount;
	private String subjectGroup="LPD";
	List<Character> preferredCourses= new ArrayList<Character>();
	List<Character> completedCourses= new ArrayList<Character>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStateChanges() {
		return stateChanges;
	}
	public void setStateChanges(int stateChanges) {
		this.stateChanges = stateChanges;
	}	
	public int getSemesterCount() {
		return semesterCount;
	}
	public void setSemesterCount(int semesterCountIn) {
		semesterCount = semesterCountIn;
	}
	
	public int getPreferencePointer() {
		return preferencePointer;
	}
	public void setPreferencePointer(int preferencePointerIn) {
		preferencePointer = preferencePointerIn;
	}
	
	public int getStateCount() {
		return stateCount;
	}
	public void setStateCount(int stateCount) {
		this.stateCount = stateCount;
	}
	
	public String getSubjectGroup() {
		return subjectGroup;
	}
	public void setSubjectGroup(String subjectGroupIn) {
		subjectGroup = subjectGroupIn;
	}
	
	public String getGraduateCheck() {
		return graduateCheck;
	}
	public void setGraduateCheck(String graduateCheck) {
		this.graduateCheck = graduateCheck;
	}
	public List<Character> getPreferredCourses() {
		return preferredCourses;
	}
	public List<Character> getCompletedCourses() {
		return completedCourses;
	}
}
