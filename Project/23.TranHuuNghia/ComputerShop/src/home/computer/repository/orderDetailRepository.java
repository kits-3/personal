package home.computer.repository;

public interface orderDetailRepository {
	void printRevenue();
	void insertOrderDetail(int idorder,String idproductname);
}
