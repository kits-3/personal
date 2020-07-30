package home.note.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import home.note.config.*;
import home.note.entity.*;

public class Dao {

	Connection Connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	Scanner scanner = new Scanner(System.in);
	List<clTblNote> notelist = new ArrayList<clTblNote>();

	public Dao() {
	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

//addUser
	
	
	public void addUser(String user, String pass) {
		try {
			String queryString = "INSERT INTO " + "user(username, password, date_reg, role)" + "VALUES(?,?,now(),?)";
			Connection = getConnection();
			ptmt = Connection.prepareStatement(queryString);
			ptmt.setString(1, user);
			ptmt.setString(2, pass);
			ptmt.setString(3, "user");
			ptmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (Connection != null) {
					Connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

//deleteUser
	public void deleteUser(String id) {
		try {
			String queryString = "delete from user where id=?";
			Connection = getConnection();
			ptmt = Connection.prepareStatement(queryString);
			ptmt.setString(1, id);
			ptmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (Connection != null) {
					Connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

//viewUser
	public List<clUser> managVieUsNo() {
		try {
			String queryString = "SELECT u.id, u.username,  COUNT(tn.id) as cid FROM user u, tbl_note tn WHERE u.id=tn.userid GROUP BY u.username";
			Connection = getConnection();
			ptmt = Connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				System.out.println("id: " + resultSet.getString("u.id") + " Username: "
						+ resultSet.getString("u.username") + "\t SLT: " + resultSet.getString("cid"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (Connection != null) {
					Connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

// findU
	public List<clUser> findU() {
		List<clUser> userlist = new ArrayList<clUser>();
		try {
			String queryString = "select* from user";
			Connection = getConnection();
			ptmt = Connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();

			while (resultSet.next()) {
				clUser cus = new clUser();
				cus.setId(resultSet.getString("id"));
				cus.setUsername(resultSet.getString("username"));
				cus.setPassword(resultSet.getString("password"));
				cus.setDate_reg(resultSet.getString("date_reg"));
				cus.setRole(resultSet.getString("role"));
				// System.out.println("id: "+resultSet.getString("id"));

				userlist.add(cus);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (Connection != null) {
					Connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return userlist;
	}

	// findU(u)
	public List<clUser> findU(String u) {
		List<clUser> userlist = new ArrayList<clUser>();
		try {
			String queryString = "select* from user where username=? ";
			Connection = getConnection();
			ptmt = Connection.prepareStatement(queryString);
			ptmt.setString(1, u);
//				ptmt.setString(2,p);
			resultSet = ptmt.executeQuery();

			while (resultSet.next()) {
				clUser cus = new clUser();
				cus.setId(resultSet.getString("id"));
				cus.setUsername(resultSet.getString("username"));
				cus.setPassword(resultSet.getString("password"));
				cus.setDate_reg(resultSet.getString("date_reg"));
				cus.setRole(resultSet.getString("role"));
				// System.out.println("id: "+resultSet.getString("id"));

				userlist.add(cus);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (Connection != null) {
					Connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return userlist;
	}

//chooseUser	
	public boolean chooseUser(String user, String pass) {
		try {
			String queryString = "select username, password from user where username=? and password=?";
			Connection = getConnection();
			ptmt = Connection.prepareStatement(queryString);
			ptmt.setString(1, user);
			ptmt.setString(2, pass);
			resultSet = ptmt.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (Connection != null) {
					Connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;

	}

//checkPremissionUser
	public String checkPremissionUser(String user, String pass) {
		try {
			String queryString = "select role from user where username=? and password=?";
			Connection = getConnection();
			ptmt = Connection.prepareStatement(queryString);
			ptmt.setString(1, user);
			ptmt.setString(2, pass);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				return resultSet.getString("role");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (Connection != null) {
					Connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}
///------------------------------------------------------------///	

//addNote
	public void addNote(String id) {
		try {
			String queryString = "INSERT INTO " + "tbl_note(namec, content, date_reg, date_upd, userid)"
					+ "VALUES(?,?,now(),now(),?)";
			Connection = getConnection();
			ptmt = Connection.prepareStatement(queryString);
			System.out.println("Enter the content name: ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			String name = scanner.nextLine();
			System.out.println("Enter the content: ");
			String cont = scanner.nextLine();
			ptmt.setString(1, name);
			ptmt.setString(2, cont);
			ptmt.setString(3, id);
			ptmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (Connection != null) {
					Connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

//update note
	public void updateNote(String uid) {
		try {
			String queryString = "UPDATE tbl_note SET namec=?, content=?, date_upd=NOW() WHERE userid=? and id=?";
			Connection = getConnection();
			ptmt = Connection.prepareStatement(queryString);
		
			System.out.println("Edit by the order number: ");
			String id = scanner.next();
			
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			System.out.println("Enter the content name: ");
			String nam = scanner.nextLine();
			System.out.println("Enter the content: ");
			String cont = scanner.nextLine();
			
			ptmt.setString(1, nam);
			ptmt.setString(2, cont);
			ptmt.setString(3, uid);
			ptmt.setString(4, id);
			
			System.out.println("edited: " +id);
			
			ptmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (Connection != null) {
					Connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

//deleteNote
	public void deleteNote(String uid) {
		try {
			String queryString = "delete from tbl_note where id=? and userid=?";
			Connection = getConnection();
			ptmt = Connection.prepareStatement(queryString);
			
			System.out.println("Delete by the order number: ");
			String id = scanner.next();
			ptmt.setString(2, uid);
			ptmt.setString(1, id);
			System.out.println("Deleted: "+id);
			ptmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (Connection != null) {
					Connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	public boolean checkIdNote(String uid, String idn) {
		try {
			String queryString ="SELECT id FROM tbl_note WHERE userid=(SELECT id FROM user WHERE id=?) AND id =?;";
			Connection = getConnection();
			ptmt = Connection.prepareStatement(queryString);
			ptmt.setString(1, uid);
			ptmt.setString(2, idn);
			resultSet = ptmt.executeQuery();
			if(resultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(ptmt != null) {
					ptmt.close();
				}
				if(Connection != null) {
					Connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
	
//findNote

	public List<clTblNote> findNote(String uid) {
		List<clTblNote> notelist = new ArrayList<clTblNote>();
		try {
			String queryString = "select * from tbl_note where userid=?";
			Connection = getConnection();
			ptmt = Connection.prepareStatement(queryString);
			ptmt.setString(1, uid);
			resultSet = ptmt.executeQuery();

			while (resultSet.next()) {
				clTblNote cln = new clTblNote();
				cln.setId(resultSet.getString("id"));
				cln.setNamec(resultSet.getString("namec"));
				cln.setConnent(resultSet.getString("content"));
				cln.setDate_reg(resultSet.getString("date_reg"));
				cln.setDate_upd(resultSet.getString("date_upd"));
				notelist.add(cln);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (Connection != null) {
					Connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return notelist;
	}

//viewIdNote	
	public void viewIdNote(String uid, String idn) {
		try {
			String queryString ="SELECT * FROM tbl_note WHERE userid=(SELECT id FROM user WHERE id=?) AND id =?;";
			Connection = getConnection();
			ptmt = Connection.prepareStatement(queryString);
			ptmt.setString(1, uid);
			ptmt.setString(2, idn);
			resultSet = ptmt.executeQuery();
			int lg=1;
			while(lg==1) {
		
				if(resultSet.next()) {
					System.out.println("ID: "+ resultSet.getByte(1));
					System.out.println("Content name: "+ resultSet.getString(2));
					System.out.println("Content: "+ resultSet.getString(3));
					System.out.println("Date added: "+ resultSet.getDate(4));
					System.out.println("Date edit: "+ resultSet.getDate(5));
					lg=0;
				}else {
					System.out.println("Input id note need view: ");
					idn=scanner.nextLine();
					viewIdNote(uid, idn);
					lg=0;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(ptmt != null) {
					ptmt.close();
				}
				if(Connection != null) {
					Connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean checkCoIdNote(String uid) {
		try {
			String queryString ="SELECT COUNT(id) AS cidn  FROM tbl_note  WHERE userid=?";
			Connection = getConnection();
			ptmt = Connection.prepareStatement(queryString);
			ptmt.setString(1, uid);
			resultSet = ptmt.executeQuery();
			
			if(resultSet.next()) {
				if(resultSet.getString(1).equals("0")) {
					return true;
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(ptmt != null) {
					ptmt.close();
				}
				if(Connection != null) {
					Connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
		
	}

}






	
