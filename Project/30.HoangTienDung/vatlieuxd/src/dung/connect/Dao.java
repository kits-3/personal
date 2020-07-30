package dung.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dung.dto.Info;
import dung.dto.Input;
import dung.dto.Order;
import dung.dto.Output;
import dung.dto.Product;
import dung.dto.User;

public class Dao implements DaoPerson, DaoClient, DaoAdmin, DaoCheck {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	private Scanner scan;

	public Dao() {
	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public void printProduct() {
		try {
			String queryString = "select * from product";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				System.out.println("Id:" + resultSet.getInt("id") + " Product:" + resultSet.getString("name")
						+ " Price_in:" + resultSet.getDouble("price_in") + " Price_out:"
						+ resultSet.getDouble("price_out") + " Qty" + resultSet.getInt("quantity"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
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

	public void addUser(User user) {
		// TODO Auto-generated method stub
		try {

			String queryString2 = "SELECT name FROM role order BY id DESC LIMIT 1";
			String queryString1 = "SELECT id FROM users order BY id DESC LIMIT 1";
			String queryString = "INSERT INTO users(user,password,role_name) VALUES(?,?,?)";

			connection = getConnection();
			ptmt = connection.prepareStatement(queryString2);
			resultSet = ptmt.executeQuery();
			resultSet.next();
			String role_name = resultSet.getString("name");

			ptmt = connection.prepareStatement(queryString1);
			resultSet = ptmt.executeQuery();
			resultSet.next();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, user.getUser());
			ptmt.setString(2, user.getPassword());
			ptmt.setString(3, role_name);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
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

	public void newInfo(Info info, User user) {
		// TODO Auto-generated method stub
		try {

			String queryString = "INSERT INTO info(id,users_id,name,address,phone) VALUES(?,?,?,?,?)";
			String queryString1 = "select id from info order by id desc limit 1";
			String queryString2 = "select id from users where user=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString2);
			ptmt.setString(1, user.getUser());
			resultSet = ptmt.executeQuery();
			resultSet.next();
			int id_user = resultSet.getInt("id");
			ptmt = connection.prepareStatement(queryString1);
			resultSet = ptmt.executeQuery();
			resultSet.next();
			int i = resultSet.getInt("id") + 1;
			info.setId(i);
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, i);
			ptmt.setInt(2, id_user);
			ptmt.setString(3, info.getName());
			ptmt.setString(4, info.getAddress());
			ptmt.setString(5, info.getPhone());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
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

	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		try {
			String queryString = "INSERT INTO vatlieu.`order` (info_id,users_id,pro_id,quantity,mount,status_name) VALUES(?,?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, order.getInfo_id());
			ptmt.setInt(2, order.getUsers_id());
			ptmt.setInt(3, order.getPro_id());
			ptmt.setInt(4, order.getQuantity());
			ptmt.setDouble(5, order.getMount());
			ptmt.setString(6, order.getStatus_check());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
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

	public void deleteUser(int id) {
		try {
			String queryString = "delete from users where id =?";
			String queryString1 = "delete from vatlieu.`info` where users_id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString1);
			ptmt.setInt(1, id);
			ptmt.executeUpdate();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			ptmt.executeUpdate();
			
			System.out.println("Delete complete!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
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

	public List<User> findUser() {
		List<User> ls = new ArrayList<>();
		try {
			String queryString = "select * from users";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				ls.add(new User(resultSet.getInt("id"), resultSet.getString("user"), resultSet.getString("password"),
						resultSet.getString("role_name")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
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
		return ls;
	}

	public User findUser(String user) {
		User User = new User();
		try {
			String queryString = "select * from users where user=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, user);
			resultSet = ptmt.executeQuery();
			resultSet.next();
			User.setId(resultSet.getInt("id"));
			User.setUser(user);
			User.setPassword(resultSet.getString("password"));
			User.setRole_name(resultSet.getString("role_name"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
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
		return User;
	}

	public void printUser(List<User> ls) {
		for (int i = 0; i < ls.size(); i++) {
			System.out.println("id:" + ls.get(i).getId() + " user:" + ls.get(i).getUser());
		}

	}

	public List<Product> findProduct() {
		List<Product> ls = new ArrayList<>();
		try {
			String queryString = "select * from product";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				ls.add(new Product(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getDouble("price_in"),
						resultSet.getDouble("price_out"), resultSet.getInt("quantity")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
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
		return ls;
	}

	public void printProduct(List<Product> ls) {
		for (int i = 0; i < ls.size(); i++) {
			System.out.println("id:" + (i + 1) + " name:" + ls.get(i).getName() + " price:" + ls.get(i).getPrice_out());
		}
	}

	@Override
	public void addMoney(User user, double money) {
		// TODO Auto-generated method stub
		try {
			String queryString = "SELECT money FROM info where users_id = (SELECT id FROM users WHERE USER=?)";
			String queryString1 = "UPDATE info SET money =? WHERE users_id = (SELECT id FROM users WHERE USER=?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, user.getUser());
			resultSet = ptmt.executeQuery();
			// System.out.println(user.getUser());

			resultSet.next();
			money += resultSet.getDouble("money");
			ptmt = connection.prepareStatement(queryString1);
			ptmt.setDouble(1, money);
			ptmt.setString(2, user.getUser());

			ptmt.executeUpdate();
			System.out.println("Recharged!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
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

	@Override
	public Info findInfo(int users_id) {
		// TODO Auto-generated method stub
		Info info = new Info();
		try {
			String queryString = "select * from info where users_id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, users_id);
			resultSet = ptmt.executeQuery();
			resultSet.next();
			info.setId(resultSet.getInt("id"));
			info.setUsers_id(resultSet.getInt("users_id"));
			info.setMoney(resultSet.getDouble("money"));
			info.setName(resultSet.getString("name"));
			info.setAddress(resultSet.getString("address"));
			info.setPhone(resultSet.getString("phone"));

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
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
		return info;
	}

	@Override
	public List<Order> findOrder(int users_id) {
		// TODO Auto-generated method stub
		List<Order> ls = new ArrayList<>();
		try {
			String queryString = "select * from vatlieu.`order` where users_id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, users_id);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				ls.add(new Order(resultSet.getInt("id"), resultSet.getInt("info_id"), resultSet.getInt("users_id"),
						resultSet.getInt("pro_id"), resultSet.getInt("quantity"), resultSet.getDouble("mount"),
						resultSet.getString("status_name")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
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
		return ls;
	}

	@Override
	public void delOrder(int order_id) {
		// TODO Auto-generated method stub
		try {
			String queryString = "delete from vatlieu.`order` where id =?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, order_id);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("delete false!");
			}
		}

	}

	@Override
	public void changeInfo(User user) {
		// TODO Auto-generated method stub
		scan = new Scanner(System.in);
		try {

			System.out.println("input info change:\n");
			System.out.print("input name: ");
			scan.skip("(\r|[\r\u2028\u2029\u0085])?");
			String name = scan.nextLine();
			System.out.print("\ninput address: ");
			scan.skip("(\r|[\r\u2028\u2029\u0085])?");
			String address = scan.nextLine();
			System.out.print("\ninput phone: ");
			scan.skip("(\r|[\r\u2028\u2029\u0085])?");
			String phone = scan.nextLine();
			String queryString = "UPDATE info SET  name=?,address=?,phone=? WHERE users_id =?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, name);
			ptmt.setString(2, address);
			ptmt.setString(3, phone);
			ptmt.setInt(4, user.getId());
			ptmt.executeUpdate();
			System.out.println("changed!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
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

	@Override
	public void changePass(User user) {
		// TODO Auto-generated method stub
		scan = new Scanner(System.in);
		try {

			System.out.print("input new password :");
			String password = scan.next();

			String queryString = "UPDATE users SET  password=? WHERE id =?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, password);
			ptmt.setInt(2, user.getId());
			ptmt.executeUpdate();
			System.out.println("changed!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
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

	@Override
	public List<Order> allOrder() {
		// TODO Auto-generated method stub
		List<Order> ls = new ArrayList<>();
		try {
			String queryString = "select * from vatlieu.`order`";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				ls.add(new Order(resultSet.getInt("id"), resultSet.getInt("info_id"), resultSet.getInt("users_id"),
						resultSet.getInt("pro_id"), resultSet.getInt("quantity"), resultSet.getDouble("mount"),
						resultSet.getString("status_name")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
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
		return ls;
	}

	public void printlistOrder(List<Order> ls) {
		for (int i = 0; i < ls.size(); i++) {
			System.out.println("id: " + ls.get(i).getId() + "\tinfo_id: " + ls.get(i).getInfo_id() + "\tusers_id: "
					+ ls.get(i).getUsers_id() + "\tpro_id: " + ls.get(i).getPro_id() + "\tquantity: "
					+ ls.get(i).getQuantity() + "\tmount: " + ls.get(i).getMount() + "\tstatus: "
					+ ls.get(i).getStatus_check());
		}
	}

	@Override
	public void checkStatus(int order_id) {// them check tien
		// TODO Auto-generated method stub
		try {
			String queryString1 = "SELECT money FROM info  WHERE id= (SELECT info_id FROM vatlieu.`order`  WHERE id=?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString1);
			ptmt.setInt(1, order_id);
			resultSet = ptmt.executeQuery();
			resultSet.next();
			double money = resultSet.getDouble("money");
			String queryString2 = "SELECT mount FROM vatlieu.`order` WHERE id =?";
			ptmt = connection.prepareStatement(queryString2);
			ptmt.setInt(1, order_id);
			resultSet = ptmt.executeQuery();
			resultSet.next();
			double mount = resultSet.getDouble("mount");
			if (mount > money) {
				System.out.println("check false!!");
			} else {
				String queryString = "UPDATE vatlieu.`order` SET status_name=? WHERE id =?";
				ptmt = connection.prepareStatement(queryString);
				ptmt.setString(1, "checked");
				ptmt.setInt(2, order_id);
				ptmt.executeUpdate();
				System.out.println("checked complete!");
				money -= mount;
				String queryString3 = "update vatlieu.`info` set money=? where users_id= (select users_id from vatlieu.`order` where id=?)";
				ptmt = connection.prepareStatement(queryString3);
				ptmt.setDouble(1, money);
				ptmt.setInt(2, order_id);
				ptmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
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

	@Override
	public void addInput(Input input) {
		// TODO Auto-generated method stub
		try {
			String queryString = "INSERT INTO vatlieu.`input` (users_id,pro_id,quantity,money) VALUES(?,?,?,?)";

			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, input.getUsers_id());
			ptmt.setInt(2, input.getPro_id());
			ptmt.setInt(3, input.getQuantity());
			ptmt.setDouble(4, input.getMoney());
			ptmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
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

	@Override
	public List<Input> lsInputUser(User user) {
		// TODO Auto-generated method stub
		List<Input> ls = new ArrayList<>();
		try {
			String queryString = "select * from vatlieu.`input`where users_id=";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, user.getId());
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				ls.add(new Input(resultSet.getInt("id"), resultSet.getInt("users_id"), resultSet.getInt("pro_id"),
						resultSet.getInt("quantity"), resultSet.getDouble("money")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
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
		return null;
	}

	@Override
	public void addOutput(Output output) {
		// TODO Auto-generated method stub
		try {
			String queryString = "INSERT INTO vatlieu.`output` (or_id,users_id,status_name) VALUES(?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, output.getOr_id());
			ptmt.setInt(2, output.getUsers_id());
			ptmt.setString(3, output.getStatus_name());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
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

	@Override
	public void showAllUser() {
		// TODO Auto-generated method stub
		try {
			String queryString = "select * from users";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				System.out.println("id: " + resultSet.getInt("id") + "\tuser: " + resultSet.getString("user")
						+ "\trole_name: " + resultSet.getString("role_name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void regisUser(User user) {
		// TODO Auto-generated method stub
		try {
			String queryString = "insert into vatlieu.`users` (user,password,role_name) values(?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, user.getUser());
			ptmt.setString(2, user.getPassword());
			ptmt.setString(3, user.getRole_name());
			ptmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public boolean Permmis(String admin, String user) {
		// TODO Auto-generated method stub
		boolean check = false;

		try {
			String queryString = "select role.id from role where role.name= (select users.role_name from users where users.user=?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, admin);
			resultSet = ptmt.executeQuery();
			resultSet.next();
			int u1 = resultSet.getInt("id");
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, user);
			resultSet = ptmt.executeQuery();
			resultSet.next();
			int u2 = resultSet.getInt("id");
			if (u1 < u2) {
				check = true;
			} else
				check = false;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return check;
	}

	@Override
	public void addPermmison(int id_user, String role_name) {
		// TODO Auto-generated method stub
		try {
			String queryString = "UPDATE vatlieu.`users` SET role_name=? WHERE id =?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, role_name);
			ptmt.setInt(2, id_user);
			ptmt.executeUpdate();
			System.out.println("update complete!");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void viewInfo(int id_user) {
		// TODO Auto-generated method stub
		try {
			System.out.println("your profile:");
			String queryString = "select * from vatlieu.`info` where users_id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id_user);
			resultSet = ptmt.executeQuery();
			resultSet.next();
			System.out.println("id: " + resultSet.getInt("id") + "\tusers_id: " + resultSet.getInt("users_id")
					+ "\tmoney: " + resultSet.getDouble("money") + "\tname: " + resultSet.getString("name")
					+ "\taddress: " + resultSet.getString("address") + "\tphone: " + resultSet.getString("phone"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub

		try {

			String queryString = "insert into product (product.name,price_in,price_out,quantity) values(?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, product.getName());
			ptmt.setDouble(2, product.getPrice_in());
			ptmt.setDouble(3, product.getPrice_out());
			ptmt.setInt(4, 1);
			ptmt.executeUpdate();
			System.out.println("Add product complete!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("input false!");
		}
	}

	@Override
	public void DeleteProduct(int id_product) {
		// TODO Auto-generated method stub
		try {

			String queryString = "delete from product where id =?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id_product);
			ptmt.executeUpdate();
			System.out.println("Delete complete!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("input false!");
		}
	}

	@Override
	public void UpdateProduct(Product product) {
		// TODO Auto-generated method stub
		try {

			String queryString = "UPDATE product SET name=?,price_in=?,price_out=? WHERE id =?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, product.getName());
			ptmt.setDouble(2, product.getPrice_in());
			ptmt.setDouble(3, product.getPrice_out());
			ptmt.setDouble(4, product.getId());
			ptmt.executeUpdate();
			System.out.println("Update complete!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("input false!");
		}
	}

	@Override
	public void ShowOrder() {
		// TODO Auto-generated method stub
		try {
			String queryString = "select * from vatlieu.`order`";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				System.out.println("id: " + resultSet.getInt("id") + "\tinfo_id: " + resultSet.getInt("info_id")
						+ "\tusers_id: " + resultSet.getInt("users_id") + "\tpro_id: " + resultSet.getInt("pro_id")
						+ "\tquantity: " + resultSet.getInt("quantity") + "\tmount: " + resultSet.getDouble("mount")
						+ "\tstatus: " + resultSet.getString("status_name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("show false!");
		}
	}

	@Override
	public void ShowOutput() {
		// TODO Auto-generated method stub
		try {
			String queryString = "select * from vatlieu.`output`";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				System.out.println(
						"id: " + resultSet.getInt("id") + "\tor_id: " + resultSet.getInt("or_id") + "\tusers_id: "
								+ resultSet.getInt("users_id") + "\tstatus: " + resultSet.getString("status_name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("show false!");
		}
	}

	@Override
	public void ShowInput() {
		// TODO Auto-generated method stub
		try {
			String queryString = "select * from vatlieu.`input`";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				System.out.println("id: " + resultSet.getInt("id") + "\tusers_id: " + resultSet.getInt("users_id")
						+ "\tpro_id: " + resultSet.getInt("pro_id") + "\tquantity: " + resultSet.getInt("quantity")
						+ "\tmoney: " + resultSet.getDouble("money"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("show false!");
		}
	}
}