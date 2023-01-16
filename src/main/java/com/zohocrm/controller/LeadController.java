package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Contact;
import com.zohocrm.entities.Lead;
import com.zohocrm.services.ContactService;
import com.zohocrm.services.LeadService;
import com.zohocrm.utilities.EmailService;

@Controller
public class LeadController {

	@RequestMapping("/viewLeadPage")
	public String viewLeadPage() {
		return "create_lead";}
	
	@Autowired
	private LeadService leadService;
	
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute("lead") Lead lead,ModelMap model) {
		leadService.saveOneLead(lead);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
	
	
	// Email integration into app
	@RequestMapping("/composeEmail")
	public String composeEmail(@RequestParam("email") String email, ModelMap model) {
		model.addAttribute("email", email);
		return "compose_email";
	}
	
	@Autowired
	private EmailService emailService;
	@RequestMapping("/sendEmail")
	public String sendEmail(@RequestParam("to") String to, @RequestParam("sub") String subject, @RequestParam("emailBody") String emailBody) {
		emailService.sendEmail(to, subject, emailBody);
		return "compose_email";
	}
	
	//Developing convert Button
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadService.getOneLead(id);
		
		Contact contact = new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		
		contactService.saveOneContact(contact);
		
		// To delete the lead
		leadService.deleteOneLead(lead.getId());
		
		List<Contact> contacts = contactService.getAllContacts();
		model.addAttribute("contacts",contacts);
		return "list_contacts";
		
	}
	
	@RequestMapping("/listAll")
	public String getAllLead(ModelMap model) {
		List<Lead> leads = leadService.listLead();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	
	@RequestMapping("/findLeadById")
	public String fineOneLead(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadService.getOneLead(id);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
}
