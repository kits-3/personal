package OOP;

public class Machine implements IFunctionMachine   {
	
	private Integer id;
	private String name;
	
	public Machine(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public Machine() {
		
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public void selectMachine() {
		System.out.println("You selectting parent machine");
		
	}



	
	

}
