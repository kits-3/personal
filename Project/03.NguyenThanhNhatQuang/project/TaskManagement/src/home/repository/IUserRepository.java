package home.repository;

import java.util.ArrayList;

import home.entity.UserEntity;

public interface IUserRepository {
	ArrayList<UserEntity> getListUser();
	UserEntity setUserLogin(String userName, String passWord);
	boolean setUserRegister(String userName, String passWord, String email, String lname, String fname, String phone);
	boolean isChangePasswordUser(String userName, String passWord);
	boolean isUpdateInformationSuccess(int idUser, String password, String email, String lname, String fname, String description, String phone);
	boolean isCheckEmailExist(String email);
	boolean isLockOrUnlockAccount(int idUser, int status);
	boolean isChangeRoleUser(int idUser, int idRole);
	String getTaskNameByUserId(int idUser);
	String getUserNameByTaskDetail(int idTaskDetail);
}
