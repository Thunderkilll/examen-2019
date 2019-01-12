package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entite.User;

@Remote
public interface IUserServiceRemote {
	public int addUser(User user);
	public User getUserByEmailAndPassword(String email, String password);
	public void deleteUser(User user);
	public List<User> getAllUsers();
	public void updateUser(User e) ;

}
