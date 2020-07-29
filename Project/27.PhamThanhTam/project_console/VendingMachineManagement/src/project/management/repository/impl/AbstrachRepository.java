package project.management.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.management.config.ConnectionFatory;
import project.management.controlandmanagement.IProduct;
import project.management.controlandmanagement.impl.Product;
import project.management.mapper.RowMapper;
import project.management.repository.GenericRepository;

public class AbstrachRepository<T> implements GenericRepository<T> {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFatory.getInstance().getConnection();
		return conn;
	}

	private void setParameter(PreparedStatement ptmt, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Integer) {
					ptmt.setInt(index, (int) parameter);
				} else if (parameter instanceof String) {
					ptmt.setString(index, (String) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		try {
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			setParameter(ptmt, parameters);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (connection != null) {
					connection.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

	}

	@Override
	public void update(String sql, Object... parameters) {
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			ptmt = connection.prepareStatement(sql);
			setParameter(ptmt, parameters);
			ptmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {

				try {
					System.out.println("update false!!! out to select !!! ");
					connection.rollback();
					IProduct product = new Product();
					product.product();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
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
	public int insert(String sql, Object... parameters) {
		try {
			int id = 0;
			connection = getConnection();
			connection.setAutoCommit(false);
			ptmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			setParameter(ptmt, parameters);
			ptmt.executeUpdate();
			resultSet = ptmt.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			connection.commit();
			return id; 
		} catch (SQLException e) {
			if (connection != null) {
				try {
					System.out.println("insert false!!! please check information and input again!!! ");
					connection.rollback();
					IProduct product = new Product();
					product.productOption("1");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
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
		return 0;
	}

}
