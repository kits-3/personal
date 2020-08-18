package maventest.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources; //Resources have s
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import maventest.vo.Book;


/* 1.connection db (MySQL/MariaDB Connector extend Driver implement Java DataBase Connection API) <- this mean import mariadb-client.jar
 * 2.ask data to DB -> SQL API as Text("select") 
 * 3.Statment/PrepateStatment -> send -> get data
 * 		-ResultSet <-DB
 * 		-our type is object (Book)
 * 		-Convert ResultSet to Book
 * 4.Model & DB type is different -> need converting 
 * Use Mybatis lib
 * SQLSessionFactory <- db connection info (mybatis-config.xml)
 * SQLSession open -> send sql statment DB (mapper.xml)
 * */
public class BookDao {
	private static SqlSessionFactory factory = null; // if set static for variable ,that variable must have a value at beginning
	//need static method to factory field
	private static SqlSessionFactory getInstance() {
		if(factory == null) {
			//Create factory
			try {
				Reader resource = Resources.getResourceAsReader("mybatis/mybatis-config.xml"); //read text from file xml
				factory = new SqlSessionFactoryBuilder().build(resource);
				resource.close(); // remember to close file
			} catch (Exception e) {
				//if failed
				e.printStackTrace();
			}
		}
		return factory;
	}
	
	public List<Book> selectAll(){
		//connection db -> make sql ->send -> get data
		// choose to get return factory
		SqlSession session = getInstance().openSession();//connecting to DB
		return session.selectList("mappers.bookMapper.selectAll");
	}
	public Book selectOne(int id){
		SqlSession session = getInstance().openSession();
		return session.selectOne("mappers.bookMapper.selectOne", id); //<-#(id)
	}
	public void insert(Book book){
		SqlSession session = getInstance().openSession();
		session.insert("mappers.bookMapper.insert", book); 
	}
	public void update(Book book){
		SqlSession session = getInstance().openSession();
		session.update("mappers.bookMapper.update", book); 
	}
	public void delete(int id){
		SqlSession session = getInstance().openSession();
		session.delete("mappers.bookMapper.delete", id);
	}
}






























