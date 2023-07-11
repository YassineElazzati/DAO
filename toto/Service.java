package toto;

import java.util.List;

public class Service {
	private ArticleDAOImpl impl;

	public Service(ArticleDAOImpl impl) {
		this.impl = impl;
	}
	
	public void remiseArticle(List<Article> lesArticles, double remise) {
		for(Article unArticle : lesArticles) {
			unArticle.setprix(unArticle.getprix() * remise);
			impl.modifArticle(unArticle);
		}
	}
}
