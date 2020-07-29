package project.management.Vending_Machine_3_machine.interfaceMachine;

import java.util.HashMap;
import java.util.List;

import project.management.entity.ProductEntity;
import project.management.entity.StoreMachineEntity;

public interface IMachine {
	boolean test_Product(String selectProduct, String product);
	boolean test_Product_Price(int productPrice, int money);
	int information(int productPrice, String product, int money);
	void order_machine(boolean checkMore, int money,List<ProductEntity> productEntities,HashMap<String,Integer> orderProduct, StoreMachineEntity storeMachineEntity,IMachine machine );
	void recept(List<ProductEntity> product, int[] count, String chance);
	void saveBill(List<ProductEntity> productEntities, HashMap<String, Integer> orderProduct);
}
