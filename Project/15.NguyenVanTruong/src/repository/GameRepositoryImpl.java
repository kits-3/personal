package repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConnectSQL;
import entity.Game;

public class GameRepositoryImpl implements GameRepository {

private	Connection connection = null;
private	PreparedStatement ptmt = null;
private	ResultSet rs = null;

	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectSQL.getInstance().getConnection();
		return conn;
	}
	public void add(Game gm) {
		try {
			String queryString = "INSERT INTO "+" game(name,price,producer,key_game) "+" VALUES(?,?,?,?) ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, gm.getName());
			ptmt.setDouble(2,gm.getPrice());
			ptmt.setString(3, gm.getProducer());
			ptmt.setString(4, gm.getKey_game());
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ptmt != null) {
					ptmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void update(Game gm) {
		try {
			String queryString = "UPDATE game SET name=?, "+" price=? ,"+"producer=?,"+"key_game=?"+" where id_game =?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);

			ptmt.setString(1,gm.getName());
			ptmt.setInt(2, gm.getPrice());
			ptmt.setString(3, gm.getProducer());

			ptmt.setString(4, gm.getKey_game());
			ptmt.setInt(5, gm.getId_game());
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				try {
					if(ptmt != null) {
					ptmt.close();
					}
					if(connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	public void delete(int id) {
		try {
			String queryString = "delete from game where id_game=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ptmt != null) {
					ptmt.close();
				}
				if(connection !=null) {
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
	public List<Game> infoGame() {
		List<Game> lsGame = new ArrayList();
		String sql="SELECT * FROM game";
		try {
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while(rs.next()) {
				Game gm = new Game();
				
			gm.setId_game(rs.getInt(1));
			gm.setName(rs.getString("name"));
			gm.setPrice(rs.getInt(3));
			gm.setProducer(rs.getString("producer"));
			gm.setKey_game(rs.getString("key_game"));
			
			lsGame.add(gm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				
				if(connection!=null) {
					connection.close();
				}
				if(ptmt!=null) {
					ptmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println(e);
				//e.printStackTrace();
				// TODO: handle exception
			} catch (Exception e) {
				System.out.println(e);
				//e.printStackTrace();
				// TODO: handle exception
			}
		}
		
		return lsGame;
	}
	@Override
	public List<Game> showKey() {
		List<Game> lsKey = new ArrayList();
		String sql = "select key from game";
		try {
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			Game gs = new Game();
			gs.setKey_game(rs.getString("key_game"));
			rs = ptmt.executeQuery();
			lsKey.add(gs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(connection!= null) {
					connection.close();
				}
				if(ptmt!= null) {
					ptmt.close();
				}
				if(rs!= null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		return lsKey;
		
	}
	
}
