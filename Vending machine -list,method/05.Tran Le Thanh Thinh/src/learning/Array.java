package learning;

public class Array {
	public static void main(String[] args) {
		
		/*Systax :1. data Type[] Name Array = new data Type[Array size]
		 * 2.data Type[] Name Array = {value 0 , value 1 , value 2 , .... value N}
		 * */
		String [] itemArr = new String[3];
		itemArr[0] = "Pepsi";
		itemArr[1] = "Coca";
		itemArr[2] = "7up";
		
		readArr(itemArr);
		
		int [] arrNumber = {20 , 12 , 96};
		
		numberArr(arrNumber);
		
	}
	public static String[] readArr (String[] arrInput) {
		for (int i = 0; i < arrInput.length; i++) {
			System.out.println(arrInput[i]);
		}
		return arrInput;
	}
	
	public static int[] numberArr (int[] input) {
		for(int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
		return input;
	}
	

}
