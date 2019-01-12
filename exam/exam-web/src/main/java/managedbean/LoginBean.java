package managedbean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.entite.Role;
import tn.esprit.entite.User;
import tn.esprit.services.UserService;

 

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	private User user;
	private Boolean loggedIn;
	@EJB
	UserService userService;

	public String doLogin() {
		String navigateTo = "null";
		System.out.println(email + " " + password);
		user = userService.getUserByEmailAndPassword(email, password);
		System.out.println(user.toString());
		if (user != null && user.getRole() == Role.admin) {//
			navigateTo = "/pages/admin/welcome?faces-redirect=true";
			loggedIn = true;
		} else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		}
		return navigateTo;
	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}