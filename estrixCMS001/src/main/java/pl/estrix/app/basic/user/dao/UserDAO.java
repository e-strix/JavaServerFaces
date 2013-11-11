package pl.estrix.app.basic.user.dao;

import java.util.List;



import org.hibernate.SessionFactory;

import pl.estrix.app.basic.user.model.User;

/**
 * 
 * User DAO
 * 
 * @author estrix.pl
 * @since 24 Oct 2013
 * @version 1.0.0
 *
 */

public class UserDAO implements IUserDAO {
	
	private SessionFactory sessionFactory;

	/**
	 * Get Hibernate Session Factory
	 * 
	 * @return SessionFactory - Hibernate Session Factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Set Hibernate Session Factory
	 * 
	 * @param SessionFactory - Hibernate Session Factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	/**
	 * Add User
	 * 
	 * @param  User user
	 */
	public void addUser(User user) {
		getSessionFactory().getCurrentSession().save(user);
	}

	/**
	 * Delete User
	 * 
	 * @param  User user
	 */
	public void deleteUser(User user) {
		getSessionFactory().getCurrentSession().delete(user);
	}

	/**
	 * Update User
	 * 
	 * @param  User user
	 */
	public void updateUser(User user) {
		getSessionFactory().getCurrentSession().update(user);
	}

	/**
	 * Get User
	 * 
	 * @param  int User Id
	 * @return User 
	 */
	public User getUserById(int id) {
		List list = getSessionFactory().getCurrentSession()
											.createQuery("from User where id=?")
									        .setParameter(0, id).list();
		return (User)list.get(0);
	}

	/**
	 * Get User List
	 * 
	 * @return List - User list
	 */
	public List<User> getUsers() {
		List list = getSessionFactory().getCurrentSession().createQuery("from User").list();
		return list;
	}

	public int getLastUserId() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from User ORDER BY id DESC").list();
		return ((User)list.get(0)).getId();
	}

	public User getUserByEmail(String email) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from User where email=?")
		        .setParameter(0, email).list();
		if (list != null && list.size() > 0)		
			return (User)list.get(0);
		else
			return null;
	}

	public User getUserByUserName(String username) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from User where username=?")
		        .setParameter(0, username).list();
		if (list != null && list.size() > 0)		
			return (User)list.get(0);
		else
			return null;
	}

}
