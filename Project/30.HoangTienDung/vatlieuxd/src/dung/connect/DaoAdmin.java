package dung.connect;

import dung.dto.Product;
import dung.dto.User;

public interface DaoAdmin {
	public void showAllUser();
	public void regisUser(User user);
	public void deleteUser(int id);
	public void addPermmison(int id_user,String role_name);
	public void viewInfo(int id_user);
	public void addProduct(Product product);
	public void DeleteProduct(int id_product);
	public void UpdateProduct(Product product);
	public void ShowOrder();
	public void ShowOutput();
	public void ShowInput();
}
