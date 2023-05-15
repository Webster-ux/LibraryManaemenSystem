package com.nishant.Student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;



@Service
public class StudentService {


	private static List<Student>students= new ArrayList<>();
	
static {
		
		students.add(new Student(101,"Nishant","Btech","CSE"));
		students.add(new Student(102,"Karan","Btech", "ISE"));
		students.add(new Student(103,"Rohan","Btech", "CSE"));
		students.add(new Student(104,"Yash","Btech", "MECH"));
	}

public List<Student> AllStudents(String string) {
	
	return students;
}

}