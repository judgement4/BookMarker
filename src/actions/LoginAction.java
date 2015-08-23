package actions;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import models.LoginModel;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport 
						   implements ModelDriven<LoginModel>, RequestAware{
	private LoginModel user = new LoginModel();
	private Map<String, Object> request;
	
	public LoginAction(){
		System.out.println("enter the login");
	}
	public LoginModel getModel(){
		return user;
	}
	
	public void setRequest(Map<String, Object>request){
		this.request = request; 
	}
	
	public String execute(){
		if(user == null){
			return "error";
		}
		System.out.println("username is:"+user.getUsername());
		System.out.println("passwd is:"+user.getPassword());
		if((user.getUsername().equals("FF"))&&(user.getPassword().equals("123"))){
			this.request.put("username", user.getUsername());
			return "success";			
		}
			else{
				System.out.println("enter failed");
				return "error";
			}
	}
	
}
