package pl.estrix.app.basic.user.service;

import java.util.List;

import pl.estrix.app.basic.user.dao.UserRolesDAO;
import pl.estrix.app.basic.user.model.UserRoles;

public class UserRolesService implements IUserRolesService {
	
	// UserRolesDAO is injected...
	UserRolesDAO userRolesDAO;

	public UserRoles getUserRolesById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserRoles> getUserRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserRolesDAO getUserRolesDAO() {
		return userRolesDAO;
	}

	public void setUserRolesDAO(UserRolesDAO userRolesDAO) {
		this.userRolesDAO = userRolesDAO;
	}
	
	

}
