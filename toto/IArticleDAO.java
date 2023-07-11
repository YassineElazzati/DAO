package toto;

import java.util.List;

public interface IArticleDAO {
	public void ajoutArticle(Article unArticle);
	public void suppArticle(int id);
	public void modifArticle(Article unArticle);
	public Article getArticle(int id);
	public List<Article> getAllArticles();
}