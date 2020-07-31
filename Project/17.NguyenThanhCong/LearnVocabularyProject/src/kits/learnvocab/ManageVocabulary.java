package kits.learnvocab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kits.learnvocab.dao.ConnectWordDao;
import kits.learnvocab.dao.LanguageDao;
import kits.learnvocab.dao.TopicDao;
import kits.learnvocab.dao.WordVnDao;
import kits.learnvocab.dto.ConnectWordDto;
import kits.learnvocab.dto.LanguageDto;
import kits.learnvocab.dto.TopicDto;
import kits.learnvocab.dto.WordvnDto;

public class ManageVocabulary implements FunctionAdmin{
	static int b,c, id;
	static String topicAdd;
	
	@Override
	public void manageLanguage() {
		LanguageDto ladto = new LanguageDto();
		LanguageDao ladao = new LanguageDao();
		List<LanguageDto> ls = new ArrayList();
		ls = ladao.findAll();
		System.out.println("There are all your language: ");
		System.out.println("id \t lang");
		for (int i =0; i < ls.size(); i++) {
			System.out.println(ls.get(i).getId()+"\t"+ls.get(i).getLang());
		}
		System.out.println("Press 1 to Add language, press 2 to delete language, "
				+ "press 3 to update language");
		
		Scanner sc = new Scanner(System.in);
		String choose = sc.next();
		if(choose.equals("1")) {
			ladao.add(ladto);
			wannaContinue();
		}
		else if(choose.equals("2")) {
			ladao.delete(ladto);
			wannaContinue();
		}
		else if(choose.equals("3")) {
			ladao.update(ladto);
			wannaContinue();
		}else {
			System.out.println("맛있게 드세요");
			System.exit(0);
		}
	}
	@Override
	public void wannaContinue() {
		System.out.println("Wanna cotinue or end y/n");
		Scanner sc1 = new Scanner(System.in);
		String choose1  = sc1.next();
		if(choose1.equals("y")) {
		
			manage();
		}else {
			System.out.println("Have a good day !!!");
			System.out.println("See u again");
			System.out.println("맛있게 드세요");
			System.exit(0);
		}
	}
	@Override
	public void manageTopic() {
		TopicDto tpdto = new TopicDto();
		TopicDao tpdao = new TopicDao();
		List<TopicDto> ls = new ArrayList();
		ls = tpdao.findAll();
		System.out.println("There are all your topic: ");
		System.out.println("ID \t topic's name");
		for (int i =0; i < ls.size(); i++) {
			System.out.println(ls.get(i).getId()+"\t"+ls.get(i).getName());
		}
		System.out.println("Press 1 to Add topic, press 2 to delete topic, "
				+ "press 3 to update topic");
		
		Scanner sc = new Scanner(System.in);
		String choose = sc.next();
		if(choose.equals("1") ) {
			tpdao.add(tpdto);
			wannaContinue();
		}
		else if(choose.equals("2")) {
			tpdao.delete(tpdto);
			wannaContinue();
		}
		else if (choose.equals("3")) {
			tpdao.update(tpdto);
			wannaContinue();
		}
		else {
			System.out.println("맛있게 드세요");
			System.exit(0);
		}
			
	}
	@Override
	public void manageConnectWord() {
		System.out.println("enter the id of topic ");
		int c = chooseTopic(b);
		c =id;
		ConnectWordDao cwdao = new ConnectWordDao();
		ConnectWordDto cwdto = new ConnectWordDto();
		List<ConnectWordDto> ls = new ArrayList();
		ls = cwdao.findByTopic();
		
		for (ConnectWordDto i : ls) {
			System.out.println(i.getId() +  ": \t" + i.getName() +
					"\t\t" + i.getLang_id() +"\t" + i.getVn_id() );
			
		}
		System.out.println("Press 1 to add new word, 2 to delete word, 3 to update word");
		Scanner sc = new Scanner(System.in);
		String choose = sc.next();
		if(choose.equals("1")) {
			
			cwdto.setTopic_id(c);
			cwdao.addWord_vn(cwdto);
			wannaContinue();
			
		}else if (choose.equals("2")) {
			cwdao.delete(cwdto);
			wannaContinue();
		}else if (choose.equals("3")) {
			cwdao.update(cwdto);
			wannaContinue();
		}
		
	}
	@Override
	public void manageWord_vn() {
		System.out.println("enter the id of topic ");
		int c = chooseTopic(b);
		c =id;
		WordVnDao wvdao = new WordVnDao();
		WordvnDto wvdto = new WordvnDto();
		List<WordvnDto> ls = new ArrayList();
		ls = wvdao.findByTopic(c);
		for (WordvnDto i : ls) {
			System.out.println(i.getId() +  ": " + i.getName());		
		}
		System.out.println("Press 1 to add new word, 2 to delete word, 3 to update word");
		Scanner sc = new Scanner(System.in);
		String choose = sc.next();
		if(choose.equals("1")) {
			
			wvdto.setTopic_id(c);
			wvdao.addWord_vn(wvdto);
			wannaContinue();
			
		}
		else if (choose.equals("2")) {
			wvdao.delete(wvdto);
			wannaContinue();
		}
		else if (choose.equals("3")) {
			wvdao.update(wvdto);
		}

}
	@Override
	 public int chooseTopic(int a) {
		
		 
			Scanner sc = new Scanner(System.in);
			TopicDto tpdto = new TopicDto();
			TopicDao tpdao = new TopicDao();
			
			List<TopicDto> ls = new ArrayList();
			
			ls = tpdao.findAll();	
			System.out.println("id \t topic's name" );
			for (int i =0; i < ls.size(); i++) {
				int j = i+1;
				System.out.println(  ls.get(i).getId()+"\t"+ ls.get(i).getName());
			}
	
			while(checkIdTopic(c)==false) {
				System.out.println("nhap lai");
			}
			
			//int choose = sc.nextInt();
			
			return id;
			
		}
	@Override
		public boolean checkIdTopic(int a) {
			List<TopicDto> ls = new ArrayList();
			TopicDao tpdao = new TopicDao();
			ls = tpdao.findAll();	
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter id");
			id = sc.nextInt();
			
			for (int i =0; i < ls.size(); i++) {
				if(id==ls.get(i).getId()) {			
					return true;
				}		
			}		
			return false;
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
	@Override
		public void manage() {
			System.out.println("Press 1 to manage table language, press 2 to manage table topic, "
					+ "press 3 to manage wordvn, press 4 to manage connectword ");
			Scanner sc = new Scanner(System.in);
			String choose = sc.next();
			ManageVocabulary mv = new ManageVocabulary();
			if(choose.equals("1")) {
				//manageLanguage();
				
				mv.manageLanguage();
			}
			else if (choose.equals("2") ) {
				
				mv.manageTopic();
			}
			else if (choose.equals("3")) {
				
				mv.manageWord_vn();
			}
			else if(choose.equals("4")) {
				mv.manageConnectWord();
			}else {
				System.out.println("Press 1, 2, 3 or 4 :((");
				manage();
			}
		}
	
		
}
