package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.EmployeeEntity;
import config.ConnectionFactory;


public class EmployeeRepositorylmpl implements EmployeeRepository {
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	@Override
	public List<EmployeeEntity> findAll() {
		List<EmployeeEntity> lsEmployee = new ArrayList();
		String queryString = "SELECT * FROM employee";
		
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); //Select
			
			while(rs.next()) {
				EmployeeEntity cus = new EmployeeEntity();
				cus.setEmp_id(rs.getInt(1));
				cus.setEmp_name(rs.getString("Emp_name"));
				cus.setEmail(rs.getString("Email"));
				cus.setPhone(rs.getString("Phone"));
				cus.setSalary(rs.getInt("Salary"));
				cus.setAccount_Id(rs.getInt("Account_Id"));
				lsEmployee.add(cus);
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lsEmployee;
		
	}

	public void add(EmployeeEntity employeeEntity) {
		try {
			String queryString = "INSERT INTO " + "employee(Emp_name, Email, Phone ,  Salary, Account_Id) "
	        + "VALUES(?,?,?,?,?)";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, employeeEntity.getEmp_name());
			stmt.setString(2, employeeEntity.getEmail());
			stmt.setString(3, employeeEntity.getPhone());
			stmt.setInt(4, employeeEntity.getSalary());
			stmt.setInt(5, employeeEntity.getAccount_Id());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) {
					stmt.close();
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
	@Override
	public void update(EmployeeEntity employeeEntity) {
		List<EmployeeEntity> lsEmployee = new ArrayList();
		String queryString = "update employee set Emp_name=?,"+ "Email=?," + "Phone=?," +"Salary=?," +"Account_Id";
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
		    stmt.executeUpdate();
			stmt.setString(1, employeeEntity.getEmp_name() );
			stmt.setString(2, employeeEntity.getEmail());
			stmt.setString(3, employeeEntity.getPhone());
			stmt.setInt(4, employeeEntity.getSalary());
			stmt.setInt(5, employeeEntity.getAccount_Id());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			 try {
				 if(stmt !=null) {
					 stmt.close();
				 }
				 if(connection !=null) {
					 connection.close();
				 }
			 }catch(SQLException e) {
				 e.printStackTrace();
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		 }
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

}
