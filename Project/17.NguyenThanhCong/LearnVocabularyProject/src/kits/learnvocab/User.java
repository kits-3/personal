package kits.learnvocab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kits.learnvocab.dao.LanguageDao;
import kits.learnvocab.dao.NewDao;
import kits.learnvocab.dao.TopicDao;
import kits.learnvocab.dto.LanguageDto;
import kits.learnvocab.dto.NewDto;
import kits.learnvocab.dto.TopicDto;

public class User implements  FunctionUser {
static int b;
		User(){
			
			b  = chooseLanguage();
			int c = 0;
			c = chooseTopic(b);
			System.out.println("Press 1 to learn by flashcard, press 2 to learn by writting");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			if(input == 1) {
				display(b, c);	
			}else if(input == 2){
				display1(b, c);
			}
			
		}
		@Override
		public void display(int b, int c) {
			NewDto newDto = new NewDto();
			NewDao newDao = new NewDao();
			List<NewDto> ls = new ArrayList();
			ls = newDao.findByLang_Topic(b,c);
			for (NewDto i : ls) {
				//System.out.println(i.getId() + ": " + i.getName() + ": " + i.getName_vn());
				System.out.println(i.getName_vn());
				System.out.println("Press y to know mean");
				Scanner sc = new Scanner(System.in);
				String input =  sc.next();
				if(input.equals("y")) {
					System.out.println(i.getName());
					System.out.println("Continue ? ");
					System.out.println("Press y to continue");
					input = sc.next();
					if(input.equals("y")) {
						continue;
						
					}else {
						System.out.println("Are you sure to want end ? ");
						System.out.println("Press n to turn back ");
						Scanner sc2 = new Scanner(System.in);
						String input2  = sc2.next();
						if(input2.equals("n")) {
							
							continue;
							
						}else {
							wannaEnd();
						}
					}
				}else if(input.equals("y")) {
					wannaEnd();
				}
				
			}
			endList();
	}
		@Override
		public void otherLanguage() {
			int b = 0;
			b  = chooseLanguage();
			int c = 0;
			c = chooseTopic(b);
			System.out.println("Press 1 to learn by flashcard, press 2 to learn by writting");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			if(input == 1) {
				display(b, c);	
			}else if(input == 2){
				display1(b, c);
			}	
		}
		@Override
		public void otherTopic(int b) {
			
			int c = 0;
			c = chooseTopic(b);
			System.out.println("Press 1 to learn by flashcard, press 2 to learn by writting");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			if(input == 1) {
				display(b, c);	
			}else if(input == 2){
				display1(b, c);
			}	
		}
		@Override
		public void endList() {
			System.out.println("End list. Wanna continue ? ");
			Scanner sc = new Scanner(System.in);
			String input  = sc.next();
			if(input.equals("y")) {
				System.out.println("Return choose language or topic");
				System.out.println("Press 1 to return choose language, press 2 to return choose topic");
				if (sc.next().equals("1")) {
					otherLanguage();
				}
				else if(sc.next().equals("1")) {
					otherTopic(b);
				}
			}else {
				wannaEnd();
			}
		}
		@Override
		public void display1(int b, int c) {
			NewDto newDto = new NewDto();
			NewDao newDao = new NewDao();
			List<NewDto> ls = new ArrayList();
			ls = newDao.findByLang_Topic(b,c);
			for (NewDto i : ls) {
				//System.out.println(i.getId() + ": " + i.getName() + ": " + i.getName_vn());
				System.out.println(i.getName_vn());
				System.out.println("Type mean this word");
				Scanner sc = new Scanner(System.in);
				String input =  sc.next();
				if(input.equals(i.getName())) {
					System.out.println("That right !");
					System.out.println("This word "+ i.getName_vn()+ ": mean "+ i.getName());
					System.out.println("Wanna continue ? ");
					System.out.println("Press y to continue");
					input = sc.next();
					if(input.equals("y")) {
						continue;
					}else {
						wannaEnd();
					}
				}else  {
					System.out.println("Wrong !");
					System.out.println("This word: "+ i.getName_vn()+ ": mean "+ i.getName());
					System.out.println("Wanna continue ? ");
					System.out.println("Press y to continue");
					input = sc.next();
					if(input.equals("y")) {
						continue;
					}else {
						wannaEnd();
					}			
				}					
			}
			endList();	
	}
		@Override
		public void wannaEnd(){
			Scanner sc = new Scanner(System.in);
			System.out.println("Wanna end ? y/n");
			if(sc.next().equals("y")) {
				System.out.println("Thank you to use this app");
				System.out.println("Bye Bye");
				System.out.println("맛있게 드세요");
				System.exit(0);			
			}else {
				System.out.println("Return choose language or topic");
				System.out.println("Press 1 to return choose language, press 2 to return choose topic");
				if (sc.next().equals("1")) {
					otherLanguage();
				}
				else if(sc.next().equals("1")) {
					otherTopic(b);
				}
			}
		}
	
		@Override
		 public int chooseTopic(int a) {
				Scanner sc = new Scanner(System.in);
				TopicDto tpdto = new TopicDto();
				TopicDao tpdao = new TopicDao();
				List<TopicDto> ls = new ArrayList();
				
				ls = tpdao.findAll();		
				for (int i =0; i < ls.size(); i++) {
					int j = i+1;
					System.out.println(  ls.get(i).getId()+"\t"+ ls.get(i).getName());
				}
				int choose = sc.nextInt();
				return choose;
				
			}
		@Override
		public int chooseLanguage() {
			Scanner sc = new Scanner(System.in);
			LanguageDto ladto = new LanguageDto();
			LanguageDao ladao = new LanguageDao();
			List<LanguageDto> ls = new ArrayList();
			
			ls = ladao.findAll();		
			for (int i =1; i < ls.size(); i++) {
				
				System.out.print("Choose " + ls.get(i).getLang()+ " press " + i + "\t");
			}
			int choose = sc.nextInt()+1;
			return choose;
		}
	
		
	
}
