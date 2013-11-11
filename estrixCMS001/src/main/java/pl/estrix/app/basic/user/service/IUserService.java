package pl.estrix.app.basic.user.service;

import java.util.List;

import pl.estrix.app.basic.user.model.User;


/**
 * 
 * User Service Interface
 * 
 * @author e-strix.pl
 * @since 24 Oct 2013
 * @version 1.0.0
 *
 */
public interface IUserService {
	
	/**
	 * Add User
	 * 
	 * @param  User user
	 */
	public void addUser(User user);
	
	/**
	 * Update User
	 * 
	 * @param  User user
	 */
	public void updateUser(User user);

	/**
	 * Delete User
	 * 
	 * @param  User user
	 */
	public void deleteUser(User user);
	
	/**
	 * Get User
	 * 
	 * @param  int User Id
	 */
	public User getUserById(int id);
	
	/**
	 * Get User
	 * 
	 * @param  String User Email
	 */
	public User getUserByEmail(String email);
	
	/**
	 * Get User
	 * 
	 * @param  String User username
	 */
	public User getUserByUserName(String username);
	
	/**
	 * Get User List
	 * 
	 * @return List - User list
	 */
	public List<User> getUsers();
	
	/**
	 * Get Last User Id
	 * @return int - Last id in table User
	 */
	public int getLastUserId();
	
	public String getLanguageVal();
}
