package com.rtpl.common;

import java.util.Date;

import org.hibernate.Session;

import com.rtpl.persistence.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
	 public static void main( String[] args )
	    {
	        System.out.println("Maven + Hibernate One-to-One example + MySQL");
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        
	        session.beginTransaction();
	        
	        Stock stock = new Stock();
	        
	        stock.setStockCode("5678");
	        stock.setStockName("neha");
	     
	        StockDetail stockDetail = new StockDetail();
	        stockDetail.setCompName("GENTING Malaysia");
	        stockDetail.setCompDesc("Best resort in the world");
	        stockDetail.setListedDate(new Date());
	        
	        stock.setStockDetail(stockDetail);
	        stockDetail.setStock(stock);
	        
	        session.save(stock);

	        session.getTransaction().commit();
	        
	        
	    }
}
