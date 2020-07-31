package project.management.repository;

import project.management.entity.UserEntity;

public interface IUserRepository {
	UserEntity findbyuserNameAndPassword(String user);
}
