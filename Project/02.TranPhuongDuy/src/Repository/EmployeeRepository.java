package Repository;

import java.util.List;

import Entity.EmployeeEntity;


public interface EmployeeRepository{
	List<EmployeeEntity> findAll();
	int delete();
	void update(EmployeeEntity employeeEntity);
	void add(EmployeeEntity employeeEntity);
	
}