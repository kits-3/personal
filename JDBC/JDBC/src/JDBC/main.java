package JDBC;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dto dto = new Dto();
		dto.setName("qqqq");
		dto.setRank_id("2");
		
		dao Dao = new dao();
		Dao.add(dto);
		Dao.findAll();
	}

}
