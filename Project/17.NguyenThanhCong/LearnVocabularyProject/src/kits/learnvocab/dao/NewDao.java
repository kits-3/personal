package kits.learnvocab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kits.learnvocab.config.ConnectionFactory;
import kits.learnvocab.dto.NewDto;
import kits.learnvocab.dto.TopicDto;

public class NewDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public NewDao() {
	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public List<NewDto> findByLang_Topic(int a, int b) {
		List<NewDto> dtoList = new ArrayList<NewDto>();
		try {
			String queryString = "SELECT connectword.id, word_vn.name AS name_vn,connectword.name "
					+ " FROM  word_vn, connectword WHERE lang_id = ? AND connectword.topic_id = ? AND"
					+ " word_vn.id = connectword.vn_id  ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, a);
			ptmt.setInt(2, b);
			resultSet = ptmt.executeQuery();

			while (resultSet.next()) {
				NewDto lstp = new NewDto();
				lstp.setId(resultSet.getInt("id"));
				lstp.setName_vn((resultSet.getString("name_vn")));
				lstp.setName((resultSet.getString("name")));
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
