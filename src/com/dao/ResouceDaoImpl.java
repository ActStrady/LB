package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.bean.Resouce;
import com.bean.User;
import com.util.HibernateSessionFactory;

public class ResouceDaoImpl implements ResouceDao {

    @Override
    public String saveBook(Resouce resouce) {
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            @SuppressWarnings("rawtypes")
            List list = session
                    .createQuery("from Resouce as r where r.bname=:bname")
                    .setString("bname", resouce.getBname()).list();
            if (list.size() > 0) {
                transaction.commit();
                HibernateSessionFactory.closeSession();
                return "addError";
            } else {
                session.save(resouce);
                transaction.commit();
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return "addSuccess";
    }

    @Override
    public void deleteBook(Resouce resouce) {
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(resouce);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            HibernateSessionFactory.closeSession();
        }

    }

    @Override
    public void updateBook(Resouce resouce) {
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(resouce);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }

    @Override
    public List<Resouce> findAll() {
        Session session = HibernateSessionFactory.getSession();
        try {
            String hql = "from Resouce";
            Query query = session.createQuery(hql);
            List<Resouce> list = query.list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    public List search(Resouce resouce) {
        List list = null;
        Session session = HibernateSessionFactory.getSession();
        Criteria c = session.createCriteria(Resouce.class);
        Example example = Example.create(resouce);
        c.add(example);
        list = c.list();
        return list;
    }

    @Override
    public Resouce getBookById(int resid) {
        Session session = HibernateSessionFactory.getSession();
        Resouce resouce = (Resouce) session.get(Resouce.class, resid);
        return resouce;

    }
}
