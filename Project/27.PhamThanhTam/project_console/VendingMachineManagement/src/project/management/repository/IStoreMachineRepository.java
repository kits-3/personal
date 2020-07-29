package project.management.repository;

import java.util.List;

import project.management.entity.StoreMachineEntity;

public interface IStoreMachineRepository extends GenericRepository<StoreMachineEntity> {
	List<StoreMachineEntity> findAll() ;
	int addStoreMachine(StoreMachineEntity storeMachineEntity);
	void updateStoreMachine(StoreMachineEntity storeMachineEntity);
	void deleteStoreMachine(int id);
	StoreMachineEntity findOne(int id);
}
