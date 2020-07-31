package adminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Model.ConnectionFactory;
import entity.Account;
import entity.Bill;

public class BillImpl implements BillDao {

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet result = null;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public List<Bill> findAll() {
		try {
			String queryString = "SELECT * from bill";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			result = ptmt.executeQuery();
			while (result.next()) {
				System.out.print("Bill_id: " + result.getInt(1) + " | ");
				System.out.print(" Gmail: " + result.getString(2) + " | ");
				System.out.println(" Total: " + result.getString(2) + " | ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
