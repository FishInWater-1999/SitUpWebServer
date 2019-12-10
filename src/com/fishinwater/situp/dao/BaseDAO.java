package com.fishinwater.situp.dao;

import java.util.List;

import com.fishinwater.situp.utils.DaoEnum;

public interface BaseDAO<T> {
	

	public int add(T obj);

	public T update(T obj);

	public int delete(T key);

	public T getBy(DaoEnum flag, String where);

	public List<T> getAll();

	public long getCount(String where);
	
}