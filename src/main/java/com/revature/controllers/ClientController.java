package com.revature.controllers;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.revature.PIMS.SessionFactoryManager;
import com.revature.beans.Client;
import com.revature.beans.StateAbbrv;
import com.revature.database.StateAbbrvDAO;

@Controller
public class ClientController  implements ServletContextAware, InitializingBean {
	
	@Autowired
	private ServletContext servletContext; // instance var
	Session session = SessionFactoryManager.getInstance().openSession();
	
	@RequestMapping(value="createClient.do", method=RequestMethod.GET)
	public String setNewClient(HttpServletRequest req){
		StateAbbrvDAO sadao = new StateAbbrvDAO(session);
		req.setAttribute("newClient", new Client());
		//req.setAttribute("saabb", sadao.getStateAbbrv());
		return "updateclient";
	}
	
	@RequestMapping(value="addClient.do", method=RequestMethod.POST)
	public ModelAndView addClient(
			@Valid Client newClient ,
			HttpServletRequest req, 
			HttpServletResponse resp){
		
		Vector<Client> clients = (Vector<Client>) this.servletContext.getAttribute("clients");
		
		clients.add(newClient);
		this.servletContext.setAttribute("clients", clients); // update peeps
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view"); // view.jsp IRVR
		mv.addObject("success", "Successfully added client!"); // request-scoped variables
		
		return mv;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		List<Client> clients = new Vector<>();
		servletContext.setAttribute("clients", clients); // app scope
		
	}

	@Override
	public void setServletContext(ServletContext ctxt) {
		this.servletContext = ctxt;
	}

}
