package Admin;

import AdminEntity.Admin;

public interface AdminDao {
	Admin login(String name, String pass);
	
}
