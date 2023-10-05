package com.travel.auth;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuthPaymentEmail {
	public String authChargeEmail(String paxName, String invNum, double amount, String txnId, String respCode, String msgCode, String descp, 
			String authCode,String address, String city, String country, String zipCode, int siteId){

		System.out.println("mail");
		//		double newAmt = capturedAmount/100;

		double newAmt = amount;

		String siteName = "Ebooktrip";
		String siteUrl = "https://www.ebooktrip.com";
		String tfn = "+1-800-404-0025";
		String emailId = "relations@ebooktrip.com";

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

		buffer.append("<img src='"+siteUrl+"/resources/images/logo.png' alt='logo'width='200' class='CToWUd'>");

		buffer.append("</td>");
		buffer.append(""); 
		buffer.append("<td width='428'>");
		buffer.append("<table width='100%' border='0' cellpadding='0' cellspacing='0'>");
		buffer.append("<tbody>");
		buffer.append("<tr>");
		buffer.append(" <td width='90%' style='text-align:right'>");
		buffer.append("<img src='"+siteUrl+"/resources/images/confirm.png' alt='Booking Refund' class='CToWUd'>");   // refund mailk
		buffer.append(" </td>");
		buffer.append("</tr>");

		LocalDateTime current = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String formatted = current.format(formatter);

		buffer.append("</tbody>");
		buffer.append("</table>");
		buffer.append("</td>");
		buffer.append("</tr>");  
		buffer.append("</tbody>");
		buffer.append("</table>");

		buffer.append("<tr><td align='center' style='padding:3% 0%'><strong style='display:block; text-align:left; padding:0 44px;font-size:25px;margin:20px 0 0;'>Dear "+paxName+", </strong> </td></tr><br> ");
		buffer.append("<tr><td align='center' style='font-size:15px;font-family:Tahoma,Geneva,sans-serif;padding:0% 0% 0px 0%; text-align:center;'> <span style='display:block; text-align:justify; margin:0 80px 0 80px;font-family:sans-serif;font-size:15px;line-height: 28px;letter-spacing: 1.5px;'>We are delighted to find customers like you. </span></td></tr><br/>");
		buffer.append("<tr><td align='center' style='font-size:15px;font-family:Tahoma,Geneva,sans-serif;padding:0% 0% 0px 0%; text-align:center;'> <span style='display:block; text-align:justify; margin:0 80px 0 80px;font-family:sans-serif;font-size:15px;line-height: 28px;letter-spacing: 1.5px;'>Kindly note that we have charged an amount of <strong>USD "+newAmt+"</strong> from your credit card with reference to your booking Id <strong>"+invNum+"</strong>.</span> </td>");
		buffer.append("<tr><td align='center' style='font-size:15px;font-family:Tahoma,Geneva,sans-serif;padding:0% 0% 0px 0%; text-align:center;'> <span style='display:block; text-align:justify; margin:0 80px 0 80px;font-family:sans-serif;font-size:15px;line-height: 28px;letter-spacing: 1.5px;'>In line with our commitment to customer satisfaction, we are working hard to enrich our customer experience. </span></td></tr>");
		buffer.append("<tr><td align='center' style='font-size:15px;font-family:Tahoma,Geneva,sans-serif;padding:0% 0% 0px 0%; text-align:center;'> <span style='display:block; text-align:justify; margin:0 80px 0 80px;font-family:sans-serif;font-size:15px;line-height: 28px;letter-spacing: 1.5px;'>We appreciate your patience and understanding.</span></td></tr>");
		buffer.append("<tr><td align='center' style='font-size:15px;font-family:Tahoma,Geneva,sans-serif;padding:0% 0% 0px 0%; text-align:center;'> <span style='display:block; text-align:justify; margin:0 80px 0 80px;font-family:sans-serif;font-size:15px;line-height: 28px;letter-spacing: 1.5px;'>Do let us know if there is anything else we can do for you.</span></td></tr><br/>");
		buffer.append("<tr><td align='center' style='font-size:15px;font-family:Tahoma,Geneva,sans-serif;padding:0% 0% 0px 0%; text-align:center;'> <span style='display:block; text-align:justify; margin:0 80px 0 80px;font-family:sans-serif;font-size:15px;line-height: 28px;letter-spacing: 1.5px;'>With your comunnication address is "+address+" and city is "+city+" with zip code "+zipCode+".</span></td></tr><br/>");
		buffer.append("<tr><td align='center' style='font-size:15px;font-family:Tahoma,Geneva,sans-serif;padding:0% 0% 0px 0%; text-align:center;'> <span style='display:block; text-align:justify; margin:40px 80px 5px 80px;font-family:sans-serif;font-size:20px; line-height: 28px;letter-spacing: 1.5px;'><strong>Sincerely</strong></span></td></tr>");   
		buffer.append("<tr><td align='center' style='font-size:15px;font-family:Tahoma,Geneva,sans-serif;padding:0% 0% 0px 0%; text-align:center;'> <span style='display:block; text-align:justify; margin:5px 80px 5px 80px;font-family:sans-serif;font-size:20px; line-height: 28px;letter-spacing: 1.5px;'>Team "+siteName+"</span></td></tr>");
		buffer.append("<tr><td align='center' style='font-size:15px;font-family:Tahoma,Geneva,sans-serif;padding:0% 0% 0px 0%; text-align:center;'> <span style='display:block; text-align:justify; margin:5px 80px 55px 80px;font-family:sans-serif;font-size:20px; line-height: 28px;letter-spacing: 1.5px;'>"+tfn+"</span></td></tr>");
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
		System.out.println("Card Charge mail is :--- "+buffer.toString());

		return buffer.toString();
	}
}