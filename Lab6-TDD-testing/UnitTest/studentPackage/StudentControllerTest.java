package studentPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentControllerTest {
	Student student1 = new Student("Majd", "Rezik", "majd@rezik.com" , 123);
	StudentController studentController = new StudentController(); 

	
	@BeforeEach
	void setUp() throws Exception {
	}

	
	/**
	 * Adding new student to the arraylist in StudentController.class
	 * That is not in the list already.
	 * the test should pass successfully.
	 */
	@Test
	void addingNewStudent_Success() {
		assertTrue(studentController.addStudent(student1));
		assertTrue(studentController.getStudentsArrayList().size() > 0);
	}
	
	
	/**
	 * Adding new student to the arraylist in StudentController.class
	 * That is in the list already.
	 * the test should not pass successfully - because it is already in the list.
	 */
	@Test
	void addingNewStudentThatAlreadyExists_Fail() {
		assertTrue(studentController.addStudent(student1));
		Student student2 = studentController.getStudentsArrayList().get(0);
		assertFalse(studentController.addStudent(student2));
		assertEquals(1,studentController.getStudentsArrayList().size());
	}
	
	
	/**
	 * Adding 6 new student to the arraylist in StudentController.class
	 * That is not in the list already.
	 * the test should pass successfully.
	 */
	@Test
	void addingNewListOfStudents_Success() {
		Student student;
		for(int i=0;i<6;i++) {
			student = new Student("i","i","i",i);
			assertTrue(studentController.addStudent(student));
		}
		assertEquals(6,studentController.getStudentsArrayList().size());
	}
	
	
	/**
	 * Adding NULL Object to the arraylist in StudentController.class
	 * the test should not pass successfully.
	 */
	@Test
	void addingNullObject_Fail() {
		assertFalse(studentController.addStudent(null));
		assertEquals(0,studentController.getStudentsArrayList().size());
	}
	
	
	/**
	 * deleting a student from the arraylist in StudentController.class
	 * That is in the list.
	 * the test should pass successfully.
	 */
	@Test
	void deletingStudentThatIsInTheList_Success() {
		assertTrue(studentController.addStudent(student1));
		assertEquals(studentController.getStudentsArrayList().size(), 1);
		assertTrue(studentController.deleteStudent(student1));
		assertEquals(studentController.getStudentsArrayList().size(), 0);
	}
	
	
	/**
	 * deleting a student from the arraylist in StudentController.class
	 * That is not in the list.
	 * the test should not pass successfully.
	 */
	@Test
	void deletingStudentThatIsNotInTheList_Fail() {
		assertTrue(studentController.addStudent(student1));
		assertEquals(studentController.getStudentsArrayList().size(), 1);
		Student studentToBeDeleted = new Student("Alex","Bob", " " , 222);
		assertFalse(studentController.deleteStudent(studentToBeDeleted));
		assertEquals(studentController.getStudentsArrayList().size(), 1);
	}
	
	
	/**
	 * deleting a List of student from the arraylist in StudentController.class
	 * That is in the list.
	 * the test should pass successfully.
	 */
	@Test
	void deletingAListOfStudentThatIsInTheList_Success() {
		//adding 6 students
		Student student;
		for(int i=0;i<6;i++) {
			student = new Student("i","i","i",i);
			assertTrue(studentController.addStudent(student));
		}
		assertEquals(6,studentController.getStudentsArrayList().size());
		//deleting 6 (all) students.
		studentController.getStudentsArrayList().clear();
		assertEquals(0,studentController.getStudentsArrayList().size());
	}
	
	
	
	
	/**
	 * editing a student from the arraylist in StudentController.class
	 * That is in the list with a new Student Object that is valid.
	 * the test should pass successfully.
	 */
	@Test
	void editingStudentThatIsInTheList_Success() {
		assertTrue(studentController.addStudent(student1));
		Student student2 = new Student("Alex","Bob", " " , 222);
		assertTrue(studentController.editStudent(student1,student2));
	}
	
	
	/**
	 * editing a student from the arraylist in StudentController.class
	 * That is not in the list with a new Student Object that is valid.
	 * the test should not pass successfully.
	 */
	@Test
	void editingStudentThatIsNotInTheList_Fail() {
		Student student2 = new Student("Alex","Bob", " " , 222);
		assertFalse(studentController.editStudent(student1,student2));
	}
	
	
	/**
	 * editing a student from the arraylist in StudentController.class
	 * That is in the list with a new Student Object that is NULL.
	 * the test should not pass successfully.
	 */
	@Test
	void editingStudentThatIsInTheListWithNullObject_Fail() {
		assertTrue(studentController.addStudent(student1));
		assertFalse(studentController.editStudent(student1,null));
	}
	
	
	/**
	 * editing a student from the arraylist in StudentController.class
	 * That is in the list with itself.
	 * the test should not pass successfully - can't edit object with itself.
	 */
	@Test
	void editingSameStudent_Fail() {
		assertTrue(studentController.addStudent(student1));
		assertFalse(studentController.editStudent(student1,student1));
	}
	
	
}
