package hamdoulilah;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Kebab.Article;
public class main {

	public static void main(String[] args) {
		
		



		Connection conn = null;
		
		try {
		    conn =
		    		
		       DriverManager.getConnection("jdbc:mysql://localhost/SnackMounir?" +
		                                   "user=root&password=root");

		  
		} catch (SQLException ex) {
			
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());

		    
		    Article Kebab = new Article(1, "Kebab", 5);
		    
		    
		    
		    
		    
		}
		
	}

}
