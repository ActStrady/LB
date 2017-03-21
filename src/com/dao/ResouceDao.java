package com.dao;

import java.util.List;

import com.bean.Resouce;

public interface ResouceDao {
	String saveBook(Resouce resouce);
	Resouce getBookById(int id);
    void deleteBook(Resouce resouce);
    void updateBook(Resouce resouce);
    List<Resouce> findAll();
    public List search(Resouce resouce);
}
