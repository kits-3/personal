package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionFactory;
import Entity.roleDto;

public class roleDao {

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public roleDao() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public void add(roleDto dto) {
		try {
			String queryString = "INSERT INTO " + "roles(id,name)" + "VALUES(?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, dto.getId());
			ptmt.setString(2, dto.getName());
			ptmt.executeUpdate();

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

	public void update(roleDto dto) {
		try {
			String queryString = "update roles set name=? where id = ?";

			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, dto.getId());
			ptmt.setString(2, dto.getName());
			ptmt.executeUpdate();

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

	public void delete(String id) {
		try {
			String queryString = "delete from user where username =?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, id);
			ptmt.executeUpdate();

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

	public roleDto findOne(int id) {
		try {
			String queryString = "Select * from roles where id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet = ptmt.executeQuery();
			roleDto dto = new roleDto();
			int i = 0;
			while (resultSet.next()) {
				dto.setId(resultSet.getInt("id"));
				dto.setName(resultSet.getString("name"));
				System.out.println("Id : " + resultSet.getInt("id") + " Name : " + resultSet.getString("name"));
			}

			return dto;
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

	public List<roleDto> findAll() {
		try {
			String queryString = "Select * from roles";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			List<roleDto> dtoList = new ArrayList<roleDto>();
			int i = 0;
			while (resultSet.next()) {
				roleDto dto = new roleDto();
				dto.setId(resultSet.getInt("id"));
				dto.setName(resultSet.getString("name"));
				dtoList.add(dto);
				System.out.println("Id : " + resultSet.getInt("id") + " Name : " + resultSet.getString("name"));
			}

			return dtoList;
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
}
