package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDao;
import domain.User;

public class UserService {
	public int register(User user){
		int rs;
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) ctx.getBean("UserDao");
		rs = userDao.add(user);
		
		return rs;
	}
}
