package com.capgemini.forestmanagement.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
	public static boolean isStringOnlyAlphabet(String str) 
	{ 
		return ((str != null) 
				&& (!str.equals("")) 
				&& (str.matches("^[a-zA-Z]*$"))); 
	}

	public static boolean isEmail(String email) 
	{  
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
				"[a-zA-Z0-9_+&*-]+)*@" + 
				"(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
				"A-Z]{2,7}$"; 

		Pattern pat = Pattern.compile(emailRegex); 
		if (email == null) { 
			return false; } else {

				return pat.matcher(email).matches(); 
			}
	} 

	public static boolean isValidDate(String d) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		try {
			Date date = sdf.parse(d); //if date invalid throw exception
			Date today = new Date();
			return date.before(today); //return false if future date
			} catch (Exception e) {
				return true;
			}
	}

	public static boolean isNumber(String num) {
		if (num.matches("[0-9]+")) {
			return true;
		}
		return false;

	} 
	

	public static boolean validPhone(String num) {
		String phoneRegex ="^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$";

		Pattern pattern = Pattern.compile(phoneRegex);
		if(num==null) {
			return false;   
		}
		return pattern.matcher(num).matches();
	}
	
	public static boolean isValidDateFormat(String d) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		try {
			Date date = sdf.parse(d); 
			return true;
			} catch (Exception e) {
				return false;
			}
	}
	
	
	
//	public static void main(String[] args) {
//		while(true) {
//			Scanner sc= new Scanner(System.in);
//			System.out.println("enter date");
//			String date= sc.next();
//			System.out.println(isValidDate(date));
//		}
//	}
}
