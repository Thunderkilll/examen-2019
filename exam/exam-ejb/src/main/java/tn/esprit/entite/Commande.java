package tn.esprit.entite;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "commande")
public class Commande implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcmd;
	
	private String dateLivraison ;
	private Status status ;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<Article> articles;
	
	
	
	
	
	public int getIdcmd() {
		return idcmd;
	}
	public void setIdcmd(int idcmd) {
		this.idcmd = idcmd;
	}
	public String getDateLivraison() {
		return dateLivraison;
	}
	public void setDateLivraison(String dateLivraison) {
		this.dateLivraison = dateLivraison;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	@Override
	public String toString() {
		return "Commande [idcmd=" + idcmd + ", dateLivraison=" + dateLivraison + ", status=" + status + ", articles="
				+ articles + "]";
	}
	public Commande(int idcmd, String dateLivraison, Status status, List<Article> articles) {
		super();
		this.idcmd = idcmd;
		this.dateLivraison = dateLivraison;
		this.status = status;
		this.articles = articles;
	}
	public Commande() {
		super();
	}

	
	
}
