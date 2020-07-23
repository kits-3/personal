package edu.examination.controller;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.examination.dao.InstituationDao;
import edu.examination.dao.impl.InstituationDaoImpl;
import edu.examination.entity.InstituationEntity;

public class RegisterPage {
	
	private Scanner scanner = new Scanner(System.in);
	private InstituationDao instituation;
	private String instiEmailAddress;
	private String instiPassword;
	
	public RegisterPage(){
		instituation = new InstituationDaoImpl();
	}
	public void registerInstituation(){
		System.out.println("==============REGISTER PAGE==============");
		enterEmail();
		enterPasswod();
		instituation.addInstituation(new InstituationEntity(instiEmailAddress, instiPassword));
		System.out.println("REGISTRATION SUCCESSFUL");
	}
	
	private void enterEmail(){
		while(true){
			System.out.print("Enter instituation email: ");
			instiEmailAddress = scanner.nextLine();
			if(isValidEmail(instiEmailAddress)==false){
				System.out.println("THE EMAIL IS NOT VALID. PLEASE ENTER AGAIN!");
				continue;
			}
			
			if(isEmailDuplicated(instiEmailAddress)==true){
				System.out.println("THE EMAIL HAVE EXISTED IN THE SYSTEM. PLEASE ENTER OTHER.");
				continue;
			}
			break;
		}
	}
	
	
	private void enterPasswod(){
		while(true){
			System.out.print("Enter instituation password: ");
			instiPassword = scanner.nextLine();
			if(isValidPassword(instiPassword) == false){
				System.out.println("THE PASSWORD IS NOT VALID. PASSWORD MUST BE AT LEAST 6 CHARACTERS LONG, ONE UPPERCASE, ONE LOWERCASE AND ONE NUMERIC CHARACTER.");
				continue;
			}
			break;
		}	
	}
	
	private boolean isEmailDuplicated(String registeredInstiEmailAddress){
		List<InstituationEntity> instituationList = instituation.getAllInstituations();
		for(InstituationEntity insti : instituationList){
			String currentInstiEmailAddress = insti.getInstiEmailAddress();
			if(currentInstiEmailAddress.equals(registeredInstiEmailAddress)){
				return true;
			}
		}
		return false;
	}
	
	private boolean isValidEmail(String email) {
	      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      return email.matches(regex);
	}
	
	 public boolean isValidPassword(String password){ 	  
        // Regex to check valid password. 
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{6,20}$"; 
  
        // Compile the ReGex 
        Pattern p = Pattern.compile(regex); 
  
        // If the password is empty 
        // return false 
        if (password == null) { 
            return false; 
        } 
  
        // Pattern class contains matcher() method 
        // to find matching between given password 
        // and regular expression. 
        Matcher m = p.matcher(password); 
  
        // Return if the password 
        // matched the ReGex 
        return m.matches(); 
    } 
	
}
