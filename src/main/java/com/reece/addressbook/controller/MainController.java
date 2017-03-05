package com.reece.addressbook.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reece.addressbook.dao.ContactRepository;
import com.reece.addressbook.model.Contact;


@Controller
public class MainController {

	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private ContactRepository contactRepo;
//
//	@RequestMapping("/hello")
//	public String hello(@RequestParam(value = "key", required = false, defaultValue = "World") String name,
//			Model model) {
//
//		String[] beanNames = applicationContext.getBeanDefinitionNames();
//
//		for (String beanName : beanNames) {
//
//			System.out.println(beanName + " : " + applicationContext.getBean(beanName).getClass().toString());
//		}
//
//		model.addAttribute("name", name);
//
//		return "helloworld";
//	}
//	
//	
//	 /**
//	   * Create a new contact with an auto-generated id and name and phone number as passed 
//	   * values.
//	   */
//	  @RequestMapping(value="/create")
//	  @ResponseBody
//	  public String create(String name, String phoneNumber) {
//	    try {
//	      Contact contact = new Contact(name, phoneNumber);
//	      contactDao.create(contact);
//	    }
//	    catch (Exception ex) {
//	      return "Error creating the contact: " + ex.toString();
//	    }
//	    return "contact succesfully created!";
//	  }
//	  
//	  

	  /**
	   * Retrieve the id for the contact with the passed email address.
	   */
	  @RequestMapping(value="/get-by-name/{contactname}")
	  @ResponseBody
	  public String getByName(@PathVariable("contactname") String name) {
		  List<Contact> contact; 
		  try {
	       contact = contactRepo.findByName(name);
	    }
	    catch (Exception ex) {
	      return "contact not found: " + ex.toString();
	    }
	    return "The contact is: " + contact;
	  }
	  
}
