package com.bng.akul.project.hello;
//package com.bng.akul.project.user;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Iterator;
//import java.util.List;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class UserdaoService {
//	private static List<User> users = new ArrayList<>();
//	private static int counter=3;
//	static {
//		users.add(new User(1,"Akul",new Date()));
//		users.add(new User(2,"Rahul",new Date()));
//		users.add(new User(3,"Shreyansh",new Date()));
//	}
//	
//	
//	//find all
//	public List<User> findAll(){
//		return users;
//	}
//	
//	//find one
//	public User findOne(int id)
//	{
//		for(User user:users)
//		{
//			if(user.getId()==id)
//			{
//				return user;
//			}
//		}
//		return null;
//	}
//	
//	public User deleteUser(int id)
//	{
//		Iterator<User> itr = users.iterator();
//		while(itr.hasNext())
//		{
//			User user= itr.next();
//			if(user.getId()==id)
//			{
//				itr.remove();
//				return user;
//			}
//		}
//		return null;
//	}
//	
//	//add user
//	public User add(User user)
//	{
//		if(user.getId()==null)
//		{
//			user.setId(++counter);
//		}
//		users.add(user);
//		return user;
//	}
//	
//}
