package action;

import java.util.Map;

import dao.UserDao;
import domain.User;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.Login;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.User;

public class LoginAction extends ActionSupport
							implements ModelDriven<User>,RequestAware,SessionAware{
	private User user;
	private Map<String, Object> request;
	private Map<String, Object> session;
	private User loginForm = new User();
	
	public User getModel(){
		return loginForm;
	}
	
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public LoginAction(){
		System.out.println("enter action loginAction\n");
	}
	
	
	public String execute(){
		System.out.println("enter action loginAction exceute\n");
		String userName;
		String passWord;
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Login login = (Login) ctx.getBean("Login");
		userName = loginForm.getUserName();
		passWord = loginForm.getPassWord();
		user = login.validate(userName, passWord);
		if(user != null)
			return "success";
		else
			return "error";
	}

}
