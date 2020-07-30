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

public class AdminRepositoryImpl implements AdminRepository, InputData{

	
	Scanner input = new Scanner(System.in);
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		List<UserEntity> lsUser = new ArrayList<UserEntity>();
		String queryString = "SELECT * FROM user";
		
		try {
			connection = getConnection();
			
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); //Select
			
			while(rs.next()) {
				UserEntity user = new UserEntity();
				
				user.setId(rs.getInt(1));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				//cus.setTeam(rs.getString("team"));
				
				lsUser.add(user);
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
		return lsUser;
}

	@Override
	public UserEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public void updateTour(TourEntity ad) {
		// TODO Auto-generated method stub
		String id;
		System.out.println("Enter ID: ");
		id = input.next();
		
		String nameTour = null;
		System.out.print("nametour: ");
		nameTour = input.next();
		
		String locationTour = null;
		System.out.print("locationTour: ");
		locationTour = input.next();
		
		String timeStart = null;
		System.out.print("timeStart(hh:mm:ss): ");
		timeStart = input.next();
		
		String dateStart = null;
		System.out.print("dateStart(yyyy-mm-dd): ");
		dateStart = input.next();
		
		int memCount = 0;
		System.out.println("memCount: ");
		
		try {
			String queryString = "update tour set name_tour = ?, location_start = ?, time_start = ?, date_start = ? where tour_id = ?" ;
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, nameTour);
			stmt.setString(2, locationTour);
			stmt.setString(3, timeStart);
			stmt.setString(4, dateStart);
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
	public void addTour(TourEntity tour) {
		// TODO Auto-generated method stub
		String nameTour = null;
		System.out.print("nametour: ");
		nameTour = input.next();
		
		String locationTour = null;
		System.out.print("locationTour: ");
		locationTour = input.next();
		
		String timeStart = null;
		System.out.print("timeStart(hh:mm:ss): ");
		timeStart = input.next();
		
		String dateStart = null;
		System.out.print("dateStart(yyyy-mm-dd): ");
		dateStart = input.next();
		
		int dayNumber;
		System.out.print("dayNumber: ");
		dayNumber = input.nextInt();
		
		int priceTour;
		System.out.print("priceTour: ");
		priceTour = input.nextInt();
		
		int memCount = 0;
		System.out.println("memCount: ");
		
		try {
			String queryString = "INSERT INTO "
		+"tour(name_tour, location_start, time_start, date_start, mem_number, day_number, price_tour)" 
		+"VALUES(?,?,?,?,?,?,?)";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, nameTour);
			stmt.setString(2, locationTour);
			stmt.setString(3, timeStart);
			stmt.setString(4, dateStart);
			stmt.setInt(5, memCount);
			stmt.setInt(6, dayNumber);
			stmt.setInt(7, priceTour);
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
	public void deleteTour(TourEntity tour) {
		// TODO Auto-generated method stub
		System.out.println("Enter ID: ");
		String id = input.next();
		System.out.println("Enter location: ");
		String location = input.next();
		try {
			String queryString = "delete from tour where tour_id = ? and location_start = ? ";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, id);
			stmt.setString(2, location);
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
			} catch (SQLException e2) {
				e2.printStackTrace();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		System.out.println("Enter ID: ");
		String id = input.next();
		try {
			String queryString = "delete from user where id = ? ";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, id);
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
			} catch (SQLException e2) {
				e2.printStackTrace();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public List<TourEntity> inputData() {
		// TODO Auto-generated method stub
		int n = input.nextInt();
		TourEntity tour = new TourEntity();
		List<TourEntity> tourentity = new ArrayList<TourEntity>();
		
		return null;
	}

	@Override
	public void findTour() {
		// TODO Auto-generated method stub
	String queryString = "SELECT * FROM user";
		
		try {
			connection = getConnection();
			
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); //Select
			
			while(rs.next()) {
				UserEntity user = new UserEntity();
				
				user.setId(rs.getInt(1));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				//cus.setTeam(rs.getString("team"));
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
	}

	
}
