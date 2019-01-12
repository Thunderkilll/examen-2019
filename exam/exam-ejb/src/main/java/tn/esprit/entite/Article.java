package tn.esprit.entite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idart;
	private String nom;
	private int prix;
	private String image;

	@ManyToOne
	@JoinColumn(name = "Fk_idcat")
	Categorie mescategories;

	public int getIdart() {
		return idart;
	}

	public void setIdart(int idart) {
		this.idart = idart;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

	public Categorie getMescategories() {
		return mescategories;
	}

	public void setMescategories(Categorie mescategories) {
		this.mescategories = mescategories;
	}

	@Override
	public String toString() {
		return "Article [idart=" + idart + ", nom=" + nom + ", prix=" + prix + ", image=" + image + "]";
	}

	public Article() {
		super();
	}

	public Article(int idart, String nom, int prix, String image) {
		super();
		this.idart = idart;
		this.nom = nom;
		this.prix = prix;
		this.image = image;
	}



}
