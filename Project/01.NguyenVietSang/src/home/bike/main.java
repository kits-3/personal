package home.bike;

import java.util.List;
import java.util.Scanner;

import home.bike.entity.ProductEntity;
import home.bike.repository.ProductImpl;
import home.bike.repository.ProductRepository;
import home.bike.service.Product;
import home.bike.service.Service;

public class main {

	public static void main(String[] args) {

		Service service = new Service();
		service.options();
		service.login();
		Product product = new Product();
	product.showproduct();
		product.chooseproduct();
		product.money();
		product.checkmoney();
	}
}