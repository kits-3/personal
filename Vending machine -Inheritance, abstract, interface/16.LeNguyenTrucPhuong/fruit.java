package machine;

public class fruit extends machine {
	public static void main(String[] args) {
		fruit f=new fruit();
		 //List<String> product = new ArrayList();
		 //List<Integer> productPrice = new ArrayList();
		f.product.add("apple");
		f.product.add("banana");
		f.product.add("aaa");
		f.product.add("bbb");
			
		f.productPrice.add(600);
		f.productPrice.add(400);
		f.productPrice.add(900);
		f.productPrice.add(100);
	 
		
		money=f.inputMoney(money);	
		int min=0;
		min=f.minMoney(min);
		f.checkMoney();
		
	}
		
}
