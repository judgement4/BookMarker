package dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.User;

public class UserDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
	    Session session=sessionFactory.openSession();//´ò¿ªsession
	    return session;
	  }
	
	public User findByName(String userName){
		User user = new User();
		System.out.println("enter UserDao findByName \n");
		String sql="select * from user where userName ='"+userName+"'";
		Session session = (Session)getSession();
		SQLQuery query = session.createSQLQuery(sql).addEntity(User.class);
		List<Object> result = query.list();
		if(!result.isEmpty()){
			Iterator it = result.listIterator();
			while(it.hasNext()){
				user = (User) it.next();
			}
			System.out.println("xxx");
		}else{
			user = null;
		}
		return user;
	}
	
	public User findById(int uid){
		User user = new User();
		System.out.println("enter UserDao findById \n");
		String sql="select * from user where uid ='"+uid+"'";
		Session session = (Session)getSession();
		SQLQuery query = session.createSQLQuery(sql).addEntity(User.class);
		List<Object> result = query.list();
		if(!result.isEmpty()){
			Iterator it = result.listIterator();
			while(it.hasNext()){
				user = (User) it.next();
			}
			System.out.println("xxx");
		}else{
			user = null;
		}
		return user;
	}
	
	public int add(User user){
		System.out.println("enter user DAO add\n");
		String userName;
		String passWord;
		String email;
		int rs;
		
		userName = user.getUserName();
		passWord = user.getPassWord();
		email = user.getEmail();
		
		String sql = "insert into user(userName, passWord, email)values('"+userName+"','"+passWord+"','"+email+"')";
		Session session = (Session)getSession();
		int temp = session.createSQLQuery(sql).executeUpdate();
		if(temp == 1){
			System.out.println("insert 1\n");
			rs = 1;
		}else{
			System.out.println("insert failed\n");
			rs = 0;
		}
				
		return rs;
	}
}
