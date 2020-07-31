package customerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.ConnectionFactory;
import entity.BillDetail;

public class BillDetailImpl_cus implements BillDetailDao_cus {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet result = null;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public void add(BillDetail billDetail) {
		try {
			String queryString = "INSERT INTO bill_detail(Book_id, Number, Bill_id)"
					+ "VALUES(?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, billDetail.getBook_id());
			ptmt.setInt(2, billDetail.getNumber());
			ptmt.setInt(3, billDetail.getBill_id());
			ptmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					System.out.println("Add success");
					ptmt.close();
				} else {
					System.out.println("Add faild");
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
	
}
