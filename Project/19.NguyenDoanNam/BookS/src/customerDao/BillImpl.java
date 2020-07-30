package customerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Model.ConnectionFactory;
import entity.Bill;
import entity.BillDetail;
import entity.Book;

public class BillImpl implements BillDao_cus {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet result = null;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public void add(Bill bill, List<Book> list,List<BillDetail> listBillDetails, Integer money_user) {
		try {
			String queryString = "INSERT INTO bill(Gmail, Total)" + "VALUES(?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString, ptmt.RETURN_GENERATED_KEYS);
			ptmt.setString(1, bill.getGmail());
			ptmt.setInt(2, bill.getTotal());
			ptmt.executeUpdate();
			result = ptmt.getGeneratedKeys();
			if (result.next()) {
				for (int i = 0; i < listBillDetails.size(); i++) {
					BillDetail billDetail = new BillDetail();
					billDetail.setBook_id(listBillDetails.get(i).getBook_id());
					billDetail.setNumber(listBillDetails.get(i).getNumber());
					billDetail.setBill_id(result.getInt("Bill_id"));
					new BillDetailImpl_cus().add(billDetail);
					System.out.println(" You buy " + list.get(i).getBook_name() +  "| " + " Number: " + listBillDetails.get(i).getNumber() + " | " + list.get(i).getPrice());
				}
				System.out.println("Total: " + bill.getTotal());
				new UserImpl_cus().update_money_bill(bill.getGmail(), bill.getTotal() , money_user);
			}
	

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					System.out.println("Payment success");
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
