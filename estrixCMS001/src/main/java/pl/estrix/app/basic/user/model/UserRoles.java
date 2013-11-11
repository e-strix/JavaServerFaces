package pl.estrix.app.basic.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * User Entity
 * 
 * @author e-strix.pl
 * @since 24 Oct 2013
 * @version 1.0.0
 *
 */
@Entity
@Table(name="user_roles")
public class UserRoles {
	
	private int userRoleId;
	
	private int userId;
	
	private String  authority;

	@Id
	@Column(name="user_role_id", unique = true, nullable = false)
	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Column(name="user_id", unique = false, nullable = false)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name="authority", unique = false, nullable = false)
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	

}
