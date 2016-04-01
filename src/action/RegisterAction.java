package action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.User;

public class RegisterAction extends ActionSupport implements ModelDriven<User>{
	
	private User RegisterForm = new User();
	
	public User getModel(){
		return RegisterForm;
	}
	public String execute(){
		String rs = "error";
		int temp = 0;
		if(RegisterForm == null)
			rs = "error";
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)ctx.getBean("UserService");
		temp = userService.register(RegisterForm);
		if(temp == 1)
			rs = "success";
		return rs;
	}
}
