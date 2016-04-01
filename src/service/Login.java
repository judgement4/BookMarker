package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDao;
import domain.User;

public class Login {
	
	public User validate(String userName, String passWord){
		User user = new User();
		System.out.println("enter service validate\n");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) ctx.getBean("UserDao");
		user = userDao.findByName(userName);
		if(user.getPassWord().equals(passWord)){
			System.out.println("validate success\n");
		}else{
			System.out.println("validate failed\n");
			user = null;
		}
		return user;
	}
}
