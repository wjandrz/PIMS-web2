package com.revature.controllers;

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
import com.revature.beans.Address;
import com.revature.beans.Client;
import com.revature.beans.ClientType;
import com.revature.beans.StateAbbrv;
import com.revature.beans.newClient;
import com.revature.database.AddressDAO;
import com.revature.database.ClientDAO;
import com.revature.database.ClientTypeDAO;
import com.revature.database.DataLayer;
import com.revature.database.StateAbbrvDAO;

@Controller
public class ClientController implements ServletContextAware, InitializingBean {
	
	@Autowired
	private ServletContext servletContext; // instance var
	Session session = SessionFactoryManager.getInstance().openSession();
	StateAbbrvDAO sadao = new StateAbbrvDAO(session);
	ClientDAO cdao = new ClientDAO(session);
	ClientTypeDAO ctdao = new ClientTypeDAO(session);
	AddressDAO adao = new AddressDAO(session);
	
	@RequestMapping(value="createClient.do", method=RequestMethod.GET)
	public String setNewClient(HttpServletRequest req){
		//ApplicationContext atxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Client client = (Client) atxt.getBean("waffles");
		//req.setAttribute("newClient", client);
		req.setAttribute("saabb", sadao.getStateAbbrv());
		req.setAttribute("clientt", ctdao.getClientType());
		return "updateclient";
	}
	
	@RequestMapping(value="addClient.do", method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public void addClient(HttpServletRequest req, HttpServletResponse resp, @RequestBody newClient client){

		DataLayer dataServiceLayer =  new DataLayer();
		int stateId = client.getNewState();
		int clienttypeId = client.getNewType();
		StateAbbrv sa = new StateAbbrv(stateId, sadao.getStateAbbrvbyId(stateId).getStateName(), sadao.getStateAbbrvbyId(stateId).getStateAbbrv());
		Address address = new Address(client.getNewAddress1(), client.getNewAddress2(), client.getNewCity(), sa, client.getNewZip());
		dataServiceLayer.createRecord(address);
		Address newAddress = adao.getAddress(client.getNewAddress1());
		ClientType clientType = new ClientType(clienttypeId, ctdao.getClientTypebyId(clienttypeId).getClientType());
		Client obj = new Client(client.getClientName(), client.getClientEmail(), client.getPointOfContactName(), 
				client.getClientPhone(), client.getClientFax(), newAddress, clientType);
		dataServiceLayer.createRecord(obj);
	}
	@RequestMapping(value="removeClient.do", method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public void removeClient(HttpServletRequest req, HttpServletResponse resp, @RequestBody newClient client){
		cdao.delete(client.getClientId());
		adao.delete(client.getNewaddressId());
	}
	@RequestMapping(value="updateClient.do", method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public void updateClient(HttpServletRequest req, HttpServletResponse resp, @RequestBody newClient client){

		DataLayer dataServiceLayer =  new DataLayer();
		int stateId = client.getNewState();
		int clienttypeId = client.getNewType();
		StateAbbrv sa = new StateAbbrv(stateId, sadao.getStateAbbrvbyId(stateId).getStateName(), sadao.getStateAbbrvbyId(stateId).getStateAbbrv());
		Address address = new Address(client.getNewaddressId(), client.getNewAddress1(), client.getNewAddress2(), client.getNewCity(), sa, client.getNewZip());
		dataServiceLayer.createRecord(address);
		Address newAddress = adao.getAddress(client.getNewAddress1());
		ClientType clientType = new ClientType(clienttypeId, ctdao.getClientTypebyId(clienttypeId).getClientType());
		Client obj = new Client(client.getClientId(), client.getClientName(), client.getClientEmail(), client.getPointOfContactName(), 
				client.getClientPhone(), client.getClientFax(), newAddress, clientType);
		dataServiceLayer.createRecord(obj);
	}
	@RequestMapping(method=RequestMethod.GET, value="showSupplier.do", produces="application/json")
	@ResponseBody
	public List<Client> showSuppliers(){
		return cdao.getClientsbySupply();
	}
	@RequestMapping(method=RequestMethod.GET, value="showRetailer.do", produces="application/json")
	@ResponseBody
	public List<Client> showRetailers(){
		return cdao.getClientsbyRetail();
	}
	@RequestMapping(method=RequestMethod.GET, value="fillSupplier.do", produces="application/json")
	@ResponseBody
	public Client fillSuppliers(@RequestParam(value="value") int value){
		return cdao.getClientsbyIdSupply(value);
	}
	@RequestMapping(method=RequestMethod.GET, value="fillRetailer.do", produces="application/json")
	@ResponseBody
	public Client fillRetailers(@RequestParam(value="value") int value){
		return cdao.getClientsbyIdRetail(value);
	}
	/*public ModelAndView addClient(
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
	}*/

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
