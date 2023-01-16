package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Contact;
import com.zohocrm.services.ContactService;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/listContacts")
	public String listContact(ModelMap model) {
		List<Contact> contacts = contactService.getAllContacts();
		model.addAttribute("contacts",contacts);
		return "list_contacts";
	}
	
	@RequestMapping("/findContactById")
	public String fineOneLead(@RequestParam("id") long id, ModelMap model) {
		Contact contact = contactService.getOneContact(id);
		model.addAttribute("contact", contact);
		return "contact_info";
	}
}
