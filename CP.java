package Studentmanagment;
import java.sql.Connection;
import java.sql.DriverManager;
public class CP {
//Connection con;
	static Connection con;
	public static Connection createC() {
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user="root";
			String password="Rahul@7999";
			String url="jdbc:mysql://localhost:3306/student";
			con=DriverManager.getConnection(url,user,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}

