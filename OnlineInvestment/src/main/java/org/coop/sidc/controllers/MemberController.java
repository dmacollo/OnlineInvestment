package org.coop.sidc.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.coop.sidc.domain.CardTransaction;
import org.coop.sidc.domain.InvestmentTransaction;
import org.coop.sidc.domain.Member;
import org.coop.sidc.service.InvestmentTransactionService;
import org.coop.sidc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping(value="/member")
@SessionAttributes({"activeUser"})
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(Model model) {
		return "memberList";
	}

	@RequestMapping(value="/edit/{memberId}",method=RequestMethod.GET)
	public String getMemberInfo(@ModelAttribute("editMember") Member editMember,@PathVariable("memberId") Long id,Model model){
		Member member=memberService.get(id);
		model.addAttribute("activeMember",member);
		return "memberInfo";
	}

	@RequestMapping(value="/edit/{memberid}",method=RequestMethod.POST)
	public String saveMemberInfo(@PathVariable("memberid") Long id,@Valid @ModelAttribute("editMember") Member editMember,BindingResult result,
			Model model){
		Member member=memberService.get(id);
		model.addAttribute("activeMember",member);
		if (result.hasErrors()){
			return "memberInfo";
		}
		model.addAttribute("activeMember",editMember);
		memberService.save(editMember);
		return "redirect:/home";
	}
	
	@RequestMapping(value="/transaction/{memberid}",method=RequestMethod.GET)
	public String getMemberTransaction(@PathVariable("memberid") Long id,@ModelAttribute("cardTransaction") CardTransaction cardTransaction,
			Model model){
		Member member=memberService.get(id);
		model.addAttribute("activeMember",member);
		return "memberCapital";
	}	
	
	@RequestMapping(value="/transaction/{memberid}",method=RequestMethod.POST)
	public String saveMemberTransaction(@PathVariable("memberid") Long id,@ModelAttribute("cardTransaction") CardTransaction cardTransaction,
			BindingResult result,Model model){
		Member member=memberService.get(id);
		model.addAttribute("activeMember",member);
		if (result.hasErrors()){
			return "memberCapital";
		}
		InvestmentTransaction investmentTransaction=new InvestmentTransaction();				
		investmentTransaction.setMember(member);
		investmentTransaction.setTransactionType(cardTransaction.getTransactionType());
		investmentTransaction.setTransactionAmount(cardTransaction.getAmount());
		investmentTransaction.setTransactionDate(new Date());
		investmentTransaction.setTransactionDescription(cardTransaction.getTransactionDescription()+" Transaction made from Card # "+cardTransaction.getCardNumber());
		investmentTransaction.setTransactionAmount(cardTransaction.getAmount());
		
		List<InvestmentTransaction> investmentTransactions=new ArrayList<InvestmentTransaction>();
		investmentTransactions.add(investmentTransaction);
		
		member.setInvestmentTransactions(investmentTransactions);
		memberService.save(member);
		return "redirect:/home";
	}
	
	@ModelAttribute("memberlist")
	public List<Member> getList(){
		return memberService.getList();
	}
	
}
