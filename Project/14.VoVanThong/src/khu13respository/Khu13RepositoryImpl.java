package khu13respository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;

import khu13config.Khu13Config;
import khu13entity.AccountEntity;
import khu13entity.MenuEntity;
import khu13entity.SiteEntity;
import kits_khu13.Admin;
import kits_khu13.Login;
import kits_khu13.User;

public class Khu13RepositoryImpl implements Khu13Repository {
	private Connection connection =null;
	private PreparedStatement pstmt = null;
	private ResultSet result = null;
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = Khu13Config.getInstance().getConnection();
		return conn;
	}
	@Override
	public List<MenuEntity> findMenu() {
		try {
			List<MenuEntity> listmenu = new ArrayList<>();
			String queryString = "SELECT * FROM menu";
			connection= getConnection();
			pstmt =connection.prepareStatement(queryString);
			result=pstmt.executeQuery();
			while(result.next()) {
				MenuEntity menuE = new MenuEntity();
				menuE.setId(result.getInt(1));
				menuE.setName(result.getString("name"));
				menuE.setPrice(result.getInt("price"));
				listmenu.add(menuE);
			}
			return listmenu;
		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(result!=null) {
					result.close();
				}
			}
		catch (Exception e) {
			// TODO: handle exception
			}
		}
		return null;
	
	}

	@Override
	public List<SiteEntity> findAll() {
		List<SiteEntity> list = new ArrayList<>();
		String queryString = "SELECT * FROM site";
		try {
			connection= getConnection();
			pstmt =connection.prepareStatement(queryString);
			result=pstmt.executeQuery();
			while(result.next()) {
				
				SiteEntity siteE = new SiteEntity();
				siteE.setId(result.getInt(1));
				siteE.setSite(result.getString("site"));
				siteE.setStatus(result.getString("status"));
				list.add(siteE);
			}
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(result!=null) {
					result.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return list;
	}

	
	@Override
	public SiteEntity findById(int id) {
		String queryString = "SELECT * FROM site where id =? ";
		SiteEntity siteE = new SiteEntity();
		try {
			connection=getConnection();
			pstmt =connection.prepareStatement(queryString);
			pstmt.setInt(1, id);
			result=pstmt.executeQuery();
			while(result.next()) {
				siteE.setId(result.getInt(1));
				siteE.setSite(result.getString("site"));
				siteE.setStatus(result.getString("status"));
			}
			return siteE;
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return siteE;
	}

	@Override
	public SiteEntity update(SiteEntity siteE) {
		 	try {
				String queString = "update site set status = ? " + " where id=?";
				User us = new User();
				int id = us.selectSite();
				connection = getConnection();
				pstmt = connection.prepareStatement(queString);
				pstmt.setString(1, "full");
				pstmt.setInt(2, id);
				siteE.setId(id);
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				try {
					if(connection!=null) {
						connection.close();
					}
					if(pstmt!=null) {
						pstmt.close();
					}
					if(result!=null) {
						result.close();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		 	return siteE;
	}
	@Override
	public MenuEntity changeprice(MenuEntity menuE) {
		try {
			String queString = "update menu set price = ? " + " where id=?";
			Admin ad = new Admin();
			connection = getConnection();
			pstmt = connection.prepareStatement(queString);
			pstmt.setInt(1, menuE.getPrice());
			pstmt.setInt(2, menuE.getId());
//			siteE.setId(id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(result!=null) {
					result.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return null;
	}
//	@Override
	public MenuEntity updatemoney(int money, String name) {		
		try {
		String queString = "update account set money = ? " + " where name=?";
//		int id = us.selectMenu();
		connection = getConnection();
		pstmt = connection.prepareStatement(queString);
		pstmt.setInt(1, money);
		pstmt.setString(2, name);
//			siteE.setId(id);
		pstmt.executeUpdate();
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
		try {
			if(connection!=null) {
				connection.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(result!=null) {
				result.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public AccountEntity delete(String username) {
		try {
			connection=getConnection();
			String queryString = "delete from account where name=?";
			pstmt =connection.prepareStatement(queryString);
			pstmt.setString(1, username);
			result=pstmt.executeQuery();
			// TODO Auto-generated method stub
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(result!=null) {
					result.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return null;
	}
	@Override
	public AccountEntity checklog(String name, String pw) {
		try {
			connection=getConnection();
			String queryString = "SELECT * FROM account WHERE name = ? and password= ?";
			pstmt =connection.prepareStatement(queryString);
			pstmt.setString(1, name);
			pstmt.setString(2, pw);
			result=pstmt.executeQuery();
			AccountEntity ac = new AccountEntity();
			if(result.next()) {
			 System.out.println("Your access: "+ result.getString(2));
				ac.setAccess(result.getString("access"));
				ac.setMoney(result.getInt("money"));
			return ac;
			}else {
				System.out.println("Error!!");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(result!=null) {
					result.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// TODO Auto-generated method stub
		return null;
	
	
	}
	public AccountEntity add(AccountEntity acc) {
		try {
			
			String queryString = "Insert Into " + "account(access,name,password,money,phone,typeofaccess)"
			    	+"Values(?,?,?,?,?,?)";
						connection = getConnection();
						pstmt = connection.prepareStatement(queryString);
						pstmt.setString(1,"user");
						pstmt.setString(2,acc.getName());
						pstmt.setString(3,acc.getPassword());
						pstmt.setInt(4,acc.getMoney());
						pstmt.setString(5,acc.getPhone());
						pstmt.setString(6,"1");
						pstmt.executeUpdate();
						System.out.println("Please login again");
						
			return acc;		
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(connection!=null) {
					connection.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(result!=null) {
					result.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return acc;
	}
	@Override
	public MenuEntity checkprice(int id) {
		MenuEntity menuE = new MenuEntity();
		try {
			connection=getConnection();
			String queryString = "SELECT * FROM menu WHERE id = ?";
			pstmt =connection.prepareStatement(queryString);
			pstmt.setInt(1, id);
			result=pstmt.executeQuery();
			while(result.next()) {
				menuE.setPrice(result.getInt("price"));
				menuE.setName(result.getString("name"));
				System.out.println("Your choice: "+result.getString("name"));
			}
			return menuE;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	
	
	
	
	
	
	
	
}
