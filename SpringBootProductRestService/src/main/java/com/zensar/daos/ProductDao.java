package com.zensar.daos;

import java.util.List;



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


public interface ProductDao {
	
	

	void insert (Product product);
	void update (Product product);
	void delete (Product product);
Product getById(int productId);
List<Product> getAll();
}
