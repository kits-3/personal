package project.management.service.impl;

import project.management.entity.UserEntity;
import project.management.repository.UserRepository;
import project.management.repository.impl.UserRepositoryImpl;
import project.management.service.ILoginService;

public class LoginService implements ILoginService {
	UserRepository userRepository = new UserRepositoryImpl();

	@Override
	public String login(String user, String password) {
		UserEntity userEntity = new UserEntity();
		String loginFalse = "login false";
		userEntity = userRepository.findbyuserNameAndPassword(user);
		if (password.equals(userEntity.getPassword()) && userEntity.getRole().equals("ADMIN")) {
			
			return userEntity.getRole();
		} else if (password.equals(userEntity.getPassword()) && userEntity.getRole().equals("NORMALSTAFF")) {
			return userEntity.getRole();
		} else {
			return loginFalse;
		}
	}

}
