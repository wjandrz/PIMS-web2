package com.revature.controllers;

import java.sql.Date;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;

import com.revature.PIMS.SessionFactoryManager;
import com.revature.beans.Client;
import com.revature.beans.NewLine;
import com.revature.beans.NewOrder;
import com.revature.beans.POCompKey;
import com.revature.beans.POLine;
import com.revature.beans.Product;
import com.revature.beans.PurchaseOrder;
import com.revature.database.ClientDAO;
import com.revature.database.DataLayer;
import com.revature.database.ProductDAO;
import com.revature.database.PurchaseOrderDAO;

@Controller
public class InvoiceController implements ServletContextAware, InitializingBean {

	@Autowired
	private ServletContext servletContext;
	Session session = SessionFactoryManager.getInstance().openSession();
	ClientDAO cdao = new ClientDAO(session);
	ProductDAO pdao = new ProductDAO(session);
	PurchaseOrderDAO podao = new PurchaseOrderDAO(session); 
	
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
	@RequestMapping(method=RequestMethod.GET, value="getclientType.do", produces="application/json")
	@ResponseBody
	public Client fillSuppliers(@RequestParam(value="value") int value){
		return cdao.getClientsbyIdSupply(value);
	}
	@RequestMapping(value="makeInvoice.do", method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public void makeInvoice(HttpServletRequest req, HttpServletResponse resp, @RequestBody NewOrder order){
		DataLayer dataServiceLayer =  new DataLayer();
		java.util.Date now = new java.util.Date();
		Date time = new Date(now.getTime());
		Client client = cdao.getClientsbyId(order.getClientId());
		PurchaseOrder obj = new PurchaseOrder(order.getSubtotal(), time, order.getTaxAmount(), order.getPoTotal(), client);
		dataServiceLayer.createRecord(obj);
	}
	
	@RequestMapping(value="addLine.do", method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public void addLine(HttpServletRequest req, HttpServletResponse resp, @RequestBody NewLine line){
		DataLayer dataServiceLayer =  new DataLayer();
		POCompKey cpkey = new POCompKey(podao.getLastPurchaseOrder(), line.getLineNumber());
		POLine obj = new POLine(cpkey, line.getUnitPrice(), line.getQty(), pdao.getProductById(line.getProductUpc()));
		dataServiceLayer.createRecord(obj);
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
