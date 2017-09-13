import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.BeforeClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentGroupTest {

	private static StudentGroup group;
	private static Student[] students = new Student[5];
	private static Student st = new Student(111, "John Johnson Testovich", new Date(
			1987 - 01 - 19), 10.57);

	@BeforeClass
	public static void initStudentArrayOperation() {
		group = new StudentGroup(5);
		group.setStudents(students);
		students[0] = new Student(1, "John Johnso11", new Date(1967 - 01 - 19), 3.57);
		students[1] = new Student(2, "John Johnson2", new Date(1967 - 01 - 20), 4.57);
		students[2] = new Student(3, "John Johnson3", new Date(1967 - 01 - 21), 5.57);
		students[3] = new Student(4, "John Johnson4", new Date(1967 - 01 - 22), 6.57);
		students[4] = new Student(5, "John Johnson5", new Date(1967 - 01 - 23), 7.57);
	}

	@Test
	public void testGroupNotNull() {

		assertNotNull("Group was not created", group);
	}

	@Test
	public void testEmptyStudents() {
		Student[] students = group.getStudents();
		for (int i = 0; i < students.length; i++) {
			assertNotNull("Student #" + i + "id is empty", students[i].getId());
			assertNotNull("Student #" + i + "name is empty",
					students[i].getFullName());
		}
	}

	@Test
	public void testSetStudents() {
		group.setStudents(students);
		int x = 0;
		for (int i = 0; i < students.length; i++) {
			if (group.getStudents()[i] == students[i]) {
				x = 1;
			}
			assertTrue("Students were not added or wrong added", x == 0);
		}
	}

	@Test
	public void testGetStudent() {
		Student st = group.getStudent(0);
		assertTrue("Wrong student", st == students[0]);
	}

	@Test
	public void testAddFirstStudent() {
		Student[] studentsBefore = group.getStudents();
		group.addFirst(st);
		Student[] studentsAfter = group.getStudents();
		assertTrue("Array length did not chnge",
				studentsBefore.length != studentsAfter.length);
		assertTrue("Array did not chnge", studentsBefore != studentsAfter);
	}

	@Test
	public void testAddLastStudent() {
		Student[] studentsBefore = group.getStudents();
		group.addLast(st);
		Student[] studentsAfter = group.getStudents();
		assertTrue("Array length did not chnge",
				studentsBefore.length != studentsAfter.length);
		assertTrue("Array did not chnge", studentsBefore != studentsAfter);
	}

	@Test
	public void testAddStudent() {
		int x = 3;
		Student[] studentsBefore = group.getStudents();
		group.add(st, x);
		Student[] studentsAfter = group.getStudents();
		assertTrue("Array length did not chnge",
				studentsBefore.length != studentsAfter.length);
		assertTrue("Array did not chnge", studentsBefore != studentsAfter);
		assertTrue("Wrong student added", st == group.getStudent(x));
	}

	@Test
	public void testRemovePos() {
		int x = 3;
		Student[] studentsBefore = group.getStudents();
		group.remove(x);
		Student[] studentsAfter = group.getStudents();
		assertTrue("Array length did not change",
				studentsBefore.length != studentsAfter.length);
		assertTrue("Array did not chnge", studentsBefore != studentsAfter);
	}

	@Test
	public void testRemoveStudent() {
		Student[] studentsBefore = group.getStudents();
		group.remove(st);
		Student[] studentsAfter = group.getStudents();
		assertTrue("Array length did not change",
				studentsBefore.length != studentsAfter.length);
		assertTrue("Array did not chnge", studentsBefore != studentsAfter);
		int x = 0;
		for (int i = 0; i < studentsAfter.length; i++) {
			if (studentsAfter[i] == st) {
				x = 1;
			}
		}
		assertTrue("Student is still in array", x == 0);
	}
}
