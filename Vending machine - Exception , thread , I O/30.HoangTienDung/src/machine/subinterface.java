package machine;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class subinterface implements interfacemachine {
	public FileWriter writer;
	
	@Override
	public List<product> addlist1() {
		List<product> list = new ArrayList<product>();
		// TODO Auto-generated method stub
			list.add(new product("Coca",10000));
			list.add(new product("Pepsi",10000));
			list.add(new product("Milk",15000));
		return list;
	}

	@Override
	public void dislay(List<product> list) {
		// TODO Auto-generated method stub
		for(int i=0;i<list.size();i++)
		{
			System.out.println((i+1)+"--"+list.get(i).getName()+"-"+list.get(i).getPrice());
		}
	}

	@Override
	public List<product> addlist2() {
		List<product> list = new ArrayList<product>();
		// TODO Auto-generated method stub
			list.add(new product("Pizza",30000));
			list.add(new product("Hambuger",15000));
			list.add(new product("Hot Dog",20000));
		return list;
	}
	
	public void output(String a, String b) {
		// TODO Auto-generated method stub
		String fileDir = b;
		try {
			writer = new FileWriter(fileDir);
			writer.write(a+"\n");
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}		
	}
}
