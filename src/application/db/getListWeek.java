package application.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.units.week;

public class getListWeek {
	
		public static List<week> getPostList() {
		      Connection con = null;
		      Statement stmt = null;
		      ResultSet result = null;
		      List<week> weeksList= new ArrayList<>();
		      
		      try {
		         Class.forName("org.hsqldb.jdbc.JDBCDriver");
		         con = DriverManager.getConnection(
		            "jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
		         stmt = con.createStatement();
		         result = stmt.executeQuery(
		            "SELECT id, context from weeks ORDER BY id ASC");
		         
		         while(result.next()){
		        	 weeksList.add(new week(result.getInt("id"),
		        			 result.getString("context")));
		         }
		      } catch (Exception e) {
		         e.printStackTrace(System.out);
		      }
			return weeksList;
		   }
	
}
