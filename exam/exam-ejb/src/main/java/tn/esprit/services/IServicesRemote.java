package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entite.Article;
import tn.esprit.entite.Categorie;
import tn.esprit.entite.Commande;

@Remote
public interface IServicesRemote {
	
	public void ajouterCategories(Categorie cat);
	public void ajouterArticle(Article article);
	public void ajouterCommande(Commande c);
	public void affecteArtCat(int idcat , int idart);
	public void affecerArtCmd(int cmd , int idart);
	public List<String> getAllArticleNamesByCategorie(int idmacategorie);
	public List<String> getAllArticleNamesGreaterTanTwoHandred();
}
