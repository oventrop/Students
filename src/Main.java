import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws ParseException {

		Student[] students = new Student[6];
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		Student student = new Student(111, "Testovich", ft.parse("2017-11-11"),
				10.57);
		Student st2 = null;

		students[0] = new Student(1, "John Johnson6", ft.parse("1977-12-11"),
				3.57);
		students[1] = new Student(2, "John Johnson5", ft.parse("1987-01-12"),
				4.57);
		students[2] = new Student(3, "John Johnson4", ft.parse("1997-3-13"),
				5.57);
		students[3] = new Student(4, "John Johnson3", ft.parse("1977-11-14"),
				6.57);
		students[4] = new Student(5, "John Johnson2", ft.parse("2017-05-15"),
				7.57);
		students[5] = new Student(6, "John Johnson1", ft.parse("2017-05-1"),
				7.57);
		StudentGroup group = new StudentGroup(students.length);
		// System.out.println(group.getStudents().length);
		group.setStudents(students);
		// group.addFirst(student);
		// System.out.println(group.getStudent(0));
		// group.addLast(student);
		group.add(student, 0);
		// group.remove(0);
		// group.remove(students[3]);
		// group.removeFromIndex(3);
		// group.removeFromElement(students[2]);
		// group.removeToIndex(3);
		// group.removeToElement(students[5]);
		// group.bubbleSort();
		// group.getStudentsWithMaxAvgMark();
		// Student [] st3 = group.getStudentsWithMaxAvgMark();
		// .out.println(st3.length);
		// for (int i = 0; i<st3.length; i++){
		// System.out.println(st3[i].toString()); }
		// for (int i = 0; i < group.getStudents().length; i++)
		// {System.out.println(group.getStudent(i));}
		// System.out.println(group.getNextStudent(students[students.length-2]).toString());

		// Student [] st3 = group.getByBirthDate(ft.parse("2000-01-01"));System
		// .out.println(st3.length); for (int i = 0; i<st3.length; i++){
		// System.out.println(st3[i].toString()); }
		/*Student[] st3 = group.getBetweenBirthDates(ft.parse("1970-01-01"),
				ft.parse("2000-01-01"));
		System.out.println(st3.length);
		for (int i = 0; i < st3.length; i++) {
			System.out.println(st3[i].toString());
		}
		Student[] st4 = group.getNearBirthDate(ft.parse("1977-12-01"), 20000);
		System.out.println(st4.length);
		for (int i = 0; i < st4.length; i++) {
			System.out.println(st4[i].toString());
		}*/
		//System.out.println(group.getCurrentAgeByDate(1));
		Student [] st3 = group.getStudentsByAge(39);
		for (int i = 0; i<st3.length; i++){
			 System.out.println(st3[i].toString());
		}
	}
}
