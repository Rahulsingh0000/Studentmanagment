package Studentmanagment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class StudentDao {
public static boolean insertStudentToDB(Student st) {
	//jdbc code..
	boolean f=false;
	try {
	Connection con=CP.createC(); 
	String q="insert into student(sname,sphone,scity) values (?,?,?)";
	//preparesStatement
	PreparedStatement pstmt=con.prepareStatement(q);
	//set the value of parameter
	pstmt.setString(1, st.getStudentName());
	pstmt.setString(2,st.getStudentPhone());
	pstmt.setString(3,st.getStudentCity());
	//excute
	pstmt.executeUpdate();
	con.close();
	f=true;
	}
catch(Exception e) {
	//too handel exception
	e.printStackTrace();
}
	return f;
}
public static boolean deleteStudent(int userId) {
	boolean f=false;
	try {
		Connection con=CP.createC();
		String q="delete from student where sid=?";
		PreparedStatement pstmt=con.prepareStatement(q);
		pstmt.setInt(1,userId);
		pstmt.executeUpdate();
		f=true;
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return f;
}
public static void showAllStudent() {
	try {
		Connection con=CP.createC();
		String q="select * from student";
		Statement stmt=con.createStatement();
		ResultSet set=stmt.executeQuery(q);
		while(set.next()) {
			int id=set.getInt(1);
			String name=set.getString(2);
			String phone=set.getString(3);
			String city=set.getString(4);
			System.out.println("Id: "+id);
			System.out.println("Name: "+name);
			System.out.println("Phone: "+phone);
			System.out.println("city: "+city);
			System.out.println("************************");
			
		} }
		catch(Exception e) {
			e.printStackTrace();
		} 
		
	}
}


