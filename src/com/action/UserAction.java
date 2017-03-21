package com.action;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Resouce;
import com.bean.User;
import com.dao.ResouceDao;
import com.dao.ResouceDaoImpl;
import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class UserAction extends ActionSupport implements ModelDriven<User> {
  static final long serialVersionUID = 1L;
 
  private UserDao userDaoImpl =new UserDaoImpl();
  private ResouceDao resouceDaoImpl = new ResouceDaoImpl();
  private User user;
  private String error1= null;
  private String error2= null;
  
  
	public String getError2() {
	return error2;
}

public void setError2(String error2) {
	this.error2 = error2;
}

	public String getError1() {
	return error1;
}

    public void setError1(String error1) {
	this.error1 = error1;
}

	@Override
	public User getModel() {
		
		@SuppressWarnings("resource")
		ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
		User user =(User)context.getBean("user");
		this.user =user;
		return user;
	}

    public String login(){
    	if(userDaoImpl.login(user)){
    		String uname=user.getUsername();
    		User uu =userDaoImpl.findByName(uname);
    		if(uu.getRid()==1){
    			List<Resouce> bookList =resouceDaoImpl.findAll();
    	    	ServletActionContext.getRequest().setAttribute("bookList", bookList);
    		return "simple";
    		}else if(uu.getRid()==2){
    			List<Resouce> bookList =resouceDaoImpl.findAll();
    	    	ServletActionContext.getRequest().setAttribute("bookList", bookList);
    			return "adm";
    	  }else{
    		setError1("用户名或密码错误");
        	return ERROR;
          }
    		}
		return null;
    }
    public String register(){
    	  user.setUsername(user.getUsername());
    	  user.setPassword(user.getPassword());
    	  String result =userDaoImpl.save(user);
    	  if(result.equals("error")){
    		  setError2("该用户名已被注册");
    		  return ERROR;
    	  }else 
    		  return SUCCESS;
    	}
    	
    	
    
}
