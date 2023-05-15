package com.nishant.Student;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class StudentControllerJpa {

	
public StudentControllerJpa(StudentService studentService,StudentRepository studentRepo) {
		super();
		this.studentRepo=studentRepo;
	}
	private StudentRepository studentRepo;
	@RequestMapping(value="/studentslist")
	public String allStudents(ModelMap model) {
		List<Student> allstudents= studentRepo.findAll();
		model.addAttribute("allstudents",allstudents);
		return "students";
	}
	
	
	@RequestMapping(value="/addstudent",method=RequestMethod.GET)
	public String addNewStudent(ModelMap model) {
		Student student=new Student(0,"","","");
		model.put("student", student);
		return "addstudent";
	}
	
	@RequestMapping(value="/addstudent",method=RequestMethod.POST)
	public String addStudent(ModelMap model,@Valid Student student,BindingResult result) {
		if(result.hasErrors()) {
			return "addstudent";
		}
		studentRepo.save(student);
		/*bookservice.addNewbooks(book.getId(),book.getTitle(),book.getAuthor(),book.getPublisher(),book.getNo_of_available());*/
		List<Student> allstudents=studentRepo.findAll();
		model.addAttribute("allstudents",allstudents);
		return "students";
	}
}
