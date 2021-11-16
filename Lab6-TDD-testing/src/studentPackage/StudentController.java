package studentPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class StudentController {
	
	
	private List<Student> studentsArrayList = new ArrayList<>();
	
	public List<Student> getStudentsArrayList() {
		return studentsArrayList;
	}
	
	/**
	 * adding a new Student Object to the List studentsArrayList.
	 * @param newStudent
	 * @return true if the object was added successfully. otherwise, false.
	 */
	public boolean addStudent(Student newStudent) {
		if(studentsArrayList.contains(newStudent))
			return false;
		if(newStudent != null) {
			studentsArrayList.add(newStudent);
			return true;
		}
		return false;
	}

	/**
	 * deleting a Student Object from the List studentsArrayList.
	 * @param student1
	 * @return true if the object was deleted successfully. otherwise, false.
	 */
	public boolean deleteStudent(Student student1) {
		if(student1.equals(null))
			return false;
		if(studentsArrayList.contains(student1)) {
			studentsArrayList.remove(student1);
			return true;
		}
		return false;
	}

	/**
	 * editing student1 object with student2 Object.
	 * Given 2 Student Objects Not NULL, update student1 reference with student2 reference.
	 * @param student1
	 * @param student2
	 * @return true if the object was edited successfully. otherwise, false.
	 */
	public boolean editStudent(Student student1, Student student2) {
		
		if(!studentsArrayList.contains(student1))
			return false;
		if(studentsArrayList.contains(student2))
			return false;
		if(student2 != null && student1 != student2){
			student1 = student2;	//Or we can assign the attributes of student2 to student1
			return true;
		}
		return false;
	}

}
