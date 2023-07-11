package hamdoulilah;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import toto.Article;
import toto.ArticleDAOImpl;
import toto.Service;

public class main {

	public static void main(String[] args) {
		
		
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Article> mesArticles = new ArrayList<Article>();
		ArticleDAOImpl imp1 = new ArticleDAOImpl();		
		Article wrap = new Article (9, "tacos", 6);
		System.out.println(imp1.getArticle(3));
		System.out.println(imp1.getAllArticles());
		
		Service monService = new Service(new ArticleDAOImpl()); 
		ArticleDAOImpl impl = new ArticleDAOImpl();
		//monService.remiseArticle(impl.getAllArticle(), 1.20);
		monService.remiseArticle(impl.getAllArticles(), 2);
		
	}
	
}