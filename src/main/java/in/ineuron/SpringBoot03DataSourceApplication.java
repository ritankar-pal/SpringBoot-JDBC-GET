package in.ineuron;
import java.sql.SQLException;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import in.ineuron.dao.StudentDAOImpl;
import in.ineuron.dao.IStudentDAO;
import in.ineuron.model.Student;


@SpringBootApplication
public class SpringBoot03DataSourceApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBoot03DataSourceApplication.class, args);
		
		IStudentDAO daoImpl = context.getBean(StudentDAOImpl.class);
		
		try {
			List<Student> students = daoImpl.getAllEmployees();
			
			System.out.println();
			students.forEach(System.out::println);
			System.out.println();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		((ConfigurableApplicationContext) context).close();
	}

}
