package com.zensar.services.business;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zensar.daos.ProductDao;
import com.zensar.entities.Product;
/*
 * Author: PALLAVI JOSHI
 * Creation Date: 30th July 2019 3.08PM
 * Modified Date: 30th July 2019 3.12PM
 * Version: 3.0
 * Copyright: Zensar Technologies. All rights reserved. 
 * Description: Represents data access object interface.
 * used by business layer.
 * It contains CRUD  operation methods for entity product.
 * */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao dao;

	public void create(Product product) {
		// TODO Auto-generated method stub
		dao.insert(product);
		

	}

	public void edit(Product product) {
		// TODO Auto-generated method stub
		Product dbproduct = findProductbyId(product.getProductId());
		if(dbproduct!=null) {
			dbproduct.setName(product.getName());
			dbproduct.setBrand(product.getBrand());
			dbproduct.setPrice(product.getPrice());
			dao.update(dbproduct);
			
		}else
			System.out.println("Sorry! Product does not exist");

	}

	public void remove(Product product) {
		// TODO Auto-generated method stub
		Product dbproduct = findProductbyId(product.getProductId());
		if(dbproduct!=null) {
			
			dao.delete(dbproduct);
			
		}else
			System.out.println("Sorry! Product does not exist");

	}

	public Product findProductbyId(int productId) {
		// TODO Auto-generated method stub
		return dao.getById(productId);
	}

	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

}
