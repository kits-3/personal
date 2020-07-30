package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionFactory;
import Entity.languageDto;

public class languageDao {

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public languageDao() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public void add(languageDto dto) {
		try {
			String queryString = "INSERT INTO " + "language(id,name)" + "VALUES(?,?)";
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

	public void update(languageDto dto) {
		try {
			String queryString = "update language set name=? where id = ?";

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
			String queryString = "delete from language where id =?";
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

	public languageDto findOne(int id) {
		try {
			String queryString = "Select * from language where id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet = ptmt.executeQuery();
			languageDto dto = new languageDto();
			int i = 0;
			while (resultSet.next()) {
				dto.setId(resultSet.getInt("id"));
				dto.setName(resultSet.getString("name"));
				
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

	public List<languageDto> findAll() {
		try {
			String queryString = "Select * from language";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			List<languageDto> dtoList = new ArrayList<languageDto>();
			int i = 0;
			while (resultSet.next()) {
				languageDto dto = new languageDto();
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
