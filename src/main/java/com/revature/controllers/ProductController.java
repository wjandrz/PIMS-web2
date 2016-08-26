package com.revature.controllers;

import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.*;
import org.springframework.web.servlet.ModelAndView;

import com.revature.PIMS.SessionFactoryManager;
import com.revature.beans.Product;
import com.revature.beans.ProductCategory;
import com.revature.beans.NewClient;
import com.revature.database.DataLayer;
import com.revature.database.ProductCategoryDAO;
import com.revature.database.ProductDAO;

@Controller
public class ProductController implements ServletContextAware, InitializingBean {
	
	@Autowired
	private ServletContext servletContext; // instance var
	Session session = SessionFactoryManager.getInstance().openSession();
	DataLayer dl = new DataLayer();
	
	
	@RequestMapping(value="create.do", method=RequestMethod.GET)
	public String setNewProd(HttpServletRequest req){
		ProductCategoryDAO prodCatDAO = new ProductCategoryDAO(session);
		ProductDAO productDAO = new ProductDAO(session);
		req.setAttribute("newProd", new Product());
		req.setAttribute("allProducts", productDAO.getAllProducts());
		req.setAttribute("prodCat", prodCatDAO.getAllProductCategories());
		return "updateproduct";
	}
	
	@RequestMapping(value="addProduct.do", method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public void addProduct(
			HttpServletRequest req, 
			HttpServletResponse resp,
			@Valid @RequestBody Product newProduct){
		
		Vector<Product> products = (Vector<Product>) this.servletContext.getAttribute("products");
		ProductCategoryDAO prodCatDAO = new ProductCategoryDAO(session);
		ProductDAO prodDAO = new ProductDAO(session);
		
		
		
		double unitCost = Double.parseDouble(newProduct.getStrUnitCost()); 
		int reQuat = Integer.parseInt(newProduct.getStrReQuat());
		double retailCost = Double.parseDouble(newProduct.getStrRetail());
		int qoh = Integer.parseInt(newProduct.getStrQOH());
		String[] prodCats = newProduct.getStrProdCat();
		Set<ProductCategory> pCat = new HashSet<>();
		
		for(int i=0;i<prodCats.length;i++){
			System.out.println(prodCats[i]);
			ProductCategory prCat = prodCatDAO.getProductCategoryById(Integer.parseInt(prodCats[i]));
			pCat.add(prCat);
		}
		
		Product newProd = new Product(newProduct.getStrName(), newProduct.getStrDesc(), newProduct.getStrShName(),
				unitCost, newProduct.getStrPackSize(), reQuat, retailCost, qoh, pCat);
		
		System.out.println(newProd.toString());			
		dl.createRecord(newProd);
		
		Product tempProd = prodDAO.getProductByShortName(newProd.getShortName());
		Set<Product> tempProdSet = new HashSet<Product>();
		tempProdSet.add(tempProd);
		
		for(ProductCategory pc : pCat){
			pc.setProducts(tempProdSet);
			dl.createRecord(pc);
		}
		
		
		products.add(newProd);
		System.out.println(newProduct.toString());
		
		this.servletContext.setAttribute("products", products); // update products
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	///						UPDATE PRODUCT
	/////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="updateProduct.do", method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public void updateProduct(
			HttpServletRequest req, 
			HttpServletResponse resp,
			@Valid @RequestBody Product newProduct){
		
		Vector<Product> products = (Vector<Product>) this.servletContext.getAttribute("products");
		ProductCategoryDAO prodCatDAO = new ProductCategoryDAO(session);
		ProductDAO prodDAO = new ProductDAO(session);
		
		
		
		double unitCost = Double.parseDouble(newProduct.getStrUnitCost()); 
		int reQuat = Integer.parseInt(newProduct.getStrReQuat());
		double retailCost = Double.parseDouble(newProduct.getStrRetail());
		int qoh = Integer.parseInt(newProduct.getStrQOH());
		String[] prodCats = newProduct.getStrProdCat();
		Set<ProductCategory> pCat = new HashSet<>();
		
		for(int i=0;i<prodCats.length;i++){
			System.out.println(prodCats[i]);
			ProductCategory prCat = prodCatDAO.getProductCategoryById(Integer.parseInt(prodCats[i]));
			pCat.add(prCat);
		}
		
		Product newProd = new Product(newProduct.getProductUpc(), newProduct.getStrName(), newProduct.getStrDesc(), newProduct.getStrShName(),
				unitCost, newProduct.getStrPackSize(), reQuat, retailCost, qoh, pCat);
		
		System.out.println(newProd.toString());			
		dl.createRecord(newProd);
		
		Product tempProd = prodDAO.getProductByShortName(newProd.getShortName());
		Set<Product> tempProdSet = new HashSet<Product>();
		tempProdSet.add(tempProd);
		
		for(ProductCategory pc : pCat){
			pc.setProducts(tempProdSet);
			dl.createRecord(pc);
		}
		
		
		products.add(newProd);
		System.out.println(newProduct.toString());
		
		this.servletContext.setAttribute("products", products); // update products
	}
	
	@RequestMapping(value="removeProduct.do", method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public void removeClient(HttpServletRequest req, HttpServletResponse resp, @RequestBody Product product){
		ProductDAO prodDao = new ProductDAO(session);
		Product prod = prodDao.getProductById(product.getProductUpc());
		prod.setProductCategories(null);
		dl.createRecord(prod);
		prodDao.deleteProduct(prod.getProductUpc());
	}
	
	@RequestMapping(value="fillProduct.do", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Product getProduct(@RequestParam(value="value") int value){
		ProductDAO productDAO = new ProductDAO(session);
		return productDAO.getProductById(value);
	}
	
	

	@Override
	public void afterPropertiesSet() throws Exception {
		List<Product> products = new Vector<>();
		servletContext.setAttribute("products", products); // app scope
	}

	@Override
	public void setServletContext(ServletContext ctxt) {
		this.servletContext = ctxt;
	}

}
