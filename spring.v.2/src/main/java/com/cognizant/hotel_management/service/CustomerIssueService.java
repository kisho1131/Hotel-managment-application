package com.cognizant.hotel_management.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.hotel_management.model.CCRepresentative;
import com.cognizant.hotel_management.model.Customer;
import com.cognizant.hotel_management.model.IssueDetail;





@Service
public class CustomerIssueService {

	public static List <IssueDetail> issuesList = new ArrayList<IssueDetail>();
	public static List <CCRepresentative> ccrList = new ArrayList<CCRepresentative>();
	public static List <Customer> customerList = new ArrayList<Customer>();
	
	
	public void addCustomerObject(Customer c)
	{
		
		//write code to add valid customer object to collection
		customerList.add(c);
	}
	
	
	
	
	
	static 
	{
		
		ccrList.add(new CCRepresentative("CCR1","RakeshSingh","RKPuram","8273838833","rak@gmail.com",4,"I1;I2;I3;I4"));
		ccrList.add(new CCRepresentative("CCR2","RajeshSingh","RJPuram","8262568833","raj@gmail.com",3,"I5;I6;I7"));
		ccrList.add(new CCRepresentative("CCR3","UttamSingh","RNPuram","8273873913","utt@gmail.com",2,"I8;I9"));
		
		issuesList.add(new IssueDetail("I1",stringToDateConverter("2020-04-12"),"C001","Complaint","M/C Not Working","InProgress","CCR1"));
		issuesList.add(new IssueDetail("I2",stringToDateConverter("2020-03-13"),"C001","Complaint","Mixie Not Working","InProgress","CCR1"));
		issuesList.add(new IssueDetail("I3",stringToDateConverter("2020-02-14"),"C001","Complaint","Fridge Not Working","InProgress","CCR1"));
		issuesList.add(new IssueDetail("I4",stringToDateConverter("2020-01-15"),"C002","Complaint","TV Not Working","InProgress","CCR1"));
		issuesList.add(new IssueDetail("I5",stringToDateConverter("2020-01-16"),"C002","Complaint","Stove Not Working","InProgress","CCR2"));
		issuesList.add(new IssueDetail("I6",stringToDateConverter("2020-02-17"),"C002","Complaint","M/C Not Working","InProgress","CCR2"));
		issuesList.add(new IssueDetail("I7",stringToDateConverter("2020-03-17"),"C003","Complaint","Mixie Not Working","InProgress","CCR2"));
		issuesList.add(new IssueDetail("I8",stringToDateConverter("2020-04-18"),"C003","Complaint","Grinder Not Working","InProgress","CCR3"));
		issuesList.add(new IssueDetail("I9",stringToDateConverter("2020-05-19"),"C003","Complaint","Fridge Not Working","InProgress","CCR3"));
		
	
	}
	// Get the First CCR in the List who has least number of issues being handled by him/her
	
	public CCRepresentative getAvailableCCR()
	{
		//CCRepresentative ccrByMinIssues = null ;

		//Type Your Code here
		List<Integer> list=new ArrayList<Integer>();
		for(CCRepresentative obj:ccrList)
			list.add(obj.getIssuesInProgress());
			Collections.sort(list);
			int min=list.get(0);
			for(CCRepresentative obj:ccrList){
				if(min==obj.getIssuesInProgress())
					return obj;
			}
	  		return null;
	}
	
	
	public CCRepresentative getCCRById(String ccrId) {
		//CCRepresentative ccRep = new CCRepresentative();

		//Type Your Code here
		for(CCRepresentative obj:ccrList){
			if(obj.getCcRId().equalsIgnoreCase(ccrId))
				return obj;
		}
		
		return null;
	}
	public IssueDetail getIssueDetailById(String issueId)
	{
		//IssueDetail issueDetail = new IssueDetail();
		
		//Type Your Code here
		for(IssueDetail obj:issuesList){
			if(obj.getCustIssueId().equalsIgnoreCase(issueId))
				return obj;
		}
		
		return null;
	}
	public String getMaxissueId()
	{
		String maxIssueId = "I";
		int max=0;
		for(IssueDetail obj:issuesList){
			int issueId=Integer.parseInt(obj.getCustIssueId().substring(1));
			if(issueId>max)
				max=issueId;
		}
		maxIssueId=maxIssueId+max;
		//Type Your Code here
		return maxIssueId;
	  		
	}
	
	public boolean validateDateOfReport(String dateOfRepo)
	{
		boolean flag = false;
		//Type Your Code here
		if(stringToDateConverter(dateOfRepo)!=null)
			flag=true;
		return flag;
	}
	//NOT A BUSINESS FUNCTION BUT UTILITY FUNCTION
	public static java.util.Date stringToDateConverter(String stringDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		try {
			return dateFormat.parse(stringDate);
		} catch (ParseException pe) {
			return null;
		}
	}
	
}
