package parkingSystem.repository;

import java.util.List;

import parkingSystem.entity.park;

public interface parkRepository {
	List<park> findAll();
	park findById(int id);
	int update();
	int delete();
	void add(park Park);
	int getID(int ID_park);
}
