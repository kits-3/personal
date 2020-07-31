package home.service.run.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import home.entity.RoleEntity;
import home.entity.TaskDetailEntity;
import home.entity.TaskEntity;
import home.entity.UserEntity;
import home.repository.IRoleRepository;
import home.repository.ITaskRepository;
import home.repository.IUserRepository;
import home.repository.impl.RoleRepositoryImpl;
import home.repository.impl.TaskDetailRepositoryImpl;
import home.repository.impl.TaskReopsitoryImpl;
import home.repository.impl.UserRepositoryImpl;
import home.service.input.IInput;
import home.service.input.impl.InputImpl;
import home.service.menu.IMenu;
import home.service.menu.impl.MenuImpl;
import home.service.run.IRun;

public class RunImpl implements IRun {

	private StringBuffer buffer = new StringBuffer();
	private String logUser = null;
	private LocalDateTime date = LocalDateTime.now();
	private FileInputStream fs = null;
	private FileOutputStream fo = null;
	private byte[] bytes;

	public void run() {

		UserEntity user;
		RoleEntity role;
		TaskEntity task;
		TaskDetailEntity taskOneDetail;

		boolean status = true;
		int userChoose = 0;

		menuStart: while (status) {
			userChoose = startProcess();
			if (userChoose == 1) {
				loopLogin: while (status) {
					userChoose = loginOrGoback();
					if (userChoose == 1) {
						login: while (status) {
							user = loginAccount();
							if (user != null) {
								try {
									try {
										logUser = "C:\\Users\\ThePlayer\\Desktop\\taskmanagement\\TaskManagementConsoleJava\\project\\TaskManagement\\src\\home\\log\\"
												+ (user.getId() + "_" + user.getUsername() + ".txt");
										fs = new FileInputStream(logUser);
										int c;
										while ((c = fs.read()) != -1) {
											buffer.append((char) c);
										}
										fs.close();
									} catch (IOException e) {
										fo = new FileOutputStream(logUser);
									}
									logUser = "C:\\Users\\ThePlayer\\Desktop\\taskmanagement\\TaskManagementConsoleJava\\project\\TaskManagement\\src\\home\\log\\"
											+ (user.getId() + "_" + user.getUsername() + ".txt");
									fo = new FileOutputStream(logUser);
									buffer.append("=========================LOG=========================\n");
									String exportFile = date + ": Id: " + user.getId() + ". Username: "
											+ user.getUsername() + ". Login Account. Status: Success.\n";
									buffer.append(exportFile);
									System.out.println("Welcome: " + user.getLname() + " : " + user.getFname());
									if (user.getStatus() == 0) {
										boolean goback = true;
										while (goback) {
											System.out.println("Your account is locked. Contact Admin. Try again");
											exportFile = date + ": Id: " + user.getId() + ". Username: "
													+ user.getUsername()
													+ ". Account is access denied. Status: Lock.\n";
											buffer.append(exportFile);
											System.out.println("1. Logout");
											new MenuImpl().menuChoose();
											userChoose = new InputImpl().userChoose();
											if (userChoose == 1) {
												goback = false;
												case8(user);
												continue menuStart;
											} else {
												goback = true;
												exportFile = date + ": Id: " + user.getId() + ". Username: "
														+ user.getUsername() + ". Input: " + userChoose
														+ ". Feature does not exist. Status: Input Error.\n";
												buffer.append(exportFile);
											}
										}
									} else {
										role = getRole(user.getId()); // return RoleEntity
										mainmenu: while (status) {
											if (role.getName().equals("ADMIN")) {
												new MenuImpl().menuAdmin();
												exportFile = date + ": Id: " + user.getId() + ". Username: "
														+ user.getUsername() + ". Role: " + role.getName() + " "
														+ ". Logout Account. Status: Success\n";
												buffer.append(exportFile);
											} else {
												new MenuImpl().menuUser();
												exportFile = date + ": Id: " + user.getId() + ". Username: "
														+ user.getUsername() + " " + role.getName() + " "
														+ ". Logout Account. Status: Success\n";
												buffer.append(exportFile);
											}
											new MenuImpl().menuChoose();
											userChoose = new InputImpl().userChoose();
											switch (userChoose) {
											case 1: {
												exportFile = date + ": Id: " + user.getId() + ". Username: "
														+ user.getUsername() + ". Role: " + role.getName() + " "
														+ ". User Choose Feature: Create Task. Status: Choose Success\n";
												buffer.append(exportFile);
												createtask: while (status) {
													new MenuImpl().menuCreateTask();
													new MenuImpl().menuChoose();
													userChoose = new InputImpl().userChoose();
													if (userChoose == 1) {
														exportFile = date + ": Id: " + user.getId() + ". Username: "
																+ user.getUsername() + ". Role: " + role.getName() + " "
																+ ". Proceed: Create Task. Status: Proceed.\n";
														buffer.append(exportFile);
														againcreatetask: while (status) {
															String header = headerTask();
															boolean checkTaskCreateSuccess = isTaskExistByUserId(header,
																	user.getId());
															exportFile = date + ": Id: " + user.getId() + ". Username: "
																	+ user.getUsername() + ". Role: " + role.getName()
																	+ " " + ". Proceed: Create Task." + " Name Task: "
																	+ header + " " + ". Status: Input Header Task.\n";
															buffer.append(exportFile);
															if (checkTaskCreateSuccess == true) {
																System.out.println("Create Task Success");
																int idTaskJustCreate = idTaskFinalByIdUser(
																		user.getId());
																exportFile = date + ": Id: " + user.getId()
																		+ ". Username: " + user.getUsername()
																		+ ". Role: " + role.getName() + " "
																		+ ". Create Task Success." + " Id:"
																		+ idTaskJustCreate + ". Name Task: " + header
																		+ ". Status: Create Task Success.\n";
																buffer.append(exportFile);
																while (status) {
																	System.out.println(
																			"Do you want to continue to create task: ? (1:yes / 2: go back)");
																	new MenuImpl().menuChoose();
																	userChoose = new InputImpl().userChoose();
																	if (userChoose == 1) {
																		exportFile = date + ": Id: " + user.getId()
																				+ ". Username: " + user.getUsername()
																				+ ". Role: " + role.getName() + " "
																				+ ". Continue Create Task"
																				+ ". Status: Create Task.\n";
																		buffer.append(exportFile);
																		continue createtask;
																	} else if (userChoose == 2) {
																		exportFile = date + ": Id: " + user.getId()
																				+ ". Username: " + user.getUsername()
																				+ ". Role: " + role.getName() + " "
																				+ ". Go back."
																				+ ". Status: Exist Feature Create Task.\n";
																		buffer.append(exportFile);
																		continue mainmenu;
																	} else {
																		exportFile = date + ": Id: " + user.getId()
																				+ ". Username: " + user.getUsername()
																				+ ". Role: " + role.getName() + " "
																				+ ". Feature does not exist"
																				+ ". Status: Input Error.\n";
																		buffer.append(exportFile);
																		System.out.println("Please input 1 2: ");
																	}
																}
															} else {
																//// Never Run
																System.out.println(
																		"Task existed. Do you want to update this task?");

																exportFile = date + " : " + user.getId() + " "
																		+ user.getUsername()
																		+ ". Create Task Failed.\n";
																buffer.append(exportFile);
																bytes = buffer.toString().getBytes();

																System.out.println(
																		"Do you want to input again: ? (1:yes / 2: go back)");
																new MenuImpl().menuChoose();
																userChoose = new InputImpl().userChoose();
																if (userChoose == 1) {
																	continue againcreatetask;
																} else {
																	continue mainmenu;
																}
																////
															}
														}
													} else {
														exportFile = date + ": Id: " + user.getId() + ". Username: "
																+ user.getUsername() + ". Role: " + role.getName() + " "
																+ ". Go Back Menu Main" + ". Status: Go Back.\n";
														buffer.append(exportFile);
														continue mainmenu;
													}
												}
											}
											case 2: {
												exportFile = date + ": Id: " + user.getId() + ". Username: "
														+ user.getUsername() + ". Role: " + role.getName() + " "
														+ ". User choose: " + userChoose
														+ ". User Choose Feature: Read Task" + ". Status: Success.\n";
												buffer.append(exportFile);
												while (status) {
													new MenuImpl().menuReadTask();
													new MenuImpl().menuChoose();
													userChoose = new InputImpl().userChoose();
													if (userChoose == 1) {
														ArrayList<TaskEntity> listTask = lsTask(user.getId());
														if (listTask != null) {
															exportFile = date + ": Id: " + user.getId() + ". Username: "
																	+ user.getUsername() + ". Role: " + role.getName()
																	+ " " + ". User choose: " + userChoose
																	+ ". Procced Read Task" + ". Status: Procced\n.";
															buffer.append(exportFile);
															System.out.println("Currently. You have " + listTask.size()
																	+ " tasks.");
															System.out.println("ID\tTitle\t\tDeadline\t\t\tStatus");
															for (TaskEntity tk : listTask) {
																System.out.printf("%-8s%-16s%-32s%-50s\n", tk.getId(),
																		tk.getHeader(), tk.getDeadline_date(),
																		(tk.getStatus() == 0 ? "incomplete"
																				: "complete"));
															}
															System.out.println("Read Task End");

															exportFile = date + ": Id: " + user.getId() + ". Username: "
																	+ user.getUsername() + ". Role: " + role.getName()
																	+ ". Read Task" + ". Status: Success.\n";
															buffer.append(exportFile);
															while (status) {
																System.out.println("Please input 1 to continue: ");
																new MenuImpl().menuChoose();
																userChoose = new InputImpl().userChoose();
																if (userChoose == 1) {
																	exportFile = date + ": Id: " + user.getId()
																			+ ". Username: " + user.getUsername()
																			+ ". Role: " + role.getName() + " "
																			+ ". User choose: " + userChoose
																			+ ". Go Back Main Menu"
																			+ ". Status: Go Back.\n";
																	buffer.append(exportFile);
																	continue mainmenu;
																} else {
																	exportFile = date + ": Id: " + user.getId()
																			+ ". Username: " + user.getUsername()
																			+ ". Role: " + role.getName() + " "
																			+ ". User choose: " + userChoose
																			+ ". Feature does not exist"
																			+ ". Status: Input error.\n";
																	buffer.append(exportFile);
																	System.out.println("Please input 1");
																}
															}
														} else {
															System.out.println("You don't have task.");
															System.out.println("Read Task End");

															exportFile = date + ": Id: " + user.getId() + ". Username: "
																	+ user.getUsername() + ". Role: " + role.getName()
																	+ ". Read Task Fail"
																	+ ". Status: Fail. Detail: Not Task To Read.\n";
															buffer.append(exportFile);

															while (status) {
																System.out.println("Please input 1 to continue: ");
																new MenuImpl().menuChoose();
																userChoose = new InputImpl().userChoose();
																if (userChoose == 1) {
																	exportFile = date + ": Id: " + user.getId()
																			+ ". Username: " + user.getUsername()
																			+ ". Role: " + role.getName() + " "
																			+ ". User choose: " + userChoose
																			+ ". Go Back Main Menu"
																			+ ". Status: Go Back.\n";
																	buffer.append(exportFile);
																	continue mainmenu;
																} else {
																	exportFile = date + ": Id: " + user.getId()
																			+ ". Username: " + user.getUsername()
																			+ ". Role: " + role.getName() + " "
																			+ ". User choose: " + userChoose
																			+ ". Feature does not exist"
																			+ ". Status: Input error.\n";
																	buffer.append(exportFile);
																	System.out.println("Please input 1");
																}
															}
														}
													} else if (userChoose == 2) {
														exportFile = date + ": Id: " + user.getId() + ". Username: "
																+ user.getUsername() + ". Role: " + role.getName() + " "
																+ ". User choose: " + userChoose + ". Go Back Main Menu"
																+ ". Status: Go Back.\n";
														buffer.append(exportFile);
														continue mainmenu;
													} else {
														exportFile = date + ": Id: " + user.getId() + ". Username: "
																+ user.getUsername() + ". Role: " + role.getName() + " "
																+ ". User choose: " + userChoose
																+ ". Feature does not exist"
																+ ". Status: Input error.\n";
														buffer.append(exportFile);
														System.out.println("Please input 1 2: ");
													}
												}
												break;
											}
											case 3: {
												exportFile = date + ": Id: " + user.getId() + ". Username: "
														+ user.getUsername() + ". Role: " + role.getName() + " "
														+ ". User choose: " + userChoose + ". Edit And Update Task"
														+ ". Status: Choose Success.\n";
												buffer.append(exportFile);
												new MenuImpl().menuEditAndUpdateTask();
												new MenuImpl().menuChoose();
												userChoose = new InputImpl().userChoose();
												if (userChoose == 1) {
													listtask: while (status) {
														exportFile = date + ": Id: " + user.getId() + ". Username: "
																+ user.getUsername() + ". Role: " + role.getName() + " "
																+ ". User choose: " + userChoose
																+ ". Edit And Update Task"
																+ ". Status: Choose Success.\n";
														buffer.append(exportFile);
														ArrayList<TaskEntity> listTask = lsTask(user.getId());
														if (listTask != null) {
															exportFile = date + ": Id: " + user.getId() + ". Username: "
																	+ user.getUsername() + ". Role: " + role.getName()
																	+ " " + ". User choose: " + userChoose
																	+ ". Procced Edit And Update Task"
																	+ ". Status: Procced.\n";
															buffer.append(exportFile);
															System.out.println("Currently. You have " + listTask.size()
																	+ " tasks.");
															System.out.println("ID\tTitle\t\tDeadline\t\t\tStatus");
															for (TaskEntity tk : listTask) {
																System.out.printf("%-8s%-16s%-32s%-50s\n", tk.getId(),
																		tk.getHeader(), tk.getDeadline_date(),
																		(tk.getStatus() == 0 ? "incomplete"
																				: "complete"));
															}
															System.out.println("Read Task End");
															exportFile = date + ": Id: " + user.getId() + ". Username: "
																	+ user.getUsername() + ". Role: " + role.getName()
																	+ " " + ". User choose: " + userChoose
																	+ ". Procced Edit And Update Task"
																	+ ". Status: Procced. Detail: Read Task Success.\n";
															buffer.append(exportFile);
															System.out.println("Input id task you want to edit: ");
															new MenuImpl().menuChoose();
															userChoose = new InputImpl().userChoose();
															exportFile = date + ": Id: " + user.getId() + ". Username: "
																	+ user.getUsername() + ". Role: " + role.getName()
																	+ " " + ". User Input Id Task: " + userChoose
																	+ ". Procced Edit And Update Task"
																	+ ". Status: Procced. Detail: Input Id Task.\n";
															buffer.append(exportFile);

															task = getTaskByIdUserAndIdTask(user.getId(), userChoose);
															exportFile = date + ": Id: " + user.getId() + ". Username: "
																	+ user.getUsername() + ". Role: " + role.getName()
																	+ " " + ". User Input Id Task: " + userChoose
																	+ ". Task User Choose: "
																	+ (task == null ? null : task.getHeader())
																	+ ". Procced Edit And Update Task"
																	+ ". Status: Procced. Detail: Choose Task Success.\n";
															buffer.append(exportFile);
															taskcurrent: while (status) {
																if (task != null) {

																	exportFile = date + ": Id: " + user.getId()
																			+ ". Username: " + user.getUsername()
																			+ ". Role: " + role.getName() + " "
																			+ ". User Input Id Task: " + userChoose
																			+ ". Task User Choose: " + task.getHeader()
																			+ ". Procced Edit And Update Task"
																			+ ". Status: Procced. Detail: Get Task Success.\n";
																	buffer.append(exportFile);
																	System.out.println("Task ban da chon:");
																	System.out.println(
																			"ID\tTitle\t\tOwner\t\tCreate_date\t\tUpdate_create\t\tDeadline\t\tDead_line\t\tStatus\t\tDisplay\t\tDescription");
																	System.out.printf(
																			"%-8s%-16s%-16s%-24s%-24s%-24s%-24s%-16s%-16s%-8s\n",
																			task.getId(), task.getHeader(),
																			user.getUsername(), task.getCreate_date(),
																			task.getUpdate_date(),
																			task.getDeadline_date(),
																			task.getDelete_date(),
																			(task.getStatus() == 0 ? "incomplete"
																					: "complete"),
																			(task.getDisplay() == 1 ? "display"
																					: "hidden"),
																			task.getDescription());

																	exportFile = date + ": Id: " + user.getId()
																			+ ". Username: " + user.getUsername()
																			+ ". Role: " + role.getName() + " "
																			+ ". User Input Id Task: " + userChoose
																			+ ". Task User Choose: " + task.getHeader()
																			+ ". Procced Edit And Update Task"
																			+ ". Status: Procced. Detail: Read Task Choose Success.\n";
																	buffer.append(exportFile);

																	new MenuImpl().menuEditOneTask();
																	new MenuImpl().menuChoose();
																	userChoose = new InputImpl().userChoose();
																	exportFile = date + ": Id: " + user.getId()
																			+ ". Username: " + user.getUsername()
																			+ ". Role: " + role.getName() + " "
																			+ ". User Input Id Task: " + userChoose
																			+ ". Task User Choose: " + task.getHeader()
																			+ ". Procced Edit And Update Task"
																			+ ". Status: Procced. Detail: Prepare Change Task.\n";
																	buffer.append(exportFile);
																	if (userChoose == 1) {
																		exportFile = date + ": Id: " + user.getId()
																				+ ". Username: " + user.getUsername()
																				+ ". Role: " + role.getName() + " "
																				+ ". User Input Id Task: " + userChoose
																				+ ". Task User Choose: "
																				+ task.getHeader()
																				+ ". Procced Edit And Update Task"
																				+ ". Status: Procced. Detail: Prepare Change Header Task.\n";
																		buffer.append(exportFile);
																		edittask: while (status) {
																			String titleTask = headerTask();
																			exportFile = date + ": Id: " + user.getId()
																					+ ". Username: "
																					+ user.getUsername() + ". Role: "
																					+ role.getName() + " "
																					+ ". User Input Id Task: "
																					+ userChoose
																					+ ". Task User Choose: "
																					+ task.getHeader()
																					+ ". New Header: " + titleTask
																					+ ". Procced Edit And Update Task"
																					+ ". Status: Procced. Detail: Input New Header Task.\n";
																			buffer.append(exportFile);
																			exportFile = date + ": Id: " + user.getId()
																					+ ". Username: "
																					+ user.getUsername() + ". Role: "
																					+ role.getName() + " "
																					+ ". User Input Id Task: "
																					+ userChoose
																					+ ". Task User Choose: "
																					+ task.getHeader()
																					+ ". New Header: " + titleTask
																					+ ". Procced Edit And Update Task"
																					+ ". Status: Procced. Detail: Process New Header Task.\n";
																			buffer.append(exportFile);
																			boolean isSuccess = isUpdateTaskSuccess(
																					task.getId(), titleTask,
																					task.getStatus(), task.getDisplay(),
																					task.getDescription());
																			if (isSuccess == true) {
																				System.out.println(
																						"Update Task Success. Do you want to update continue ? (1: current task / 2: list task / 3: go back)");

																				task.setHeader(titleTask);

																				exportFile = date + ": Id: "
																						+ user.getId() + ". Username: "
																						+ user.getUsername()
																						+ ". Role: " + role.getName()
																						+ " " + ". User Input Id Task: "
																						+ userChoose
																						+ ". Task User Choose: "
																						+ task.getHeader()
																						+ ". Procced Edit And Update Task"
																						+ ". Status: Procced. Detail: Change New Header Task Success.\n";
																				buffer.append(exportFile);

																				new MenuImpl().menuChoose();
																				userChoose = new InputImpl()
																						.userChoose();
																				if (userChoose == 1) {
																					exportFile = date + ": Id: "
																							+ user.getId()
																							+ ". Username: "
																							+ user.getUsername()
																							+ ". Role: "
																							+ role.getName() + " "
																							+ ". User Input Id Task: "
																							+ userChoose
																							+ ". Task User Choose: "
																							+ task.getHeader()
																							+ ". Procced Edit And Update Task"
																							+ ". Status: Procced. Detail: Go Back Task Current.\n";
																					buffer.append(exportFile);
																					continue taskcurrent;
																				} else if (userChoose == 2) {
																					exportFile = date + ": Id: "
																							+ user.getId()
																							+ ". Username: "
																							+ user.getUsername()
																							+ ". Role: "
																							+ role.getName() + " "
																							+ ". User Choose: "
																							+ userChoose
																							+ ". Procced Edit And Update Task"
																							+ ". Status: Procced. Detail: Go Back List Task.\n";
																					buffer.append(exportFile);
																					continue listtask;
																				} else if (userChoose == 3) {
																					exportFile = date + ": Id: "
																							+ user.getId()
																							+ ". Username: "
																							+ user.getUsername()
																							+ ". Role: "
																							+ role.getName() + " "
																							+ ". User Choose: "
																							+ userChoose
																							+ ". Procced Edit And Update Task"
																							+ ". Status: Procced. Detail: Go Back Main Menu.\n";
																					buffer.append(exportFile);
																					continue mainmenu;
																				} else {
																					exportFile = date + ": Id: "
																							+ user.getId()
																							+ ". Username: "
																							+ user.getUsername()
																							+ ". Role: "
																							+ role.getName() + " "
																							+ ". User choose: "
																							+ userChoose
																							+ ". Feature does not exist"
																							+ ". Status: Input error.\n";
																					buffer.append(exportFile);
																					System.out.println(
																							"Please input 1 2 3: ");
																				}
																			} else {
																				/// Never Run
																				System.out.println(
																						"Task existed. You want to input again (1: yes / 2: go back)");

																				exportFile = date + " : " + user.getId()
																						+ " " + user.getUsername()
																						+ ". Create Task Failed\n";
																				buffer.append(exportFile);
																				bytes = buffer.toString().getBytes();

																				new MenuImpl().menuChoose();
																				userChoose = new InputImpl()
																						.userChoose();
																				if (userChoose == 1) {
																					continue edittask;
																				} else {
																					continue mainmenu;
																				}
																				/////
																			}
																		}
																	} else if (userChoose == 2) {
																		exportFile = date + ": Id: " + user.getId()
																				+ ". Username: " + user.getUsername()
																				+ ". Role: " + role.getName() + " "
																				+ ". User Input Id Task: " + userChoose
																				+ ". Task User Choose: "
																				+ task.getHeader()
																				+ ". Procced Edit And Update Task"
																				+ ". Status: Procced. Detail: Prepare Change Status Task.\n";
																		buffer.append(exportFile);
																		edittask: while (status) {
																			int statusTask = status();
																			exportFile = date + ": Id: " + user.getId()
																					+ ". Username: "
																					+ user.getUsername() + ". Role: "
																					+ role.getName() + " "
																					+ ". User Input Id Task: "
																					+ userChoose
																					+ ". Task User Choose: "
																					+ task.getHeader()
																					+ ". Task Status Now: "
																					+ task.getStatus() + ". Change: "
																					+ statusTask
																					+ ". Procced Edit And Update Task"
																					+ ". Status: Procced. Detail: Procced Change Status Task.\n";
																			buffer.append(exportFile);
																			boolean isSuccess = isUpdateTaskByStatusOrDisplayOrDescriptionSuccess(
																					task.getId(), statusTask,
																					task.getDisplay(),
																					task.getDescription());
																			exportFile = date + ": Id: " + user.getId()
																					+ ". Username: "
																					+ user.getUsername() + ". Role: "
																					+ role.getName() + " "
																					+ ". User Input Id Task: "
																					+ userChoose
																					+ ". Task User Choose: "
																					+ task.getHeader()
																					+ ". Task Status Now: "
																					+ task.getStatus() + ". Change: "
																					+ statusTask
																					+ ". Procced Edit And Update Task"
																					+ ". Status: Procced. Detail: Procced Change Status Task.\n";
																			buffer.append(exportFile);
																			if (isSuccess == true) {
																				System.out.println(
																						"Update Task Success. Do you want to update continue ? (1: current task / 2: list task / 3: go back)");

																				task.setStatus(statusTask);

																				exportFile = date + ": Id: "
																						+ user.getId() + ". Username: "
																						+ user.getUsername()
																						+ ". Role: " + role.getName()
																						+ " " + ". User Input Id Task: "
																						+ userChoose
																						+ ". Task User Choose: "
																						+ task.getHeader()
																						+ ". Task Status Now: "
																						+ task.getStatus()
																						+ ". Procced Edit And Update Task"
																						+ ". Status: Procced. Detail: Change Status Task Success.\n";
																				buffer.append(exportFile);

																				new MenuImpl().menuChoose();
																				userChoose = new InputImpl()
																						.userChoose();

																				if (userChoose == 1) {
																					exportFile = date + ": Id: "
																							+ user.getId()
																							+ ". Username: "
																							+ user.getUsername()
																							+ ". Role: "
																							+ role.getName() + " "
																							+ ". User Input Id Task: "
																							+ userChoose
																							+ ". Task User Choose: "
																							+ task.getHeader()
																							+ ". Procced Edit And Update Task"
																							+ ". Status: Procced. Detail: Go Back Task Current.\n";
																					buffer.append(exportFile);
																					continue taskcurrent;
																				} else if (userChoose == 2) {
																					exportFile = date + ": Id: "
																							+ user.getId()
																							+ ". Username: "
																							+ user.getUsername()
																							+ ". Role: "
																							+ role.getName() + " "
																							+ ". User Choose: "
																							+ userChoose
																							+ ". Procced Edit And Update Task"
																							+ ". Status: Procced. Detail: Go Back List Task.\n";
																					buffer.append(exportFile);
																					continue listtask;
																				} else if (userChoose == 3) {
																					exportFile = date + ": Id: "
																							+ user.getId()
																							+ ". Username: "
																							+ user.getUsername()
																							+ ". Role: "
																							+ role.getName() + " "
																							+ ". User Choose: "
																							+ userChoose
																							+ ". Procced Edit And Update Task"
																							+ ". Status: Procced. Detail: Go Back Main Menu.\n";
																					buffer.append(exportFile);
																					continue mainmenu;
																				} else {
																					exportFile = date + ": Id: "
																							+ user.getId()
																							+ ". Username: "
																							+ user.getUsername()
																							+ ". Role: "
																							+ role.getName() + " "
																							+ ". User choose: "
																							+ userChoose
																							+ ". Feature does not exist"
																							+ ". Status: Input error.\n";
																					buffer.append(exportFile);
																					System.out.println(
																							"Please input 1 2 3: ");
																				}
																			} else {
																				// Never Run
																				System.out.println(
																						"Task existed. You want to input again (1: yes / 2: go back)");

																				exportFile = date + " : " + user.getId()
																						+ " " + user.getUsername()
																						+ ". Update Task Failed\n";
																				buffer.append(exportFile);
																				bytes = buffer.toString().getBytes();

																				new MenuImpl().menuChoose();
																				userChoose = new InputImpl()
																						.userChoose();
																				if (userChoose == 1) {
																					continue edittask;
																				} else {
																					continue mainmenu;
																				}
																				///
																			}
																		}
																	} else if (userChoose == 3) {
																		exportFile = date + ": Id: " + user.getId()
																				+ ". Username: " + user.getUsername()
																				+ ". Role: " + role.getName() + " "
																				+ ". User Input Id Task: " + userChoose
																				+ ". Task User Choose: "
																				+ task.getHeader()
																				+ ". Procced Edit And Update Task"
																				+ ". Status: Procced. Detail: Prepare Delete Task.\n";
																		buffer.append(exportFile);
																		edittask: while (status) {
																			exportFile = date + ": Id: " + user.getId()
																					+ ". Username: "
																					+ user.getUsername() + ". Role: "
																					+ role.getName() + " "
																					+ ". User Input Id Task: "
																					+ userChoose
																					+ ". Task User Choose: "
																					+ task.getHeader()
																					+ ". Procced Edit And Update Task"
																					+ ". Status: Procced. Detail: Proceed Delete Task.\n";
																			buffer.append(exportFile);
																			int displayTask = display();
																			exportFile = date + ": Id: " + user.getId()
																					+ ". Username: "
																					+ user.getUsername() + ". Role: "
																					+ role.getName() + " "
																					+ ". User Input Id Task: "
																					+ userChoose
																					+ ". Task User Choose: "
																					+ task.getHeader()
																					+ ". Display Task Now: "
																					+ task.getDisplay()
																					+ ". Change Display Task: "
																					+ displayTask
																					+ ". Procced Edit And Update Task"
																					+ ". Status: Procced. Detail: Proceed Delete Task.\n";
																			buffer.append(exportFile);
																			boolean isSuccess = isUpdateTaskByStatusOrDisplayOrDescriptionSuccess(
																					task.getId(), task.getStatus(),
																					displayTask, task.getDescription());
																			if (isSuccess == true) {
																				System.out.println(
																						"Update Task Success. Do you want to update continue ? (1: current task / 2: list task / 3: go back)");

																				task.setDisplay(displayTask);
																				exportFile = date + ": Id: "
																						+ user.getId() + ". Username: "
																						+ user.getUsername()
																						+ ". Role: " + role.getName()
																						+ " " + ". User Input Id Task: "
																						+ userChoose
																						+ ". Task User Choose: "
																						+ task.getHeader()
																						+ ". Display Task Now: "
																						+ task.getDisplay()
																						+ ". Procced Edit And Update Task"
																						+ ". Status: Procced. Detail: Delete Task Success.\n";
																				buffer.append(exportFile);
																				new MenuImpl().menuChoose();
																				userChoose = new InputImpl()
																						.userChoose();

																				if (userChoose == 1) {
																					exportFile = date + ": Id: "
																							+ user.getId()
																							+ ". Username: "
																							+ user.getUsername()
																							+ ". Role: "
																							+ role.getName() + " "
																							+ ". User Input Id Task: "
																							+ userChoose
																							+ ". Task User Choose: "
																							+ task.getHeader()
																							+ ". Procced Edit And Update Task"
																							+ ". Status: Procced. Detail: Go Back Task Current.\n";
																					buffer.append(exportFile);
																					continue taskcurrent;
																				} else if (userChoose == 2) {
																					exportFile = date + ": Id: "
																							+ user.getId()
																							+ ". Username: "
																							+ user.getUsername()
																							+ ". Role: "
																							+ role.getName() + " "
																							+ ". User Choose: "
																							+ userChoose
																							+ ". Procced Edit And Update Task"
																							+ ". Status: Procced. Detail: Go Back List Task.\n";
																					buffer.append(exportFile);
																					continue listtask;
																				} else if (userChoose == 3) {
																					exportFile = date + ": Id: "
																							+ user.getId()
																							+ ". Username: "
																							+ user.getUsername()
																							+ ". Role: "
																							+ role.getName() + " "
																							+ ". User Choose: "
																							+ userChoose
																							+ ". Procced Edit And Update Task"
																							+ ". Status: Procced. Detail: Go Back Main Menu.\n";
																					buffer.append(exportFile);
																					continue mainmenu;
																				} else {
																					exportFile = date + ": Id: "
																							+ user.getId()
																							+ ". Username: "
																							+ user.getUsername()
																							+ ". Role: "
																							+ role.getName() + " "
																							+ ". User choose: "
																							+ userChoose
																							+ ". Feature does not exist"
																							+ ". Status: Input error.\n";
																					buffer.append(exportFile);
																					System.out.println(
																							"Please input 1 2 3: ");
																				}
																			} else {
																				// Never Run
																				System.out.println(
																						"Task existed. You want to input again (1: yes / 2: go back)");

																				exportFile = date + " : " + user.getId()
																						+ " " + user.getUsername()
																						+ ". Update Task Failed\n";
																				buffer.append(exportFile);
																				bytes = buffer.toString().getBytes();

																				new MenuImpl().menuChoose();
																				userChoose = new InputImpl()
																						.userChoose();
																				if (userChoose == 1) {
																					continue edittask;
																				} else {
																					continue mainmenu;
																				}
																				//
																			}
																		}
																	} else if (userChoose == 4) {
																		exportFile = date + ": Id: " + user.getId()
																				+ ". Username: " + user.getUsername()
																				+ ". Role: " + role.getName() + " "
																				+ ". User Input Id Task: " + userChoose
																				+ ". Task User Choose: "
																				+ task.getHeader()
																				+ ". Procced Edit And Update Task"
																				+ ". Status: Procced. Detail: Prepare Change Description Task.\n";
																		buffer.append(exportFile);
																		edittask: while (status) {
																			String description = description();
																			boolean isSuccess = isUpdateTaskByStatusOrDisplayOrDescriptionSuccess(
																					task.getId(), task.getStatus(),
																					task.getDisplay(), description);
																			exportFile = date + ": Id: " + user.getId()
																					+ ". Username: "
																					+ user.getUsername() + ". Role: "
																					+ role.getName() + " "
																					+ ". User Input Id Task: "
																					+ userChoose
																					+ ". Task User Choose: "
																					+ task.getHeader()
																					+ ". Description Task: "
																					+ task.getDescription()
																					+ ". New Description Task: "
																					+ description
																					+ ". Procced Edit And Update Task"
																					+ ". Status: Procced. Detail: Proceed Change Description Task.\n";
																			buffer.append(exportFile);
																			if (isSuccess == true) {
																				System.out.println(
																						"Update Task Success. Do you want to update continue ? (1: current task / 2: list task / 3: go back)");
																				task.setDescription(description);
																				exportFile = date + ": Id: "
																						+ user.getId() + ". Username: "
																						+ user.getUsername()
																						+ ". Role: " + role.getName()
																						+ " " + ". User Input Id Task: "
																						+ userChoose
																						+ ". Task User Choose: "
																						+ task.getHeader()
																						+ ". Procced Edit And Update Task"
																						+ ". Status: Procced. Detail: Change Description Task Success.\n";
																				buffer.append(exportFile);
																				new MenuImpl().menuChoose();
																				userChoose = new InputImpl()
																						.userChoose();
																				if (userChoose == 1) {
																					exportFile = date + ": Id: "
																							+ user.getId()
																							+ ". Username: "
																							+ user.getUsername()
																							+ ". Role: "
																							+ role.getName() + " "
																							+ ". User Input Id Task: "
																							+ userChoose
																							+ ". Task User Choose: "
																							+ task.getHeader()
																							+ ". Procced Edit And Update Task"
																							+ ". Status: Procced. Detail: Go Back Task Current.\n";
																					buffer.append(exportFile);
																					continue taskcurrent;
																				} else if (userChoose == 2) {
																					exportFile = date + ": Id: "
																							+ user.getId()
																							+ ". Username: "
																							+ user.getUsername()
																							+ ". Role: "
																							+ role.getName() + " "
																							+ ". User Choose: "
																							+ userChoose
																							+ ". Procced Edit And Update Task"
																							+ ". Status: Procced. Detail: Go Back List Task.\n";
																					buffer.append(exportFile);
																					continue listtask;
																				} else if (userChoose == 3) {
																					exportFile = date + ": Id: "
																							+ user.getId()
																							+ ". Username: "
																							+ user.getUsername()
																							+ ". Role: "
																							+ role.getName() + " "
																							+ ". User Choose: "
																							+ userChoose
																							+ ". Procced Edit And Update Task"
																							+ ". Status: Procced. Detail: Go Back Main Menu.\n";
																					buffer.append(exportFile);
																					continue mainmenu;
																				} else {
																					exportFile = date + ": Id: "
																							+ user.getId()
																							+ ". Username: "
																							+ user.getUsername()
																							+ ". Role: "
																							+ role.getName() + " "
																							+ ". User choose: "
																							+ userChoose
																							+ ". Feature does not exist"
																							+ ". Status: Input error.\n";
																					buffer.append(exportFile);
																					System.out.println(
																							"Please input 1 2 3: ");
																				}
																			} else {
																				// Never Run
																				System.out.println(
																						"Task existed. You want to input again (1: yes / 2: go back)");

																				exportFile = date + " : " + user.getId()
																						+ " " + user.getUsername()
																						+ ". Update Task Failed\n";
																				buffer.append(exportFile);
																				bytes = buffer.toString().getBytes();

																				new MenuImpl().menuChoose();
																				userChoose = new InputImpl()
																						.userChoose();
																				if (userChoose == 1) {
																					continue edittask;
																				} else {
																					continue mainmenu;
																				}
																				///
																			}
																		}
																	} else if (userChoose == 5) {
																		exportFile = date + ": Id: " + user.getId()
																				+ ". Username: " + user.getUsername()
																				+ ". Role: " + role.getName() + " "
																				+ ". User choose: " + userChoose
																				+ ". Go Back Main Menu"
																				+ ". Status: Go Back.\n";
																		buffer.append(exportFile);
																		continue mainmenu;
																	} else {
																		exportFile = date + ": Id: " + user.getId()
																				+ ". Username: " + user.getUsername()
																				+ ". Role: " + role.getName() + " "
																				+ ". User choose: " + userChoose
																				+ ". Feature does not exist"
																				+ ". Status: Input error.\n";
																		buffer.append(exportFile);
																		System.out.println("Please input 1 2 3 4 5");
																	}
																} else {
																	System.out.println("Task is not exist");
																	break;
																}
															}
														} else {
															System.out.println("You don't have task.");
															System.out.println("Read Task End");

															exportFile = date + ": Id: " + user.getId() + ". Username: "
																	+ user.getUsername() + ". Role: " + role.getName()
																	+ " " + ". User choose: " + userChoose
																	+ ". Edit And Update Task"
																	+ ". Status: Fail. Detail: Not Task\n";
															buffer.append(exportFile);

															userChoose = new InputImpl().userChoose();
															if (userChoose == 1) {
																exportFile = date + ": Id: " + user.getId()
																		+ ". Username: " + user.getUsername()
																		+ ". Role: " + role.getName() + " "
																		+ ". User choose: " + userChoose
																		+ ". Go Back Main Menu"
																		+ ". Status: Go Back.\n";
																buffer.append(exportFile);
																continue mainmenu;
															} else {
																exportFile = date + ": Id: " + user.getId()
																		+ ". Username: " + user.getUsername()
																		+ ". Role: " + role.getName() + " "
																		+ ". User choose: " + userChoose
																		+ ". Feature does not exist"
																		+ ". Status: Input error.\n";
																buffer.append(exportFile);
																System.out.println("Please input 1");
															}
														}
													}
												} else if (userChoose == 2) {
													exportFile = date + ": Id: " + user.getId() + ". Username: "
															+ user.getUsername() + ". Role: " + role.getName() + " "
															+ ". User choose: " + userChoose + ". Go Back Main Menu"
															+ ". Status: Go Back.\n";
													buffer.append(exportFile);
													continue mainmenu;
												} else {
													exportFile = date + ": Id: " + user.getId() + ". Username: "
															+ user.getUsername() + ". Role: " + role.getName() + " "
															+ ". User choose: " + userChoose
															+ ". Feature does not exist" + ". Status: Input error.\n";
													buffer.append(exportFile);
													System.out.println("Please input 1 2");
												}
												break;
											}
											case 4: {
												exportFile = date + ": Id: " + user.getId() + ". Username: "
														+ user.getUsername() + ". Role: " + role.getName() + " "
														+ userChoose + ". User Choose: "
														+ ". User Choose Feature: Delete Task. Status: Choose Success .\n";
												buffer.append(exportFile);
												featuredelete: while (status) {
													new MenuImpl().menuDeleteTask();
													new MenuImpl().menuChoose();
													userChoose = new InputImpl().userChoose();
													deletetask: while (status) {
														ArrayList<TaskEntity> listTask = lsTask(user.getId());
														if (listTask != null) {
															System.out.println("Currently. You have " + listTask.size()
																	+ " tasks.");
															System.out.println("ID\tTitle\t\tDeadline\t\t\tStatus");
															for (TaskEntity tk : listTask) {
																System.out.printf("%-8s%-16s%-32s%-50s\n", tk.getId(),
																		tk.getHeader(), tk.getDeadline_date(),
																		(tk.getStatus() == 0 ? "incomplete"
																				: "complete"));
															}
															System.out.println("Input id task you want to delete: ");
															new MenuImpl().menuChoose();
															userChoose = new InputImpl().userChoose();
															task = getTaskByIdUserAndIdTask(user.getId(), userChoose);
															if (task != null) {
																System.out.println("Task ban da chon:");
																System.out.println(
																		"ID\tTitle\t\tOwner\t\tCreate_date\t\tUpdate_create\t\tDeadline\t\tDead_line\t\tStatus\t\tDisplay\t\tDescription");
																System.out.printf(
																		"%-8s%-16s%-16s%-24s%-24s%-24s%-24s%-16s%-16s%-8s\n",
																		task.getId(), task.getHeader(),
																		user.getUsername(), task.getCreate_date(),
																		task.getUpdate_date(), task.getDeadline_date(),
																		task.getDelete_date(),
																		(task.getStatus() == 0 ? "incomplete"
																				: "complete"),
																		(task.getDisplay() == 1 ? "display" : "hidden"),
																		task.getDescription());
															}
															boolean isDeleteSuccess = isUpdateTaskByStatusOrDisplayOrDescriptionSuccess(
																	userChoose, task.getStatus(), 0,
																	task.getDescription());
															if (isDeleteSuccess) {
																System.out.println(
																		"Delete Task Success. Do you want to delete continue ? (1: current task / 2: list task / 3: go back)");

																exportFile = date + " : " + user.getId() + " "
																		+ user.getUsername()
																		+ ". Delete Task Success\n";
																buffer.append(exportFile);
																bytes = buffer.toString().getBytes();

																new MenuImpl().menuChoose();
																userChoose = new InputImpl().userChoose();
																if (userChoose == 1) {
																	continue featuredelete;
																} else if (userChoose == 2) {
																	continue deletetask;
																} else {
																	continue mainmenu;
																}
															} else {
																System.out.println("Task didn't exist. Try again");

																exportFile = date + " : " + user.getId() + " "
																		+ user.getUsername() + ". Delete Task Failed\n";
																buffer.append(exportFile);
																bytes = buffer.toString().getBytes();

															}
														} else {
															System.out.println("You don't have task.");
															System.out.println("Read Task End");

															exportFile = date + " : " + user.getId() + " "
																	+ user.getUsername() + ". Delete Task Failed\n";
															buffer.append(exportFile);
															bytes = buffer.toString().getBytes();

															System.out.println("Please input 1 to continue: ");
															new MenuImpl().menuChoose();
															userChoose = new InputImpl().userChoose();
															if (userChoose == 1) {
																continue mainmenu;
															}
														}
													}
												}
												break;
											}
											case 5: {
												viewmenuonetask: while (status) {
													new MenuImpl().menuViewDetailOneTask();
													new MenuImpl().menuChoose();
													userChoose = new InputImpl().userChoose();
													if (userChoose == 1) {
														viewdetailtask: while (status) {
															ArrayList<TaskEntity> listTask = lsTask(user.getId());
															if (listTask != null) {
																System.out.println("Currently. You have "
																		+ listTask.size() + " tasks.");
																System.out.println("ID\tTitle\t\tDeadline\t\t\tStatus");
																for (TaskEntity tk : listTask) {
																	System.out.printf("%-8s%-16s%-32s%-50s\n",
																			tk.getId(), tk.getHeader(),
																			tk.getDeadline_date(),
																			(tk.getStatus() == 0 ? "incomplete"
																					: "complete"));
																}
																System.out.println(
																		"Input id task you want to view detail: ");
																new MenuImpl().menuChoose();
																userChoose = new InputImpl().userChoose();
																task = getTaskByIdUserAndIdTask(user.getId(),
																		userChoose);
																taskdetailcurrent: while (status) {
																	if (task != null) {
																		System.out.println("Task ban da chon:");
																		System.out.println(
																				"ID\tTitle\t\tOwner\t\tCreate_date\t\tUpdate_create\t\tDeadline\t\tDead_line\t\tStatus\t\tDisplay\t\tDescription");
																		System.out.printf(
																				"%-8s%-16s%-16s%-24s%-24s%-24s%-24s%-16s%-16s%-8s\n",
																				task.getId(), task.getHeader(),
																				user.getUsername(),
																				task.getCreate_date(),
																				task.getUpdate_date(),
																				task.getDeadline_date(),
																				task.getDelete_date(),
																				(task.getStatus() == 0 ? "incomplete"
																						: "complete"),
																				(task.getDisplay() == 1 ? "display"
																						: "hidden"),
																				task.getDescription());
																		exportFile = date + " : " + user.getId() + " "
																				+ user.getUsername()
																				+ ". View Task Detail Success\n";
																		buffer.append(exportFile);
																		ArrayList<TaskDetailEntity> listTaskDetailEntity = new ArrayList<TaskDetailEntity>();
																		listTaskDetailEntity = lsTaskDetail(task.getId());
																		currenttaskdetail: while (status) {
																			if (listTaskDetailEntity != null) {
																				listTaskDetailEntity = lsTaskDetail(
																						task.getId());
																				System.out.println("Task detail of :"
																						+ task.getHeader() + "(id: "
																						+ task.getId() + ")");
																				System.out.println(
																						"Id\tContent\t\tTask_id\t\tTask\t\tCreate_date\t\tUpdate_date\t\tDelete_date\t\tStatus\t\tDisplay\t\tDescription");
																				for (TaskDetailEntity taskDetail : listTaskDetailEntity) {
																					System.out.printf(
																							"%-8s%-17s%-15s%-16s%-24s%-25s%-23s%-16s%-16s%-17s\n",
																							taskDetail.getId(),
																							taskDetail.getContent(),
																							taskDetail.getTask_id(),
																							task.getHeader(),
																							taskDetail.getCreate_date(),
																							taskDetail.getUpdate_date(),
																							taskDetail.getDelete_date(),
																							(taskDetail.getStatus() == 0
																									? "incomplete"
																									: "complete"),
																							(taskDetail.getDisplay() == 1
																									? "display"
																									: "hidden"),
																							taskDetail.getDescription());
																				}
																				new MenuImpl().menuEditTaskDetail();
																				new MenuImpl().menuChoose();
																				userChoose = new InputImpl().userChoose();

																				if (userChoose == 1) {
																					new MenuImpl().menuCreateTaskDetail();
																					new MenuImpl().menuChoose();
																					userChoose = new InputImpl()
																							.userChoose();
																					if (userChoose == 1) {
																						String contentTaskDetail = contentTaskDetail();
																						boolean isSuccess = isCreateTaskDetailByIdTask(
																								task.getId(),
																								contentTaskDetail);
																						if (isSuccess) {
																							System.out.println(
																									"Create Task Detail Success. What do you want to do (1: Current taskdetail / 2: List taskdetail / 3: go back)");

																							exportFile = date + " : "
																									+ user.getId() + " "
																									+ user.getUsername()
																									+ ". Create Task Detail Success\n";
																							buffer.append(exportFile);
																							bytes = buffer.toString()
																									.getBytes();

																							userChoose = new InputImpl()
																									.userChoose();
																							if (userChoose == 1) {
																								continue currenttaskdetail;
																							} else if (userChoose == 2) {
																								continue viewdetailtask;
																							} else {
																								continue viewmenuonetask;
																							}
																						} else {
																							System.out.println(
																									"Create Task Detail Fail. Try again (1: Current taskdetail / 2: List taskdetail / 3: go back)");

																							exportFile = date + " : "
																									+ user.getId() + " "
																									+ user.getUsername()
																									+ ". Create Task Detail Fail\n";
																							buffer.append(exportFile);
																							bytes = buffer.toString()
																									.getBytes();

																							userChoose = new InputImpl()
																									.userChoose();
																							if (userChoose == 1) {
																								continue currenttaskdetail;
																							} else if (userChoose == 2) {
																								continue viewdetailtask;
																							} else {
																								continue viewmenuonetask;
																							}
																						}
																					} else {
																						continue taskdetailcurrent;
																					}
																				} else if (userChoose == 2) {
																					listtaskdetailonetask: while (status) {
																						listTaskDetailEntity = lsTaskDetail(
																								task.getId());
																						System.out
																								.println("Task detail of :"
																										+ task.getHeader()
																										+ "(id: "
																										+ task.getId()
																										+ ")");
																						System.out.println(
																								"Id\tContent\t\tTask_id\t\tTask\t\tCreate_date\t\tUpdate_date\t\tDelete_date\t\tStatus\t\tDisplay\t\tDescription");
																						for (TaskDetailEntity taskDetail : listTaskDetailEntity) {
																							System.out.printf(
																									"%-8s%-17s%-15s%-16s%-24s%-25s%-23s%-16s%-16s%-17s\n",
																									taskDetail.getId(),
																									taskDetail.getContent(),
																									taskDetail.getTask_id(),
																									task.getHeader(),
																									taskDetail
																											.getCreate_date(),
																									taskDetail
																											.getUpdate_date(),
																									taskDetail
																											.getDelete_date(),
																									(taskDetail
																											.getStatus() == 0
																													? "incomplete"
																													: "complete"),
																									(taskDetail
																											.getDisplay() == 1
																													? "display"
																													: "hidden"),
																									taskDetail
																											.getDescription());
																						}
																						System.out.println(
																								"Input id task detail you want to edit: ");
																						new MenuImpl().menuChoose();
																						int userChooseTaskIDDetail = new InputImpl()
																								.userChoose();
																						taskdetailcurrentchoose: while (status) {
																							taskOneDetail = getTaskDetailByIdTaskDetail(
																									userChooseTaskIDDetail);
																							System.out.println(
																									"Task Detail:");
																							System.out.println(
																									"Id\tContent\t\tTask_id\t\tTask\t\tCreate_date\t\tUpdate_date\t\tDelete_date\t\tStatus\t\tDisplay\t\tDescription");
																							for (TaskDetailEntity taskDetail : listTaskDetailEntity) {
																								System.out.printf(
																										"%-8s%-17s%-15s%-16s%-24s%-25s%-23s%-16s%-16s%-17s\n",
																										taskDetail.getId(),
																										taskDetail
																												.getContent(),
																										taskDetail
																												.getTask_id(),
																										task.getHeader(),
																										taskDetail
																												.getCreate_date(),
																										taskDetail
																												.getUpdate_date(),
																										taskDetail
																												.getDelete_date(),
																										(taskDetail
																												.getStatus() == 0
																														? "incomplete"
																														: "complete"),
																										(taskDetail
																												.getDisplay() == 1
																														? "display"
																														: "hidden"),
																										taskDetail
																												.getDescription());

																								new MenuImpl()
																										.menuEditFieldTaskDetail();
																								new MenuImpl().menuChoose();
																								userChoose = new InputImpl()
																										.userChoose();
																								if (userChoose == 1) {
																									new MenuImpl()
																											.menuChangeContentTaskDetail();
																									new MenuImpl()
																											.menuChoose();
																									userChoose = new InputImpl()
																											.userChoose();
																									if (userChoose == 1) {
																										String content = contentTaskDetail();
																										boolean isSuccess = isUpdateTaskDetail(
																												taskOneDetail
																														.getId(),
																												content,
																												taskOneDetail
																														.getStatus(),
																												taskOneDetail
																														.getDisplay(),
																												taskOneDetail
																														.getDescription());
																										if (isSuccess) {
																											System.out
																													.println(
																															"Update Content Task Detail Success. Input 1 to continue");

																											exportFile = date
																													+ " : "
																													+ user.getId()
																													+ " "
																													+ user.getUsername()
																													+ ". Update Content Task Detail Success\n";
																											buffer.append(
																													exportFile);
																											bytes = buffer
																													.toString()
																													.getBytes();

																											new MenuImpl()
																													.menuChoose();
																											userChoose = new InputImpl()
																													.userChoose();
																											if (userChoose == 1) {
																												continue taskdetailcurrentchoose;
																											}
																										} else {
																											System.out
																													.print("Update Content Task Detail Fail. Input 1 to continue ");

																											exportFile = date
																													+ " : "
																													+ user.getId()
																													+ " "
																													+ user.getUsername()
																													+ ". Update Content Task Detail Fail\n";
																											buffer.append(
																													exportFile);
																											bytes = buffer
																													.toString()
																													.getBytes();

																											new MenuImpl()
																													.menuChoose();
																											userChoose = new InputImpl()
																													.userChoose();
																											if (userChoose == 1) {
																												continue taskdetailcurrentchoose;
																											}
																										}
																									} else {
																										continue taskdetailcurrentchoose;
																									}

																								} else if (userChoose == 2) {
																									new MenuImpl()
																											.menuChangeStatusTaskDetail();
																									new MenuImpl()
																											.menuChoose();
																									userChoose = new InputImpl()
																											.userChoose();
																									if (userChoose == 1) {
																										int changeStatusTaskDetail = status();
																										boolean isSuccess = isUpdateTaskDetail(
																												taskOneDetail
																														.getId(),
																												taskOneDetail
																														.getContent(),
																												changeStatusTaskDetail,
																												taskOneDetail
																														.getDisplay(),
																												taskOneDetail
																														.getDescription());
																										if (isSuccess) {
																											System.out
																													.println(
																															"Update Status Task Detail Success. Input 1 to continue");

																											exportFile = date
																													+ " : "
																													+ user.getId()
																													+ " "
																													+ user.getUsername()
																													+ ". Update Status Task Success\n";
																											buffer.append(
																													exportFile);
																											bytes = buffer
																													.toString()
																													.getBytes();

																											new MenuImpl()
																													.menuChoose();
																											userChoose = new InputImpl()
																													.userChoose();
																											if (userChoose == 1) {
																												continue taskdetailcurrentchoose;
																											}
																										} else {
																											System.out
																													.print("Update Status Task Detail Fail. Input 1 to continue ");

																											exportFile = date
																													+ " : "
																													+ user.getId()
																													+ " "
																													+ user.getUsername()
																													+ ". Update Status Task Fail\n";
																											buffer.append(
																													exportFile);
																											bytes = buffer
																													.toString()
																													.getBytes();

																											new MenuImpl()
																													.menuChoose();
																											userChoose = new InputImpl()
																													.userChoose();
																											if (userChoose == 1) {
																												continue taskdetailcurrentchoose;
																											}
																										}
																									} else {
																										continue taskdetailcurrentchoose;
																									}
																								} else if (userChoose == 3) {
																									new MenuImpl()
																											.menuChangeDisplayTaskDetail();
																									new MenuImpl()
																											.menuChoose();
																									userChoose = new InputImpl()
																											.userChoose();
																									if (userChoose == 1) {
																										int changeDisplayTaskDetail = display();
																										boolean isSuccess = isUpdateTaskDetail(
																												taskOneDetail
																														.getId(),
																												taskOneDetail
																														.getContent(),
																												taskOneDetail
																														.getStatus(),
																												changeDisplayTaskDetail,
																												taskOneDetail
																														.getDescription());
																										if (isSuccess) {
																											System.out
																													.println(
																															"Hidden Task Detail Success. Input 1 to continue");

																											exportFile = date
																													+ " : "
																													+ user.getId()
																													+ " "
																													+ user.getUsername()
																													+ ". Delete Task Detail Success\n";
																											buffer.append(
																													exportFile);
																											bytes = buffer
																													.toString()
																													.getBytes();

																											new MenuImpl()
																													.menuChoose();
																											userChoose = new InputImpl()
																													.userChoose();
																											if (userChoose == 1) {
																												continue currenttaskdetail;
																											}
																										} else {
																											System.out
																													.print("Update Status Task Detail Fail. Input 1 to continue ");

																											exportFile = date
																													+ " : "
																													+ user.getId()
																													+ " "
																													+ user.getUsername()
																													+ ". Delete Task Detail Fail\n";
																											buffer.append(
																													exportFile);
																											bytes = buffer
																													.toString()
																													.getBytes();

																											new MenuImpl()
																													.menuChoose();
																											userChoose = new InputImpl()
																													.userChoose();
																											if (userChoose == 1) {
																												continue taskdetailcurrentchoose;
																											}
																										}
																									} else {
																										continue taskdetailcurrentchoose;
																									}
																								} else if (userChoose == 4) {
																									new MenuImpl()
																											.menuChangeDescriptionTaskDetail();
																									new MenuImpl()
																											.menuChoose();
																									userChoose = new InputImpl()
																											.userChoose();
																									if (userChoose == 1) {
																										String changeDescriptionTaskDetail = description();
																										boolean isSuccess = isUpdateTaskDetail(
																												taskOneDetail
																														.getId(),
																												taskOneDetail
																														.getContent(),
																												taskOneDetail
																														.getStatus(),
																												taskOneDetail
																														.getDisplay(),
																												changeDescriptionTaskDetail);
																										if (isSuccess) {
																											System.out
																													.println(
																															"Update Description Task Detail Success. Input 1 to continue");

																											exportFile = date
																													+ " : "
																													+ user.getId()
																													+ " "
																													+ user.getUsername()
																													+ ". Update Description Task Detail Success\n";
																											buffer.append(
																													exportFile);
																											bytes = buffer
																													.toString()
																													.getBytes();

																											new MenuImpl()
																													.menuChoose();
																											userChoose = new InputImpl()
																													.userChoose();
																											if (userChoose == 1) {
																												continue taskdetailcurrentchoose;
																											}
																										} else {
																											System.out
																													.print("Update Description Task Detail Fail. Input 1 to continue ");

																											exportFile = date
																													+ " : "
																													+ user.getId()
																													+ " "
																													+ user.getUsername()
																													+ ". Update Description Task Detail Fail\n";
																											buffer.append(
																													exportFile);
																											bytes = buffer
																													.toString()
																													.getBytes();

																											new MenuImpl()
																													.menuChoose();
																											userChoose = new InputImpl()
																													.userChoose();
																											if (userChoose == 1) {
																												continue taskdetailcurrentchoose;
																											}
																										}
																									} else {
																										continue taskdetailcurrentchoose;
																									}
																								} else {
																									continue currenttaskdetail;
																								}
																							}
																						}
																					}
																				} else if (userChoose == 3) {
																					new MenuImpl().menuDeleteTaskDetail();
																					new MenuImpl().menuChoose();
																					userChoose = new InputImpl()
																							.userChoose();

																					if (userChoose == 1) {

																						System.out
																								.println("Task detail of :"
																										+ task.getHeader()
																										+ "(id: "
																										+ task.getId()
																										+ ")");
																						System.out.println(
																								"Id\tContent\t\tTask_id\t\tTask\t\tCreate_date\t\tUpdate_date\t\tDelete_date\t\tStatus\t\tDisplay\t\tDescription");
																						for (TaskDetailEntity taskDetail : listTaskDetailEntity) {
																							System.out.printf(
																									"%-8s%-17s%-15s%-16s%-24s%-25s%-23s%-16s%-16s%-17s\n",
																									taskDetail.getId(),
																									taskDetail.getContent(),
																									taskDetail.getTask_id(),
																									task.getHeader(),
																									taskDetail
																											.getCreate_date(),
																									taskDetail
																											.getUpdate_date(),
																									taskDetail
																											.getDelete_date(),
																									(taskDetail
																											.getStatus() == 0
																													? "incomplete"
																													: "complete"),
																									(taskDetail
																											.getDisplay() == 1
																													? "display"
																													: "hidden"),
																									taskDetail
																											.getDescription());
																						}
																						System.out.println(
																								"Input id task detail you want to edit: ");
																						new MenuImpl().menuChoose();
																						int userChooseTaskIDDetail = new InputImpl()
																								.userChoose();
																						taskdetailcurrentchoose: while (status) {
																							taskOneDetail = getTaskDetailByIdTaskDetail(
																									userChooseTaskIDDetail);

																							// int changeDisplayTaskDetail =
																							// display();
																							boolean isSuccess = isUpdateTaskDetail(
																									taskOneDetail.getId(),
																									taskOneDetail
																											.getContent(),
																									taskOneDetail
																											.getStatus(),
																									0, taskOneDetail
																											.getDescription());
																							if (isSuccess) {
																								System.out.println(
																										"Delete Task Detail Success. Input 1 to continue");

																								exportFile = date + " : "
																										+ user.getId() + " "
																										+ user.getUsername()
																										+ ". Delete Task Detail Success\n";
																								buffer.append(exportFile);
																								bytes = buffer.toString()
																										.getBytes();

																								new MenuImpl().menuChoose();
																								userChoose = new InputImpl()
																										.userChoose();
																								if (userChoose == 1) {
																									continue currenttaskdetail;
																								}
																							} else {
																								System.out.print(
																										"Update Status Task Detail Fail. Input 1 to continue ");

																								exportFile = date + " : "
																										+ user.getId() + " "
																										+ user.getUsername()
																										+ ". Delete Task Detail Fail\n";
																								buffer.append(exportFile);
																								bytes = buffer.toString()
																										.getBytes();

																								new MenuImpl().menuChoose();
																								userChoose = new InputImpl()
																										.userChoose();
																								if (userChoose == 1) {
																									continue viewdetailtask;
																								}
																							}
																						}
																					} else {
																						continue viewmenuonetask;
																					}
																				} else {
																					continue viewmenuonetask;
																				}

																			} else {
																				System.out.println(
																						"Task is not detail. You want to input again (1: Create Task Detail / 2: current task / 3: list task / 4: go back)");
																				exportFile = date + " : " + user.getId()
																						+ " " + user.getUsername()
																						+ ". Not Task Success\n";

																				buffer.append(exportFile);
																				bytes = buffer.toString().getBytes();

																				new MenuImpl().menuChoose();
																				userChoose = new InputImpl().userChoose();
																				if (userChoose == 1) {
																					new MenuImpl().menuCreateTaskDetail();
																					new MenuImpl().menuChoose();
																					userChoose = new InputImpl()
																							.userChoose();
																					if (userChoose == 1) {
																						String contentTaskDetail = contentTaskDetail();
																						boolean isSuccess = isCreateTaskDetailByIdTask(
																								task.getId(),
																								contentTaskDetail);
																						if (isSuccess) {
																							System.out.println(
																									"Create Task Detail Success");
																							exportFile = date + " : "
																									+ user.getId() + " "
																									+ user.getUsername()
																									+ ". Create Task Success\n";

																							buffer.append(exportFile);
																							bytes = buffer.toString()
																									.getBytes();
																							System.out.println(
																									"Input 1 continue: ");
																							new MenuImpl().menuChoose();
																							userChoose = new InputImpl()
																									.userChoose();
																							if (userChoose == 1) {
																								continue viewdetailtask;
																							}
																						} else {
																							System.out.println(
																									"Create Task Detail Fail");
																							exportFile = date + " : "
																									+ user.getId() + " "
																									+ user.getUsername()
																									+ ". Create Task Fail\n";

																							buffer.append(exportFile);
																							bytes = buffer.toString()
																									.getBytes();
																							userChoose = new InputImpl()
																									.userChoose();
																							System.out.println(
																									"Input 1 continue: ");
																							new MenuImpl().menuChoose();
																							userChoose = new InputImpl()
																									.userChoose();
																							if (userChoose == 1) {
																								continue viewdetailtask;
																							}
																						}
																					} else {
																						continue taskdetailcurrent;
																					}
																				} else if (userChoose == 2) {
																					continue taskdetailcurrent;
																				} else if (userChoose == 3) {
																					continue viewdetailtask;
																				} else {
																					continue viewmenuonetask;
																				}
																			}
																		}
																	} else {
																		System.out.println("Task does not exist");
																		break;
																	}
																}
															} else {
																System.out.println("You don't have task.");
																System.out.println("Read Task End");
																exportFile = date + " : " + user.getId() + " "
																		+ user.getUsername() + ". Not Task.\n";

																buffer.append(exportFile);
																bytes = buffer.toString().getBytes();

																System.out.println("Please input 1 to continue: ");
																new MenuImpl().menuChoose();
																userChoose = new InputImpl().userChoose();
																if (userChoose == 1) {
																	continue mainmenu;
																}
															}
														}
													} else {
														continue mainmenu;
													}
												}
												break;
											}
											case 6: {
												case6(user);
												exportFile = date + " : " + user.getId() + " " + user.getUsername()
														+ ". Show Info Success\n";

												buffer.append(exportFile);
												bytes = buffer.toString().getBytes();

												break;
											}
											case 7: {
												case7(user);
												break;
											}
											case 8: {
												case8(user);
												continue menuStart;
											}
											case 9: {
												if (role.getName().equals("ADMIN")) {
													ArrayList<UserEntity> list = case9();
													System.out.println(
															"Id\tUserName\tPassword\tEmail\t\t\t\tRole\tLastName\tFirstName\tBrithday\t\t\tCreate_date\t\t\tUpdate_date\t\t\tDelete_date\t\t\tStatus\t\tDisplay\t\tDescription\tPhone");
													for (UserEntity userCase9 : list) {
														String roleName = getNameRole(userCase9.getId());
														System.out.printf(
																"%-8s%-17s%-15s%-32s%-8s%-16s%-16s%-32s%-32s%-32s%-32s%-16s%-16s%-16s%-5s\n",
																userCase9.getId(), userCase9.getUsername(),
																userCase9.getPassword(), userCase9.getEmail(), roleName,
																userCase9.getLname(), userCase9.getFname(),
																userCase9.getBirthday(), userCase9.getCreate_date(),
																userCase9.getUpdate_date(), userCase9.getDelete_date(),
																(userCase9.getStatus() == 1 ? "Active" : "Lock"),
																(userCase9.getDisplay() == 1 ? "Use" : "Hidden"),
																userCase9.getDescription(), userCase9.getPhone());
													}
												} else {
													System.out.println("Please input 1 2 3 4 5");
												}
												break;
											}
											case 10: {
												if (role.getName().equals("ADMIN")) {
													ArrayList<UserEntity> list = case9();
													System.out.println(
															"Id\tUserName\tPassword\tEmail\t\t\t\tRole\tLastName\tFirstName\tBrithday\t\t\tCreate_date\t\t\tUpdate_date\t\t\tDelete_date\t\t\tStatus\t\tDisplay\t\tDescription\tPhone");
													for (UserEntity userCase9 : list) {
														String roleName = getNameRole(userCase9.getId());
														System.out.printf(
																"%-8s%-17s%-15s%-32s%-8s%-16s%-16s%-32s%-32s%-32s%-32s%-16s%-16s%-16s%-5s\n",
																userCase9.getId(), userCase9.getUsername(),
																userCase9.getPassword(), userCase9.getEmail(), roleName,
																userCase9.getLname(), userCase9.getFname(),
																userCase9.getBirthday(), userCase9.getCreate_date(),
																userCase9.getUpdate_date(), userCase9.getDelete_date(),
																(userCase9.getStatus() == 1 ? "Active" : "Lock"),
																(userCase9.getDisplay() == 1 ? "Use" : "Hidden"),
																userCase9.getDescription(), userCase9.getPhone());
													}
													System.out.print("Input id user you want change status: ");
													int inputIdUser = new InputImpl().userChoose();
													System.out.print(
															"You want to lock or unlock user (0: lock / 1: unlock): ");
													int inputStatusUser = new InputImpl().userChoose();
													if (case10(inputIdUser, inputStatusUser)) {
														System.out.println("Change status success");
													} else {
														System.out.println("Change status fail");
													}
												} else {
													System.out.println("Please 1 2 3 4 5");
												}

												break;
											}
											case 11: {
												if (role.getName().equals("ADMIN")) {
													ArrayList<UserEntity> list = case9();
													System.out.println(
															"Id\tUserName\tPassword\tEmail\t\t\t\tRole\tLastName\tFirstName\tBrithday\t\t\tCreate_date\t\t\tUpdate_date\t\t\tDelete_date\t\t\tStatus\t\tDisplay\t\tDescription\tPhone");
													for (UserEntity userCase9 : list) {
														String roleName = getNameRole(userCase9.getId());
														System.out.printf(
																"%-8s%-17s%-15s%-32s%-8s%-16s%-16s%-32s%-32s%-32s%-32s%-16s%-16s%-16s%-5s\n",
																userCase9.getId(), userCase9.getUsername(),
																userCase9.getPassword(), userCase9.getEmail(), roleName,
																userCase9.getLname(), userCase9.getFname(),
																userCase9.getBirthday(), userCase9.getCreate_date(),
																userCase9.getUpdate_date(), userCase9.getDelete_date(),
																(userCase9.getStatus() == 1 ? "Active" : "Lock"),
																(userCase9.getDisplay() == 1 ? "Use" : "Hidden"),
																userCase9.getDescription(), userCase9.getPhone());
													}
													case11(user.getId(), user.getUsername());
												} else {
													System.out.println("Please 1 2 3 4 5");
												}

												break;
											}
											case 12: {
												if (role.getName().equals("ADMIN")) {
													case12(user.getId(), user.getUsername());
												} else {
													System.out.println("Please input 1 2 3 4 5");
												}

												break;
											}
											case 13: {
												if (role.getName().equals("ADMIN")) {
													case13(user.getId(), user.getUsername());
												} else {
													System.out.println("Please input 1 2 3 4 5");
												}

												break;
											}
											}
										}
									}
									// ket thuc o day

								} catch (IOException e) {
									e.printStackTrace();
								}
							} else {
								while (true) {
									System.out.println(
											"Username or password is incorret. Try again (1: yes/ 2: go back)");
									new MenuImpl().menuChoose();
									userChoose = new InputImpl().userChoose();
									if (userChoose == 1) {
										continue login;
									} else if (userChoose == 2) {
										continue menuStart;
									} else {
										System.out.println("Please input 1 2: ");
									}
								}
							}
						}
					} else if (userChoose == 2) {
						continue menuStart;
					} else {
						System.out.println("Please input 1 2: ");
						continue loopLogin;
					}
				}
			} else if (userChoose == 2) {
				userChoose = registerOrGoback();
				if (userChoose == 1) {
					register: while (status) {
						ArrayList<String> list = new ArrayList<String>();
						list = isRegisterSuccess();
						if (list != null) {
							System.out.println("Register Success");
							continue menuStart;
						} else {
							System.out.println("Username or email is exist. Try again (1: yes / 2: go back)");
							new MenuImpl().menuChoose();
							if (new InputImpl().userChoose() == 1) {
								continue register;
							} else {
								continue menuStart;
							}
						}
					}
				} else {
					continue menuStart;
				}

			} else if (userChoose == 3) {
				user = null;
				System.out.println("Good bye. See you again");
				status = false;
			} else {
				System.out.println("Please input 1 2 3: ");
				status = true;
			}
		}
	}

	@Override
	public int startProcess() {
		IMenu menu = new MenuImpl();
		IInput input = new InputImpl();

		menu.menuStart();
		menu.menuChoose();

		return input.userChoose();
	}

	@Override
	public UserEntity loginAccount() {
		UserEntity user;
		IUserRepository userRepository = new UserRepositoryImpl();
		String userName = userName();
		String passWord = passWord();
		user = userRepository.setUserLogin(userName, passWord);
		return user;
	}

	@Override
	public UserEntity loginAccount(String userName, String passWord) {
		UserEntity user;
		IUserRepository userRepository = new UserRepositoryImpl();
		user = userRepository.setUserLogin(userName, passWord);
		return user;
	}

	@Override
	public String userName() {
		new MenuImpl().menuInputUserName();

		IInput input = new InputImpl();
		return input.userName();
	}

	@Override
	public String passWord() {
		new MenuImpl().menuInputPassword();

		IInput input = new InputImpl();
		return input.passWord();
	}

	@Override
	public int loginOrGoback() {
		new MenuImpl().menuLoginAccount();
		new MenuImpl().menuChoose();
		IInput input = new InputImpl();
		return input.userChoose();
	}

	@Override
	public int registerOrGoback() {
		new MenuImpl().menuRegisterAccount();
		new MenuImpl().menuChoose();
		IInput input = new InputImpl();
		return input.userChoose();
	}

	@Override
	public String email() {
		new MenuImpl().menuInputEmail();

		IInput input = new InputImpl();
		return input.email();
	}

	@Override
	public String lname() {
		new MenuImpl().menuInputLName();

		IInput input = new InputImpl();
		return input.lname();
	}

	@Override
	public String fname() {
		new MenuImpl().menuInputFname();

		IInput input = new InputImpl();
		return input.fname();
	}

	@Override
	public String phone() {
		new MenuImpl().menuInputPhone();

		IInput input = new InputImpl();
		return input.phone();
	}

	@Override
	public ArrayList<String> isRegisterSuccess() {
		ArrayList<String> list = new ArrayList<String>();
		String userName = userName();
		String passWord = passWord();
		String email = email();
		String lname = lname();
		String fname = fname();
		String phone = phone();
		if (new UserRepositoryImpl().setUserRegister(userName, passWord, email, lname, fname, phone)) {
			list.add(userName);
			list.add(passWord);
		} else {
			list = null;
		}
		return list;
	}

	@Override
	public RoleEntity getRole(int idUser) {
		RoleEntity role;
		IRoleRepository roleRepository = new RoleRepositoryImpl();
		role = roleRepository.getRole(idUser);
		return role;
	}

	@Override
	public ArrayList<TaskEntity> lsTask(int idUser) {
		ArrayList<TaskEntity> listTask;
		ITaskRepository taskRepository = new TaskReopsitoryImpl();
		listTask = taskRepository.getAllTaskByIdUser(idUser);
		return listTask;
	}

	@Override
	public String headerTask() {
		new MenuImpl().menuInputHeader();
		IInput input = new InputImpl();
		return input.headerTask();
	}

	@Override
	public boolean isTaskExistByUserId(String header, int idUser) {
		boolean isTaskExist = false;
		isTaskExist = new TaskReopsitoryImpl().isCheckTaskExistByUserId(header, idUser);
		return isTaskExist;
	}

	@Override
	public TaskEntity getTaskByIdUserAndIdTask(int idUser, int idTask) {
		TaskEntity task;
		task = new TaskReopsitoryImpl().taskSelect(idUser, idTask);
		return task;
	}

	@Override
	public boolean isUpdateTaskSuccess(int idTask, String header, int status, int display, String description) {
		boolean isSuccess = false;
		isSuccess = new TaskReopsitoryImpl().isCheckUpdateTaskSuccess(idTask, header, status, display, description);
		return isSuccess;
	}

	@Override
	public int status() {
		new MenuImpl().menuInputStatus();

		IInput input = new InputImpl();
		return input.status();
	}

	@Override
	public int display() {
		new MenuImpl().menuInputDisplay();

		IInput input = new InputImpl();
		return input.display();
	}

	@Override
	public String description() {
		new MenuImpl().menuInputDescription();
		IInput input = new InputImpl();
		return input.description();
	}

	@Override
	public boolean isUpdateTaskByStatusOrDisplayOrDescriptionSuccess(int idTask, int status, int display,
			String description) {
		boolean isSuccess = false;
		isSuccess = new TaskReopsitoryImpl().isCheckUpdateTaskByStatusOrDisplayOrDescription(idTask, status, display,
				description);
		return isSuccess;
	}

	@Override
	public ArrayList<TaskDetailEntity> lsTaskDetail(int idTask) {
		ArrayList<TaskDetailEntity> listTaskDetail = new ArrayList<TaskDetailEntity>();
		listTaskDetail = new TaskDetailRepositoryImpl().getListTaskDetailByIdTask(idTask);
		return listTaskDetail;
	}

	@Override
	public String contentTaskDetail() {
		new MenuImpl().menuInputContentTaskDeTail();
		IInput input = new InputImpl();
		return input.content();
	}

	@Override
	public boolean isCreateTaskDetailByIdTask(int idTask, String content) {
		boolean isSuccess = false;
		isSuccess = new TaskDetailRepositoryImpl().isInsertTaskDetailSuccess(idTask, content);
		return isSuccess;
	}

	@Override
	public boolean isUpdateTaskDetail(int idTaskDetail, String content, int status, int display, String description) {
		boolean isSuccess = false;
		isSuccess = new TaskDetailRepositoryImpl().updateTaskDetailSuccess(idTaskDetail, content, status, display,
				description);
		return isSuccess;
	}

	@Override
	public TaskDetailEntity getTaskDetailByIdTaskDetail(int idTaskDetail) {
		TaskDetailEntity taskDetail;
		taskDetail = new TaskDetailRepositoryImpl().taskDetail(idTaskDetail);
		return taskDetail;
	}

	@Override
	public void case6(UserEntity user) {
		System.out.println("============================================================");
		System.out.println("Main Information");
		System.out.println("----------------");
		System.out.println("username: " + user.getUsername());
		System.out.println("email : " + user.getEmail() + "\n");

		System.out.println("Sup Information");
		System.out.println("----------------");
		System.out.println("first name: " + user.getFname());
		System.out.println("last name : " + user.getLname());
		System.out.println("birthday : " + user.getBirthday());
		System.out.println("description : " + user.getDescription());
		System.out.println("phone :" + user.getPhone());

		boolean status = true;
		while (status) {
			System.out.print("Input 1 to continue : \n");
			new MenuImpl().menuChoose();
			IInput input = new InputImpl();
			if (input.userChoose() == 1) {
				status = false;
			} else {
				System.out.println("Please input 1");
			}
		}

	}

	@Override
	public void case8(UserEntity user) {
		System.out.println("Good bye " + user.getLname() + user.getFname() + " .See you again!");
		bytes = buffer.toString().getBytes();
		try {
			fo.write(bytes);
			fo.flush();
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		user = null;
	}

	@Override
	public UserEntity case7(UserEntity user) {
		boolean status = true;
		UserEntity userCurrent = user;
		while (status) {
			System.out.println("ID\tUserName\tEmail\tLastName\tFirstName\tBirthday\tStatus\tDescription\tPhone");
			System.out.println(userCurrent.getId() + "\t" + userCurrent.getUsername() + "\t" + userCurrent.getEmail()
					+ "\t" + userCurrent.getLname() + "\t" + userCurrent.getFname() + "\t" + userCurrent.getBirthday()
					+ "\t" + (userCurrent.getStatus() == 1 ? "Active" : "Lock") + "\t" + userCurrent.getDescription()
					+ "\t" + userCurrent.getPhone());
			new MenuImpl().menuChangeInfomationUser();
			System.out.print("what do you want to do : \n");
			new MenuImpl().menuChoose();
			IInput input = new InputImpl();
			int userChoose = input.userChoose();
			switch (userChoose) {
			case 1: {
				new MenuImpl().menuInputOldPassword();
				String oldPassword = input.passWord();

				new MenuImpl().menuInputNewPassword();
				String newPassword = input.passWord();

				if (isChangePassWord(userCurrent.getUsername(), oldPassword)) {
					if (isUpdateSuccess(userCurrent.getId(), newPassword, userCurrent.getEmail(),
							userCurrent.getLname(), userCurrent.getFname(), userCurrent.getDescription(),
							userCurrent.getPhone())) {
						user = null;
						System.out.println("Change password success. Please login again");
						try {
							String exportFile = date + " : " + userCurrent.getId() + " " + userCurrent.getUsername()
									+ ". Update Password User Success\n";
							buffer.append(exportFile);
							bytes = buffer.toString().getBytes();
							fo.write(bytes);
							fo.flush();
							fo.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						run();
					} else {
						System.out.println("Change password fail");

						String exportFile = date + " : " + userCurrent.getId() + " " + userCurrent.getUsername()
								+ ". Update Password User Failed\n";
						buffer.append(exportFile);

					}
				} else {
					System.out.println("Old password error. Change password fail");

					String exportFile = date + " : " + userCurrent.getId() + " " + userCurrent.getUsername()
							+ ". Update Password User Failed\n";
					buffer.append(exportFile);

				}
				break;
			}
			case 2: {
				new MenuImpl().menuInputEmail();
				String newEmail = input.email();

				if (!isCheckEmailUserExist(newEmail)) {
					if (isUpdateSuccess(userCurrent.getId(), userCurrent.getPassword(), newEmail,
							userCurrent.getLname(), userCurrent.getFname(), user.getDescription(), user.getPhone())) {
						userCurrent.setEmail(newEmail);
						System.out.println("Change email success.");

						String exportFile = date + " : " + userCurrent.getId() + " " + userCurrent.getUsername()
								+ ". Update Email User Success\n";
						buffer.append(exportFile);

					} else {
						System.out.println("Change email fail");

						String exportFile = date + " : " + userCurrent.getId() + " " + userCurrent.getUsername()
								+ ". Update Email User Failed\n";
						buffer.append(exportFile);

					}
				} else {
					System.out.println("Email is existed. Change email fail");

					String exportFile = date + " : " + userCurrent.getId() + " " + userCurrent.getUsername()
							+ ". Update Email User Failed\n";
					buffer.append(exportFile);

				}
				break;
			}
			case 3: {
				new MenuImpl().menuInputLName();
				String newLName = input.lname();
				if (isUpdateSuccess(userCurrent.getId(), userCurrent.getPassword(), userCurrent.getEmail(), newLName,
						userCurrent.getFname(), user.getDescription(), user.getPhone())) {
					userCurrent.setLname(newLName);
					System.out.println("Change last name success.");

					String exportFile = date + " : " + userCurrent.getId() + " " + userCurrent.getUsername()
							+ ". Update Last Name User Success\n";
					buffer.append(exportFile);

				} else {
					System.out.println("Change last name fail");

					String exportFile = date + " : " + userCurrent.getId() + " " + userCurrent.getUsername()
							+ ". Update Last Name User Failed\n";
					buffer.append(exportFile);

				}
				break;
			}
			case 4: {
				new MenuImpl().menuInputFname();
				String newFName = input.fname();
				if (isUpdateSuccess(userCurrent.getId(), userCurrent.getPassword(), userCurrent.getEmail(),
						userCurrent.getLname(), newFName, user.getDescription(), user.getPhone())) {
					userCurrent.setFname(newFName);
					System.out.println("Change first name success.");

					String exportFile = date + " : " + userCurrent.getId() + " " + userCurrent.getUsername()
							+ ". Update First Name User Success\n";
					buffer.append(exportFile);

				} else {
					System.out.println("Change first name fail");

					String exportFile = date + " : " + userCurrent.getId() + " " + userCurrent.getUsername()
							+ ". Update First Name User Fail\n";
					buffer.append(exportFile);

				}
				break;
			}
			case 5: {
				new MenuImpl().menuInputFname();
				String newDescription = input.description();
				if (isUpdateSuccess(userCurrent.getId(), userCurrent.getPassword(), userCurrent.getEmail(),
						userCurrent.getLname(), userCurrent.getFname(), newDescription, user.getPhone())) {
					userCurrent.setDescription(newDescription);
					System.out.println("Change description success.");

					String exportFile = date + " : " + userCurrent.getId() + " " + userCurrent.getUsername()
							+ ". Update Description User Success\n";
					buffer.append(exportFile);

				} else {
					System.out.println("Change description fail");

					String exportFile = date + " : " + userCurrent.getId() + " " + userCurrent.getUsername()
							+ ". Update Description User Success\n";
					buffer.append(exportFile);
				}
				break;
			}
			case 6: {
				new MenuImpl().menuInputPhone();
				String newPhone = input.phone();
				if (isUpdateSuccess(userCurrent.getId(), userCurrent.getPassword(), userCurrent.getEmail(),
						userCurrent.getLname(), userCurrent.getFname(), user.getDescription(), newPhone)) {
					userCurrent.setPhone(newPhone);
					System.out.println("Change phone success.");

					String exportFile = date + " : " + userCurrent.getId() + " " + userCurrent.getUsername()
							+ ". Update Phone User Success\n";
					buffer.append(exportFile);

				} else {
					System.out.println("Change phone fail");

					String exportFile = date + " : " + userCurrent.getId() + " " + userCurrent.getUsername()
							+ ". Update Phone User Failed\n";
					buffer.append(exportFile);

				}
				break;
			}
			case 7: {
				status = false;
				break;
			}
			default: {
				System.out.println("please input from 1 to 7: ");
				break;
			}
			}
			user = userCurrent;
		}
		return userCurrent;
	}

	@Override
	public boolean isChangePassWord(String username, String password) {
		boolean isSuccess = false;
		isSuccess = new UserRepositoryImpl().isChangePasswordUser(username, password);
		return isSuccess;
	}

	@Override
	public boolean isUpdateSuccess(int idUser, String password, String email, String lname, String fname,
			String description, String phone) {
		boolean isSuccess = false;
		isSuccess = new UserRepositoryImpl().isUpdateInformationSuccess(idUser, password, email, lname, fname,
				description, phone);
		return isSuccess;
	}

	@Override
	public boolean isCheckEmailUserExist(String email) {
		boolean isCheck = false;
		isCheck = new UserRepositoryImpl().isCheckEmailExist(email);
		return isCheck;
	}

	@Override
	public ArrayList<UserEntity> case9() {
		ArrayList<UserEntity> list = new UserRepositoryImpl().getListUser();
		return list;
	}

	@Override
	public String getNameRole(int idUser) {
		String roleName = "";
		roleName = new RoleRepositoryImpl().getNameRole(idUser);
		return roleName;
	}

	@Override
	public boolean case10(int idUser, int status) {
		boolean isSuccess = false;
		isSuccess = new UserRepositoryImpl().isLockOrUnlockAccount(idUser, status);
		return isSuccess;
	}

	@Override
	public void case11(int idUser, String username) {
		new MenuImpl().menuInputIdUser();
		int idUserChoose = new InputImpl().userChoose();
		new MenuImpl().menuChangeRoleUser();
		int idRole = new InputImpl().userChoose();
		while (true) {
			boolean isSuccess = isSuccess(idUserChoose, idRole);
			if (isSuccess) {
				System.out.println("Change role success");
				String exportFile = date + " : " + idUser + " " + username + ". Update Role Success\n";
				buffer.append(exportFile);
				break;
			} else {
				System.out.println("Change role fail");
				String exportFile = date + " : " + idUser + " " + username + ". Update Role Fail\n";
				buffer.append(exportFile);
				break;
			}
		}
	}

	@Override
	public boolean isSuccess(int idUser, int idRole) {
		boolean isSuccess = false;
		isSuccess = new UserRepositoryImpl().isChangeRoleUser(idUser, idRole);
		return isSuccess;
	}

	@Override
	public void getListTask() {
		ArrayList<TaskEntity> list = new TaskReopsitoryImpl().getAllTask();
		System.out.println(
				"ID\tTitle\t\tOwner\t\t\tCreate_date\t\t\tUpdate_create\t\t\tDealine_date\t\t\tDelete_date\t\t\tStatus\t\tDisplay\t\tDescription");
		for (TaskEntity task : list) {
			String username = getUserName(task.getOwner());
			System.out.printf(String.format("%-8s%-16s%-24s%-32s%-32s%-32s%-32s%-32s%-16s%-16s\n", task.getId(),
					task.getHeader(), username, task.getCreate_date(), task.getUpdate_date(), task.getDeadline_date(),
					task.getDelete_date(), (task.getStatus() == 0 ? "incomplete" : "complete"),
					(task.getDisplay() == 1 ? "display" : "hidden"), task.getDescription()));
		}
	}

	@Override
	public void case12(int idUser, String username) {
		getListTask();
	}

	@Override
	public String getUserName(int idUser) {
		String userName = "";
		userName = new UserRepositoryImpl().getTaskNameByUserId(idUser);
		return userName;
	}

//	public void 

	@Override
	public void case13(int idUser, String username) {
		getListTaskDetail(idUser, username);
	}

	@Override
	public void getListTaskDetail(int idUser, String username) {
		ArrayList<TaskDetailEntity> list = new TaskDetailRepositoryImpl().getAllTaskDetail();
		System.out.println(
				"Id\tContent\t\tTaskName\tOwner\t\tCreate_date\t\t\tUpdate_date\t\t\tDelete_date\t\t\tStatus\t\t\tDisplay\t\t\tDescription");
		for (TaskDetailEntity taskDetail : list) {
			String taskName = getTaskName(taskDetail.getTask_id());
			String userName = getUserNameByIdTaskDetail(taskDetail.getTask_id());
			System.out.printf(String.format("%-8s%-16s%-16s%-16s%-32s%-32s%-32s%-24s%-24s%-32s\n", taskDetail.getId(),
					taskDetail.getContent(), taskName, userName, taskDetail.getCreate_date(),
					taskDetail.getUpdate_date(), taskDetail.getDelete_date(),
					(taskDetail.getStatus() == 0 ? "incomplete" : "complete"),
					(taskDetail.getDisplay() == 1 ? "display" : "hidden"), taskDetail.getDescription()));
		}
		String exportFile = date + " : " + idUser + " " + username + ". Read All Task Detail Success\n";
		buffer.append(exportFile);
	}

	@Override
	public String getTaskName(int idTask) {
		String taskName = "";
		taskName = new TaskReopsitoryImpl().getNameTaskByIdTask(idTask);
		return taskName;
	}

	@Override
	public String getUserNameByIdTaskDetail(int idTaskFromTaskDetail) {
		String userName = "";
		userName = new UserRepositoryImpl().getUserNameByTaskDetail(idTaskFromTaskDetail);
		return userName;
	}

	@Override
	public int idTaskFinalByIdUser(int idUser) {
		ArrayList<TaskEntity> list = new ArrayList<TaskEntity>();
		int idTask = 0;
		list = new TaskReopsitoryImpl().getAllTaskByIdUserDepisteStatusOrDisplay(idUser);
		if (list != null) {
			idTask = list.get(list.size() - 1).getId();
		} else {
			idTask = 0;
		}
		return idTask;
	}

}
