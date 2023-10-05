package com.travel.utility;

public class SubscribeMail 
{
	public String buildSubscribeMail(String emailID, String type){
		StringBuffer buffer = new StringBuffer();
		
		if(type.equalsIgnoreCase("subscribe")){
			buffer.append("You have Subscribed Susccessfully at email-id: "+emailID+"<br>");
		}
		else if(type.equalsIgnoreCase("newsletter")){
			buffer.append("You have Registered Susccessfully at email-id: "+emailID+"<br>");
		}
		
		return buffer.toString();
	}
}
