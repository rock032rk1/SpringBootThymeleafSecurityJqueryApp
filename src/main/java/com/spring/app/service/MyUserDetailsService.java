package com.spring.app.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.spring.app.model.Student;
import com.spring.app.model.UserPrincipal;
import com.spring.app.repository.StudentRepository;
@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Student st=studentRepository.findByUsername(username);		
	    ModelAndView model=new ModelAndView();
	    int id=st.getId();
	    model.addObject("id", id);
		if(st==null) {
			throw new UsernameNotFoundException("Student not found.......");
		}	
		
		return new UserPrincipal(st);
	}

}
