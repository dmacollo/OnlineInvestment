package org.coop.sidc.controllers;

import java.util.List;

import org.coop.sidc.domain.Staff;
import org.coop.sidc.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value={"/staff"})
public class StaffController {
	@Autowired
	StaffService staffService;
	
	// to show the  staff.jsp page to add new staff
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String getForm(@ModelAttribute("newStaff") Staff staff,Model model){
		return "staffAddForm";
	}
	//save the staff's data to the DB and redirect to the list with validation
	@RequestMapping(value={"/add"},method=RequestMethod.POST)// with validation 
	public String stsave(@ModelAttribute("newStaff") @Validated Staff staffObj, BindingResult result,Model model){
		if(result.hasErrors()){
			return "staffAddForm";
		}else{
		staffService.save(staffObj);
		return "redirect:/staff/add";
		}
	}
	//to gate the id to edit the staff's DB
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String get(@PathVariable long id, Model model) {
		model.addAttribute("editStaff", staffService.getStaffById(id));
		return "staffEditForm";
	}
	//to get the id along with it's data and again save into the DB along with the validation
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public String update(Staff staff, @PathVariable long id, @ModelAttribute("editStaff") @Validated Staff editStaff, BindingResult result, Model model) {
		if(result.hasErrors()){
			return"staffEditForm";
		}else{
		staff.setId(id);
		staffService.save(editStaff);
		return "redirect:/staff/add";
		}
	}
	//to delete the staff member by id
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		staffService.delete(id);
		return "redirect:/staff/add";
	}
	
	@ModelAttribute("stafflist")
	public List<Staff> showList(){
		List<Staff> staffList=staffService.getAllStaff();
		return staffList;
	}

}
