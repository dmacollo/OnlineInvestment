package org.coop.sidc.controllers;

import org.coop.sidc.domain.Member;
import org.coop.sidc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/membership")
public class MembershipController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String getMembershipForm(@ModelAttribute("newApplicant") Member member,Model model){		
		return "membershipForm";
	}
	
	@RequestMapping(value="/form",method=RequestMethod.POST)
	public String saveMembershipForm(@ModelAttribute("newApplicant") Member member,BindingResult result,RedirectAttributes attributes){
		memberService.save(member);
		if (result.hasErrors()){
			return "membershipForm";
		}
		return "redirect:/membership/agreement";
	}
	
	@RequestMapping(value="/agreement",method=RequestMethod.GET)
	public String getAgreementForm(){
		return "agreementForm";
	}

	@RequestMapping(value="/agreement",method=RequestMethod.POST)
	public String saveAgreementForm(){
		return "redirect:/membership/document";
	}
	
	@RequestMapping(value="/document",method=RequestMethod.GET)
	public String getDocumentForm(){
		return "documentForm";
	}

	@RequestMapping(value="/document",method=RequestMethod.POST)
	public String saveDocumentForm(){
		return "redirect:/membership/payment";
	}
	@RequestMapping(value="/payment",method=RequestMethod.GET)
	public String getPaymentForm(){
		return "paymentForm";
	}

	@RequestMapping(value="/payment",method=RequestMethod.POST)
	public String savePaymentForm(){
		return "redirect:/home";
	}

}
