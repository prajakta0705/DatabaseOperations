package DBOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertionDemo {
	Connection con;
	PreparedStatement ps;
	InsertionDemo() 
	{
		try
		{
			//Class.forName("org.postgresql.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:postgresql://localhost/JavaDatabase","postgres","postgres");
			if(con!=null)
			{
				System.out.println("connect");
			}
			else
			{
				System.out.println("could not connect");
				System.exit(0);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in connection");
		}
	}
	void save()
	{
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Employee Id=");
			int id=Integer.parseInt(br.readLine());
			System.out.println("Enter Employee name=");
			String name=br.readLine();
			System.out.println("Enter Employee Salary=");
			int salary=Integer.parseInt(br.readLine());
			
			
			ps=con.prepareStatement("insert into employee values(?,?,?)");
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setInt(3,salary);
			int i=ps.executeUpdate();
			if(i==0)
				System.out.println("unable to insert");
			else
				System.out.println("Inserted Successfully!");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionDemo ob=new InsertionDemo();
		ob.save();
	}

}
