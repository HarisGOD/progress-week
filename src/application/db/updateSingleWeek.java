package application.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class updateSingleWeek {
	public static void update(int id, String context) {
	      Connection con = null;
	      Statement stmt = null;
	      int result = 0;
	      
	      try {
	         Class.forName("org.hsqldb.jdbc.JDBCDriver");
	         con = DriverManager.getConnection(
	            "jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
	         stmt = con.createStatement();
	         result = stmt.executeUpdate(
	            "UPDATE weeks SET context='"+context+"' WHERE id ="+id);
	      } catch (Exception e) {
	         e.printStackTrace(System.out);
	      }
	      System.out.println(result+" Rows effected");
	   }
}
