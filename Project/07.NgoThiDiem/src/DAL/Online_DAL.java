package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BUS.Online_BUS;
import DTO.Account_DTO;
import DTO.Patient_DTO;

import GUI.CreateTable;
import GUI.Online_GUI;

public class Online_DAL {
	// register
	public void insertData(Account_DTO dto) {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();
		CreateTable tb = new CreateTable();
		Online_GUI online_gui = new Online_GUI();
		try {
//			if(checkAccountExist(dto) == 1) {
				PreparedStatement preState = conn.prepareStatement(
						"insert into account(username, email, password, permission) " + "values(?,?,?,?)");
				
				preState.setString(1, dto.getUserName());
				preState.setString(2, dto.getEmail());
				preState.setString(3, dto.getPassWord());
				preState.setInt(4, 0);			
				int i = preState.executeUpdate();
				if(i != -1) {
					System.err.println("\n"+tb.createSpace()+"Regis success");
					online_gui.login_Account(dto);					
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
		String query="select * from account";
		int k = 0;
		 try {
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(query);
			
			while(result.next()) {
				if((dto.getEmail().equals(result.getString("email"))) && (dto.getUserName().equals(result.getString("username")))){
					k = 1;
					break;
				}
				if(dto.getEmail().equals(result.getString("email"))) {
					k = 2;
					break;
				}
				if(dto.getUserName().equals(result.getString("username"))) {
					k = 3;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return k;
	}

	// Login
	//Permission login
	public int checkPermisstion(Account_DTO dto) {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();
		try {
			String queryAccount = "select username,password,permission from account";
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(queryAccount);

			while(result.next()) {
				if(dto.getUserName().equals(result.getString("username")) && dto.getPassWord().equals(result.getString("password")) 
						&& result.getInt("permission") == 0)
					return 0;
				if(dto.getUserName().equals(result.getString("username")) && dto.getPassWord().equals(result.getString("password")) 
						&& result.getInt("permission") == 1)
					return 1;
				if(dto.getUserName().equals(result.getString("username")) && dto.getPassWord().equals(result.getString("password")) 
						&& result.getInt("permission") == 2)
					return 2;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}
	//patient information
	public ResultSet patientInformation(Patient_DTO patient_info_dto) {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();
		
		try {
			String query = "select * from patient";
			
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(query);
			
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	//show table account
	public ResultSet showAccount(Account_DTO ac_dto) {
		Connection conn = connectionMariaDB_DAL.getConnectionToDB();
		
		try {
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery("select * from account");
			
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//insert data into patient_infor
		public void insertDataPatientInfo(Patient_DTO patient_info_dto) {
			Connection conn = connectionMariaDB_DAL.getConnectionToDB();
			CreateTable tb = new CreateTable();
			Online_GUI online_gui = new Online_GUI();
			try {
				
					PreparedStatement preState = conn.prepareStatement("insert into patient(id_card, "
							+ "code_patient, name, age, gender,"
							+ "phone, address, registration_date, discharge_date, status) "
							+ "values(?,?,?,?,?,?,?,?,?,?)");
					
					preState.setInt(1,patient_info_dto.getId_card());
					preState.setString(2,patient_info_dto.getCode_patient());
					preState.setString(3,patient_info_dto.getName());
					preState.setInt(4,patient_info_dto.getAge());
					preState.setString(5,patient_info_dto.getGender());
					preState.setLong(6,patient_info_dto.getPhone());
					preState.setString(7,patient_info_dto.getAddress());
					preState.setString(8,patient_info_dto.getRegistrationDate());
					preState.setString(9,patient_info_dto.getDischargeDate());
					preState.setString(10,patient_info_dto.getStatus());
					
					int i = preState.executeUpdate();
					if(i == 1) {
						System.err.println("\tSuccess");
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
}
