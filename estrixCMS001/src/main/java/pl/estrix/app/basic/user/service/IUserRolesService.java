package pl.estrix.app.basic.user.service;

import java.util.List;

import pl.estrix.app.basic.user.model.UserRoles;

public interface IUserRolesService {

	/**
	 * Get UserRoles
	 * 
	 * @param  int User Id
	 */
	public UserRoles getUserRolesById(int id);
	
	/**
	 * Get UserRoles List
	 * 
	 * @return List - UserRoles list
	 */
	public List<UserRoles> getUserRoles();
}
