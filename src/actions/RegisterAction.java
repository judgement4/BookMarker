package actions;

import models.User;
import models.UserModel;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven<UserModel>{
	private UserModel regForm = new UserModel();
	
	public UserModel getModel(){
		return regForm;
	}
	
	public RegisterAction(){
		System.out.println("enter register");
	}
	
	public String execute(){
		System.out.println("enter register2");
		User user = new User();
		int count = 0;
		count = user.add(regForm);
		if(count > 0){
			System.out.println(count);
			return SUCCESS;
		}
		else
			return "error";
	}
}
