package com.revature.controllers;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;

import com.revature.PIMS.SessionFactoryManager;
import com.revature.beans.POLine;
import com.revature.beans.Product;
import com.revature.database.ClientDAO;
import com.revature.database.ProductDAO;

@Controller
public class InvoiceController implements ServletContextAware, InitializingBean {

	@Autowired
	private ServletContext servletContext;
	Session session = SessionFactoryManager.getInstance().openSession();
	ClientDAO cdao = new ClientDAO(session);
	ProductDAO pdao = new ProductDAO(session);
	
	@RequestMapping(value="createInvoice.do", method=RequestMethod.GET)
	public String setNewInvoice(HttpServletRequest req){
		req.setAttribute("client", cdao.getClients());
		req.setAttribute("prod", pdao.getAllProducts());
		return "invoice";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="fillLine.do", produces="application/json")
	@ResponseBody
	public Product fillLine(@RequestParam(value="value") int value){
		return pdao.getProductById(value);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		List<POLine> poLines = new Vector<>();
		servletContext.setAttribute("poLines", poLines);
	}

	@Override
	public void setServletContext(ServletContext ctxt) {
		this.servletContext = ctxt;
	}

}
