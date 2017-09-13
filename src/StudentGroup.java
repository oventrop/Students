
//import java.util.Calendar;
import java.util.Date;

/**
 * A fix-sized array of students array length should always be equal to the
 * number of stored elements after the element was removed the size of the array
 * should be equal to the number of stored elements after the element was added
 * the size of the array should be equal to the number of stored elements null
 * elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given
 * class, interface or method DO NOT PUT any classes into packages
 * 
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;

	/**
	 * DO NOT remove or change this constructor, it will be used during task
	 * check
	 * 
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];

	}

	@Override
	public Student[] getStudents() {
		if (students == null) {
			throw new IllegalArgumentException();
		}
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		if (students == null) {
			throw new IllegalArgumentException();
		}
		this.students = students;

	}

	@Override
	public Student getStudent(int index) {
		if (index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		if (student == null || index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		students[index] = student;
	}

	@Override
	public void addFirst(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		Student[] students2 = new Student[students.length + 1];
		for (int i = 0; i < students.length; i++) {
			students2[i + 1] = students[i];
		}
		students2[0] = student;
		setStudents(students2);
	}

	@Override
	public void addLast(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		Student[] students2 = new Student[students.length + 1];

		for (int i = 0; i < students.length; i++) {
			students2[i] = students[i];
		}
		students2[students.length] = student;
		setStudents(students2);
	}

	@Override
	public void add(Student student, int index) {
		if (student == null || index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		Student[] students2 = new Student[students.length + 1];

		for (int i = 0; i < index; i++) {
			students2[i] = students[i];
		}
		students2[index] = student;
		for (int i = index + 1; i < students2.length; i++) {
			students2[i] = students[i - 1];
		}

		setStudents(students2);
	}

	@Override
	public void remove(int index) {
		if (index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		Student[] students2 = new Student[students.length - 1];

		for (int i = 0; i < index; i++) {
			students2[i] = students[i];
		}
		for (int i = index; i < students2.length; i++) {
			students2[i] = students[i + 1];
		}

		setStudents(students2);
	}

	@Override
	public void remove(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}

		int x = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] == student) {
				x = i;
			}
		}
		remove(x);
	}

	@Override
	public void removeFromIndex(int index) {
		if (index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		Student[] students2 = new Student[index + 1];
		for (int i = 0; i < students2.length - 1; i++) {
			students2[i] = students[i];
		}

		setStudents(students2);
	}

	@Override
	public void removeFromElement(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		int x = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] == student)
				x = i;
		}
		removeFromIndex(x);

	}

	@Override
	public void removeToIndex(int index) {

		if (index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}

		Student[] students2 = new Student[students.length - index + 1];
		for (int i = 0; i < students2.length; i++) {
			students2[i] = students[index + i - 1];
		}
		setStudents(students2);
	}

	@Override
	public void removeToElement(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}

		int x = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] == student)
				x = i;
		}
		removeToIndex(x);
	}

	@Override
	public void bubbleSort() {
		int n = students.length;
		Student temp = null;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {

				if (students[j - 1].compareTo(students[j]) > 0) {

					temp = students[j - 1];
					students[j - 1] = students[j];
					students[j] = temp;
				}
			}
		}

	}

	@Override
	public Student[] getByBirthDate(Date date) {
		if (date == null) {
			throw new IllegalArgumentException();
		}
		int x = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i].getBirthDate().compareTo(date) <= 0) {
				x++;
			}
		}
		Student[] students2 = new Student[x];
		int z = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i].getBirthDate().compareTo(date) <= 0) {
				students2[z] = students[i];
				// System.out.println(students2[z].toString());
				z++;
			}
		}
		return students2;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		if (firstDate == null || lastDate == null) {
			throw new IllegalArgumentException();
		}
		int x = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i].getBirthDate().before(lastDate)
					&& students[i].getBirthDate().after(firstDate)) {
				x++;
			}
		}
		Student[] students2 = new Student[x];
		int z = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i].getBirthDate().before(lastDate)
					&& students[i].getBirthDate().after(firstDate)) {
				students2[z] = students[i];
				// System.out.println(students2[z].toString());
				z++;
			}
		}
		return students2;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		if (date == null) {
			throw new IllegalArgumentException();
		}
		
		/*Calendar date2 = Calendar.getInstance();
		date2.setTime(date);
		date2.add(Calendar.DATE, days);
		Date date3 = date2.getTime();*/
		long x = date.getTime()/1000;
		System.out.println(x);
		long y = days*24*3600;
		System.out.println(y);
		long z = (x+y)*1000;
		System.out.println(z);
		Date date3 = new Date(z);
		System.out.println(date3.toString());
		int a = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i].getBirthDate().before(date3)
					&& students[i].getBirthDate().after(date)) {
				a++;
			}
		}
		Student[] students2 = new Student[a];
		int b = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i].getBirthDate().before(date3)
					&& students[i].getBirthDate().after(date)) {
				students2[b] = students[i];
				// System.out.println(students2[z].toString());
				b++;
			}
		}
		return students2;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		if (indexOfStudent == 0) {
			throw new IllegalArgumentException();
		}
		Student student = null;
		for(int i = 0; i<students.length; i++){
			if(students[i].getId() == indexOfStudent)
				student = students[i];
		}
		Date date = student.getBirthDate();
		Date currentDate = new Date();
		long x = currentDate.getTime()-date.getTime();
		System.out.println(x);
		double y = x/(1000*3600);
		y = y/(24*365);
		System.out.println(y);
		int z = (int)y;
		return z;
	}
	

	@Override
	public Student[] getStudentsByAge(int age) {
		int a =0;
		for (int i = 0; i<students.length; i++){
			Date date = students[i].getBirthDate();
			Date currentDate = new Date();
			long x = currentDate.getTime()-date.getTime();
		//	System.out.println(x);
			double y = x/(1000*3600);
			y = y/(24*365);
		//	System.out.println(y);
			int z = (int)y;
			if (z==age){a++;}
		}Student []students2 = new Student[a];
		int b = 0;
		for (int i = 0; i<students.length; i++){
			Date date = students[i].getBirthDate();
			Date currentDate = new Date();
			long x = currentDate.getTime()-date.getTime();
		//	System.out.println(x);
			double y = x/(1000*3600);
			y = y/(24*365);
		//	System.out.println(y);
			int z = (int)y;
			if (z==age){students2[b]=students[i];
				b++;}
			}return students2;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		double max = students[0].getAvgMark();
		int x = 0;
		for (int i = 1; i < students.length; i++) {
			if (students[i].getAvgMark() > max) {
				max = students[i].getAvgMark();

			}
		}

		for (int i = 0; i < students.length; i++) {
			if (students[i].getAvgMark() == max) {
				x++;
			}
		}
		Student[] students2 = new Student[x];
		int z = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i].getAvgMark() == max) {
				students2[z] = students[i];
				// System.out.println(students2[z].toString());
				z++;
			}
		}
		return students2;
	}

	@Override
	public Student getNextStudent(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		int x = -1;
		for (int i = 0; i < students.length; i++) {
			if (students[i] == student) {
				x = i;
			}
		}
		if (x == -1) {
			System.out.println("No such stud");
			throw new IllegalArgumentException();
		} else {
			if (x == students.length - 1) {
				System.out.println("Last stud");
				throw new IllegalArgumentException();
			} else {
				return students[x + 1];
			}
		}
	}
}
