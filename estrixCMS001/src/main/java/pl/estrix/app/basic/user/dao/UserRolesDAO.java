package pl.estrix.app.basic.user.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import pl.estrix.app.basic.user.model.UserRoles;

public class UserRolesDAO implements IUserRolesDAO {
	
	private SessionFactory sessionFactory;

	public UserRoles getUserRolesById(int id) {
		List<UserRoles> list = getSessionFactory().getCurrentSession()
				.createQuery("from UserRoles where id=?")
		        .setParameter(0, id).list();
		return list.get(0);
	}

	public List<UserRoles> getUserRoles() {
		List<UserRoles> list = getSessionFactory().getCurrentSession().createQuery("from UserRoles").list();
		return list;
	}
	
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

}
