package kits.learnvocab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kits.learnvocab.dao.LanguageDao;
import kits.learnvocab.dao.TopicDao;
import kits.learnvocab.dto.LanguageDto;
import kits.learnvocab.dto.TopicDto;

public class Main {
	public static void main(String[] args) {
		LanguageDto ladto = new LanguageDto();
		LanguageDao ladao = new LanguageDao();
		
		//----find all----//
//		List<LanguageDto> ls = new ArrayList();
//		ls = ladao.findAll();	
//		System.out.println("there are all your language: ");
//		System.out.println("id \t lang");
//		for (int i =0; i < ls.size(); i++) {
//			
//			System.out.println(ls.get(i).getId()+"\t"+ls.get(i).getLang());
//		}
		//----add----//
		
		//ladto.setId(9);
		
		
		
		//ladao.add(ladto);
		//ladao.delete(ladto);1
		
		
		
		//----delete----//
		//tpdao.delete(tpdto);
		
		//ladao.update(ladto);
		
		Login lg = new Login();
		SignUp su = new SignUp();
		System.out.println("-------Welcome to my Learn Vocabulary APP-------");
		System.out.println("Press 1 to login, 2 to signup");
		Scanner sc = new Scanner(System.in);
		String input= sc.next();
		if(input.equals("1")) {
			lg.Login();
		}else if (input.equals("2")) {
			su.Sign_Up();
		}else {
			System.out.println("Bye");
			System.out.println("맛있게 드세요");
			System.exit(0);
			
		}
		
		
		
	}
	
	
}

