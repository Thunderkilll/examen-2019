package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.entite.User;

@Stateless
@LocalBean
public class UserService implements IUserServiceRemote {

	@PersistenceContext(unitName = "exam-ejb")
	EntityManager em;

	@Override
	public int addUser(User user) {
		try {
			System.out.println("adding user ...");
			em.persist(user);

			System.out.println("adding user ended  ...");
			return user.getId();

		} catch (Exception e) {
			System.out.println(e + " ...");
			return -1;
		}
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		System.out.println("inside getuserbyemailandpassword  ....");
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email=:email AND u.password=:password",
				User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void deleteUser(User user) {
		try {
			System.out.println("inside delete user");
			Query query = em.createQuery("DELETE FROM User u WHERE u.id=:id");
			query.setParameter("id", user.getId());
			query.executeUpdate();
			System.out.println("user removed");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public List<User> getAllUsers() {
		try {
			System.out.println("inside getAllUsers");
			return em.createQuery("SELECT u FROM User u", User.class).getResultList();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	@Override
	public void updateUser(User e) {
		User emp = em.find(User.class, e.getId());
		emp.setLastname(e.getLastname());
		emp.setPassword(e.getPassword());
		emp.setEmail(e.getEmail());
		emp.setFirstname(e.getFirstname());
		emp.setRole(e.getRole());

	}

}
