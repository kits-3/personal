package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionFactory;
import Entity.dictionary_clientDto;

public class dictionaryClientDao {

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	public dictionaryClientDao() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public void add(dictionary_clientDto dto) {
		try {
			String queryString = "INSERT INTO "
					+ "dictionary_client(content,description,translation,example,language_id,create_by)"
					+ "VALUES(?,?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, dto.getContent());
			ptmt.setString(2, dto.getDescription());
			ptmt.setString(3, dto.getTranslation());
			ptmt.setString(4, dto.getExample());
			ptmt.setInt(5, dto.getLanguage_id());
			ptmt.setString(6, dto.getCreateBy());
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

	public void update(dictionary_clientDto dto) {
		try {
			String queryString = "update dictionary_client set content=?," + "description=?," + "translation=?,"
					+ "example=?," + "language_id=?," + "create_by=?  where id = ?";

			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, dto.getContent());
			ptmt.setString(2, dto.getDescription());
			ptmt.setString(3, dto.getTranslation());
			ptmt.setString(4, dto.getExample());
			ptmt.setInt(5, dto.getLanguage_id());
			ptmt.setString(6, dto.getCreateBy());
			ptmt.setInt(7, dto.getId());
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
	
	public void updateDictionary(dictionary_clientDto dto) {
		try {
			String queryString = "update dictionary_client set content=?," + "description=?," + "translation=?,"
					+ "example=?," + "language_id=?," + "create_by=?  where id = ?";

			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, dto.getContent());
			ptmt.setString(2, dto.getDescription());
			ptmt.setString(3, dto.getTranslation());
			ptmt.setString(4, dto.getExample());
			ptmt.setInt(5, dto.getLanguage_id());
			ptmt.setString(6, dto.getCreateBy());
			ptmt.setInt(7, dto.getId());
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
			String queryString = "delete from dictionary_client where id =?";
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

	public void delete(int id, String create_by) {
		try {
			String queryString = "delete from dictionary_client where id =? and create_by=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			ptmt.setString(2, create_by);
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

	public List<dictionary_clientDto> findAll() {
		try {
			String queryString = "Select * from dictionary_client";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			List<dictionary_clientDto> dtoList = new ArrayList<dictionary_clientDto>();
			int i = 0;
			while (resultSet.next()) {
				dictionary_clientDto dto = new dictionary_clientDto();
				dto.setId(resultSet.getInt("id"));
				dto.setContent(resultSet.getString("content"));
				dto.setDescription(resultSet.getString("description"));
				dto.setTranslation(resultSet.getString("translation"));
				dto.setExample(resultSet.getString("example"));
				dto.setLanguage_id(resultSet.getInt("language_id"));
				dto.setCreateBy(resultSet.getString("create_by"));
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

	public List<dictionary_clientDto> findByCreateBy(String createBy) {
		try {
			String queryString = "Select * from dictionary_client where create_by=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, createBy);
			resultSet = ptmt.executeQuery();
			List<dictionary_clientDto> dtoList = new ArrayList<dictionary_clientDto>();
			int i = 0;
			while (resultSet.next()) {
				dictionary_clientDto dto = new dictionary_clientDto();
				dto.setId(resultSet.getInt("id"));
				dto.setContent(resultSet.getString("content"));
				dto.setDescription(resultSet.getString("description"));
				dto.setTranslation(resultSet.getString("translation"));
				dto.setExample(resultSet.getString("example"));
				dto.setLanguage_id(resultSet.getInt("language_id"));
				dto.setCreateBy(resultSet.getString("create_by"));
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

	public List<dictionary_clientDto> findWord(String word) {
		try {
			String queryString = "Select * from dictionary_client where content LIKE '%" + word
					+ "%' OR translation LIKE '%" + word + "%' ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			List<dictionary_clientDto> dtoList = new ArrayList<dictionary_clientDto>();
			int i = 0;
			while (resultSet.next()) {
				dictionary_clientDto dto = new dictionary_clientDto();
				dto.setId(resultSet.getInt("id"));
				dto.setContent(resultSet.getString("content"));
				dto.setDescription(resultSet.getString("description"));
				dto.setTranslation(resultSet.getString("translation"));
				dto.setExample(resultSet.getString("example"));
				dto.setLanguage_id(resultSet.getInt("language_id"));
				dto.setLanguage_id(resultSet.getInt("create_by"));
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

	public List<dictionary_clientDto> findWordByClient(String word, Integer languageId) {
		try {
			String queryString = "Select * from dictionary_client where content LIKE '%" + word
					+ "%' OR translation LIKE '%" + word + "%' AND language_id = " + languageId;
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			List<dictionary_clientDto> dtoList = new ArrayList<dictionary_clientDto>();
			int i = 0;
			while (resultSet.next()) {
				dictionary_clientDto dto = new dictionary_clientDto();
				dto.setId(resultSet.getInt("id"));
				dto.setContent(resultSet.getString("content"));
				dto.setDescription(resultSet.getString("description"));
				dto.setTranslation(resultSet.getString("translation"));
				dto.setExample(resultSet.getString("example"));
				dto.setLanguage_id(resultSet.getInt("language_id"));
				dto.setCreateBy(resultSet.getString("create_by"));
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

	public dictionary_clientDto findOne(String word) {
		try {
			dictionary_clientDto dto = new dictionary_clientDto();
			String queryString = "Select * from dictionary_client where content=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, word);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				dto.setId(resultSet.getInt("id"));
				dto.setContent(resultSet.getString("content"));
				dto.setDescription(resultSet.getString("description"));
				dto.setTranslation(resultSet.getString("translation"));
				dto.setExample(resultSet.getString("example"));
				dto.setLanguage_id(resultSet.getInt("language_id"));
				dto.setCreateBy(resultSet.getString("create_by"));

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
	
	public dictionary_clientDto findDictionaryByCreateBy(Integer id , String create_by) {
		try {
			dictionary_clientDto dto = new dictionary_clientDto();
			String queryString = "Select * from dictionary_client where id=? and create_by=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			ptmt.setString(2, create_by);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				dto.setId(resultSet.getInt("id"));
				dto.setContent(resultSet.getString("content"));
				dto.setDescription(resultSet.getString("description"));
				dto.setTranslation(resultSet.getString("translation"));
				dto.setExample(resultSet.getString("example"));
				dto.setLanguage_id(resultSet.getInt("language_id"));
				dto.setCreateBy(resultSet.getString("create_by"));

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
