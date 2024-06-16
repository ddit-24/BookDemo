package com.Test;

import java.util.List;

import com.Entity.Category;
import com.Service.CategoryService;
import com.ServiceImpl.CategoryServiceImpl;

public class CategoryTest {

	public static void main(String[] args) {
		CategoryService cs = new CategoryServiceImpl();
		List<Category> seletcall = cs.selectList();
		System.out.println(seletcall.size());
	}

}
