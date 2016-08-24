package com.revature.beans;

public class newClient {

		private int clientId;
		private String clientName;
		private String clientEmail;
		private String pointOfContactName;
		private String clientPhone;
		private String clientFax;
		private Address addressId;
		private ClientType clientTypeId;
		
		public int getClientId() {
			return clientId;
		}
		public void setClientEmail(String clientEmail) {
			this.clientEmail = clientEmail;
		}
		public void setClientId(int clientId) {
			this.clientId = clientId;
		}
		public String getClientName() {
			return clientName;
		}
		public void setClientName(String clientName) {
			this.clientName = clientName;
		}
		public String getClientEmail() {
			return clientEmail;
		}
		public void setClientemail(String clientemail) {
			this.clientEmail = clientemail;
		}
		public String getPointOfContactName() {
			return pointOfContactName;
		}
		public void setPointOfContactName(String pointOfContactName) {
			this.pointOfContactName = pointOfContactName;
		}
		public String getClientPhone() {
			return clientPhone;
		}
		public void setClientPhone(String clientPhone) {
			this.clientPhone = clientPhone;
		}
		public String getClientFax() {
			return clientFax;
		}
		public void setClientFax(String clientFax) {
			this.clientFax = clientFax;
		}
		public Address getAddressId() {
			return addressId;
		}
		public void setAddressId(Address addressId) {
			this.addressId = addressId;
		}
		public ClientType getClientTypeId() {
			return clientTypeId;
		}
		public void setClientTypeId(ClientType clientTypeId) {
			this.clientTypeId = clientTypeId;
		}
	private int newaddressId;
	private String newAddress1;
	private String newAddress2;
	private String newCity;
	private int newState;
	private String newZip;
	private int newType;
	
	public int getNewaddressId() {
		return newaddressId;
	}
	public void setNewaddressId(int newaddressId) {
		this.newaddressId = newaddressId;
	}
	public String getNewAddress1() {
		return newAddress1;
	}
	public void setNewAddress1(String newAddress1) {
		this.newAddress1 = newAddress1;
	}
	public String getNewAddress2() {
		return newAddress2;
	}
	public void setNewAddress2(String newAddress2) {
		this.newAddress2 = newAddress2;
	}
	public String getNewCity() {
		return newCity;
	}
	public void setNewCity(String newCity) {
		this.newCity = newCity;
	}
	public int getNewState() {
		return newState;
	}
	public void setNewState(int newState) {
		this.newState = newState;
	}
	public String getNewZip() {
		return newZip;
	}
	public void setNewZip(String newZip) {
		this.newZip = newZip;
	}
	public int getNewType() {
		return newType;
	}
	public void setNewType(int newType) {
		this.newType = newType;
	}
	
	public newClient(String clientName, String clientEmail, String pointOfContactName, String clientPhone,
			String clientFax, String newAddress1, String newAddress2, String newCity, int newState, String newZip,
			int newType) {
		super();
		this.clientName = clientName;
		this.clientEmail = clientEmail;
		this.pointOfContactName = pointOfContactName;
		this.clientPhone = clientPhone;
		this.clientFax = clientFax;
		this.newAddress1 = newAddress1;
		this.newAddress2 = newAddress2;
		this.newCity = newCity;
		this.newState = newState;
		this.newZip = newZip;
		this.newType = newType;
	}
	public newClient(int clientId, String clientName, String clientEmail, String pointOfContactName, String clientPhone,
			String clientFax, Address addressId, ClientType clientTypeId, String newAddress1, String newAddress2,
			String newCity, int newState, String newZip, int newType) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientEmail = clientEmail;
		this.pointOfContactName = pointOfContactName;
		this.clientPhone = clientPhone;
		this.clientFax = clientFax;
		this.addressId = addressId;
		this.clientTypeId = clientTypeId;
		this.newAddress1 = newAddress1;
		this.newAddress2 = newAddress2;
		this.newCity = newCity;
		this.newState = newState;
		this.newZip = newZip;
		this.newType = newType;
	}
	
	public newClient(int clientId, String clientName, String clientEmail, String pointOfContactName, String clientPhone,
			String clientFax, int newaddressId, String newAddress1,	String newAddress2, String newCity, int newState, String newZip, int newType) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientEmail = clientEmail;
		this.pointOfContactName = pointOfContactName;
		this.clientPhone = clientPhone;
		this.clientFax = clientFax;
		this.newaddressId = newaddressId;
		this.newAddress1 = newAddress1;
		this.newAddress2 = newAddress2;
		this.newCity = newCity;
		this.newState = newState;
		this.newZip = newZip;
		this.newType = newType;
	}
	
	public newClient(int clientId, int newaddressId) {
		super();
		this.clientId = clientId;
		this.newaddressId = newaddressId;
	}
	public newClient() {
		super();
	}
}
