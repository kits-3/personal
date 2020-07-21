import java.util.HashMap;
import java.util.Map;

public class List_Example {
	
	
	public static void main(String[] args) {
		
		Map<String,String> map=new HashMap<String, String>();
		
		map.put("11", "Gia tri 1");
		map.put("22","Giá trị 2");
		map.put("33","Giá trị 3");
		map.put("44","Giá trị 4");
		map.put("55","Giá trị 5");
		
		
		for(Map.Entry<String, String> entry:map.entrySet()) {
			
			System.out.println(entry.getKey()+" "+entry.getValue())	;
			
		}
			
	}

}
