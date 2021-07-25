package DBOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class FetchingDemo {
	public FetchingDemo() {
		// TODO Auto-generated constructor stub
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/JavaDatabase","postgres","postgres");
			if(con!=null)
				System.out.println("database connected");
			else
				System.out.println("not connected");
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select * from employee");
			while(rs.next())
			{
				System.out.println(rs.getInt("Id")+" : "+rs.getString("name")+" : "+rs.getInt("salary"));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FetchingDemo ob=new FetchingDemo();
	}

}
