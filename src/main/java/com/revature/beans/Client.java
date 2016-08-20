package com.revature.beans;

import javax.persistence.*;

@Entity
@Table(name="IMS_CLIENT")
public class Client {

		@Id
		@Column(name="IMS_CLIENT_ID", nullable=false)
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="clientSeq")
		@SequenceGenerator(name="clientSeq", sequenceName="CLIENT_SEQ",initialValue=1, allocationSize=1)
	private int clientId;
		@Column(name="CLIENT_NAME", nullable=false)
	private String clientName;
		@Column(name="CLIENT_EMAIL", nullable=false)
	private String clientEmail;
		@Column(name="POINT_OF_CONTACT_NAME", nullable=false)
	private String pointOfContactName;
		@Column(name="CLIENT_PHONE", nullable=false)
	private String clientPhone;
		@Column(name="CLIENT_FAX", nullable=false)
	private String clientFax;
		@OneToOne
		@JoinColumn(name="ADDRESS_ID", unique=true, nullable=false)
	private Address addressId;
		@ManyToOne
		@JoinColumn(name="CLIENT_TYPE_ID", nullable=false)
	private ClientType clientTypeId;
	
	public int getClientId() {
		return clientId;
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
	public Client(int clientId, String clientName, String clientEmail, String pointOfContactName, String clientPhone,
			String clientFax, Address addressId, ClientType clientTypeId) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientEmail = clientEmail;
		this.pointOfContactName = pointOfContactName;
		this.clientPhone = clientPhone;
		this.clientFax = clientFax;
		this.addressId = addressId;
		this.clientTypeId = clientTypeId;
	}
	public Client() {
		super();
	}
}
