package JDBC;

public class Main {
	public static void main(String[] args) {
		Dto dto = new Dto();
		dto.setName("QQQ");
		dto.setRank_id("2");
		
		
		Dao dao = new Dao();
		dao.add(dto);
		dao.findAll();
	}

}
