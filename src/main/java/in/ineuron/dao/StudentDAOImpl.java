package in.ineuron.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import in.ineuron.model.Student;


@Repository(value = "dao")
public class StudentDAOImpl implements IStudentDAO{
	
	private static final String SQL_GET_QUERY = "select sid, saddress, sage, sname from student";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<Student> getAllEmployees() {
		
		System.out.println(dataSource.getClass().getName());
		List<Student> list = null;
		
		try(Connection connection = dataSource.getConnection(); 
				PreparedStatement psmt = connection.prepareStatement(SQL_GET_QUERY)){
			
			ResultSet resultSet = psmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(resultSet.next()) {
				
				Student student = new Student();
				
				student.setSid(resultSet.getInt(1));
				student.setSaddress(resultSet.getString(2));
				student.setSage(resultSet.getInt(3));
				student.setSname(resultSet.getString(4));
		
				list.add(student);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
