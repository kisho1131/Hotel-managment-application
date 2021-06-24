package com.cognizant.hotel_management.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.hotel_management.exception.ApplicationException;
import com.cognizant.hotel_management.model.CCRepresentative;
import com.cognizant.hotel_management.model.Customer;
import com.cognizant.hotel_management.model.IssueDetail;
import com.cognizant.hotel_management.service.CustomerIssueService;


//@Controller
@SessionAttributes("custId")

public class LoginController {
	@Autowired
	CustomerIssueService custService;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@GetMapping("/login1")
	public String showLoginPage(@ModelAttribute("customer") Customer customer) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showCustomerPage(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,
			ModelMap map) throws ApplicationException

	{
		
		map.put("custId",customer.getCustId());
		if (result.hasErrors())
			// return "redirect:/login1";
			return "login";
		
		custService.addCustomerObject(customer);
		return "customerform";
	}

	
	  @RequestMapping(value = "/customerform", method = RequestMethod.GET) 
	  public String showCustomerForm(){
		  return "customerform"; 
	  }
	 

	@RequestMapping(value = "/customerform", method = RequestMethod.POST)
	public ModelAndView showCustomerIssue(ModelMap model, @RequestParam String issueid, @RequestParam String option)
			throws ApplicationException {
		ModelAndView mv = new ModelAndView();
		if (option.equals("ri")) {
			String custIssueId = custService.getMaxissueId();
			custIssueId = custIssueId.substring(0, 1) + (Integer.parseInt(custIssueId.substring(1)) + 1);
			mv.addObject("custIssueId", custIssueId);
			mv.addObject("custId",(String)model.get("custId"));
			mv.addObject("date",dateFormat.format(new Date()));
			mv.setViewName("raiseissue");
		} 
		else if (option.equals("vi")) {
			IssueDetail issueobj = custService.getIssueDetailById(issueid);
			if (issueid != null && issueobj !=null) {
				//System.out.println(issueobj);
				mv.addObject("issueobj", issueobj);
				mv.setViewName("customerissue");

			} else {
				mv.addObject("msg","No records found with that id");
				mv.setViewName("error1.jsp");
				throw new ApplicationException("No records found with that id");
			}
		}
		else {
			mv.addObject("msg","No records found with that id");
			mv.setViewName("error1.jsp");
			throw new ApplicationException("No records found with that id");
		}
		return mv;
	}

	@RequestMapping(value = "/raiseissue", method = RequestMethod.POST)
	public ModelAndView raiseIssue(ModelMap model, @RequestParam String custIssueId,@RequestParam String issueReportDate, @RequestParam String custId,
			@RequestParam String category, @RequestParam String descr)throws ParseException {
	
		ModelAndView mv = new ModelAndView();
		IssueDetail issueDetail=new IssueDetail(custIssueId,dateFormat.parse(issueReportDate),(String)model.get("custId"),category,descr,"Open",custService.getAvailableCCR().getCcRId());
		//custService.issuesList.add(issueDetail);
		mv.addObject("issue",issueDetail);
		mv.setViewName("issueraised");
		return mv;
	}
}