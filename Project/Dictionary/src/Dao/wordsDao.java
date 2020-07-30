package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionFactory;
import Entity.userDto;
import Entity.wordsDto;

public class wordsDao {

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public wordsDao() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public void add(wordsDto dto) {
		try {
			String queryString = "INSERT INTO " + "words(content,description,translation,examples,language_id)"
					+ "VALUES(?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, dto.getContent());
			ptmt.setString(2, dto.getDescription());
			ptmt.setString(3, dto.getTranslation());
			ptmt.setString(4, dto.getExample());
			ptmt.setInt(5, dto.getLanguage_id());
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

	public void update(wordsDto dto) {
		try {
			String queryString = "update words set content=?," + "description=?," + "translation=?," + "examples=?,"
					+ "language_id=?  where id = ?";

			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, dto.getContent());
			ptmt.setString(2, dto.getDescription());
			ptmt.setString(3, dto.getTranslation());
			ptmt.setString(4, dto.getExample());
			ptmt.setInt(5, dto.getLanguage_id());
			ptmt.setInt(6, dto.getId());
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

	public void delete(int id) {
		try {
			String queryString = "delete from words where id =?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
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


	public List<wordsDto> findAll() {
		try {
			String queryString = "Select * from words";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			List<wordsDto> dtoList = new ArrayList<wordsDto>();
			int i = 0;
			while (resultSet.next()) {
				wordsDto dto = new wordsDto();
				dto.setId(resultSet.getInt("id"));
				dto.setContent(resultSet.getString("content"));
				dto.setDescription(resultSet.getString("description"));
				dto.setTranslation(resultSet.getString("translation"));
				dto.setExample(resultSet.getString("examples"));
				dto.setLanguage_id(resultSet.getInt("language_id"));

				dtoList.add(dto);
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
	
	public List<wordsDto> findWord(String word) {
		try {
			String queryString = "Select * from words where content LIKE '%"+ word + "%' OR translation LIKE '%"+ word +"%' ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			List<wordsDto> dtoList = new ArrayList<wordsDto>();
			int i = 0;
			while (resultSet.next()) {
				wordsDto dto = new wordsDto();
				dto.setId(resultSet.getInt("id"));
				dto.setContent(resultSet.getString("content"));
				dto.setDescription(resultSet.getString("description"));
				dto.setTranslation(resultSet.getString("translation"));
				dto.setExample(resultSet.getString("examples"));
				dto.setLanguage_id(resultSet.getInt("language_id"));
				dtoList.add(dto);
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
	
	public List<wordsDto> findWordByClient(String word , Integer languageId) {
		try {
			String queryString = "Select * from words where content LIKE '%"+ word + "%' OR translation LIKE '%"+ word +"%' AND language_id = "+languageId;
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			List<wordsDto> dtoList = new ArrayList<wordsDto>();
			int i = 0;
			while (resultSet.next()) {
				wordsDto dto = new wordsDto();
				dto.setId(resultSet.getInt("id"));
				dto.setContent(resultSet.getString("content"));
				dto.setDescription(resultSet.getString("description"));
				dto.setTranslation(resultSet.getString("translation"));
				dto.setExample(resultSet.getString("examples"));
				dto.setLanguage_id(resultSet.getInt("language_id"));
				dtoList.add(dto);
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
	
	public wordsDto findOne(String word) {
		try {
			wordsDto dto = new wordsDto();
			String queryString = "Select * from words where content=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, word);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
					dto.setId(resultSet.getInt("id"));
					dto.setContent(resultSet.getString("content"));
					dto.setDescription(resultSet.getString("description"));
					dto.setLanguage_id(resultSet.getInt("language_id"));
					dto.setTranslation(resultSet.getString("translation"));
					dto.setExample(resultSet.getString("examples"));

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
	
	public wordsDto findOneId(Integer id) {
		try {
			wordsDto dto = new wordsDto();
			String queryString = "Select * from words where id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
					dto.setId(resultSet.getInt("id"));
					dto.setContent(resultSet.getString("content"));
					dto.setDescription(resultSet.getString("description"));
					dto.setLanguage_id(resultSet.getInt("language_id"));
					dto.setTranslation(resultSet.getString("translation"));
					dto.setExample(resultSet.getString("examples"));
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

}
