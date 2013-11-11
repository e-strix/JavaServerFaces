package pl.estrix.app.basic.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pl.estrix.app.basic.user.dao.IUserDAO;
import pl.estrix.app.basic.user.model.User;


/**
 * 
 * User Service
 * 
 * @author estrix.pl
 * @since 24 Oct 2013
 * @version 1.0.0
 *
 */
@Transactional(readOnly = true)
public class UserService implements IUserService {
	
	private String language;

	// UserDAO is injected...
	IUserDAO userDAO;
	
	/**
	 * Add User
	 * 
	 * @param  User user
	 */
	@Transactional(readOnly = false)
	public void addUser(User user) {
		getUserDAO().addUser(user);
	}

	/**
	 * Delete User
	 * 
	 * @param  User user
	 */
	@Transactional(readOnly = false)
	public void deleteUser(User user) {
		getUserDAO().deleteUser(user);
	}
	
	/**
	 * Update User
	 * 
	 * @param  User user
	 */
	@Transactional(readOnly = false)
	public void updateUser(User user) {
		getUserDAO().updateUser(user);
	}
	
	/**
	 * Get User
	 * 
	 * @param  int User Id
	 */
	public User getUserById(int id) {
		return getUserDAO().getUserById(id);
	}

	/**
	 * Get User List
	 * 
	 */
	public List<User> getUsers() {	
		return getUserDAO().getUsers();
	}

	/**
	 * Get User DAO
	 * 
	 * @return IUserDAO - User DAO
	 */
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * Set User DAO
	 * 
	 * @param IUserDAO - User DAO
	 */
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public int getLastUserId() {
		return getUserDAO().getLastUserId();
	}

	public String getLanguageVal() {
		// TODO Auto-generated method stub
		return getLanguage();
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public User getUserByEmail(String email) {
		return getUserDAO().getUserByEmail(email);
	}

	public User getUserByUserName(String username) {
		return getUserDAO().getUserByUserName(username);
	}


}
