package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {SpringApplication.run(CruddemoApplication.class, args);}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
		return runner ->{
			// createStudent(studentDAO);
			// createMultipleStudent(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO){
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Number of Rows deleted: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO){
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	public void updateStudent(StudentDAO student){
		int studentId = 1;
		Student myStudent = student.findById(studentId);
		myStudent.setFirstName("Scooby");
		student.update(myStudent);
		System.out.println(myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO){
		List<Student> theStudents = studentDAO.findByLastName("Duck");
		for(Student student:theStudents){
			System.out.print(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO){
		List<Student> theStudent = studentDAO.findAll();

		for(Student tempStudent : theStudent){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO){
		Student tempStudent = new Student("Daffy",  "Duck", "Daffy@Daffy.com");
		studentDAO.save(tempStudent);
		int theId = tempStudent.getId();
		System.out.println("The Id is: "+theId);
		Student myStudent = studentDAO.findById(theId);
		System.out.println(myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO){
		System.out.println("Creating a new student object ...");

		Student tempStudent1 = new Student("John",  "Doe", "John@John.com");
		Student tempStudent2 = new Student("Egon",  "Doe", "Egon@John.com");
		Student tempStudent3 = new Student("Andrew",  "Doe", "Andrew@John.com");

		System.out.println("Save the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO){
		System.out.println("Creating a new student object ...");
		Student tempStudent = new Student("Paul",  "Doe", "paul@paul.com");

		System.out.println("Save the student ...");
		studentDAO.save(tempStudent);

		System.out.print("Saved student. Generated id: " + tempStudent.getId());
	}

}