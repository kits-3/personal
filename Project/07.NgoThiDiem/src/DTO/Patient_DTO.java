package DTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patient_DTO {

	
	private  int   id_card;
	private  String  code_patient;
	private  String  name;
	private  int     age;
	private  String  gender;
	private  long  phone;
	private  String  address;
	private  String   registrationDate;
	private  String   dischargeDate;
	private  String   status;		   
// constructor
public  Patient_DTO(int id_card, String  code_patient, String  name, int age, 
String  gender, long phone, String  address,  String  registrationDate, String  dischargeDate, String status 	)
{
	this.id_card = id_card;
	this.code_patient = code_patient;
	this.name = name;
	this.age  = age;
	this.gender = gender;
	this.phone  = phone;
	this.address = address;
	this.registrationDate = registrationDate;
	this.dischargeDate = dischargeDate;

	
}
public Patient_DTO() {
	// TODO Auto-generated constructor stub
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getId_card() {
	return id_card;
}
public void setId_card(int id_card) {
	this.id_card = id_card;
}


public String getCode_patient() {
	return code_patient;
}
public void setCode_patient(String code_patient) {
	this.code_patient = code_patient;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String  getRegistrationDate() {
	return registrationDate;
}
public void setRegistrationDate(String  registrationDate) {
	this.registrationDate = registrationDate;
}
public String  getDischargeDate() {
	return dischargeDate;
}
public void setDischargeDate(String  dischargeDate) {
	this.dischargeDate = dischargeDate;
}

}
