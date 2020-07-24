package parkingSystem.repository;

import java.util.List;

import parkingSystem.entity.parking;

public interface parkingRepository {
	List<parking> findAll();
	parking findById(int id);
	int update();
	int delete();
}
