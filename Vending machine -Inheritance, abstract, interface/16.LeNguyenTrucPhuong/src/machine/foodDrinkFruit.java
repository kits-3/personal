package machine;

public interface foodDrinkFruit {
	 public class food extends machine {
			public static void name() {
				product.add("chicken");
				product.add("piza");
				product.add("hamburger");
				product.add("rice");
					
				productPrice.add(600);
				productPrice.add(400);
				productPrice.add(900);
				productPrice.add(100);

			}


}
	 public class drink extends machine {
			public static void name() {
				product.add("co");
				product.add("milk");
				product.add("coki");
				product.add("juice");
					
				productPrice.add(600);
				productPrice.add(400);
				productPrice.add(900);
				productPrice.add(100);
		
			} 
	 }
	 
	 public class fruit extends machine {
			public static void name() {
				product.add("apple");
				product.add("banana");
				product.add("aaa");
				product.add("bbb");
					
				productPrice.add(600);
				productPrice.add(400);
				productPrice.add(900);
				productPrice.add(100);
				
				
			}
			
	 }
	 public class start extends machine{
		 start() {
		 	machine m = new machine() ;
			money=m.inputMoney(money);	
			int min=0;
			min=m.minMoney(min);
			m.checkMoney();
	 }}
	 public static void main(String[] args) {
		
	}
	 
	 
	 

}
