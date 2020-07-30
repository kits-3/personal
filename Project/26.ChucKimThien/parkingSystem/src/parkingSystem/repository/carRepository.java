package parkingSystem.repository;

import java.util.List;

import parkingSystem.entity.car;

public interface carRepository {
	List<car> findAll();
	car findById(int id);
	int update();
	int delete();
	void add(car Car);
	int getID(int id_user);
}
