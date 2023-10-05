// 
// Decompiled by Procyon v0.5.36
// 

package com.travel.utility;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import com.travel.bean.ContactForm;
import com.travel.object.bookingrequest.BookingRequest;
import com.travel.object.searchRequest.FlightRequest;

public class Emails_google
{
    @Value("${tfn}")
    private String tfn;
    
    public String buildFlightEmail(final BookingRequest bookingRequest, final FlightRequest searchRequest) {
        final StringBuffer buffer = new StringBuffer();
        buffer.append("<html>");
        buffer.append("<body>");
        buffer.append("<table width='100%' border='0' cellpadding='0' cellspacing='0' style='max-width:700px;min-width:700px;margin:auto;border:1px solid #dddddd;font-family:Arial, Helvetica, sans-serif;'>");
        buffer.append("<tr>");
        buffer.append("<td>");
        buffer.append("<a href='https://www.ebooktrip.com' target='_blank'>");
        buffer.append("<img src='https://www.ebooktrip.com/resources/images/logolb.png' style='height:50px;margin-left:15px;'>");
        buffer.append("</a>");
        buffer.append("</td>");
        buffer.append("<td style='text-align:right; color:#FF4500;font-family:Arial, Helvetica, sans-serif;font-weight:500;padding:10px 20px 0 0;'>");
        buffer.append("Call Us:<a href='tel:1-800-404-0025' style='color:#17252A;font-size:20px;text-decoration:none;'>1-800-404-0025</a>");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td colspan='2' style='background-color:#FF4500;height:30px;'></td>");
        buffer.append("</tr>");  
        buffer.append("<tr>");
        buffer.append("<td colspan='2' style='padding:15px 0;'><img src='https://www.ebooktrip.com/resources/images/confirm.png' style='margin:auto;display:block;' width='80px' height='80px'></td>");
        buffer.append("</tr>");
        
        if(bookingRequest.getSourceMedia().equalsIgnoreCase("google")){
    		buffer.append("<tr>");
    		buffer.append("<td colspan='2' style='text-align:center;font-size:22px;color:#17252A;font-weight:600;padding:5px;'>Payment Successful - Your trip is now booked and in process.</td>");
    		buffer.append("</tr>");
    		}else{
    			buffer.append("<tr>");
    			buffer.append("<td colspan='2' style='text-align:center;font-size:22px;color:#17252A;font-weight:600;padding:5px;'>Your trip is now booked and in process.</td>");
    			buffer.append("</tr>");
    		}
        
        buffer.append("<tr>");
        buffer.append("<td colspan='2' style='text-align:center;color:#666666;padding:5px;'>");
        buffer.append("Your E-Tickets will be sent shortly in a separate email once the process is completed.");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td colspan='2' style='text-align:center;color:#666666;padding:5px;'>");
        buffer.append("For immediate help on your booking, please call us at <a style='color:#17252A;text-decoration:none;' href='tel:1-800-404-0025'>1-800-404-0025</a> between 8am to 9pm (EST).");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td colspan='2' style='text-align:center;color:#666666;padding:5px;'>");
        buffer.append("Your booking reference number is");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td colspan='2' style='text-align:center;padding:5px;font-size:30px;color:#17252A;font-weight:600;'>");
        buffer.append(new StringBuilder().append(bookingRequest.getBookingID()).toString());
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td colspan='2' style='background-color:#FF4500;padding-left:15px;font-size:20px;color:#ffffff;font-weight:550;height:35px'>");
        buffer.append("Flight Summary");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td colspan='2'>");
        buffer.append("<table width='100%' border='0' cellpadding='0' cellspacing='0' style='background-color:#eeeeee;font-family:Arial, Helvetica, sans-serif;padding:5px 20px;'>");
        final SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        final SimpleDateFormat dateformatTime = new SimpleDateFormat("hh:mm:a");
        final SimpleDateFormat dateformatDate = new SimpleDateFormat("dd, MMM yyyy");
        final DateFormat inputFormat = new SimpleDateFormat("HH:mm");
        final DateFormat outputFormat = new SimpleDateFormat("hh:mm a");
        buffer.append("<tr>");
        buffer.append("<td width='100%' colspan='3' style='color:#17252A;font-size:17px;font-weight:600;padding:10px 0;'>");
        buffer.append("Departure Flights <span style='font-size:16px;font-weight:400;'></span>");
        buffer.append("</td>");
        buffer.append("</tr>");
        for (int j = 0; j < bookingRequest.getFlightResult().getOutBound().size(); ++j) {
            String depFroTimeStr = "";
            String depFroDateStr = "";
            String depToTimeStr = "";
            String depToDateStr = "";
            try {
                final Date depDate = dateformat.parse(bookingRequest.getFlightResult().getOutBound().get(j).getDepDate());
                depFroTimeStr = outputFormat.format(inputFormat.parse(bookingRequest.getFlightResult().getOutBound().get(j).getDepDate().split("T")[1]));
                depFroDateStr = dateformatDate.format(depDate);
                final Date reachDate = dateformat.parse(bookingRequest.getFlightResult().getOutBound().get(j).getReachDate());
                depToTimeStr = outputFormat.format(inputFormat.parse(bookingRequest.getFlightResult().getOutBound().get(j).getReachDate().split("T")[1]));
                depToDateStr = dateformatDate.format(reachDate);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
            buffer.append("<tr>");
            buffer.append("<td style='display:flex;align-items:center;font-size:15px;padding:5px;color:#444444'><img src='https://www.ebooktrip.com/resources/images/airline-logo/" + bookingRequest.getFlightResult().getOutBound().get(j).getAirline() + ".png' width='50px' height='30px'> " + bookingRequest.getFlightResult().getOutBound().get(j).getAirlineName() + "</td>");
            buffer.append("<td style='text-align:center;font-size:14px;font-weight:550;padding:5px;color:#444444'>Flight No: <span style='font-size:13px;font-weight:400;'>" + bookingRequest.getFlightResult().getOutBound().get(j).getFlightNo() + "</span></td>");
            String cabin = "";
            if (bookingRequest.getFlightResult().getOutBound().get(j).getCabinClass() == 1) {
                cabin = "Economy";
            }
            else if (bookingRequest.getFlightResult().getOutBound().get(j).getCabinClass() == 2) {
                cabin = "Premium Economy";
            }
            else if (bookingRequest.getFlightResult().getOutBound().get(j).getCabinClass() == 3) {
                cabin = "Business";
            }
            else if (bookingRequest.getFlightResult().getOutBound().get(j).getCabinClass() == 4) {
                cabin = "First";
            }
            buffer.append("<td style='text-align:right;font-size:14px;font-weight:550;padding:5px;color:#444444'>Class : <span style='font-size:13px;font-weight:400;'>" + cabin + "</span></td>");
            buffer.append("</tr>");
            buffer.append("<tr>");
            buffer.append("<td style='padding:5px;color:#666666;'>" + depFroDateStr + "," + depFroTimeStr + "</td>");
            try {
                buffer.append("<td style='text-align:center;padding:5px;color:#666666;'><img src='https://www.ebooktrip.com/resources/images/clocko.png' width='14px;' height='14px;'>" + Utility.timeConversion((int)bookingRequest.getFlightResult().getOutBound().get(j).getEft()) + "</td>");
            }
            catch (Exception e3) {
                buffer.append("<td style='text-align:center;padding:5px;color:#666666;'></td>");
            }
            buffer.append("<td style='text-align:right;padding:5px;color:#666666;'>" + depToDateStr + "," + depToTimeStr + "</td>");
            buffer.append("</tr>");
            buffer.append("<tr>");
            buffer.append("<td style='padding:5px;color:#17252A;font-weight:550;'>" + bookingRequest.getFlightResult().getOutBound().get(j).getFromAirport() + "<span style='font-weight:400;color:#444444;'>(" + bookingRequest.getFlightResult().getOutBound().get(j).getFroCityName() + ")</span></td>");
            buffer.append("<td style='text-align:center;padding:5px;'><img src='https://www.ebooktrip.com/resources/images/rightarrow.png' width='30px;' height='30px;'></td>");
            buffer.append("<td style='padding:5px;color:#17252A;font-weight:550;text-align:right;'>" + bookingRequest.getFlightResult().getOutBound().get(j).getToAirport() + "<span style='font-weight:400;color:#444444'>(" + bookingRequest.getFlightResult().getOutBound().get(j).getToCityName() + ")</span></td>");
            buffer.append("</tr>");
            buffer.append("<tr>");
            buffer.append("<td style='font-size:15px;padding:0 5px;color:#444444'>" + bookingRequest.getFlightResult().getOutBound().get(j).getFromAirportName() + "</td>");
            buffer.append("<td style='text-align:center;font-size:14px;font-weight:550;padding:0 5px;color:#444444'>Non-Stop</td>");
            buffer.append("<td style='text-align:right;font-size:15px;padding:0 5px;color:#444444'>" + bookingRequest.getFlightResult().getOutBound().get(j).getToAirportName() + "</td>");
            buffer.append("</tr>");
            buffer.append("<tr style='height:10px;'></tr>");
            try {
                if (bookingRequest.getFlightResult().getOutBound().get(j).getLayOverTime() > 0) {
                    buffer.append("<tr style='height:30px;'>");
                    buffer.append("<td><hr style='border:dashed #999999;border-width:0 0 1px 0'></td>");
                    buffer.append("<td style='text-align:center;color:#666666;font-size:13px;font-weight:500;'><img src='/resources/images/clocko.png' width='13px;' height='13px;'> " + Utility.timeConversion((int)bookingRequest.getFlightResult().getOutBound().get(j).getLayOverTime()) + " layover in " + bookingRequest.getFlightResult().getOutBound().get(j).getToCityName() + " (" + bookingRequest.getFlightResult().getOutBound().get(j).getToAirport() + ")</td>");
                    buffer.append("<td><hr style='border:dashed #999999;border-width:0 0 1px 0'></td>");
                    buffer.append("</tr>");
                }
            }
            catch (Exception ex) {}
        }
        if (searchRequest.getTripType() != 1) {
            buffer.append("<tr>");
            buffer.append("<td width='100%' colspan='3' style='color:#17252A;font-size:17px;font-weight:600;padding:10px 0;'>");
            if (searchRequest.getTripType() == 2) {
                buffer.append("Return Flights <span style='font-size:16px;font-weight:400;'></span>");
            }
            else if (searchRequest.getTripType() == 3) {
                buffer.append("Departure Flights <span style='font-size:16px;font-weight:400;'></span>");
            }
            buffer.append("</td>");
            buffer.append("</tr>");
            for (int j = 0; j < bookingRequest.getFlightResult().getInBound().size(); ++j) {
                String depFroTimeStr = "";
                String depFroDateStr = "";
                String depToTimeStr = "";
                String depToDateStr = "";
                try {
                    final Date depDate = dateformat.parse(bookingRequest.getFlightResult().getInBound().get(j).getDepDate());
                    depFroTimeStr = outputFormat.format(inputFormat.parse(bookingRequest.getFlightResult().getInBound().get(j).getDepDate().split("T")[1]));
                    depFroDateStr = dateformatDate.format(depDate);
                    final Date reachDate = dateformat.parse(bookingRequest.getFlightResult().getInBound().get(j).getReachDate());
                    depToTimeStr = outputFormat.format(inputFormat.parse(bookingRequest.getFlightResult().getInBound().get(j).getReachDate().split("T")[1]));
                    depToDateStr = dateformatDate.format(reachDate);
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
                buffer.append("<tr>");
                buffer.append("<td style='display:flex;align-items:center;font-size:15px;padding:5px;color:#444444'><img src='https://www.ebooktrip.com/resources/images/airline-logo/" + bookingRequest.getFlightResult().getInBound().get(j).getAirline() + ".png' width='50px' height='30px'> " + bookingRequest.getFlightResult().getInBound().get(j).getAirlineName() + "</td>");
                buffer.append("<td style='text-align:center;font-size:14px;font-weight:550;padding:5px;color:#444444'>Flight No: <span style='font-size:13px;font-weight:400;'>" + bookingRequest.getFlightResult().getInBound().get(j).getFlightNo() + "</span></td>");
                String cabin = "";
                if (bookingRequest.getFlightResult().getInBound().get(j).getCabinClass() == 1) {
                    cabin = "Economy";
                }
                else if (bookingRequest.getFlightResult().getInBound().get(j).getCabinClass() != 2) {
                    if (bookingRequest.getFlightResult().getInBound().get(j).getCabinClass() == 3) {
                        cabin = "Business";
                    }
                    else if (bookingRequest.getFlightResult().getInBound().get(j).getCabinClass() == 4) {
                        cabin = "First";
                    }
                }
                buffer.append("<td style='text-align:right;font-size:14px;font-weight:550;padding:5px;color:#444444'>Class : <span style='font-size:13px;font-weight:400;'>" + cabin + "</span></td>");
                buffer.append("</tr>");
                buffer.append("<tr>");
                buffer.append("<td style='padding:5px;color:#666666;'>" + depFroDateStr + "," + depFroTimeStr + "</td>");
                try {
                    buffer.append("<td style='text-align:center;padding:5px;color:#666666;'><img src='https://www.ebooktrip.com/resources/images/clocko.png' width='14px;' height='14px;'>" + Utility.timeConversion((int)bookingRequest.getFlightResult().getInBound().get(j).getEft()) + "</td>");
                }
                catch (Exception e3) {
                    buffer.append("<td style='text-align:center;padding:5px;color:#666666;'></td>");
                }
                buffer.append("<td style='text-align:right;padding:5px;color:#666666;'>" + depToDateStr + "," + depToTimeStr + "</td>");
                buffer.append("</tr>");
                buffer.append("<tr>");
                buffer.append("<td style='padding:5px;color:#17252A;font-weight:550;'>" + bookingRequest.getFlightResult().getInBound().get(j).getFromAirport() + "<span style='font-weight:400;color:#444444;'>(" + bookingRequest.getFlightResult().getInBound().get(j).getFroCityName() + ")</span></td>");
                buffer.append("<td style='text-align:center;padding:5px;'><img src='https://www.ebooktrip.com/resources/images/rightarrow.png' width='30px;' height='30px;'></td>");
                buffer.append("<td style='padding:5px;color:#17252A;font-weight:550;text-align:right;'>" + bookingRequest.getFlightResult().getInBound().get(j).getToAirport() + "<span style='font-weight:400;color:#444444'>(" + bookingRequest.getFlightResult().getInBound().get(j).getToCityName() + ")</span></td>");
                buffer.append("</tr>");
                buffer.append("<tr>");
                buffer.append("<td style='font-size:15px;padding:0 5px;color:#444444'>" + bookingRequest.getFlightResult().getInBound().get(j).getFromAirportName() + "</td>");
                buffer.append("<td style='text-align:center;font-size:14px;font-weight:550;padding:0 5px;color:#444444'>Non-Stop</td>");
                buffer.append("<td style='text-align:right;font-size:15px;padding:0 5px;color:#444444'>" + bookingRequest.getFlightResult().getInBound().get(j).getToAirportName() + "</td>");
                buffer.append("</tr>");
                buffer.append("<tr style='height:10px;'></tr>");
                try {
                    if (bookingRequest.getFlightResult().getInBound().get(j).getLayOverTime() > 0) {
                        buffer.append("<tr style='height:30px;'>");
                        buffer.append("<td><hr style='border:dashed #999999;border-width:0 0 1px 0'></td>");
                        buffer.append("<td style='text-align:center;color:#666666;font-size:13px;font-weight:500;'><img src='/resources/images/clocko.png' width='13px;' height='13px;'> " + Utility.timeConversion((int)bookingRequest.getFlightResult().getInBound().get(j).getLayOverTime()) + " layover in " + bookingRequest.getFlightResult().getInBound().get(j).getToCityName() + " (" + bookingRequest.getFlightResult().getInBound().get(j).getToAirport() + ")</td>");
                        buffer.append("<td><hr style='border:dashed #999999;border-width:0 0 1px 0'></td>");
                        buffer.append("</tr>");
                    }
                }
                catch (Exception ex2) {}
            }
        }
        if (searchRequest.getTripType() == 3) {
            for (int j = 0; j < bookingRequest.getFlightResult().getOtherBound().size(); ++j) {
                buffer.append("<tr>");
                buffer.append("<td width='100%' colspan='3' style='color:#17252A;font-size:17px;font-weight:600;padding:10px 0;'>");
                buffer.append("Departure Flights <span style='font-size:16px;font-weight:400;'></span>");
                buffer.append("</td>");
                buffer.append("</tr>");
                for (int i = 0; i < bookingRequest.getFlightResult().getOtherBound().get(j).size(); ++i) {
                    String depFroTimeStr2 = "";
                    String depFroDateStr2 = "";
                    String depToTimeStr2 = "";
                    String depToDateStr2 = "";
                    try {
                        final Date depDate2 = dateformat.parse(bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getDepDate());
                        depFroTimeStr2 = outputFormat.format(inputFormat.parse(bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getDepDate().split("T")[1]));
                        depFroDateStr2 = dateformatDate.format(depDate2);
                        final Date reachDate2 = dateformat.parse(bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getReachDate());
                        depToTimeStr2 = outputFormat.format(inputFormat.parse(bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getReachDate().split("T")[1]));
                        depToDateStr2 = dateformatDate.format(reachDate2);
                    }
                    catch (ParseException e2) {
                        e2.printStackTrace();
                    }
                    buffer.append("<tr>");
                    buffer.append("<td style='display:flex;align-items:center;font-size:15px;padding:5px;color:#444444'><img src='https://www.ebooktrip.com/resources/images/airline-logo/" + bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getAirline() + ".png' width='50px' height='30px'> " + bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getAirlineName() + "</td>");
                    buffer.append("<td style='text-align:center;font-size:14px;font-weight:550;padding:5px;color:#444444'>Flight No: <span style='font-size:13px;font-weight:400;'>" + bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getFlightNo() + "</span></td>");
                    String cabin2 = "";
                    if (bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getCabinClass() == 1) {
                        cabin2 = "Economy";
                    }
                    else if (bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getCabinClass() != 2) {
                        if (bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getCabinClass() == 3) {
                            cabin2 = "Business";
                        }
                        else if (bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getCabinClass() == 4) {
                            cabin2 = "First";
                        }
                    }
                    buffer.append("<td style='text-align:right;font-size:14px;font-weight:550;padding:5px;color:#444444'>Class : <span style='font-size:13px;font-weight:400;'>" + cabin2 + "</span></td>");
                    buffer.append("</tr>");
                    buffer.append("<tr>");
                    buffer.append("<td style='padding:5px;color:#666666;'>" + depFroDateStr2 + "," + depFroTimeStr2 + "</td>");
                    try {
                        buffer.append("<td style='text-align:center;padding:5px;color:#666666;'><img src='https://www.ebooktrip.com/resources/images/clocko.png' width='14px;' height='14px;'>" + Utility.timeConversion((int)bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getEft()) + "</td>");
                    }
                    catch (Exception e4) {
                        buffer.append("<td style='text-align:center;padding:5px;color:#666666;'></td>");
                    }
                    buffer.append("<td style='text-align:right;padding:5px;color:#666666;'>" + depToDateStr2 + "," + depToTimeStr2 + "</td>");
                    buffer.append("</tr>");
                    buffer.append("<tr>");
                    buffer.append("<td style='padding:5px;color:#17252A;font-weight:550;'>" + bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getFromAirport() + "<span style='font-weight:400;color:#444444;'>(" + bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getFroCityName() + ")</span></td>");
                    buffer.append("<td style='text-align:center;padding:5px;'><img src='https://www.ebooktrip.com/resources/images/rightarrow.png' width='30px;' height='30px;'></td>");
                    buffer.append("<td style='padding:5px;color:#17252A;font-weight:550;text-align:right;'>" + bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getToAirport() + "<span style='font-weight:400;color:#444444'>(" + bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getToCityName() + ")</span></td>");
                    buffer.append("</tr>");
                    buffer.append("<tr>");
                    buffer.append("<td style='font-size:15px;padding:0 5px;color:#444444'>" + bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getFromAirportName() + "</td>");
                    buffer.append("<td style='text-align:center;font-size:14px;font-weight:550;padding:0 5px;color:#444444'>Non-Stop</td>");
                    buffer.append("<td style='text-align:right;font-size:15px;padding:0 5px;color:#444444'>" + bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getToAirportName() + "</td>");
                    buffer.append("</tr>");
                    buffer.append("<tr style='height:10px;'></tr>");
                    try {
                        if (bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getLayOverTime() > 0) {
                            buffer.append("<tr style='height:30px;'>");
                            buffer.append("<td><hr style='border:dashed #999999;border-width:0 0 1px 0'></td>");
                            buffer.append("<td style='text-align:center;color:#666666;font-size:13px;font-weight:500;'><img src='/resources/images/clocko.png' width='13px;' height='13px;'> " + Utility.timeConversion((int)bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getLayOverTime()) + " layover in " + bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getToCityName() + " (" + bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getToAirport() + ")</td>");
                            buffer.append("<td><hr style='border:dashed #999999;border-width:0 0 1px 0'></td>");
                            buffer.append("</tr>");
                        }
                    }
                    catch (Exception ex3) {}
                }
            }
        }
        buffer.append("</table>");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td colspan='2' style='background-color:#FF4500;padding-left:15px;font-size:20px;color:#ffffff;font-weight:550;height:35px'>");
        buffer.append("Traveler(s) Details");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td colspan='2'>");
        buffer.append("<table width='100%' border='0' cellpadding='0' cellspacing='0' style='font-family:Arial, Helvetica, sans-serif;padding:5px 0px;'>");
        buffer.append("<tr style='background-color:#dddddd;text-align:center;font-weight:550;'>");
        buffer.append("<td style='padding:5px;'>S.No.</td>");
        buffer.append("<td style='padding:5px;'>Name</td>");
        buffer.append("<td style='padding:5px;'>Gender</td>");
        buffer.append("<td style='padding:5px;'>DOB</td>");
        buffer.append("</tr>");
        for (int k = 0; k < bookingRequest.getPassengerDetails().size(); ++k) {
            buffer.append("<tr style='background-color:#ffffff;text-align:center;font-weight:400;'>");
            buffer.append("<td style='padding:5px;'>" + (k + 1) + "</td>");
            buffer.append("<td style='padding:5px;'>" + bookingRequest.getPassengerDetails().get(k).getFirstName() + " " + bookingRequest.getPassengerDetails().get(k).getMiddleName() + " " + bookingRequest.getPassengerDetails().get(k).getLastName() + "</td>");
            if (bookingRequest.getPassengerDetails().get(k).getGender() == 1) {
                buffer.append("<td style='padding:5px;'>Male</td>");
            }
            else {
                buffer.append("<td style='padding:5px;'>Female</td>");
            }
            buffer.append("<td style='padding:5px;'>" + bookingRequest.getPassengerDetails().get(k).getDobDay() + "-" + this.getMonthName(bookingRequest.getPassengerDetails().get(k).getDateOfMonth()) + "-" + bookingRequest.getPassengerDetails().get(k).getDateOfYear() + "</td>");
            buffer.append("</tr>");
        }
        buffer.append("</table>");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td colspan='2' style='background-color:#FF4500;padding-left:15px;font-size:20px;color:#ffffff;font-weight:550;height:35px'>");
        buffer.append("Contact Details");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td colspan='2'>");
        buffer.append("<table width='100%' border='0' cellpadding='0' cellspacing='0' style='font-family:Arial, Helvetica, sans-serif;padding:5px 0px;'>");
        buffer.append("<tr style='background-color:#dddddd;text-align:center;font-weight:550;'>");
        buffer.append("<td style='padding:5px;'>Billing Phone</td>");
        buffer.append("<td style='padding:5px;'>Alternate Phone</td>");
        buffer.append("<td style='padding:5px;'>Email</td>");
        buffer.append("</tr>");
        buffer.append("<tr style='background-color:#ffffff;text-align:center;font-weight:400;'>");
        buffer.append("<td style='padding:5px;'>" + bookingRequest.getPhoneNo() + "</td>");
        buffer.append("<td style='padding:5px;'>" + bookingRequest.getMobileNo() + "</td>");
        buffer.append("<td style='padding:5px;'>" + bookingRequest.getEmailID() + "</td>");
        buffer.append("</tr>");
        buffer.append("</table>");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td colspan='2' style='background-color:#FF4500;padding-left:15px;font-size:20px;color:#ffffff;font-weight:550;height:35px'>");
        buffer.append("Price Details");
        buffer.append("</td>");
        buffer.append("</tr>");
        final DecimalFormat format = new DecimalFormat("#0.00");
        final double adultTotal = bookingRequest.getFlightResult().getFare().getAdultFare() + bookingRequest.getFlightResult().getFare().getAdultMarkup() + bookingRequest.getFlightResult().getFare().getAdultTax();
        final double childTotal = bookingRequest.getFlightResult().getFare().getChildFare() + bookingRequest.getFlightResult().getFare().getChildMarkup() + bookingRequest.getFlightResult().getFare().getChildTax();
        final double infantTotal = bookingRequest.getFlightResult().getFare().getInfantFare() + bookingRequest.getFlightResult().getFare().getInfantMarkup() + bookingRequest.getFlightResult().getFare().getInfantTax();
        final double infantWsTotal = bookingRequest.getFlightResult().getFare().getInfantWsFare() + bookingRequest.getFlightResult().getFare().getInfantWsMarkup() + bookingRequest.getFlightResult().getFare().getInfantWsTax();
        buffer.append("<tr>");
        buffer.append("<td colspan='2'>");
        buffer.append("<table width='100%' border='0' cellpadding='0' cellspacing='0' style='font-family:Arial, Helvetica, sans-serif;padding:5px 10px;'>");
        buffer.append("<tr style='color:#17252A;font-weight:550'>");
        buffer.append("<td style='padding:5px;'><span>" + searchRequest.getAdults() + "</span> Traveler(s): <span>Adult</span></td>");
        buffer.append("<td style='padding:5px;text-align:right;'>$" + format.format(adultTotal * searchRequest.getAdults()) + "</td>");
        buffer.append("</tr>");
        buffer.append("<tr style='color:#17252A;font-weight:400;font-size:14px;'>");
        buffer.append("<td style='padding:5px;'>Flight Charges per adult</td>");
        buffer.append("<td style='padding:5px;text-align:right;'>$" + format.format(bookingRequest.getFlightResult().getFare().getAdultFare() + bookingRequest.getFlightResult().getFare().getAdultMarkup() + bookingRequest.getFlightResult().getFare().getAdultTax()) + "</td>");
        buffer.append("</tr>");
        if (searchRequest.getChild() > 0) {
            buffer.append("<tr>");
            buffer.append("<td colspan='2'><hr></td>");
            buffer.append("</tr>");
            buffer.append("<tr style='color:#17252A;font-weight:550'>");
            buffer.append("<td style='padding:5px;'><span>" + searchRequest.getChild() + "</span> Traveler(s): <span>Child</span></td>");
            buffer.append("<td style='padding:5px;text-align:right;'>$" + format.format(searchRequest.getChild() * childTotal) + "</td>");
            buffer.append("</tr>");
            buffer.append("<tr style='color:#17252A;font-weight:400;font-size:14px;'>");
            buffer.append("<td style='padding:5px;'>Flight Charges per Child</td>");
            buffer.append("<td style='padding:5px;text-align:right;'>$" + format.format(bookingRequest.getFlightResult().getFare().getChildFare() + bookingRequest.getFlightResult().getFare().getChildMarkup() + bookingRequest.getFlightResult().getFare().getChildTax()) + "</td>");
            buffer.append("</tr>");
        }
        if (searchRequest.getInfants() > 0) {
            buffer.append("<tr>");
            buffer.append("<td colspan='2'><hr></td>");
            buffer.append("</tr>");
            buffer.append("<tr style='color:#17252A;font-weight:550'>");
            buffer.append("<td style='padding:5px;'><span>" + searchRequest.getInfants() + "</span> Traveler(s): <span>Infant</span></td>");
            buffer.append("<td style='padding:5px;text-align:right;'>$" + format.format(searchRequest.getInfants() * infantTotal) + "</td>");
            buffer.append("</tr>");
            buffer.append("<tr style='color:#17252A;font-weight:400;font-size:14px;'>");
            buffer.append("<td style='padding:5px;'>Flight Charges per Infant</td>");
            buffer.append("<td style='padding:5px;text-align:right;'>$" + format.format(bookingRequest.getFlightResult().getFare().getInfantFare() + bookingRequest.getFlightResult().getFare().getInfantMarkup() + bookingRequest.getFlightResult().getFare().getInfantTax()) + "</td>");
            buffer.append("</tr>");
        }
        if (searchRequest.getInfantsWs() > 0) {
            buffer.append("<tr>");
            buffer.append("<td colspan='2'><hr></td>");
            buffer.append("</tr>");
            buffer.append("<tr style='color:#17252A;font-weight:550'>");
            buffer.append("<td style='padding:5px;'><span>" + searchRequest.getInfantsWs() + "</span> Traveler(s): <span>Infant(WS)</span></td>");
            buffer.append("<td style='padding:5px;text-align:right;'>$" + format.format(searchRequest.getInfantsWs() * infantWsTotal) + "</td>");
            buffer.append("</tr>");
            buffer.append("<tr style='color:#17252A;font-weight:400;font-size:14px;'>");
            buffer.append("<td style='padding:5px;'>Flight Charges per Infant(WS)</td>");
            buffer.append("<td style='padding:5px;text-align:right;'>$" + format.format(bookingRequest.getFlightResult().getFare().getInfantFare() + bookingRequest.getFlightResult().getFare().getInfantMarkup() + bookingRequest.getFlightResult().getFare().getInfantTax()) + "</td>");
            buffer.append("</tr>");
        }
        double tgPrice = 0.0;
        double pdpPrice = 0.0;
        double taPrice = 0.0;
        if (bookingRequest.getTravelGuard().equalsIgnoreCase("Yes")) {
            tgPrice = bookingRequest.getTravelGuardCost();
            buffer.append("<tr style='color:#17252A;font-weight:550'>");
            buffer.append("<td style='padding:5px;'> Travel Guard Insurance </td>");
            buffer.append("<td style='padding:5px;text-align:right;'>$" + format.format(bookingRequest.getTravelGuardCost()) + "</td>");
            buffer.append("</tr>");
        }
        if (bookingRequest.getPriceDropTaken().equalsIgnoreCase("Yes")) {
            pdpPrice = bookingRequest.getPriceDropAmount();
            buffer.append("<tr style='color:#17252A;font-weight:550'>");
            buffer.append("<td style='padding:5px;'> Price Drop Protection </td>");
            buffer.append("<td style='padding:5px;text-align:right;'>$" + format.format(bookingRequest.getPriceDropAmount()) + "</td>");
            buffer.append("</tr>");
        }
        if (bookingRequest.getTravelAssistTaken().equalsIgnoreCase("Yes")) {
            taPrice = bookingRequest.getTravelAssistAmount();
            buffer.append("<tr style='color:#17252A;font-weight:550'>");
            buffer.append("<td style='padding:5px;'> Travel Assist </td>");
            buffer.append("<td style='padding:5px;text-align:right;'>$" + format.format(bookingRequest.getTravelAssistAmount()) + "</td>");
            buffer.append("</tr>");
        }
        buffer.append("<tr style='color:#17252A;font-weight:550;background-color:#eeeeee;'>");
        buffer.append("<td style='padding:5px;'>Final Total</td>");
        buffer.append("<td style='padding:5px;text-align:right;'>$" + format.format(bookingRequest.getFlightResult().getFare().getGrandTotal() + tgPrice + pdpPrice + taPrice) + "</td>");
        buffer.append("</tr>");
        buffer.append("<tr style='text-align:left;font-size:13px;color:#333;'>");
        buffer.append("<td colspan='2' style='padding:5px;'><b>NOTE:</b> All Fares displayed are quoted in USD and inclusive of base fare, taxes and all fees. Additional baggage fees may apply as per the airline policies. Fares are not Guaranteed and are subject to change until Tickets are issued.</td>");
        buffer.append("</tr>");
        buffer.append("</table>");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td colspan='2'><hr></td>");
        buffer.append("</tr>");
        buffer.append("<tr style='text-align:center;font-weight:550;'>");
        buffer.append("<td style='padding-top:20px;'>");
        buffer.append("<a href='https://www.ebooktrip.com/privacy-policy' target='_blank' style='color:#FF4500;text-decoration:none;'>Privacy Policy</a>");
        buffer.append("</td>");
        buffer.append("<td style='padding-top:20px;'>");
        buffer.append("<a href='https://www.ebooktrip.com/contactus' target='_blank' style='color:#FF4500;text-decoration:none;'>Support</a>");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr style='text-align:center;font-size:14px;color:#666666'>");
        buffer.append("<td style='padding:20px 15px 0 15px;'>");
        buffer.append("We are dedicated towards protecting your privacy. See our privacy policy for details.");
        buffer.append("</td>");
        buffer.append("<td style='padding:20px 15px 0 15px;'>");
        buffer.append("Contact our customer support team by phone & email 24x7 Toll Free 1-800-404-0025.");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr style='text-align:center;font-size:18px;color:#666666;font-weight:500;'>");
        buffer.append("<td colspan='2' style='padding-top:40px'>");
        buffer.append("Flight Booking Terms & Policies");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td colspan='2'>");
        buffer.append("<table width='100%' border='0' cellpadding='0' cellspacing='0' style='font-family:Arial, Helvetica, sans-serif;padding:5px 20px;font-size:14px;color:#999999;font-weight:400;'>");
        buffer.append("<tr>");
        buffer.append("<td colspan='2' style='padding:5px'>");
        buffer.append("<b>Note:</b> Amount can be charged in separate transitions not exceeding the total.");
        buffer.append("Amount can be charged on the payment gateway E-BookTrip or " + bookingRequest.getFlightResult().getOutBound().get(0).getAirlineName() + " as a part of taxes and fees");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("</table>");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td colspan='2'>");
        buffer.append("<table width='100%' border='0' cellpadding='0' cellspacing='0' style='padding:5px 20px;'>");
        buffer.append("<tr>");
        buffer.append("<td width='100%' colspan='2' style='color:#666666;font-size:17px;font-weight:500;padding:10px 0;'>Checked bags</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
        buffer.append("Please check with the airline(s) that you are traveling on to make sure that you are prepared for any extra baggage fees. Some airlines will charge for carry-ons as well as checked baggage. Baggage fees range from $15 up to $200 or more depending on the size and weight of the bag and is per checked bag. These fees are to be paid directly to airline upon using such service");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td width='100%' colspan='2' style='color:#666666;font-size:17px;font-weight:500;padding:10px 0;'>Fare terms and conditions</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;'>");
        buffer.append("This fare cannot be applied to tickets already purchased. Tickets are non-transferable and non-refundable unless otherwise stated.");
        buffer.append("Changes are permitted but airlines penalty and fare difference may apply. Please check the names and the flight details. Name changes are not permitted.");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td width='100%' colspan='2' style='color:#666666;font-size:17px;font-weight:500;padding:10px 0;'>Visa information and Travel Document</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;'>");
        buffer.append("It is the responsibility of passengers to ensure that their travel documents are valid and that they hold all necessary visas and medical certificates for entry into their destination.");
        buffer.append("The Airlines reserve the right to refuse carriage if passengers fail to comply with such requirements. We will not be liable for any loss or expenses incurred by the passenger as a result of the passenger being refused entry into their destination.");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td width='100%' colspan='2' style='color:#666666;font-size:17px;font-weight:500;padding:10px 0;'>Schedule Change and Flight Cancellation</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;'>");
        buffer.append("Airline Policy on Schedule Changes: Airlines all have differing rules and policies regarding schedule changes. Due to the operational needs of each airline they often make changes to the flights that they are currently operating.");
        buffer.append("Reasons for Cancellations or Schedule Changes: a) Peak or high travel seasons b) Low travel season c) Airport Terminal or Gate changes d) Fuel Prices e) Civil Unrest f) Acts of God - volcano, earthquakes, hurricanes, Strom, Bad Weather etc. g) Bankruptcy etc.");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;padding:10px 0;'>");
        buffer.append("Ebooktrip.com does not assume any liability whatsoever for canceled flights, flights that are missed, or flights not connecting due to any scheduled changes made by the airlines.");
        buffer.append("Our policy on schedule changes: We make every attempt to notify the customer of any schedule changes. It is always best to contact the airline to reconfirm your flights within 72 hours of departure.");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;padding:10px 0;'>");
        buffer.append("<b>DISCLAIMER:</b> This transmission is intended only for the use of the individual or entity to which it is addressed. It may contain privileged and/or confidential information.");
        buffer.append("If the reader of this message is not the recipient, you are hereby notified that any disclosure, distribution or copying of this information is strictly prohibited.");
        buffer.append("In addition, any confidential information contained in this transmission must be safeguarded against unauthorized release.");
        buffer.append("If you receive this in error, please contact the sender and delete the material from your computer.");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;padding:10px 0;'>");
        buffer.append("Please don't print this e-mail unless you really need to. Save paper and the environment");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("</table>");
        buffer.append("</td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td colspan='2'><hr></td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        buffer.append("<td colspan='2' style='text-align:center;padding:3%;color:#17252A;font-size:15px;'>© Copyright 2021-2022 All right Reserved ebooktrip.com</td>");
        buffer.append("</tr>");
        buffer.append("</table>");
        buffer.append("</body>");
        buffer.append("</html>");
        return buffer.toString();
    }
    
    public String buildContactEmail(final ContactForm form) {
        final StringBuffer buffer = new StringBuffer();
        buffer.append("First Name : " + form.getFirstName() + "<br>");
        buffer.append("Last Name : " + form.getLastName() + "<br>");
        buffer.append("Email : " + form.getEmail() + "<br>");
        buffer.append("Phone : " + form.getPhone() + "<br>");
        buffer.append("Message : " + form.getMessage() + "<br>");
        return buffer.toString();
    }
    
    public String getMonthName(final String month) {
        String monthName = "";
        if (month.equalsIgnoreCase("1")) {
            monthName = "Jan";
        }
        else if (month.equalsIgnoreCase("2")) {
            monthName = "Feb";
        }
        else if (month.equalsIgnoreCase("3")) {
            monthName = "Mar";
        }
        else if (month.equalsIgnoreCase("4")) {
            monthName = "Apr";
        }
        else if (month.equalsIgnoreCase("5")) {
            monthName = "May";
        }
        else if (month.equalsIgnoreCase("6")) {
            monthName = "Jun";
        }
        else if (month.equalsIgnoreCase("7")) {
            monthName = "Jul";
        }
        else if (month.equalsIgnoreCase("8")) {
            monthName = "Aug";
        }
        else if (month.equalsIgnoreCase("9")) {
            monthName = "Sep";
        }
        else if (month.equalsIgnoreCase("10")) {
            monthName = "Oct";
        }
        else if (month.equalsIgnoreCase("11")) {
            monthName = "Nov";
        }
        else if (month.equalsIgnoreCase("12")) {
            monthName = "Dec";
        }
        return monthName;
    }
}
