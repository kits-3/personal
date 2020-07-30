package pj.tour.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pj.tour.entity.AccountEntity;
import pj.tour.entity.TourEntity;
import pj.tour.entity.UserEntity;
import pj.tour.repository.account.AccountRepository;
import pj.tour.config.ConnectionFactory;

public class UserRepositoryImpl implements UserRepository{
	
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	Scanner input = new Scanner(System.in);
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public List<TourEntity> findAll() {
		// TODO Auto-generated method stub
		List<TourEntity> tourlists = new ArrayList<TourEntity>();
		String queryString = "SELECT * FROM tour";
		
		try {
			connection = getConnection();	
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); //Select
			
			while(rs.next()) {
				TourEntity cus = new TourEntity();
				
				cus.setName_tour(rs.getString("name_Tour"));
				cus.setLocation_start(rs.getString("location_start"));
				cus.setTime_start(rs.getString("time_start"));
				cus.setDate_start(rs.getString("date_start"));
				cus.setMem_number(rs.getInt("mem_number"));
				cus.setDay_number(rs.getInt("day_number"));
				
				tourlists.add(cus); 
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			}
			catch (SQLException e) {
				System.out.println(e);
			}
		}
		return tourlists;
}

	@Override
	public UserEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateInfo() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter ID: ");
		String id = input.next();
		System.out.println("name: ");
		String name = input.next();
		System.out.println("gmail: ");
		String gmail = input.next();
		System.out.println("PhoneNumber: ");
		String phoneNumber = input.next();
		System.out.println("Address: ");
		String address = input.next();
				
		try {
			String queryString = "update user set name = ?,  gmail = ?, phonenumber = ?, address = ? where id = ?" ;
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, name);
			stmt.setString(2, gmail);
			stmt.setString(3, phoneNumber);
			stmt.setString(4, address);
			stmt.setString(5, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	@Override
	public void findTour(){
		// TODO Auto-generated method stub
		boolean check = true;
		List<TourEntity> listTours = new ArrayList<TourEntity>();
		String queryString = "SELECT * FROM Tour where location_start = ?";
		
		try {
			do {
				System.out.println("Enter location: ");
				String location = input.next();
				connection = getConnection();
				stmt = connection.prepareStatement(queryString);
				stmt.setString(1, location);
				rs = stmt.executeQuery(); //Select	
				
				if(rs.next()) {
					if (location.equals(rs.getString("location_start")) ) {						
						listTours = showListTour(location);
						for (int i = 0; i < listTours.size(); i++) {
							System.out.println("Id_tour: " + listTours.get(i).getTour_id() + "  ");
							System.out.print("Name_tour: " + listTours.get(i).getName_tour()+" -- ");
							System.out.print("location_start: " + listTours.get(i).getLocation_start()+" -- ");
							System.out.print("time_start: " + listTours.get(i).getTime_start()+" -- ");
							System.out.print("date_start: " + listTours.get(i).getDate_start()+" -- ");
							System.out.print("day_number: " + listTours.get(i).getDay_number() + " day --");
							System.out.println("price_tour: "+ listTours.get(0).getPrice_tour()+"$");
						}
						check = false;
					}
				}
			} while (check);
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			}
			catch (SQLException e) {
				System.out.println(e);
			}
			
		}
	}

	@Override
	public List<TourEntity> showListTour(String location) {
		// TODO Auto-generated method stub
		
		List<TourEntity> tourlists = new ArrayList<TourEntity>();
		String queryString = "SELECT * FROM tour WHERE location_start = ?";
		
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, location);
			rs = stmt.executeQuery(); //Select	
			
			while(rs.next()) {
				TourEntity cus = new TourEntity();	
				cus.setTour_id(rs.getString("tour_id"));
				cus.setName_tour(rs.getString("name_Tour"));
				cus.setLocation_start(rs.getString("location_start"));
				cus.setTime_start(rs.getString("time_start"));
				cus.setDate_start(rs.getString("date_start"));
				cus.setMem_number(rs.getInt("mem_number"));
				cus.setDay_number(rs.getInt("day_number"));
				cus.setPrice_tour(rs.getInt("price_tour"));
				
				tourlists.add(cus); 
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			}
			catch (SQLException e) {
				System.out.println(e);
			}
		}
		return tourlists;
	}

	@Override
	public void inputMoney() {
		// TODO Auto-generated method stub
		
	}

}
