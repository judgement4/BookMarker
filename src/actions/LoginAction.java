package actions;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import models.User;
import models.UserModel;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class LoginAction extends ActionSupport 
						   implements ModelDriven<UserModel>,RequestAware,SessionAware{
	private UserModel loginForm = new UserModel();
	private UserModel userInfo = new UserModel();
	private Map<String, Object> request;
	private Map<String, Object> session;
	
	public LoginAction(){
		System.out.println("enter the login");
	}
	public UserModel getModel(){
		return loginForm;
	}
	
	public void setRequest(Map<String, Object>request){
		this.request = request; 
	}
	@Override
	public void setSession(Map<String, Object>session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	
	public String execute(){
		if(loginForm == null){
			return "error";
		}
		User user = new User();
		userInfo = user.checkUser(loginForm.getUsername(), loginForm.getPassword());
		if(user.flag == true){
			session.put("user", userInfo);
			return "success";
		}else{
			return "error";
		}

	}

	
}
