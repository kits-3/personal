package project.management.task;

import java.util.List;

import project.management.entity.StoreMachineEntity;

public interface IStatistics {
	void statistics();
	void findAllProductOfAMachine(int id);
	void findAllMachine();
	void finance();
	void graph(List<StoreMachineEntity> storeMachineEntities, int sumAll);
}
