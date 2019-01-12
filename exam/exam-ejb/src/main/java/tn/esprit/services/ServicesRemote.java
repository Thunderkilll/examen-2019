package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.entite.Article;
import tn.esprit.entite.Categorie;
import tn.esprit.entite.Commande;



@Stateless
@LocalBean
public class ServicesRemote implements IServicesRemote {

	
	@PersistenceContext(unitName = "exam-ejb")
	EntityManager em;
	
	@Override
	public void ajouterCategories(Categorie cat) {
		try {
			System.out.println("adding cat ...");
			em.persist(cat);

			System.out.println("adding cat ended  ...");
			 

		} catch (Exception e) {
			System.out.println(e + " ...");
 
		}

	}

	@Override
	public void ajouterArticle(Article article) {
		try {
			System.out.println("adding article ...");
			em.persist(article);

			System.out.println("adding article ended  ...");
			 

		} catch (Exception e) {
			System.out.println(e + " ...");
 
		}

	}

	@Override
	public void ajouterCommande(Commande c) {
		try {
			System.out.println("adding commande ...");
			em.persist(c);

			System.out.println("adding commande ended  ...");
			 

		} catch (Exception e) {
			System.out.println(e + " ...");
 
		}


	}

	@Override
	public void affecteArtCat(int idcat, int idart) {
	 Article art = em.find(Article.class, idart);
	 art.setMescategories( em.find(Categorie.class, idcat));
		
	}

	@Override
	public void affecerArtCmd(int idcmd, int idart) {
		Commande c = em.find(Commande.class, idcmd);
		Article art = em.find(Article.class, idart);
		c.getArticles().add(art);
		
		em.merge(c);
	}

	@Override
	public List<String> getAllArticleNamesByCategorie(int idmacategorie) {
		return em.createQuery("select nom from Article p where p.Fk_idcat=:idmacategorie").getResultList();
	  	
	}

	@Override
	public List<String> getAllArticleNamesGreaterTanTwoHandred() {
		// TODO Auto-generated method stub
		return null;
	}

}
