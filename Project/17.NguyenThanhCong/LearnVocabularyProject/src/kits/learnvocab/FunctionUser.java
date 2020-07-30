package kits.learnvocab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kits.learnvocab.dao.NewDao;
import kits.learnvocab.dto.NewDto;

public interface FunctionUser {

	void display(int b, int c) ;
	void otherLanguage() ;
	void otherTopic(int b);
	void endList();
	void display1(int b, int c);
	void wannaEnd();
	int chooseTopic(int a);
	int chooseLanguage();
	
}
