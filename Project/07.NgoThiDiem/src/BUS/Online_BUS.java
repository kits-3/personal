package BUS;

import java.sql.ResultSet;

import DAL.Online_DAL;
import DTO.Account_DTO;
import DTO.Patient_DTO;

import GUI.CreateTable;

public class Online_BUS {
	// Registration form
		public void getDataRegisterForm(Account_DTO dto, String _email, String _username, String _password) {
			dto.setEmail(_email);
			dto.setUserName(_username);
			dto.setPassWord(_password);
			dto.setPerMission(0);
		}
		public boolean checkData(String _email, String _username, String _password) {
			if (_email.isEmpty() || _username.isEmpty() || _password.isEmpty())
				return false;
			return true;
		}
		public boolean checkLength(String _username, String _password) {
			if (_username.length() < 6 && _password.length() < 6)
				return false;
			return true;
		}
		// Login form
		public void getDataLoginForm(Account_DTO dto, String _username, String _password) {
			dto.setUserName(_username);
			dto.setPassWord(_password);
		}
	
}
