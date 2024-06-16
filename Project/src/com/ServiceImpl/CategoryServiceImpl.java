package com.ServiceImpl;

import java.util.List;

import com.Dao.CategoryDao;
import com.Dao.UserDao;
import com.DaoImpl.CategoryDaolmpl;
import com.DaoImpl.UserDaoImpl;
import com.Entity.Category;
import com.Entity.User;
import com.Service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public List<Category> selectList() {
		CategoryDao categoryDao = new CategoryDaolmpl();
		List<Category> Selectlist = categoryDao.selectList();
		return Selectlist;
	}

}
