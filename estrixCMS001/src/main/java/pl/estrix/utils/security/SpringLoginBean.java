package pl.estrix.utils.security;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  
import javax.faces.event.ActionEvent;  
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import pl.estrix.app.basic.user.managed.bean.UserManagedBean;
import pl.estrix.app.basic.user.model.User;
import pl.estrix.app.basic.user.service.IUserService;
import pl.estrix.utils.StringUtils;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.stereotype.Service;

/**
 * 
 * Spring Login Managed Bean
 * 
 * @author estrix.pl
 * @since 27 Oct 2012
 * @version 1.0.0
 *
 */
@ManagedBean(name="springLoginMB")
@RequestScoped
public class SpringLoginBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(UserManagedBean.class);
	
	private String userName = null;
	
    private String password = null;
    
    private Boolean rememberMe = false;
    
    private boolean logIn = false;

    //Spring User Service is injected...
  	@ManagedProperty(value="#{UserService}")
  	IUserService userService;
  	
  	@ManagedProperty(value="#{StringUtils}")
  	StringUtils stringUtils;
  	
  	@ManagedProperty(value="#{authenticationManager}")
    private AuthenticationManager authenticationManager = null;
  	
  	/** The remember me services. */
    @ManagedProperty(value = "#{rememberMeServices}")
    private RememberMeServices rememberMeServices = null;

    @ManagedProperty(value="#{userDetailsService}")
    private UserDetailsService userDetailsService = null;
    
    public String loginAction() {
    	String returned = null;
    	FacesContext context = FacesContext.getCurrentInstance();
    
    	User user = userService.getUserByEmail(userName);
    	
    	if (user == null){
    		user = userService.getUserByUserName(userName);
    		if (user == null){
    			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd logowania", "Użytkownik \"" + userName + "\" nie istnieje.")); 
    			logIn = false;
    			return returned;
    		}else{
    			logIn = true;
    		}
    	}else{
    		logIn = true;
    	}
    	
    	if (!user.getPassword().equals(stringUtils.getMD5Sum(password))){
    		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd logowania", "Podane hasło jest niepoprawne")); 
    		logIn = false;
    	}
    	
    	if (!user.getEnabled()){
    		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd logowania", "Użytkownik został zablokowany.")); 
    		logIn = false;
    	}
    	
    	
        if (logIn){
        	try {
                Authentication result = null;
                if (rememberMe) {                        
                    UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
                    RememberMeAuthenticationToken rememberMeAuthenticationToken = new RememberMeAuthenticationToken("jsfspring-sec", userDetails,userDetails.getAuthorities());
                    HttpServletRequest httpServletRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
                    HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                    rememberMeServices.loginSuccess(httpServletRequest, httpServletResponse, rememberMeAuthenticationToken);
                    result = rememberMeAuthenticationToken;
                    returned = "Protected";
                } else {
                    Authentication request = new UsernamePasswordAuthenticationToken(getUserName(), getPassword());
                    result = authenticationManager.authenticate(request);
                    returned = "Protected";
                }
                SecurityContextHolder.getContext().setAuthentication(result);
            } catch (AuthenticationException e) {
            	log.error("AuthenticationException" , e);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błędne dane logowania.", ""));
            }
        	
            
            
        }else{
        	
        }
        
        return returned;
        
    }
    
    /**
     * Logout.
     * Delete Cookies
     * @return the string
     */
    public String logout() {
        SecurityContextHolder.clearContext();
        HttpServletRequest httpServletRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        Cookie cookie = new Cookie("SPRING_SECURITY_REMEMBER_ME_COOKIE", null);
        cookie.setMaxAge(0);
        cookie.setPath(httpServletRequest.getContextPath().length() > 0 ? httpServletRequest.getContextPath() : "/");
        httpServletResponse.addCookie(cookie);
        return "loggedout";
    }
    
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public StringUtils getStringUtils() {
		return stringUtils;
	}

	public void setStringUtils(StringUtils stringUtils) {
		this.stringUtils = stringUtils;
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public RememberMeServices getRememberMeServices() {
		return rememberMeServices;
	}

	public void setRememberMeServices(RememberMeServices rememberMeServices) {
		this.rememberMeServices = rememberMeServices;
	}

	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
    
    
    
    
    
    
	
}
