package customerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.ConnectionFactory;

public class SaveBillImpl implements SaveBill {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet result = null;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	@Override
	public int findMoney(String gmail) {
		try {
			String sql = "SELECT Money FROM user WHERE Gmail = ?";
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			ptmt.setString(1, gmail);
			result = ptmt.executeQuery();
			int a = 0;
			if(result.next()) {
				a = result.getInt(1);
				System.out.println("You have money: " + result.getInt(1));
				System.out.println("------------------------------------------");
			}
			return a;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;	
	}
}
