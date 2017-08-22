
 package com.upgo.service;

import java.util.ArrayList;
import java.util.List;

import com.upgo.dao.ProductDao;
import com.upgo.dao.TBoardDao;
import com.upgo.dto.Product;
import com.upgo.dto.TBoard;
import com.upgo.dto.TBoardComment;
import com.upgo.dto.BoardAttach;
import com.upgo.dto.BoardComment;
import com.upgo.dto.Member;
import com.upgo.dao.MemberDao;


public class ProductService {

	public void writeProduct(Product product) {
		// 처리해야할 내용이 있는 경우 구현 ...
		ProductDao productDao = new ProductDao();
		productDao.writeProduct(product);
		
	}
	
	public List<Product> selectProductList(int first, int last) {
		ProductDao dao = new ProductDao();
		List<Product> Products = dao.selectProductList(first, last);
		return Products;
	}

	
	public Product findProductByProductNo(int prdNo) {
		ProductDao productDao = new ProductDao();
		Product product = productDao.selectProductByProductNo(prdNo);
		return product;
	}
	
	public void updateProduct(Product product) {
		ProductDao productDao = new ProductDao();
		productDao.updateProduct(product);
		
	}

	public void deleteProduct(int productNo) {
		ProductDao productDao = new ProductDao();
		productDao.deleteProduct(productNo);		
	}

		
	}


