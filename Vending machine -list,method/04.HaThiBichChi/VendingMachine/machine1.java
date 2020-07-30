package VendingMachine;

public class machine1 extends machine{
	public machine1() {
		
		productNameList.add("soju");
		productNameList.add("beer");
		productNameList.add("wine");
		
		productPriceList.add(100);
		productPriceList.add(100);
		productPriceList.add(200);
		
		super.built();
	}
}
