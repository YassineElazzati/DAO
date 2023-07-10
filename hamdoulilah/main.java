package hamdoulilah;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Kebab.Article;

public class main {

	public static void main(String[] args) {
		Connection conn = null;
		

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Article> mesArticles = new ArrayList<Article>();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    
		    String dbName = "SnackMounir"; 
		    String dbUserName = "root"; 
		    String dbPassword = "root"; 
		    String connectionString = "jdbc:mysql://127.0.0.1:3306/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";

		    conn = DriverManager.getConnection(connectionString);
		    
		    Article Kebab = new Article (1,"kebab", 6);
		    
		    
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM Article");
		    while(rs.next()) {
//		    	 System.out.println(rs.getInt(1));
//		    	 System.out.println(rs.getString(2));
//		    	 System.out.println(rs.getInt(3));
	    	     Article MonArticle = new Article (rs.getInt(1),rs.getString(2),rs.getInt(3));
	    	     System.out.println(MonArticle);
	    	     mesArticles.add(MonArticle);
		    }
		   
		    
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
