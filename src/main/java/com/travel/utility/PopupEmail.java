package com.travel.utility;

public class PopupEmail {
	public String PopupEmail(String froCity, String toCity, String froDatePop, String toDatePop, String tripType, String email, String paxName, String paxPhone, String popOfferPrice, String noOfPax){
 
//		String siteName = "Ebooktrip";
//		String siteUrl = "https://www.ebooktrip.com";
//		String tfn = "+1-800-404-0025";
//		String emailId = "relations@ebooktrip.com";
		
		String siteName = "Lowtickets";
		String siteUrl = "https://www.lowtickets.com";
		String tfn = "+1-800-984-7414";
		String emailId = "bookings@lowtickets.com";

		StringBuffer buffer=new StringBuffer(); 
		buffer.append("<!DOCTYPE>");
		buffer.append("<html>");
		buffer.append("<head>"); 
		buffer.append("</head>"); 
		buffer.append("<body>");
		buffer.append("<div class=''>");
		buffer.append("<div id=':1n9' tabindex='-1'></div><div id=':1mw' class='ii gt adO'>");
		buffer.append("	<div id=':1mv' class='a3s aXjCH m16492927770d2a09'>");
		buffer.append("	<div dir='ltr'>");
		buffer.append("<div class='gmail_quote' style='width:850px; margin: auto; border: 8px solid #e5e5e5; padding: 20px; '>");
		buffer.append("	<table width='100%' border='0' cellpadding='0' style='padding:0 28px; font-family:Arial,Helvetica,sans-serif' cellspacing='0'>");
		buffer.append("<tbody>");
		buffer.append("<tr>");
		buffer.append("<td width='20%'>"); 

		buffer.append("<img src='https://www.lowtickets.com/resources/images/logolb.png' alt='logo'width='200' class='CToWUd'>");
		buffer.append("</td>");
		buffer.append(""); 
		buffer.append("</tr>");  
		//buffer.append("</tbody>");
		//	buffer.append("</table>");

		buffer.append("<table width='100%' border='0' cellpadding='0' cellspacing='0' style='border-bottom:1px solid #e5e5e5;background:#ececec;margin: 15 0 0 0;'>");
		buffer.append("<tbody>");
		buffer.append("</tbody></table>"); 
		buffer.append("<table width='100%' border='0' cellpadding='0' cellspacing='0' style='border-bottom:1px solid #e5e5e5;background:#ececec;margin: 15 0 0 0;'>");
		buffer.append("<tbody>");
		buffer.append("<tr><td  > <span style='font-size:18px;font-family:Tahoma,Geneva,sans-serif;padding:0% 0% 4% 0%'>From City : "+froCity+"</span> </td></tr>");
		buffer.append("<tr><td  > <span style='font-size:18px;font-family:Tahoma,Geneva,sans-serif;padding:0% 0% 4% 0%'>To City : "+toCity+"</span> </td></tr>");	
		buffer.append("<tr><td  > <span style='font-size:18px;font-family:Tahoma,Geneva,sans-serif;padding:0% 0% 4% 0%'>From Date : "+froDatePop+"</span> </td></tr>");	
		buffer.append("<tr><td > <span style='font-size:18px;font-family:Tahoma,Geneva,sans-serif;padding:0% 0% 4% 0%'>To Date : "+toDatePop+"</span> </td></tr>");	
		buffer.append("<tr><td  > <span style='font-size:18px;font-family:Tahoma,Geneva,sans-serif;padding:0% 0% 4% 0%'>Trip Type : "+tripType+"</span> </td></tr>");	
		buffer.append("<tr><td  > <span style='font-size:18px;font-family:Tahoma,Geneva,sans-serif;padding:0% 0% 4% 0%'>Pax Name : "+paxName+"</span> </td></tr>");	
		buffer.append("<tr><td > <span style='font-size:18px;font-family:Tahoma,Geneva,sans-serif;padding:0% 0% 4% 0%'>Email : "+email+"</span> </td></tr>");	
		buffer.append("<tr><td  > <span style='font-size:18px;font-family:Tahoma,Geneva,sans-serif;padding:0% 0% 4% 0%'>Phone No : "+paxPhone+"</span> </td></tr>");
		buffer.append("<tr><td  > <span style='font-size:18px;font-family:Tahoma,Geneva,sans-serif;padding:0% 0% 4% 0%'>Offer Price : "+Double.parseDouble(popOfferPrice)+"</span> </td></tr>");
		buffer.append("<tr><td  > <span style='font-size:18px;font-family:Tahoma,Geneva,sans-serif;padding:0% 0% 4% 0%'>No Of Pax : "+Integer.valueOf(noOfPax)+"</span> </td></tr>");
		buffer.append("</tbody></table>");

		buffer.append("</tbody>");
		buffer.append("</table>"); 

		buffer.append("<table width='100%' style='margin-top:20px'>");
		buffer.append("<tbody><tr>"); 
		buffer.append("		<td align='center' style='padding:20px 0px'><span><b>Thank you for choosing</b><br><a href='"+siteUrl+"' rel=' noopener noreferrer' target='_blank'> <img src='"+siteUrl+"/resources/images/logo.png' alt='logo'width='200' class='CToWUd'></a></span> </td>");
		buffer.append("	</tr>");
		buffer.append("	<tr>");
		buffer.append("		<td align='center' style='padding-bottom:20px'><span ><a href='"+siteUrl+"/terms' rel=' noopener noreferrer' target='_blank'>Terms and Conditions</a> &nbsp;<a href='"+siteUrl+"/privacy' rel=' noopener noreferrer' target='_blank' >Privacy Policy</a><p style='margin:0em'>Copyright &#9400; 2022-2023 "+siteName+". All Rights Reserved.</p><p style='margin-top:0em'>For Assistance, Please Contact "+siteName+" Via telephone : "+tfn+" <br/>or Via E-Mail : "+emailId+" 24x7.</p></span> </td>");
		buffer.append("	</tr>");
		buffer.append("</tbody></table>");



		buffer.append("<table width='100%' border='0' rules='all' cellspacing='0' cellpadding='0' style='font-family:Arial,Helvetica,sans-serif;margin:1% auto;font-size:12px'>");
		buffer.append("<tbody><tr>");


		buffer.append("");
		buffer.append("");
		buffer.append("</tr>");
		buffer.append("</tbody></table>");

		buffer.append("");
		buffer.append("</div>");
		buffer.append("");
		buffer.append("</div>");
		buffer.append("");
		buffer.append("");
		buffer.append("");
		buffer.append("</body>");
		buffer.append("");
		buffer.append("");
		buffer.append("");
		buffer.append("<html>");
		System.out.println("pop up Email is :--- "+buffer.toString());

		return buffer.toString();

	}


}
