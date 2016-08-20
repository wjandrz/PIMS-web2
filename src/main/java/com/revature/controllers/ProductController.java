package com.revature.controllers;

import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.validation.Valid;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.*;
import org.springframework.web.servlet.ModelAndView;

import com.revature.beans.Product;

@Controller
public class ProductController implements ServletContextAware, InitializingBean {
	
	@Autowired
	private ServletContext servletContext; // instance var
	
	@RequestMapping(value="create.do", method=RequestMethod.GET)
	public String setNewProd(HttpServletRequest req){
		req.setAttribute("newProd", new Product());
		return "updateproduct";
	}
	
	@RequestMapping(value="addProduct.do", method=RequestMethod.POST)
	public ModelAndView addProduct(
			@Valid Product newProduct , 
			HttpServletRequest req, 
			HttpServletResponse resp){
		
		Vector<Product> products = (Vector<Product>) this.servletContext.getAttribute("products");
		
		products.add(newProduct);
		this.servletContext.setAttribute("products", products); // update peeps
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view"); // view.jsp IRVR
		mv.addObject("success", "Successfully added product!"); // request-scoped variables
		
		return mv;
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
