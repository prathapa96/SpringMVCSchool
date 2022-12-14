package com.ty.school.controller;

import javax.persistence.PostRemove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.school.dto.Student;
import com.ty.school.service.StudentService;

@Controller
public class StudentControllerPage {
	@Autowired
	StudentService studentService;
	
	@GetMapping("/loadStudent")
	public ModelAndView loadStudent() {
		ModelAndView modelAndView=new ModelAndView("CreateStudent.jsp");
		modelAndView.addObject("student",new Student());
		return modelAndView;
	}
	@PostMapping("/saveStudent")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		Student students=studentService.saveStudent(student);
		ModelAndView modelAndView=new ModelAndView("myDisplay.jsp");
		modelAndView.addObject("mssg",students.getName());
		return modelAndView;
	}
	@GetMapping("/allStudent")
	public ModelAndView getAllStudent() {
		ModelAndView modelAndView=new ModelAndView("ViewAllStudent.jsp");
		modelAndView.addObject("allstudents", studentService.getAllStudent());
		return modelAndView;
	}
	@GetMapping("/editStudent")
	public ModelAndView editStudent(@RequestParam(name="id") int id,ModelAndView modelAndView) {
		modelAndView.setViewName("UpdateStudent.jsp");
		modelAndView.addObject("editStudent", studentService.getStudentById(id));
		return modelAndView;
	}
	@PostMapping("/updateStudent")
	public ModelAndView updateStudent(@ModelAttribute Student student,ModelAndView modelAndView) {
		studentService.updateStudentById(student.getId(), student);
		modelAndView.setViewName("ViewAllStudent.jsp");
		modelAndView.addObject("allstudents", studentService.getAllStudent());
		return modelAndView;
	}
	@DeleteMapping("/deleteStudent")
	public ModelAndView deleteStudent(@RequestParam(name="id") int id,ModelAndView modelAndView) {
		modelAndView.setViewName("DeleteStudent.jsp");
		modelAndView.addObject("delete", studentService.deleteStudentById(id));
		return modelAndView;
	}
}
