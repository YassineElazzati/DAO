package toto;

import java.util.List;
import toto.ArticleDAOImpl;

public class GestionnaireArticle {
	private ArticleDAOImpl impl;
	
	public GestionnaireArticle(ArticleDAOImpl impl) {
		this.impl = impl;
	}  
	public double calculerPrixTotal(List<Article>lesArticles) {
		double prixTotal= 0.0;
		for (Article unArticle : lesArticles)
			prixTotal+= unArticle.getprix();
		return prixTotal;
	}
	
}
