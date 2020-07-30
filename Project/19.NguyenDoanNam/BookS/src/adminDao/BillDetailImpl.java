package adminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Model.ConnectionFactory;
import entity.BillDetail;

public class BillDetailImpl implements BillDetailDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet result = null;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public List<BillDetail> findAll() {
		try {
			String queryString = "SELECT * from bill_detail";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			result = ptmt.executeQuery();
			while (result.next()) {
				System.out.print("Bill Detail Id: " + result.getInt(1) + " | ");
				System.out.print(" Book_id: " + result.getString(2) + " | ");
				System.out.print(" Number: " + result.getInt(3) + " | ");
				System.out.print(" Time: " + result.getDate(4) + " | ");
				System.out.println(" Bill id: " + result.getInt(5) + " | ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
