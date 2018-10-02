package com.portfolio.onlineStore.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.portfolio.onlineStore.entity.Product;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ProductSessionBean {
	@PersistenceContext
	EntityManager em;
	
	public Product find() {
		return null;
	}
	public void delete(Product product) {
		
	}
	public List<Product> findAll(){
		return null;
	}
}
