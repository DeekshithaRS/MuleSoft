package movie;

import java.sql.*;
import java.util.Scanner;

public class movieDatabase {
	
	public static void main(String args[] ){
		
		Scanner sc = new Scanner(System.in);
		try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?autoReconnect=true&useSSL=false", "root", "Deeksha2001!");
				Statement st = con.createStatement();
				Statement st1 = con.createStatement();
				ResultSet rs = st.executeQuery("select * from moviesdata");
				while(rs.next()) {
					System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5));
					}
				int result = st.executeUpdate("insert into moviesdata(movieName,actorName,actressName,yearOfRelease,directorName) values('Daasa','Darshan','Rekha','2003','Sathya')");
				if(result>0)
					System.out.println("Successfully inserted");
				else
					System.out.println("Unsuccessful");
				System.out.println("Enter the actor's name:");
				String s = sc.nextLine();
				ResultSet rs1 = st1.executeQuery("select * from moviesdata where actorName='"+s+"'");
				while(rs1.next()) {
		            System.out.println(rs1.getString(1)+"\t\t"+rs1.getString(2)+"\t\t"+rs1.getString(3)+"\t\t"+rs1.getString(4)+"\t\t"+rs1.getString(5));
					String movieName = rs1.getString(1);
					String actorName = rs1.getString(2);
					String actressName = rs1.getString(3);
					String yearOfRelease = rs1.getString(4);
			        String directorName = rs1.getString(5);
				}
		        
		        st.close();
		        st1.close();
		        con.close();
		    }
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		}
	
	
	

}
