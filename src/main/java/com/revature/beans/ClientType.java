package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="IMS_CLIENT_TYPE")
public class ClientType {

		@Id
		@Column(name="CLIENT_TYPE_ID", nullable=false)
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="clientTypeSeq")
		@SequenceGenerator(name="clientTypeSeq", sequenceName="CLIENT_TYPE_SEQ",initialValue=1, allocationSize=1)
	private int clientTypeId;
	
		@Column(name="CLIENT_TYPE", nullable=false)
	private String clientType;
	
	public int getClientTypeId() {
		return clientTypeId;
	}
	public void setClientTypeId(int clientTypeId) {
		this.clientTypeId = clientTypeId;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public ClientType(int clientTypeId, String clientType) {
		super();
		this.clientTypeId = clientTypeId;
		this.clientType = clientType;
	}
	public ClientType() {
		super();
	}
}
