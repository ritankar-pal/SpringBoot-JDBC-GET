package in.ineuron.dao;
import java.sql.SQLException;
import java.util.List;
import in.ineuron.model.Student;



public interface IStudentDAO {
	public List<Student> getAllEmployees() throws SQLException;
}
