package com.spring.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.spring.app.model.Student;
import com.spring.app.repository.StudentRepository;
import com.spring.app.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/getAll/page/{pageNo}")
	public String getAll(@PathVariable(value = "pageNo")int pageNo,Model model) {

		//List<Student> slist=studentService.getAll();
		//model.addAttribute("stud", slist);
		return findPaginated(pageNo, model);

		//return "students";
	}

	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<Student> getOne(Integer id) {

		return studentService.getOne(id);
	}

	@PostMapping("/addNew")
	public String addNew(Student stu) {

		studentService.addNew(stu);

		return "redirect:/students/getAll/page/1";
	}

	// Modified method to Add a new user User
	@PostMapping("/addNew1")
	public RedirectView addNewStudent(Student user, RedirectAttributes redir) {

		studentService.addNew(user);

		RedirectView redirectView = new RedirectView("/login", true);

		redir.addFlashAttribute("message", "You successfully registered! You can now login");

		return redirectView;
	}

	@PostMapping("/update")
	public String update(Student stu) {

		studentService.update(stu);

		return "redirect:/students/getAll/page/1";
	}

	@GetMapping("/delete")
	public String delete(Integer id) {

		studentService.delete(id);

		return "redirect:/students/getAll";
	}

	@GetMapping("/profile")
	public String profile(Integer id, Model model) {

		List<Student> slist = studentService.getAll();
		Student s = slist.stream().filter(student -> id.equals(student.getId())).findAny().orElse(null);
		model.addAttribute("st", s);

		return "profile";
	}

	@GetMapping("/profile1")
	public String getProfile(String username, Model model) {

		List<Student> slist = studentService.getAll();
		Student s = slist.stream().filter(student -> username.equals(student.getUsername())).findAny().orElse(null);
		model.addAttribute("st", s);

		return "profile";
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo")int pageNo,Model model) {
		int pageSize=5;
		
		Page<Student> page=studentService.findPaginated(pageNo, pageSize);
		List<Student> slist=page.getContent();
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("stud", slist);
		
		return "students";
	}
	
}
