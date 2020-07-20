package machine;

public class food extends machine {
	public static void main(String[] args) {
		food f=new food();
		 //List<String> product = new ArrayList();
		 //List<Integer> productPrice = new ArrayList();
			f.product.add("chicken");
			f.product.add("piza");
			f.product.add("hamburger");
			f.product.add("rice");
				
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
