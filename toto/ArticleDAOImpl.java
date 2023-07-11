package toto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAOImpl implements IArticleDAO {

	static Connection conn = null;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dbName = "snackmounir"; 
			String dbUserName = "root"; 
			String dbPassword = "root"; 
			String connectionString = "jdbc:mysql://localhost/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword ;
			conn = DriverManager.getConnection(connectionString);
			
			
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
		public void ajoutArticle (Article monArticle) {
			PreparedStatement stmtAddArticle;
			try {
				stmtAddArticle = conn.prepareStatement("INSERT INTO article (libelle, prix) VALUES (?,?)");
				stmtAddArticle.setString(1, monArticle.getlibelle());
				stmtAddArticle.setDouble(2, monArticle.getprix());
				int nbInserted =  stmtAddArticle.executeUpdate();
				System.out.println(nbInserted);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
		@Override
		public void suppArticle(int id) {
			PreparedStatement stmtDeleteArticle;
			try {
				stmtDeleteArticle = conn.prepareStatement("DELETE FROM article WHERE id = ?");
				stmtDeleteArticle.setInt(1, id);
				int nbInserted =  stmtDeleteArticle.executeUpdate();
				System.out.println(nbInserted);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
		@Override
		public void modifArticle(Article monArticle) {
			PreparedStatement stmtUpArticle;
			try {
				stmtUpArticle = conn.prepareStatement("UPDATE article SET libelle = ?, prix = ? WHERE id = ? ");
				stmtUpArticle.setString(1, monArticle.getlibelle());
				stmtUpArticle.setDouble(2, monArticle.getprix());
				stmtUpArticle.setInt(3, monArticle.getid());
				int nbInserted =  stmtUpArticle.executeUpdate();
				System.out.println(nbInserted);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
		@Override
		public Article getArticle(int id) {
			
			PreparedStatement stmtArticle;
			Article newArticle = null;
			try {
				stmtArticle = conn.prepareStatement("SELECT * FROM article WHERE id= ?");
				stmtArticle.setInt(1, id);
				ResultSet res = stmtArticle.executeQuery();
				if(res.next()) {
					newArticle = new Article(res.getInt("id"), res.getString("libelle"), res.getDouble("prix"));
				}
           
				
			} catch (SQLException e) {
				e.printStackTrace();
			}		
			return newArticle;
					
		}
	
		@Override
		public  List <Article> getAllArticles() {
			List<Article> mesArticles = new ArrayList<Article>();
			
			PreparedStatement stmtArticle;
			try {
				stmtArticle = conn.prepareStatement("SELECT * FROM article");
				
				ResultSet res = stmtArticle.executeQuery();	
				while(res.next()) {
	        	   	mesArticles.add(new Article(res.getInt("id"),res.getString("libelle") ,res.getInt("prix") ));				
	        	   	}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return mesArticles;
			 
		}

}