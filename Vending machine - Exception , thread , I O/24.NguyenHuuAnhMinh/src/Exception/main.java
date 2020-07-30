package Exception;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			int number[]={1,2,3,4};
			System.out.println("message "+ number[4]);
		}catch(Exception e){
			System.out.println("Error: "+ e.getMessage());
			System.out.println("Error: "+ e.getCause());
			System.out.println("Error: "+ e.getStackTrace());
		}	
		exam1();
	}
	public static void exam1(){
		try{
			exam2();
		}catch (Exception e){
			System.out.println("Run error1: "+ e.getMessage() );
		}
	}
	public static void exam2() throws Exception{
		try{
			throw new Exception("Error2");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Run error2: "+ e.getMessage());
		}
	}

}
