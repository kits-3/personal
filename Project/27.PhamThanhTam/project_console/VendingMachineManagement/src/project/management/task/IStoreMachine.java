package project.management.task;

import project.management.entity.StoreMachineEntity;

public interface IStoreMachine {
	void insertStoreMachine(StoreMachineEntity storeMachineEntity,StoreMachineEntity storeMachineAlreadyInserEntity);
	void updateStoreMachine(StoreMachineEntity storeMachineEntity);
	void deleteStoreMachine();
}
