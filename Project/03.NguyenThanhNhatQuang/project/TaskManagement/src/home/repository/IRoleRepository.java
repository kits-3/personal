package home.repository;

import home.entity.RoleEntity;

public interface IRoleRepository {
	RoleEntity getRole(int idRole);
	String getNameRole(int idUser);
}
