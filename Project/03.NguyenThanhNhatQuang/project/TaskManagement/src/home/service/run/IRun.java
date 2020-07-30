package home.service.run;

import java.util.ArrayList;

import home.entity.RoleEntity;
import home.entity.TaskDetailEntity;
import home.entity.TaskEntity;
import home.entity.UserEntity;

public interface IRun {
	void run();
	int startProcess();
	int loginOrGoback();
	int registerOrGoback();
	UserEntity loginAccount();
	UserEntity loginAccount(String userName, String passWord);
	ArrayList<String> isRegisterSuccess();
	String userName();
	String passWord();
	String email();
	String lname();
	String fname();
	String phone();
	String headerTask();
	
	String contentTaskDetail();
	
	int status();
	int display();
	String description();
	
	RoleEntity getRole(int idUser);
	
	ArrayList<TaskEntity> lsTask(int idUser);
	ArrayList<TaskDetailEntity> lsTaskDetail(int idTask);
	TaskEntity getTaskByIdUserAndIdTask(int idUser, int idTask);
	TaskDetailEntity getTaskDetailByIdTaskDetail(int idTaskDetail);

	boolean isTaskExistByUserId(String header, int idUser);
	boolean isUpdateTaskSuccess(int idTask, String header, int status, int display, String description);
	boolean isUpdateTaskByStatusOrDisplayOrDescriptionSuccess(int idTask, int status, int display, String description);
	boolean isCreateTaskDetailByIdTask(int idTask, String content);
	boolean isUpdateTaskDetail(int idTaskDetail, String content, int status, int display, String description);
	
	boolean isChangePassWord(String username, String password);
	boolean isUpdateSuccess(int idUser, String password, String email, String lname, String fname, String description, String phone);
	boolean isCheckEmailUserExist(String email);
	
	String getNameRole(int idUser);
	
	void case6(UserEntity user); // show information
	UserEntity case7(UserEntity user); // edit information user
	void case8(UserEntity user); //logout
	ArrayList<UserEntity> case9(); // show all user
	
	boolean case10(int idUser, int status);
	
	void case11(int idUser, String username);
	
	boolean isSuccess(int idUser, int idRole);
	
	void getListTask();
	
	void getListTaskDetail(int idUser, String username);
	
	void case12(int idUser, String username);
	
	void case13(int idUser, String username);
	
	String getUserName(int idUser);
	String getTaskName(int idTask);
	String getUserNameByIdTaskDetail(int idTaskFromTaskDetail);
	
	int idTaskFinalByIdUser(int idUser);
}