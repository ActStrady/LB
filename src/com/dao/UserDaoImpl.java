package com.dao;
import java.util.List;




import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.User;
import com.dao.UserDao;
import com.util.HibernateSessionFactory;


public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
   //增加用户方法
	
	public String save(User user) {
		Session session =HibernateSessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        try{
			@SuppressWarnings("rawtypes")
			List list =session.createQuery("from User as u where u.username=:username")
           		  .setString("username",user.getUsername()).list();
        	if(list.size()>0){
        		tx.commit();
        		HibernateSessionFactory.closeSession();
        		return "error";
        	}else{
        	user.setRid(1);
        	session.save(user);
        	tx.commit();
            session.close();
        	}
        }catch(Exception e){
        	e.printStackTrace();
        	tx.rollback();
        }
		return "success";
	}
  //查询方法
	@Override
	public User findById(int id) {
		User user=null;
		Session session=HibernateSessionFactory.getSession();
		Transaction tx =session.beginTransaction();
		try{
			user=(User)session.get(User.class, id);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return user;
	}

	@Override
	public void delete(User user) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tx =session.beginTransaction();
        try{
        	session.delete(user);
        	tx.commit();
        }catch(Exception e){
        	e.printStackTrace();
        	tx.rollback();
        }finally{
        	HibernateSessionFactory.closeSession();
        }
	}
      
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Session session=HibernateSessionFactory.getSession();
		Transaction tx =session.beginTransaction();
		try{
		 session.update(user);
		 tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	@Override
	public boolean login(User user) {
		Session session=HibernateSessionFactory.getSession();		
		try{
			String hql="from User as u where u.username=? and u.password=?";
			Query query =session.createQuery(hql);
			query.setString(0, user.getUsername());
			query.setString(1, user.getPassword());
			@SuppressWarnings("rawtypes")
			List userList =query.list();
			    if(userList.size()>0){
			    	
			    	return true;
			    }else {
					return false;
				}
				    
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public User findByName(String username) {
		Session session=HibernateSessionFactory.getSession();
	   try{
		   String hql="from User as u where u.username=:n";
		   Query query =session.createQuery(hql);
		   query.setString("n", username);
		   List<User> list =query.list();
		   User user=null;
		   for(User user2:list){
			   user =user2;
		   }
		   return user;
	   }catch(HibernateException e){
		   throw e;
	   }finally{
		   if(session!=null){
			   session.close();
		   }
	   }
		
	}
    
    
}
