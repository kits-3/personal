package Dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Connection.ConnectionFactory;
import Entity.dictionary_clientDto;
import Entity.languageDto;
import Entity.userDto;
import Entity.wordsDto;
import thread.ThreadDictionary;

public class UserDao {
	static userDto account = new userDto();
	static List<dictionary_clientDto> listDictionary = new ArrayList<dictionary_clientDto>();
	static List<userDto> listUser = new ArrayList<userDto>();
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public UserDao() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public void add(userDto dto) {
		try {
			String queryString = "INSERT INTO " + "user(username,password,roleId,email)" + "VALUES(?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, dto.getUserName());
			ptmt.setString(2, dto.getPassWord());
			ptmt.setInt(3, dto.getRoleId());
			ptmt.setString(4, dto.getEmail());
			ptmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(userDto dto) {
		try {
			String queryString = "update user set password=?," + "roleId=?," + "email=? where username = ?";

			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, dto.getPassWord());
			ptmt.setInt(2, dto.getRoleId());
			ptmt.setString(3, dto.getEmail());
			ptmt.setString(4, dto.getUserName());
			ptmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(String id) {
		try {
			String queryString = "delete from user where username =?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, id);
			ptmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<userDto> findAll() {
		try {
			String queryString = "Select * from user";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			List<userDto> dtoList = new ArrayList<userDto>();
			int i = 0;
			while (resultSet.next()) {
				userDto dto = new userDto();
				dto.setUserName(resultSet.getString("username"));
				dto.setPassWord(resultSet.getString("password"));
				dto.setEmail(resultSet.getString("email"));
				dto.setRoleId(resultSet.getInt("roleId"));
				dtoList.add(dto);
//				System.out.println("User Name : " + resultSet.getString("username")
//				+ "Pass word : " 
//				+ resultSet.getString("password"));
			}

			return dtoList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
					ptmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void showLogin() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Plese enter your username");
		String userName = scan.nextLine();
		System.out.println("Plese enter your password");
		String password = scan.nextLine();
		UserDao uDao = new UserDao();
		userDto dto = uDao.checkLogin(userName, password);
		account = dto;
		if (dto.getUserName() != null) {
			uDao.checkRole(dto.getRoleId(), dto.getUserName());
		}

	}

	public userDto checkLogin(String userName, String password) {
		try {
			userDto dto = new userDto();
			String queryString = "Select * from user";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
//			ptmt.setString(1, userName);
			resultSet = ptmt.executeQuery();
			boolean flag = false;
			while (resultSet.next()) {
				if (resultSet.getString("username").equals(userName)) {
					flag = true;
					if (resultSet.getString("password").equals(password)) {
						System.out.println("Login success");
						dto.setUserName(resultSet.getString("username"));
						dto.setPassWord(resultSet.getString("password"));
						dto.setRoleId(resultSet.getInt("roleId"));
						dto.setEmail(resultSet.getString("email"));
						break;
					}
					System.out.println("wrong password");

				}

			}
			if (dto.getUserName() == null && flag == false) {
				System.out.println("wrong username");
			}
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
					ptmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void checkRole(Integer roleId, String username) {
		if (roleId == 1) {
			System.out.println("Hello" + " " + username + " admin ");
			showAdminArea();

		} else {
			System.out.println("Hello" + " " + username);
			showClientArea();
		}
	}

	public void showAdminArea() {
		Scanner scan = new Scanner(System.in);
		String choose = null;
		boolean exit = false;
		boolean back = false;

		while (true) {
			showOptionAdmin();
			choose = scan.nextLine();
			switch (choose) {
			case "1":
				System.out.println("choose Add new user");
				register();
				showConfirm();
				break;
			case "2":
				System.out.println("choose Find user");
				findUser();
				showConfirm();
				break;
			case "3":
				System.out.println("Update user");
				editAdmin();
				showConfirm();
				break;
			case "4":
				System.out.println("show all words of system");
				showAllWords();
				showConfirm();
				break;
			case "5": 
				System.out.println("choose Add new word");
				addWords();
				showConfirm();
				break;
			case "6":
				System.out.println("choose Edit word");
				updateWord();
				showConfirm();
				break;
			case "7":
				System.out.println("choose Delete word");
				removeWord();
				showConfirm();
				break;
			case "8":
				System.out.println("choose Find one word");
				findWord();
				showConfirm();
				break;
			case "0":
				System.out.println("exited!");
				exit = true;
				back = true;
				break;

			default:
				System.out.println("invalid! please choose action in below menu:");
				break;
			}
			if (exit && back) {
				break;
			}
		}
		return;
	}

	public void removeWord() {
		boolean exist = false;
		while (true) {
			showAllWords();
			Scanner scan = new Scanner(System.in);
			wordsDao wDao = new wordsDao();
			System.out.println("Please enter word you need to delete below");
			String word = scan.nextLine();
			wordsDto dto = wDao.findOne(word);
			if (dto.getContent() != null) {
				wDao.delete(dto.getId());
				System.out.println("delete word success!");
				exist = true;
			} else {
				System.out.println("word not exist! please check agin!");
			}
			if (exist) {
				break;
			}
		}

	}

	public void updateWord() {
		boolean exist = false;
		while (true) {
			Scanner scan = new Scanner(System.in);
			showAllWords();
			System.out.println("Please input word you need to update");
			String word = scan.nextLine();
			wordsDao wDao = new wordsDao();
			wordsDto dto = wDao.findOne(word);
			if (dto.getContent() != null) {
				System.out.println("Please fill words update below");
				String words = scan.nextLine();
				System.out.println("Please fill new description update below");
				String description = scan.nextLine();
				System.out.println("Please fill new translation update below");
				String translation = scan.nextLine();
				System.out.println("Please fill new example update below");
				String example = scan.nextLine();
				dto.setContent(words);
				dto.setDescription(description);
				dto.setTranslation(translation);
				dto.setExample(example);
				wDao.update(dto);
				System.out.println("update user success!");
				exist = true;
			} else {
				System.out.println("word not exist! please check agin!");
			}
			if (exist) {
				break;
			}
		}

	}

	public void findWord() {
		boolean exist = false;

		while (true) {

			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter words you need to find :");
			String word = scan.nextLine();
			System.out.println("Find word with key : " + word);
			wordsDao wDao = new wordsDao();
			List<wordsDto> wordsList = wDao.findWord(word);
			languageDto langDto = new languageDto();
			languageDao lDao = new languageDao();
			if (wordsList.size() > 0) {
				for (int i = 0; i < wordsList.size(); i++) {
					System.out.println("-----------------------------");
					System.out.println("| Id : " + wordsList.get(i).getId() + "|");
					System.out.println("| Word : " + wordsList.get(i).getContent() + "|");
					System.out.println("| Description : " + wordsList.get(i).getDescription() + "|");
					System.out.println("| Translation : " + wordsList.get(i).getTranslation() + "|");
					langDto = lDao.findOne(wordsList.get(i).getLanguage_id());
					System.out.println("| Language : " + langDto.getName() + "|");
					System.out.println("| Example : " + wordsList.get(i).getExample());
					System.out.println("-----------------------------");
					exist = true;
				}
			} else {
				System.out.println("word not exist!");
			}
			if (exist) {
				break;
			}
		}

	}

	public void findWordByClient() {
		boolean exist = false;

		while (true) {
			Integer language = 0;
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter words you need to find :");
			String word = scan.nextLine();
			System.out.println("Please select language to translate :");
			System.out.println("Please select language below :");
			System.out.println("<----------------------------------->");
			System.out.println("1.English");
			System.out.println("2.Korean");
			System.out.println("3.Japanese");
			System.out.println("4. China");
			System.out.println("5. German");
			System.out.println("0. Exist");
			System.out.println("<----------------------------------->");
			System.out.print("Please choose: ");
			String choose = scan.nextLine();
			switch (choose) {
			case "1":
				System.out.println("choose language English");
				language = 1;
				break;
			case "2":
				System.out.println("choose language Korean");
				language = 2;
				break;
			case "3":
				System.out.println("choose language Japanese");
				language = 3;
				break;
			case "4":
				System.out.println("choose language China");
				language = 4;
				break;
			case "5":
				System.out.println("choose language German");
				language = 5;
				break;
			default:
				System.out.println("invalid! please choose action in below menu:");
				break;
			}
			System.out.println("Find word with key : " + word);
			wordsDao wDao = new wordsDao();
			List<wordsDto> wordsList = wDao.findWordByClient(word, language);
			languageDto langDto = new languageDto();
			languageDao lDao = new languageDao();
			if (wordsList.size() > 0) {
				for (int i = 0; i < wordsList.size(); i++) {
					System.out.println("-----------------------------");
					System.out.println("| Id : " + wordsList.get(i).getId() + "|");
					System.out.println("| Word : " + wordsList.get(i).getContent() + "|");
					System.out.println("| Description : " + wordsList.get(i).getDescription() + "|");
					System.out.println("| Translation : " + wordsList.get(i).getTranslation() + "|");
					langDto = lDao.findOne(wordsList.get(i).getLanguage_id());
					System.out.println("| Language : " + langDto.getName() + "|");
					System.out.println("| Example : " + wordsList.get(i).getExample());
					System.out.println("-----------------------------");
					exist = true;
				}
			} else {
				System.out.println("word not exist!");
			}
			if (exist) {
				break;
			}
		}

	}

	public void showClientArea() {

		while (true) {
			Scanner scan = new Scanner(System.in);
			String choose = null;
			boolean exit = false;
			boolean back = false;
			System.out.println("Well come back client area");
			System.out.println("Dictionary System Demo Version 0.001");
			System.out.println(" ----------------------------------");
			System.out.println("1. Translate");
			System.out.println("2. Find word");
			System.out.println("3. Your dictionary");
			System.out.println("4. Add words into your dictionary");
			System.out.println("5. Edit words in your dictionary");
			System.out.println("6. Remove words in your dictionary ");
			System.out.println("7. Memorize vocabulary ");
			System.out.println("8. Print dictionary ");
			System.out.println("0. Exits");
			System.out.println(" ----------------------------------");
			System.out.print("Please choose: ");
			choose = scan.nextLine();
			switch (choose) {
			case "1":
				System.out.println("choose translate");
				findWord();
				showConfirm();
				break;
			case "2":
				System.out.println("choose Find word by language");
				findWordByClient();
				showConfirm();
				break;
			case "3":
				System.out.println("choose go to your dictionary");
				showDictionaryClient();
				showConfirm();
				break;
			case "4":
				System.out.println("Add word into your dictionary");
				addDictionary();
				showConfirm();
				break;
			case "5":
				System.out.println("Edit word in your dictionary");
				editDictionary();
				showConfirm();
				break;
			case "6":
				System.out.println("Remove words in your dictionary");
				Memorize();
				showConfirm();
				break;
			case "7":
				System.out.println("Memorize vocabulary");
				Memorize();
				showConfirm();
				break;
			case "8":
				System.out.println("Print dictionary");
				writeReceipt();
				showConfirm();
				break;
			case "0":
				System.out.println("exited!");
				exit = true;
				back = true;
				break;

			default:
				System.out.println("invalid! please choose action in below menu:");
				break;
			}
			if (exit && back) {
				break;
			}
		}
		return;
	}

	public void addNewUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please fill new username below");
		String username = scan.nextLine();
		System.out.println("Please fill new password below");
		String password = scan.nextLine();
		System.out.println("Please fill new email below");
		String email = scan.nextLine();
		Integer roleId = 2;
		userDto dto = new userDto();
		dto.setUserName(username);
		dto.setPassWord(password);
		dto.setRoleId(roleId);
		dto.setEmail(email);
		add(dto);
		System.out.println("Add new user success!");

	}

	public static void register() {
		UserDao uDao = new UserDao();
		boolean exist = false;
		while (true) {
			System.out.println("-------------Register User------------");
			System.out.println("Please enter your username");
			Scanner scan = new Scanner(System.in);
			String userName = scan.nextLine();
			if (uDao.checkUserExist(userName)) {
				exist = true;
			}
			if (exist) {
				break;
			}

			System.out.println("-------------End Register User------------");
			System.out.println("Please choose another username ");
		}

	}

	public void addNewUser(String username) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please fill  password below");
		String password = scan.nextLine();
		System.out.println("Please fill  email below");
		String email = scan.nextLine();
		Integer roleId = 2;
		userDto dto = new userDto();
		dto.setUserName(username);
		dto.setPassWord(password);
		dto.setRoleId(roleId);
		dto.setEmail(email);
		add(dto);
		System.out.println("Register success full!");

	}

	public void editUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input username you need to update");
		String username = scan.nextLine();
		System.out.println("Please fill new password update below");
		String password = scan.nextLine();
		System.out.println("Please fill new email update below");
		String email = scan.nextLine();
		Integer roleId = 1;
		userDto dto = new userDto();
		dto.setUserName(username);
		dto.setPassWord(password);
		dto.setEmail(email);
		dto.setRoleId(roleId);
		update(dto);
		System.out.println("update user success!");
	}

	public void editAdmin() {
		Scanner scan = new Scanner(System.in);
		showAllUser ();
		System.out.println("Please input username you need to update");
		String username = scan.nextLine();
		userDto dto = findUser(username);
		if (dto.getUserName() != null) {
			System.out.println("Please fill new password update below");
			String password = scan.nextLine();
			System.out.println("Please fill new email update below");
			String email = scan.nextLine();
			Integer roleId = dto.getRoleId();
			dto.setUserName(username);
			dto.setPassWord(password);
			dto.setEmail(email);
			dto.setRoleId(roleId);
			update(dto);
			System.out.println("update user success!");
		} else {
			System.out.println("username not exist! please check agin!");
		}

	}

	public void findUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input username you need to find");
		String username = scan.nextLine();
		userDto dto = findUser(username);
		boolean exist = false;
		if (dto.getUserName() != null) {
			while (true) {
				System.out.println("-------------Find User------------");
				System.out.println("User name : " + dto.getUserName());
				System.out.println("Password : " + dto.getPassWord());
				System.out.println("Password : " + dto.getEmail());
				if (dto.getRoleId() == 1) {
					System.out.println("Role : admin ");
				} else {
					System.out.println("Role : client");
				}
				break;
			}

		} else {
			System.out.println("Username not exist!");
		}

	}

	public userDto findEmail() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input your username");
		String username = scan.nextLine();
		userDto dto = findUser(username);
//		System.out.println("User name : " + dto.getUserName());
//		System.out.println("Password : "+ dto.getPassWord());
		return dto;

	}

	public void showOptionAdmin() {
		System.out.println("Well come back admin area");
		System.out.println("Dictionary System Demo Version 0.001");
		System.out.println(" ----------------------------------");
		System.out.println("1. Add new user");
		System.out.println("2. Find user");
		System.out.println("3. Edit user");
		System.out.println("4. Find all words");
		System.out.println("5. Add new words");
		System.out.println("6. Edit words");
		System.out.println("7. Delete words");
		System.out.println("8. Find one words");
		System.out.println("0. Exits");
		System.out.println(" ----------------------------------");
		System.out.print("Please choose: ");
	}

	public void showConfirm() {
		String confirm = null;
		System.out.println("You want to exist system or back menu admin ?");
		System.out.println("1. Back");
		System.out.println("2. Exist");
		Scanner scan = new Scanner(System.in);
		confirm = scan.nextLine();
		switch (confirm) {
		case "1":
			System.out.println("Wating... back to menu admin");
			break;
		case "2":
			System.out.println("Close system");
			break;
		default:
			System.out.println("invalid! please choose action in below menu:");
			break;
		}
	}

	public userDto findUser(String userName) {
		try {
			userDto dto = new userDto();
			String queryString = "Select * from user where username=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, userName);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getString("username").equals(userName)) {
					dto.setUserName(resultSet.getString("username"));
					dto.setPassWord(resultSet.getString("password"));
					dto.setRoleId(resultSet.getInt("roleId"));
					dto.setEmail(resultSet.getString("email"));
				}
			}
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
					ptmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean checkUserExist(String username) {
		userDto dto = findUser(username);

		if (dto.getUserName() != null) {
			System.out.println("Username available!");
			return false;
		}
		System.out.println("You can use username to register!");
		System.out.println("----------------------------------");
		addNewUser(username);
		return true;

	}

	public void addWords() {
		boolean exist = false;
		Integer language = null;
		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please fill new words below");
			String content = scan.nextLine();
			wordsDao wDao = new wordsDao();
			wordsDto word = new wordsDto();
			word = wDao.findOne(content);
			if (word.getContent() != null) {
				System.out.println("Words was exist in system !");

			} else {

				System.out.println("Please fill new description below");
				String description = scan.nextLine();
				System.out.println("Please select language below :");
				System.out.println("<----------------------------------->");
				System.out.println("1.English");
				System.out.println("2.Korean");
				System.out.println("3.Japanese");
				System.out.println("4. China");
				System.out.println("5. German");
				System.out.println("0. Exist");
				System.out.println("<----------------------------------->");
				System.out.print("Please choose: ");
				String choose = scan.nextLine();
				switch (choose) {
				case "1":
					System.out.println("choose language English");
					language = 1;
					break;
				case "2":
					System.out.println("choose language Korean");
					language = 2;
					break;
				case "3":
					System.out.println("choose language Japanese");
					language = 3;
					break;
				case "4":
					System.out.println("choose language China");
					language = 4;
					break;
				case "5":
					System.out.println("choose language German");
					language = 5;
					break;
				default:
					System.out.println("invalid! please choose action in below menu:");
					break;
				}
				System.out.println("Please fill translation of word below");
				String translation = scan.nextLine();
				System.out.println("Please fill example of word below");
				String example = scan.nextLine();

				word.setContent(content);
				word.setDescription(description);
				word.setLanguage_id(language);
				word.setTranslation(translation);
				word.setExample(example);

				wDao.add(word);

				System.out.println("Add new word success!");
				exist = true;
			}

			if (exist) {
				break;
			}
		}

	}

	public void showAllWords() {
		System.out.println("All words of system current");
		wordsDao wDao = new wordsDao();
		List<wordsDto> wordsList = wDao.findAll();
		languageDto langDto = new languageDto();
		languageDao lDao = new languageDao();
		for (int i = 0; i < wordsList.size(); i++) {
			System.out.println("-----------------------------");
			System.out.println("| Id : " + wordsList.get(i).getId() + "|");
			System.out.println("| Word : " + wordsList.get(i).getContent() + "|");
			System.out.println("| Description : " + wordsList.get(i).getDescription() + "|");
			System.out.println("| Translation : " + wordsList.get(i).getTranslation() + "|");
			langDto = lDao.findOne(wordsList.get(i).getLanguage_id());
			System.out.println("| Language : " + langDto.getName() + "|");
			System.out.println("| Example : " + wordsList.get(i).getExample());
			System.out.println("-----------------------------");
		}

	}

	public void addDictionary() {
		showAllWords();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please select id of word you want to add into your dictionary");
		Integer id = scan.nextInt();
		wordsDao wDao = new wordsDao();
		wordsDto dto = wDao.findOneId(id);
		dictionaryClientDao dicDao = new dictionaryClientDao();
		dictionary_clientDto dicDto = new dictionary_clientDto();
		dicDto.setContent(dto.getContent());
		dicDto.setDescription(dto.getDescription());
		dicDto.setTranslation(dto.getTranslation());
		dicDto.setExample(dto.getExample());
		dicDto.setLanguage_id(dto.getLanguage_id());
		dicDto.setCreateBy(account.getUserName());
		dicDao.add(dicDto);
		System.out.println("add new word into your dictionary success!");

	}

	public void showDictionaryClient() {
		dictionaryClientDao dicDao = new dictionaryClientDao();
		List<dictionary_clientDto> dicList = dicDao.findByCreateBy(account.getUserName());
		languageDto langDto = new languageDto();
		languageDao lDao = new languageDao();
		for (int i = 0; i < dicList.size(); i++) {
			System.out.println("-----------------------------");
			System.out.println("| Id : " + dicList.get(i).getId() + "|");
			System.out.println("| Word : " + dicList.get(i).getContent() + "|");
			System.out.println("| Description : " + dicList.get(i).getDescription() + "|");
			System.out.println("| Translation : " + dicList.get(i).getTranslation() + "|");
			langDto = lDao.findOne(dicList.get(i).getLanguage_id());
			System.out.println("| Language : " + langDto.getName() + "|");
			System.out.println("| Example : " + dicList.get(i).getExample());
			System.out.println("| CreateBy : " + dicList.get(i).getCreateBy());
			System.out.println("-----------------------------");
		}

	}

	public void editDictionary() {
		dictionary_clientDto dto = new dictionary_clientDto();
		Integer language = 0;
		dictionaryClientDao dicDao = new dictionaryClientDao();
		List<dictionary_clientDto> dicList = dicDao.findByCreateBy(account.getUserName());
		if (dicList.isEmpty()) {
			System.out.println("Dictionary of you is empty !");
		} else {
			showDictionaryClient();
			Scanner scan = new Scanner(System.in);
			System.out.println("Please select id of word you want to edit into your dictionary");
			int id = scan.nextInt();
			System.out.println("Please enter new Words ");
			scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			String words = scan.nextLine();
			System.out.println("Please enter new Description ");
			String description = scan.nextLine();
			System.out.println("please enter new Translation");
			String translation = scan.nextLine();
			System.out.println("Please select new language :");
			System.out.println("<----------------------------------->");
			System.out.println("1.English");
			System.out.println("2.Korean");
			System.out.println("3.Japanese");
			System.out.println("4. China");
			System.out.println("5. German");
			System.out.println("0. Exist");
			System.out.println("<----------------------------------->");
			System.out.print("Please choose: ");
			String choose = scan.nextLine();
			switch (choose) {
			case "1":
				System.out.println("choose language English");
				language = 1;
				break;
			case "2":
				System.out.println("choose language Korean");
				language = 2;
				break;
			case "3":
				System.out.println("choose language Japanese");
				language = 3;
				break;
			case "4":
				System.out.println("choose language China");
				language = 4;
				break;
			case "5":
				System.out.println("choose language German");
				language = 5;
				break;
			default:
				System.out.println("invalid! please choose action in below menu:");
				break;
			}
			System.out.println("please enter new Example");
			String example = scan.nextLine();

			dto.setId(id);
			dto.setContent(words);
			dto.setDescription(description);
			dto.setLanguage_id(language);
			dto.setExample(example);
			dto.setTranslation(translation);
			dto.setCreateBy(account.getUserName());

			dicDao.update(dto);
			System.out.println("update words succees !");

		}

	}

	public void removeWordsClient() {
		dictionaryClientDao dDao = new dictionaryClientDao();
		List<dictionary_clientDto> dicList = dDao.findByCreateBy(account.getUserName());
		if (dicList.isEmpty()) {
			System.out.println("Dictionary of you is empty !");
		} else {
			showDictionaryClient();
			Scanner scan = new Scanner(System.in);
			System.out.println("Please select id of word you want to edit into your dictionary");
			int id = scan.nextInt();
			dDao.delete(id);
			System.out.println("remove words have id:" + id + "success!");
		}
	}

	public void Memorize() {
		ThreadDictionary thread = new ThreadDictionary();
		dictionaryClientDao dicDao = new dictionaryClientDao();
		Scanner scan = new Scanner(System.in);
		languageDto langDto = new languageDto();
		languageDao lDao = new languageDao();
		List<dictionary_clientDto> dicList = dicDao.findByCreateBy(account.getUserName());
		if (dicList.isEmpty()) {
			System.out.println("You have not vocabulary in the dictionary");
		} else {
			for (int i = 0; i < dicList.size(); i++) {
				System.out.println("-----------------------------");
				System.out.println("| Id : " + dicList.get(i).getId() + "|");
				System.out.println("| Word : " + dicList.get(i).getContent() + "|");
				System.out.println("| Description : " + dicList.get(i).getDescription() + "|");
				System.out.println("| Translation : " + dicList.get(i).getTranslation() + "|");
				langDto = lDao.findOne(dicList.get(i).getLanguage_id());
				System.out.println("| Language : " + langDto.getName() + "|");
				System.out.println("| Example : " + dicList.get(i).getExample());
				System.out.println("| CreateBy : " + dicList.get(i).getCreateBy());
				System.out.println("-----------------------------");
				thread.run();
				System.out.println("Please enter words");
				String answer = scan.nextLine();
				if(answer.equals(dicList.get(i).getContent())) {
					
				}else {
					System.out.println("Wrong answer! let start over ^_^!");
					i -=1;
				}
				
			}
			System.out.println("Congratulations on your accomplishment");

		}
	}
	
	public static void writeReceipt(String data) {
		File newfile = new File("D:/dictionary.txt");
		OutputStream os = null;
		try {
			os = new FileOutputStream(newfile);
//			os.write(data.getBytes(), 0, data.length());
			os.write(data.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void writeReceipt() {
		dictionaryClientDao dDao = new dictionaryClientDao();
		listDictionary = dDao.findByCreateBy(account.getUserName());
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < listDictionary.size(); i++) {
			buffer.append("-------------------------------------"+"\n");
			buffer.append(listDictionary.get(i).getId()+"|"+"\n");
			buffer.append(listDictionary.get(i).getContent()+"|"+"\n");
			buffer.append(listDictionary.get(i).getDescription()+"|"+"\n");
			buffer.append(listDictionary.get(i).getTranslation()+"|"+"\n");
			buffer.append(listDictionary.get(i).getLanguage_id()+"|"+"\n");
			buffer.append(listDictionary.get(i).getExample()+"|"+"\n");
			buffer.append(listDictionary.get(i).getCreateBy()+"|"+"\n");
			buffer.append("-------------------------------------"+"\n");
			
		}
		String write = buffer.toString();
		writeReceipt(write);
		System.out.println("print dictionary success !");
		
	}
	
	public static void showAllUser () {
		UserDao uDao = new UserDao();
		listUser = uDao.findAll();
		for (int i = 0; i < listUser.size(); i++) {
			System.out.println("+++++++++++++++++++++++++++++");
			System.out.println("| UserName : "+listUser.get(i).getUserName()+"|");
			System.out.println("+++++++++++++++++++++++++++++");
		}
	}
	
	
	

}
