package tn.esprit.entite;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Categorie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcat")
	private int idcat;
	private String nomcat;
	
	@OneToMany(mappedBy="mescategories")
	private List<Article> mes_articles;
	
	

	public int getIdcat() {
		return idcat;
	}

	public void setIdcat(int idcat) {
		this.idcat = idcat;
	}

	public String getNomcat() {
		return nomcat;
	}

	public void setNomcat(String nomcat) {
		this.nomcat = nomcat;
	}

	public List<Article> getMes_articles() {
		return mes_articles;
	}

	public void setMes_articles(List<Article> mes_articles) {
		this.mes_articles = mes_articles;
	}

	public Categorie(int idcat, String nomcat, List<Article> mes_articles) {
		super();
		this.idcat = idcat;
		this.nomcat = nomcat;
		this.mes_articles = mes_articles;
	}

	public Categorie() {
		super();
	}

	public Categorie(int idcat, String nomcat) {
		super();
		this.idcat = idcat;
		this.nomcat = nomcat;
	}
	
	

}
