package Default;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entity.EmployeeEntity;
import Repository.AccountRepository;
import Repository.AccountRepositoryImpl;
import Repository.EmployeeRepository;
import Repository.EmployeeRepositorylmpl;




public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//EmployeeRepository employeeRepo = new EmployeeRepositorylmpl();
//		List<EmployeeEntity> ls = new ArrayList();
//		ls = employeeRepo.findAll();
//		for (int i =0; i < ls.size(); i++) {
//			System.out.println(ls.get(i).getEmp_name() + "|" + ls.get(i).getEmail() + "|" + ls.get(i).getPhone() + "|" + ls.get(i).getSalary());
//		}
		AccountRepository a = new AccountRepositoryImpl(); 
		a.login();
		
	}

}
