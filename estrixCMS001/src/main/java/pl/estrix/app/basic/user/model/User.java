package pl.estrix.app.basic.user.model;

import java.sql.Date;

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
@Table(name="users")
public class User {
	
	private int id;
	
	private String username;
	
	private String password;
	
	private String authority;
	
	private Boolean enabled = false;
	
	private String email;
	
	private Date registerDate;
	
	private int messagesCounter;
	
	private int communiqueCounter;
	
	private String sessionId;
	
	@Id
	@Column(name="id", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="username", unique = false, nullable = false)
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="password", unique = false, nullable = false)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="authority", unique = false, nullable = false)
	public String getAuthority() {
		return authority;
	}
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Column(name="enabled", unique = false, nullable = false)
	public Boolean getEnabled() {
		return enabled;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	@Column(name="email", unique = true, nullable = false)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="register_date", unique = false, nullable = false)
	public Date getRegisterDate() {
		return registerDate;
	}
	
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	@Column(name="messages_counter", unique = false, nullable = false)
	public int getMessagesCounter() {
		return messagesCounter;
	}
	
	public void setMessagesCounter(int messagesCounter) {
		this.messagesCounter = messagesCounter;
	}
	
	@Column(name="communique_counter", unique = false, nullable = false)
	public int getCommuniqueCounter() {
		return communiqueCounter;
	}
	
	public void setCommuniqueCounter(int communiqueCounter) {
		this.communiqueCounter = communiqueCounter;
	}
	
	@Column(name="session_id", unique = false, nullable = false)
	public String getSessionId() {
		return sessionId;
	}
	
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("id : ").append(getId());
		strBuff.append(", username : ").append(getUsername());
		strBuff.append(", email : ").append(getEmail());
		return strBuff.toString();
	}
	
}
