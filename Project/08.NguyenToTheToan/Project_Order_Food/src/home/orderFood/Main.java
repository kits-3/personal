package home.orderFood;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import home.orderFood.entity.ProductEntity;
import home.orderFood.entity.UserEntity;
import home.orderFood.repository.ProductRepositorylmpl;
import home.orderFood.repository.UserRepositorylmpl;
import home.orderFood.repository.storeRepositorylmpl;
import home.orderFood.entity.storeEntity;
public class Main {
	/*-------------main *--------------------*/
	
	public static void main(String[] args) {
		
//		while(true) 
//			{		
//			 		Scanner sc =new Scanner(System.in);
//					System.out.println("Welcome to join our family.");
//					System.out.println("Do you already have an account(Yes/No)?");
//						String register = sc.nextLine();
//						if(register.equals("yes")) {
//							login();
//							store();
//							break;
//						}
//						else{
//							registrationUs();
//							login();
//							store();
//							break;
//						}
//						
//			}	
		store();
	}
   /*--------------------------/Main----------------------------------------------------------------*/
	
	
	static  UserRepositorylmpl push =new UserRepositorylmpl();
	static  Scanner sc = new Scanner(System.in);
	static  UserEntity test=new UserEntity();
	/*-------------------registrationUs---------------------------*/
	public static void registrationUs() {
		 System.out.println("*****************--Registration--***********");
		 System.out.println("*Please enter the Registration form........*");

		 System.out.println("*Please enter your username :..............*");
		 String UserName=sc.nextLine();
		 test.setUserName(UserName);
		 System.out.println("*Please enter your PassWord :..............*");
		 String PassWord=sc.nextLine();
		 test.setPassWordUser(PassWord);
		 System.out.println("*Please enter your Email    :..............*");
		 String Email=sc.nextLine();
		 test.setEmailUser(Email);
		 System.out.println("*Please enter your Phone    :..............*");
		 String Phone=sc.nextLine();
		 test.setPhoneUser(Phone);
		 System.out.println("*Please enter your Full Name:..............*");
		 String FullName=sc.nextLine();
		 test.setFullNameUser(FullName);
		 push.add(test);
		 System.out.println("********************************************");
		
	}
	/*-------------------/registrationUs---------------------------*/
	
	
	/*-------		Login userName--------*/
	public static void  login() 
	{
		
		System.out.println("*****************--Login--******************");
		System.out.println("*Please enter the Login form...............*");
		System.out.println("*Please login your account.................*");
		//Lấy User nhập từ bàn phím
		System.out.println("*Please input your Username:...............*");
		String user = sc.nextLine();
		test.setUserName(user);
		//lấy password nhap từ bàn phím
		System.out.println("*Please input your Password:...............*");
		String pass= sc.nextLine();
		test.setPassWordUser(pass);
		test = push.get(test);
//		System.out.println(test.getUserName());
		if(test.getUserName() != null) {
			System.out.println("login success!!!");
		}else {
			System.out.println("login falid!!");
		}
		System.out.println("********************************************");
		
	}
	/*-------/Login userName--------*/
	
	/*---------------------------select store--------------------------*/
	static String select;
	static String sel;
	
	static  storeEntity testStore=new storeEntity();
	static  storeRepositorylmpl pushStore =new storeRepositorylmpl();
	
	static  ProductEntity testType=new ProductEntity();
	static  ProductRepositorylmpl pushType =new ProductRepositorylmpl();
	
	  static ProductEntity testProduct=new ProductEntity();
		static ProductRepositorylmpl pushProduct =new ProductRepositorylmpl();
	public static void store() {
		
		System.out.println("****************************************************************************");
		System.out.println("*                           Select you want store?:                        *");
		
		List<String> listNameStore = new ArrayList<>();
		 
		
		listNameStore = pushStore.get();
		for (int i = 0; i < listNameStore.size(); i++) {
			System.out.println("*" + i + ". " + listNameStore.get(i) );
		}
		
		System.out.println("*3.Close                                                                   *");
		System.out.println("****************************************************************************");
		System.out.println("Please enter the store of your choice:.........");
		while(true){
					select = sc.next();
					if(select.equals("0")) {
									while(true) {
										System.out.println("you have entered Kentucky Fried Chicken store");
									    System.out.println("-----------------------------------------------------------------------------");
										System.out.println("-           This is Kentucky Fried Chicken 									-");
										System.out.println("-There are the following. Feel free to choose:                              -");
										
										ProductEntity type1=pushType.get(testProduct);
										System.out.println("-1."+type1.getTypeProduct()+"                                                                -");                                                         
										
										
										ProductEntity type2=pushType.get(testProduct);
										System.out.println("-2."+type2.getTypeProduct()+"                                                                -");
										
										
										ProductEntity type3=pushType.get(testProduct);
										System.out.println("-3."+type3.getTypeProduct()+"                                                                -");
										
										System.out.println("-4.Close?                                                                   -");
										System.out.println("-----------------------------------------------------------------------------");
										System.out.println("Please enter the store of your choice:.........");
										 sel = sc.next();
										
										if(sel.equals("1"))
										{				
											  			
														System.out.println("you have entered chicken dishes ");
														System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
														System.out.println("|           This is Chicken dishes                                          |");
														System.out.println("|There are the following. Feel free to choose:                              |");
		
														
														ProductEntity product1=pushProduct.get(testProduct);
														System.out.println("| 1."+product1.getNameProduct()+"                                                            |");
														
														
														ProductEntity product2=pushProduct.get(testProduct);
														System.out.println("| 2."+product2.getNameProduct()+"                                                            |");
														
														
														ProductEntity product3=pushProduct.get(testProduct);
														System.out.println("|3."+product3.getNameProduct()+"                                                             |");
														
														
														System.out.println("|4.Return?                                                                  |");
														System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
										}
										else if(sel.equals("2")) 
										{
											
															System.out.println("you have entered chicken dishes ");
															System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
															System.out.println("|           This is Chicken dishes                                          |");
															System.out.println("|There are the following. Feel free to choose:                              |");
															
															
															
															
															
															ProductEntity product1=pushProduct.get(testProduct);
															System.out.println("| 1."+product1.getNameProduct()+"                                                            |");
															
															
															ProductEntity product2=pushProduct.get(testProduct);
															System.out.println("| 2."+product2.getNameProduct()+"                                                            |");
															
															
															ProductEntity product3=pushProduct.get(testProduct);
															System.out.println("|3."+product3.getNameProduct()+"                                                             |");
															
															
															System.out.println("|4.Return?                                                                  |");
															System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
											}
										else if(sel.equals("3"))
										{
															System.out.println("you have entered chicken dishes ");
															System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
															System.out.println("|           This is Chicken dishes                                          |");
															System.out.println("|There are the following. Feel free to choose:                              |");
															
															
															
															
															
															ProductEntity product1=pushProduct.get(testProduct);
															System.out.println("| 1."+product1.getNameProduct()+"                                                            |");
															
															
															ProductEntity product2=pushProduct.get(testProduct);
															System.out.println("| 2."+product2.getNameProduct()+"                                                            |");
															
															
															ProductEntity product3=pushProduct.get(testProduct);
															System.out.println("|3."+product3.getNameProduct()+"                                                             |");
															
															
															System.out.println("|4.Return?                                                                  |");
															System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
											}else if(sel.equals("4")) {
											System.err.println("see you again!!");
											break;
										}
										else 
										{
											System.out.println("There are no types?");
										}
										break;
									}
					}else if(select.equals("1")) {
							while(true) {
												System.out.println("you have entered Kentucky Fried Chicken store");
											    System.out.println("-----------------------------------------------------------------------------");
												System.out.println("-           This is Kentucky Fried Chicken 	store							-");
												System.out.println("-There are the following. Feel free to choose:                              -");
												
												ProductEntity type1=pushType.get(testProduct);
												System.out.println("-1."+type1.getTypeProduct()+"                                                                -");                                                         
												
												
												ProductEntity type2=pushType.get(testProduct);
												System.out.println("-2."+type2.getTypeProduct()+"                                                                -");
												
												
												ProductEntity type3=pushType.get(testProduct);
												System.out.println("-3."+type3.getTypeProduct()+"                                                                -");
												
												System.out.println("-4.Close?                                                                   -");
												System.out.println("-----------------------------------------------------------------------------");
												System.out.println("Please enter the store of your choice:.........");
											sel = sc.next();
											
											
											if(sel.equals("1"))
											{				
												  			
															System.out.println("you have entered chicken dishes ");
															System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
															System.out.println("|           This is Chicken dishes                                          |");
															System.out.println("|There are the following. Feel free to choose:                              |");
			
															
															ProductEntity product1=pushProduct.get(testProduct);
															System.out.println("| 1."+product1.getNameProduct()+"                                                            |");
															
															
															ProductEntity product2=pushProduct.get(testProduct);
															System.out.println("| 2."+product2.getNameProduct()+"                                                            |");
															
															
															ProductEntity product3=pushProduct.get(testProduct);
															System.out.println("|3."+product3.getNameProduct()+"                                                             |");
															
															
															System.out.println("|4.Return?                                                                  |");
															System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
											}
											else if(sel.equals("2")) 
											{
												
																System.out.println("you have entered chicken dishes ");
																System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
																System.out.println("|           This is Chicken dishes                                          |");
																System.out.println("|There are the following. Feel free to choose:                              |");
																
																
																
																
																
																ProductEntity product1=pushProduct.get(testProduct);
																System.out.println("| 1."+product1.getNameProduct()+"                                                            |");
																
																
																ProductEntity product2=pushProduct.get(testProduct);
																System.out.println("| 2."+product2.getNameProduct()+"                                                            |");
																
																
																ProductEntity product3=pushProduct.get(testProduct);
																System.out.println("|3."+product3.getNameProduct()+"                                                             |");
																
																
																System.out.println("|4.Return?                                                                  |");
																System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
												}
											else if(sel.equals("3"))
											{
																System.out.println("you have entered chicken dishes ");
																System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
																System.out.println("|           This is Chicken dishes                                          |");
																System.out.println("|There are the following. Feel free to choose:                              |");
																
																
																
																
																
																ProductEntity product1=pushProduct.get(testProduct);
																System.out.println("| 1."+product1.getNameProduct()+"                                                            |");
																
																
																ProductEntity product2=pushProduct.get(testProduct);
																System.out.println("| 2."+product2.getNameProduct()+"                                                            |");
																
																
																ProductEntity product3=pushProduct.get(testProduct);
																System.out.println("|3."+product3.getNameProduct()+"                                                             |");
																
																
																System.out.println("|4.Return?                                                                  |");
																System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
												}else if(sel.equals("4")) {
												System.err.println("see you again!!");
												break;
											}
											else 
											{
												System.out.println("There are no types?");
											}
											break;
										}	
					}else if(select.equals("2")) {
								while(true) {
									System.out.println("you have entered Kentucky Fried Chicken store");
								    System.out.println("-----------------------------------------------------------------------------");
									System.out.println("-           This is Kentucky Fried Chicken 									-");
									System.out.println("-There are the following. Feel free to choose:                              -");
									
									ProductEntity type1=pushType.get(testProduct);
									System.out.println("-1."+type1.getTypeProduct()+"                                                                -");                                                         
									
									
									ProductEntity type2=pushType.get(testProduct);
									System.out.println("-2."+type2.getTypeProduct()+"                                                                -");
									
									
									ProductEntity type3=pushType.get(testProduct);
									System.out.println("-3."+type3.getTypeProduct()+"                                                                -");
									
									System.out.println("-4.Close?                                                                   -");
									System.out.println("-----------------------------------------------------------------------------");
									System.out.println("Please enter the store of your choice:.........");
											sel = sc.next();
							
											
											if(sel.equals("1"))
											{				
												  			
															System.out.println("you have entered chicken dishes ");
															System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
															System.out.println("|           This is Chicken dishes                                          |");
															System.out.println("|There are the following. Feel free to choose:                              |");
			
															
															ProductEntity product1=pushProduct.get(testProduct);
															System.out.println("| 1."+product1.getNameProduct()+"                                                            |");
															
															
															ProductEntity product2=pushProduct.get(testProduct);
															System.out.println("| 2."+product2.getNameProduct()+"                                                            |");
															
															
															ProductEntity product3=pushProduct.get(testProduct);
															System.out.println("|3."+product3.getNameProduct()+"                                                             |");
															
															
															System.out.println("|4.Return?                                                                  |");
															System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
											}
											else if(sel.equals("2")) 
											{
												
																System.out.println("you have entered chicken dishes ");
																System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
																System.out.println("|           This is Chicken dishes                                          |");
																System.out.println("|There are the following. Feel free to choose:                              |");
																
																
																
																
																
																ProductEntity product1=pushProduct.get(testProduct);
																System.out.println("| 1."+product1.getNameProduct()+"                                                            |");
																
																
																ProductEntity product2=pushProduct.get(testProduct);
																System.out.println("| 2."+product2.getNameProduct()+"                                                            |");
																
																
																ProductEntity product3=pushProduct.get(testProduct);
																System.out.println("|3."+product3.getNameProduct()+"                                                             |");
																
																
																System.out.println("|4.Return?                                                                  |");
																System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
												}
											else if(sel.equals("3"))
											{
																System.out.println("you have entered chicken dishes ");
																System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
																System.out.println("|           This is Chicken dishes                                          |");
																System.out.println("|There are the following. Feel free to choose:                              |");
																
																
																
																
																
																ProductEntity product1=pushProduct.get(testProduct);
																System.out.println("| 1."+product1.getNameProduct()+"                                                            |");
																
																
																ProductEntity product2=pushProduct.get(testProduct);
																System.out.println("| 2."+product2.getNameProduct()+"                                                            |");
																
																
																ProductEntity product3=pushProduct.get(testProduct);
																System.out.println("|3."+product3.getNameProduct()+"                                                             |");
																
																
																System.out.println("|4.Return?                                                                  |");
																System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
												}else if(sel.equals("4")) {
												System.err.println("see you again!!");
												break;
											}
											else 
											{
												System.out.println("There are no types?");
											}
											break;
								}			
					}else if(select.equals("3")) {
						System.err.println("see you again!!");
						break;
					}else {
						System.err.println("No store name like that?");
					}
					
		}
		
		
	}
	


	


	


	/*---------------------------/selectstore-------------------------*/
	public static void selectproduct() {
		System.out.println("select you want product?:");
		
	}
}
