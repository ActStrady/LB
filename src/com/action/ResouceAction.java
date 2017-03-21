package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Resouce;
import com.dao.ResouceDao;
import com.dao.ResouceDaoImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ResouceAction extends ActionSupport implements
        ModelDriven<Resouce>, RequestAware, SessionAware {

    private static final long serialVersionUID = 1L;
    private Resouce resouce;
    private ResouceDao resouceDaoImpl = new ResouceDaoImpl();
    private int resid;

    @Override
    public Resouce getModel() {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        Resouce resouce = (Resouce) context.getBean("resouce");
        this.resouce = resouce;
        return resouce;
    }

    public String deleteBook() {
        String id = ServletActionContext.getRequest().getParameter("id");
        int resid = Integer.parseInt(id);
        Resouce res = resouceDaoImpl.getBookById(resid);
        if (res != null) {
            System.out.println(res.getBname());
            resouceDaoImpl.deleteBook(res);
            List<Resouce> bookList = resouceDaoImpl.findAll();
            ServletActionContext.getRequest()
                    .setAttribute("bookList", bookList);
            return SUCCESS;
        }
        return ERROR;

    }

    public String saveBook() {
        resouce.setBname(resouce.getBname());
        resouce.setBdate(resouce.getBdate());
        resouce.setPrice(resouce.getPrice());
        String result = resouceDaoImpl.saveBook(resouce);
        if (result == "addSuccess") {
            List<Resouce> bookList = resouceDaoImpl.findAll();
            ServletActionContext.getRequest()
                    .setAttribute("bookList", bookList);
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String updateBook() {
        resouce.setBname(resouce.getBname());
        resouce.setBdate(resouce.getBdate());
        resouce.setPrice(resouce.getPrice());
        resouceDaoImpl.updateBook(resouce);
        List<Resouce> bookList = resouceDaoImpl.findAll();
        ServletActionContext.getRequest().setAttribute("bookList", bookList);
        return "manager";
    }

    public String toUpdate() {
        String id = ServletActionContext.getRequest().getParameter("id");
        int resid = Integer.parseInt(id);
        Resouce resouce = resouceDaoImpl.getBookById(resid);
        request.put("resouce", resouce);
        return "toupdate";
    }
    
    Map<String, Object> request;

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    Map<String, Object> session;

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
