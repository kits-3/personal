package home.computer.repository;

import java.util.List;

import home.computer.entity.productEntity;

public interface productRepository {
	void select();
	void insert();
	void update();
	void delete();
	String findProduct();
	void updateUnitInStock(int UnitInStock, int id);
	productEntity chooseProduct(int chooseProduct);
	void menu();
}
