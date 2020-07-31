package project.management.service;

import java.util.List;

import project.management.entity.StoreMachineEntity;

public interface IStoreMachineService {
	StoreMachineEntity addStoreMachine(StoreMachineEntity storeMachineEntity);
	StoreMachineEntity updateStoreMachine(StoreMachineEntity storeMachineEntity);
	void deleteStoreMachine(int id);
	List<StoreMachineEntity> findAll();
	StoreMachineEntity findOneById(int id);
}
