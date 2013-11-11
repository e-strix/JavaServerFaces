package pl.estrix.app.basic.user.dao;

import java.util.List;

import pl.estrix.app.basic.user.model.UserRoles;


public interface IUserRolesDAO {

	/**
	 * Get UserRoles
	 * 
	 * @param  int User Role Id
	 */
	public UserRoles getUserRolesById(int id);
	
	/**
	 * Get UserRoles List
	 * 
	 */
	public List<UserRoles> getUserRoles();
}
