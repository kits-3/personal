package project.management.repository.impl;

import java.util.List;

import project.management.entity.StoreMachineEntity;
import project.management.mapper.StoreMachineMapper;
import project.management.repository.IStoreMachineRepository;

public class StoreMachineRepository extends AbstrachRepository<StoreMachineEntity> implements IStoreMachineRepository {

	@Override
	public List<StoreMachineEntity> findAll() {
		String sql = "SELECT * FROM storemachine";
		return query(sql, new StoreMachineMapper());
	}

	@Override
	public int addStoreMachine(StoreMachineEntity storeMachineEntity) {
		StringBuilder sql = new StringBuilder("INSERT INTO storemachine ");
		sql.append(" (name, address, userid, status)");
		sql.append(" VALUES(?, ?, ?, ?)");
		return insert(sql.toString(), storeMachineEntity.getName(), storeMachineEntity.getAddress(), storeMachineEntity.getUserid(), storeMachineEntity.getStatus());

	}

	@Override
	public void updateStoreMachine(StoreMachineEntity storeMachineEntity) {
		StringBuilder sql = new StringBuilder("UPDATE storemachine ");
		sql.append(" SET name = ?, address = ?");
		sql.append(" WHERE id = ?");
		update(sql.toString(), storeMachineEntity.getName(), storeMachineEntity.getAddress(), storeMachineEntity.getId());
		
	}

	@Override
	public void deleteStoreMachine(int id) {
		String sql = "DELETE FROM storemachine WHERE id = ?";
		update(sql, id);	
	}

	@Override
	public StoreMachineEntity findOne(int id) {
		String sql = "SELECT * FROM  storemachine where id = ?";
		List<StoreMachineEntity> storeMachineEntities = query(sql, new StoreMachineMapper(), id);
		return storeMachineEntities.isEmpty() ? null : storeMachineEntities.get(0);
	}
	
}
