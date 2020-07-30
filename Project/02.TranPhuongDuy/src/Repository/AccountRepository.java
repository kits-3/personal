package Repository;

import java.util.Scanner;

import Entity.EmployeeEntity;

public interface AccountRepository {
    boolean login();
    boolean isExist(String username , String password);
    boolean isAdmin(int id);
     void update();
    EmployeeEntity findByID(int id);
}
