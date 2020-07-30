package pj.tour.repository.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pj.tour.config.ConnectionFactory;
import pj.tour.entity.PaymentTourEntity;
import pj.tour.entity.TourEntity;
import pj.tour.repository.UserRepository;
import pj.tour.repository.UserRepositoryImpl;
import pj.tour.repository.booking.BookingRepositoryImpl;
import pj.tour.repository.booking.BookingTour;

public class PaymentTourImpl implements PaymentTour{

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
	public void payTour(String booking) {
		// TODO Auto-generated method stub
		BookingTour bookingtour = new BookingRepositoryImpl();
		UserRepository userrepository = new UserRepositoryImpl();
		
		PaymentTourEntity pay = new PaymentTourEntity();
		String queryString = "SELECT * FROM tour where tour_id = ?";
		try {
			connection = getConnection();	
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, booking);
			rs = stmt.executeQuery(); //Select				
			if(rs.next()) {
				List<PaymentTourEntity> listpayment = new ArrayList<PaymentTourEntity>();
				int priceTour = rs.getInt("price_tour");
				System.out.println("price Tour: "+ priceTour);
				listpayment = showListTour(booking);	
//				System.out.println(listpayment);
				System.out.println("Current money: "+listpayment.get(0).getMoneyNumber());	
				
				if (listpayment.get(0).getMoneyNumber() != 0) {
					if (listpayment.get(0).getMoneyNumber() >= priceTour ) {
						int refund = listpayment.get(0).getMoneyNumber() - priceTour;
						System.out.println("your refund: " + refund);
						System.out.println("payment complete!");
						updateInfo(refund, booking);
					}else {
						System.out.println("Current money don't enought please get more money!!");
						System.out.print("Input more money: ");
						int returnmoneySQL = findMoney(booking);
						int moneyCharge = input.nextInt();
						moneyCharge += returnmoneySQL;
						updateInfo(moneyCharge, booking);
						payTour(booking);
					}
				}else {
					System.out.println("no money in your account! please recharge! ");
					System.out.println("do you want continute deal ?  --- yes --- no --- ?");
					String yes_no = input.nextLine();
					if (yes_no.equals("yes")) {
						System.out.println("Input money: ");
						int moneyCharge = input.nextInt();
						updateInfo(moneyCharge, booking);
						payTour(booking);
					}else {
						System.out.println("shutdow please!!!");
					}
				}
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
	
	@Override
	public List<PaymentTourEntity> showListTour(String pay_id) {
		// TODO Auto-generated method stub
		
		List<PaymentTourEntity> tourlists = new ArrayList<PaymentTourEntity>();
		String queryString = "SELECT * FROM payment WHERE pay_id = ?";
		
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, pay_id);
			rs = stmt.executeQuery(); //Select	
			
			while(rs.next()) {
				PaymentTourEntity cus = new PaymentTourEntity();	
				cus.setPayId(rs.getString("pay_id"));
				cus.setMoneyNumber(rs.getInt("money_number"));
				cus.setTourID(rs.getString("tour_id"));
				cus.setUserID(rs.getString("user_id"));				
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
	public void updateInfo(int count, String id) {
		// TODO Auto-generated method stub
				
		try {
			String queryString = "update payment set money_number = ? where pay_id = ?" ;
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setInt(1, count);
			stmt.setString(2, id);
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
	public int findMoney(String id) {
		// TODO Auto-generated method stub

			try {
				String quertString = "Select * from payment where pay_id = ?";
				connection = getConnection();
				stmt = connection.prepareStatement(quertString);
				stmt.setString(1, id);
				rs = stmt.executeQuery();
				if (rs.next()) {
					return rs.getInt("money_number");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
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
				} catch (SQLException e) {
					System.out.println(e);
				}

			}
		return 0;
	}
}
