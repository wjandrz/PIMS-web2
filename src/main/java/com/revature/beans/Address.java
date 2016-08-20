package com.revature.beans;

import javax.persistence.*;

@Entity
@Table(name="IMS_ADDRESS")
public class Address {

		@Id
		@Column(name="IMS_ADDRESS_ID", nullable=false)
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="addSeq")
		@SequenceGenerator(name="addSeq", sequenceName="ADDRESS_SEQ",initialValue=1, allocationSize=1)
	private int addressId;
		@Column(name="STREET_ADDRESS_1", nullable=false)
	private String streetAddress1;
		@Column(name="STREET_ADDRESS_2", nullable=false)
	private String streetAddress2;
		@Column(name="ADDRESS_CITY", nullable=false)
	private String addressCity;
		@ManyToOne
		@JoinColumn(name="STATE_ID", nullable=false)
	private StateAbbrv stateId;
		@Column(name="ADDRESS_ZIP", nullable=false)
	private String addressZip;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreetAddress1() {
		return streetAddress1;
	}
	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}
	public String getStreetAddress2() {
		return streetAddress2;
	}
	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public StateAbbrv getStateId() {
		return stateId;
	}
	public void setStateId(StateAbbrv stateId) {
		this.stateId = stateId;
	}
	public String getAddressZip() {
		return addressZip;
	}
	public void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}
	public Address(int addressId, String streetAddress1, String streetAddress2, String addressCity, StateAbbrv stateId,
			String addressZip) {
		super();
		this.addressId = addressId;
		this.streetAddress1 = streetAddress1;
		this.streetAddress2 = streetAddress2;
		this.addressCity = addressCity;
		this.stateId = stateId;
		this.addressZip = addressZip;
	}
	public Address() {
		super();
	}
}
