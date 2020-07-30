package kits.learnvocab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kits.learnvocab.config.ConnectionFactory;
import kits.learnvocab.dto.NewDto;
import kits.learnvocab.dto.TableExtra1Dto;

public class TableExtra1Dao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public TableExtra1Dao() {
		
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public  List<TableExtra1Dto> findByTopic(int a) {
		List<TableExtra1Dto> dtoList = new ArrayList<TableExtra1Dto>();
		try {
			String queryString = "SELECT distinct word_vn.id, word_vn.name AS name_vn  FROM  word_vn, connectword WHERE  connectword.topic_id = ? AND word_vn.id = connectword.vn_id   ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			
			ptmt.setInt(1, a);
			resultSet = ptmt.executeQuery();

			while (resultSet.next()) {
				TableExtra1Dto lstp = new TableExtra1Dto();
				lstp.setId(resultSet.getInt("id"));
				lstp.setName_vn((resultSet.getString("name_vn")));
				
				dtoList.add(lstp);

			}
			return dtoList;
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
		
		return dtoList;
	}

}

