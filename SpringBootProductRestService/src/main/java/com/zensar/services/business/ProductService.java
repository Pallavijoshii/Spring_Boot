package com.zensar.services.business;
/*
 * Author: PALLAVI JOSHI
 * Creation Date: 30th July 2019 3.08PM
 * Modified Date: 30th July 2019 3.12PM
 * Version: 3.0
 * Copyright: Zensar Technologies. All rights reserved. 
 * Description: Represents product services which can be accessed by presentation layer.
 * It encapsulates business logic of product entity.
 * */

import java.util.List;

import com.zensar.entities.Product;

public interface ProductService {


	void create(Product product);
	void edit(Product product);
	void remove(Product product);
	Product findProductbyId(int productId);
	List<Product> findAllProducts();
}
