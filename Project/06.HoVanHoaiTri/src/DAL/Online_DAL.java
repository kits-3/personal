package DAL;

import java.awt.Desktop;
import java.io.File;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BUS.Online_BUS;
import DTO.Account_DTO;
import DTO.Customer_DTO;
import DTO.Room_book_DTO;
import DTO.Room_info_DTO;
import GUI.CreateTable;
import GUI.Offline_GUI;
import GUI.Online_GUI;

public class Online_DAL {
	// register
	public void insertData(Account_DTO dto) {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();
		CreateTable tb = new CreateTable();
		Online_GUI online_gui = new Online_GUI();
		try {
			if (checkAccountExist(dto) == 0) {
				PreparedStatement preState = conn.prepareStatement(
						"insert into account(username, email, password, permission) " + "values(?,?,?,?)");
				preState.setString(1, dto.getUserName());
				preState.setString(2, dto.getEmail());
				preState.setString(3, dto.getPassWord());
				preState.setInt(4, dto.getPerMission());
				int i = preState.executeUpdate();
				if (i != -1) {
					System.err.println("\n" + tb.createSpace() + "Regis success");
					online_gui.login_Account(dto);
					online_gui.loginChecked(dto);
				}
			} else {
				while (checkAccountExist(dto) == 1) {
					System.err.println("\n" + tb.createSpace() + "Email and username exist!!!!!");
					online_gui.register_Account(dto);
					insertData(dto);
				}
				while (checkAccountExist(dto) == 2) {
					System.err.println("\n" + tb.createSpace() + "Email exist!!!!!");
					online_gui.register_Account(dto);
					insertData(dto);
				}
				while (checkAccountExist(dto) == 3) {
					System.err.println("\n" + tb.createSpace() + "Username exist!!!!!");
					online_gui.register_Account(dto);
					insertData(dto);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	// insert acount from admin 2
	public void insertDataAdmin2(Account_DTO dto) {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();
		CreateTable tb = new CreateTable();
		Online_GUI online_gui = new Online_GUI();
		try {
			if (checkAccountExist(dto) == 0) {
				PreparedStatement preState = conn.prepareStatement(
						"insert into account(username, email, password, permission) " + "values(?,?,?,?)");
				preState.setString(1, dto.getUserName());
				preState.setString(2, dto.getEmail());
				preState.setString(3, dto.getPassWord());
				preState.setInt(4, dto.getPerMission());
				int i = preState.executeUpdate();
				if (i != -1) {
					System.err.println("\n" + tb.createSpace() + "Regis success");
				}
			} else {
				while (checkAccountExist(dto) == 1) {
					System.err.println("\n" + tb.createSpace() + "Email and username exist!!!!!");
					online_gui.register_Account(dto);
					insertData(dto);
				}
				while (checkAccountExist(dto) == 2) {
					System.err.println("\n" + tb.createSpace() + "Email exist!!!!!");
					online_gui.register_Account(dto);
					insertData(dto);
				}
				while (checkAccountExist(dto) == 3) {
					System.err.println("\n" + tb.createSpace() + "Username exist!!!!!");
					online_gui.register_Account(dto);
					insertData(dto);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public int checkAccountExist(Account_DTO dto) {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();
		String query = "select * from account";
		int k = 0;
		try {
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(query);

			while (result.next()) {
				if ((dto.getEmail().equals(result.getNString("email")))
						&& (dto.getUserName().equals(result.getNString("username")))) {
					k = 1;
					break;
				}
				if (dto.getEmail().equals(result.getNString("email"))) {
					k = 2;
					break;
				}
				if (dto.getUserName().equals(result.getNString("username"))) {
					k = 3;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return k;
	}

	// Login
	// Permission login
	public int checkPermisstion(Account_DTO dto, Offline_GUI off) {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();
		Online_BUS bus = new Online_BUS();
		try {
			String queryAccount = "select * from account";// username,password,permission
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(queryAccount);

			while (result.next()) {
				if (dto.getUserName().equals(result.getNString("username"))
						&& dto.getPassWord().equals(result.getNString("password"))
						&& result.getInt("permission") == 0) {
					dto.setAccountID(result.getInt("id_account"));
					return 0;
				}
				if (dto.getUserName().equals(result.getNString("username"))
						&& dto.getPassWord().equals(result.getNString("password"))
						&& result.getInt("permission") == 1) {
//					dto.setAccountID(result.getInt("id_account"));
					off.restID = result.getInt("id_account");
					return 1;
				}
				if (dto.getUserName().equals(result.getNString("username"))
						&& dto.getPassWord().equals(result.getNString("password")) && result.getInt("permission") == 2)
					return 2;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}

	// room information
	public ResultSet roomInformation(Room_info_DTO room_info_dto) {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();

		try {
			String query = "select * from room_info";

			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(query);

			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	// get data table room_infor
	public ResultSet getDataRoomInfor() {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();
		try {
			String query = "select * from room_info";
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(query);

			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	// insert data into room_infor
	public void insertDataRoomInfo(Room_info_DTO room_info_dto) {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();
		CreateTable tb = new CreateTable();
		Customer_DTO c_dto = new Customer_DTO();
		Online_GUI online_gui = new Online_GUI();
		Account_DTO ac_dto = new Account_DTO();
		try {

			PreparedStatement preState = conn.prepareStatement(
					"insert into room_info(number_room, type_of_room, price, Characteristics) " + "values(?,?,?,?)");
			preState.setInt(1, room_info_dto.getNumber_room());
			preState.setString(2, room_info_dto.getType_of_room());
			preState.setFloat(3, room_info_dto.getPrice());
			preState.setString(4, room_info_dto.getCharacteristics());
			int i = preState.executeUpdate();
			if (i != -1) {
				System.err.println("\n\t" + "***Insert success");
				online_gui.showRomInformation(room_info_dto, c_dto, ac_dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public void deleteRoomIfor(Room_info_DTO room_info_dto) {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();
		Online_GUI online_gui = new Online_GUI();
		Customer_DTO c_dto = new Customer_DTO();
		CreateTable tb = new CreateTable();
		Account_DTO ac_dto = new Account_DTO();
		try {
			PreparedStatement prepe = conn.prepareStatement("delete from room_info where id_room_info = ?");
			prepe.setInt(1, room_info_dto.getRoom_info_ID());
			int i = prepe.executeUpdate();
			if (i != -1) {
				System.err.println("\n\t***Delete success");
				online_gui.showRomInformation(room_info_dto, c_dto, ac_dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// show table account
	public ResultSet showAccount(Account_DTO ac_dto) {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();

		try {
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery("select * from account");

			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	// delete account admin 2
	public void deleteAccountAdmin2(Account_DTO dto) {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();
		Online_GUI online_gui = new Online_GUI();
		CreateTable tb = new CreateTable();
		try {
			PreparedStatement prepe = conn.prepareStatement("delete from account where id_account = ?");
			prepe.setInt(1, dto.getAccountID());
			int i = prepe.executeUpdate();
			if (i != -1) {
				System.err.println("\n\t***Delete success");
				online_gui.showAccount(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// insert personal information into table Customer
	public void insertPersonalInfo(Customer_DTO dto, Account_DTO ac_dto, int id_login) {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();
		CreateTable tb = new CreateTable();
		Online_BUS bus = new Online_BUS();
		try {
			PreparedStatement pre = conn.prepareStatement(
					"insert into customer(id_customer,name_customer,date_of_birth,address,telephone,id_account)"
							+ "values(?,?,?,?,?,?)");
			pre.setLong(1, dto.getCustomerID());
			pre.setNString(2, dto.getCustomerName());
			pre.setNString(3, dto.getDateOfBirth());
			pre.setNString(4, dto.getAddress());
			pre.setLong(5, dto.getTelephone());
			pre.setInt(6, id_login);
			int i = pre.executeUpdate();
			if (i == 1) {
				System.err.println("\n" + tb.createSpace() + "Success");
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// insert room book
	public void insertRoomBook(Room_book_DTO b, Room_info_DTO f, Customer_DTO c_dto) {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();
		CreateTable tb = new CreateTable();
		try {
			PreparedStatement pre = conn.prepareStatement(
					"insert into room_book(check_in_date, check_out_date, service, day_of_stay, total,id_customer, number_room)"
							+ "values(?,?,?,?,?,?,?)");
			pre.setString(1, b.getCheckInDate());
			pre.setNString(2, b.getCheckOutDate());
			pre.setNString(3, b.getService());
			pre.setLong(4, b.getDayOfStay());
			pre.setFloat(5, b.getTotal());
			pre.setLong(6, c_dto.getCustomerID());
			pre.setInt(7, f.getRoomN());

			int i = pre.executeUpdate();
			if (i == 1) {
				System.err.println("\n" + tb.createSpace() + "Success");
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// get room book table
	// get table customer
	public ResultSet getDataCustomer() {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();
		try {
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery("select * from customer");
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	// update room information
	public void updateRomInfo(int a) {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();
		CreateTable tb = new CreateTable();

		try {
			PreparedStatement pre = conn.prepareStatement("update room_info set Status=? where number_room =?");
			pre.setNString(1, "Full");
			pre.setInt(2, a);
			int i = pre.executeUpdate();
			if (i == 1) {
				System.err.println("\n" + tb.createSpace() + "Update status room success");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void insertRoomInfo(Room_info_DTO f) {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();
		CreateTable tb = new CreateTable();
		Online_GUI gui = new Online_GUI();
		Room_info_DTO room_info_dto = new Room_info_DTO();
		Customer_DTO c_dto = new Customer_DTO();
		Account_DTO dto = new Account_DTO();
		try {
			PreparedStatement pre = conn.prepareStatement(
					"insert into room_info(number_room,type_of_room,price,Characteristics) values(?,?,?,?)");
			pre.setInt(1, f.getNumber_room());
			pre.setNString(2, f.getType_of_room());
			pre.setFloat(3, f.getPrice());
			pre.setNString(4, f.getCharacteristics());
			int i = pre.executeUpdate();
			if (i == 1) {
				System.err.println("\n" + tb.createSpace() + "Success");
				gui.showRomInformationAdmin2(room_info_dto, c_dto, dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}// delete Roominfo

	public void deleteRominfo(int a) {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();
		CreateTable tb = new CreateTable();
		Online_GUI gui = new Online_GUI();
		Room_info_DTO room_info_dto = new Room_info_DTO();
		Customer_DTO c_dto = new Customer_DTO();
		Account_DTO dto = new Account_DTO();
		try {
			PreparedStatement pre = conn.prepareStatement("delete from room_info where id_room_info = ?");
			pre.setInt(1, a);
			int i = pre.executeUpdate();

			if (i == 1) {
				System.err.println("\n\t" + "Delete success");
				gui.showRomInformationAdmin2(room_info_dto, c_dto, dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// show table user booked
	public ResultSet showRoomInfoBooked(long id) {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();

		try {
			PreparedStatement pre = conn.prepareStatement(
					"select * from room_book inner join room_info on room_book.number_room = room_info.number_room "
							+ "and room_book.id_customer = ?");
			pre.setLong(1, id);
			ResultSet result = pre.executeQuery();

			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public void reportFileExcel(String _fileName) {

		Connection conn = connectionMariaDB_DAL.getConnectionToDB();
		Offline_GUI off = new Offline_GUI();

		try {
			File file = new File("../HotelManagement_ConsoleApp/" + _fileName + ".xlsx");

			if (file.exists()) {
				System.err.println("\t" + file.getName() + " is exist !!");
				off.enterFileName();
			} else {
				FileOutputStream output = new FileOutputStream("../HotelManagement_ConsoleApp/" + _fileName + ".xlsx");
				XSSFWorkbook wb = new XSSFWorkbook();

				XSSFCellStyle cellStyle = wb.createCellStyle();
				cellStyle.setAlignment(HorizontalAlignment.CENTER);
				cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

				XSSFFont font = wb.createFont();
				font.setBold(true);
				font.setFontHeightInPoints((short) 16);
				XSSFSheet sheet = wb.createSheet(_fileName);

				XSSFCellStyle cellStyle1 = wb.createCellStyle();
				cellStyle1.setAlignment(HorizontalAlignment.CENTER);
				cellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);

				XSSFCellStyle cellStyle2 = wb.createCellStyle();
				cellStyle2.setAlignment(HorizontalAlignment.CENTER);
				cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);

				XSSFFont font1 = wb.createFont();
				XSSFFont font2 = wb.createFont();
				font2.setFontHeightInPoints((short) 25);
				font2.setBold(true);
				font1.setFontHeightInPoints((short) 15);

				Statement state = conn.createStatement();
				ResultSet result = state.executeQuery("select * from room_book");
				XSSFCell cell1, cell2, cell3, cell4, cell5, cell6, cell0, cell;
				XSSFRow row1, row2, row3, row4;
				int i = 1;
				float totalPrice = 0;
				row4 = sheet.createRow(3);
				cell = row4.createCell(0);
				cell.setCellValue("SALES REPORT EVERY MONTH");
				cell.setCellStyle(cellStyle2);
				cellStyle2.setFont(font2);
				row4.setHeight((short) 1500);

				sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 6));
				while (result.next()) {
					// title
					row1 = sheet.createRow(6);
					row2 = sheet.createRow(result.getRow() + 6);
					row1.setHeight((short) 1000);
					sheet.setColumnWidth(0, 6000);
					sheet.setColumnWidth(1, 6000);
					sheet.setColumnWidth(2, 6000);
					sheet.setColumnWidth(3, 6000);
					sheet.setColumnWidth(4, 6000);
					sheet.setColumnWidth(5, 6000);
					sheet.setColumnWidth(6, 6000);

					cell = row1.createCell(0);
					cell.setCellValue("Numerical order");
					cell.setCellStyle(cellStyle);
					cellStyle.setFont(font);

					cell = row1.createCell(1);
					cell.setCellValue("Number room");
					cell.setCellStyle(cellStyle);

					cell = row1.createCell(2);
					cell.setCellValue("Check in date");
					cell.setCellStyle(cellStyle);

					cell = row1.createCell(3);
					cell.setCellValue("Check out date");
					cell.setCellStyle(cellStyle);

					cell = row1.createCell(4);
					cell.setCellValue("Service");
					cell.setCellStyle(cellStyle);

					cell = row1.createCell(5);
					cell.setCellValue("Day of stay");
					cell.setCellStyle(cellStyle);

					cell = row1.createCell(6);
					cell.setCellValue("Total");
					cell.setCellStyle(cellStyle);

					cell = row2.createCell(0);
					cell.setCellValue(i);
					cell.setCellStyle(cellStyle1);
					cellStyle1.setFont(font1);

					cell = row2.createCell(1);
					cell.setCellValue(result.getInt("number_room"));
					cell.setCellStyle(cellStyle1);

					cell = row2.createCell(2);
					cell.setCellValue(result.getString("check_in_date"));
					cell.setCellStyle(cellStyle1);

					cell = row2.createCell(3);
					cell.setCellValue(result.getString("check_out_date"));
					cell.setCellStyle(cellStyle1);

					cell = row2.createCell(4);
					cell.setCellValue(result.getString("service"));
					cell.setCellStyle(cellStyle1);

					cell = row2.createCell(5);
					cell.setCellValue(result.getString("day_of_stay"));
					cell.setCellStyle(cellStyle1);

					cell = row2.createCell(6);
					cell.setCellValue(result.getInt("total") + "$");
					cell.setCellStyle(cellStyle1);

					totalPrice += result.getFloat("total");
					i++;
				}
				row2 = sheet.createRow(result.getRow() + 7);
				cell = row2.createCell(0);
				cell.setCellValue("Sum");
				cell.setCellStyle(cellStyle);

				cell = row2.createCell(6);
				cell.setCellValue(totalPrice + "$");
				cell.setCellStyle(cellStyle);
				wb.write(output);
				System.err.println("\tExport file success");
				wb.close();
				output.close();
				
				callExcel(_fileName);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void callExcel(String path) {
		try {
			File file = new File("../HotelManagement_ConsoleApp/" + path + ".xlsx");
			
			Desktop.getDesktop().open(file);
		}
		catch(Exception e) {
			
		}
	}
}
