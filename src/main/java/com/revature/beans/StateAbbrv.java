package com.revature.beans;

import javax.persistence.*;

@Entity
@Table(name="IMS_STATE_ABBRV")
public class StateAbbrv {

		@Id
		@Column(name="ABBRV_ID", nullable=false)
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="stAbbrvSeq")
		@SequenceGenerator(name="stAbbrvSeq", sequenceName="STATE_ABBRV_SEQ",initialValue=1, allocationSize=1)
	private int abbrvId;
	
		@Column(name="STATE_NAME", nullable=false)
	private String stateName;
		
		@Column(name="STATE_ABBRV", nullable=false)
	private String stateAbbrv;
	
	public int getAbbrvId() {
		return abbrvId;
	}
	public void setAbbrvId(int abbrvId) {
		this.abbrvId = abbrvId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getStateAbbrv() {
		return stateAbbrv;
	}
	public void setStateAbbrv(String stateAbbrv) {
		this.stateAbbrv = stateAbbrv;
	}
	public StateAbbrv(int abbrvId, String stateName, String stateAbbrv) {
		super();
		this.abbrvId = abbrvId;
		this.stateName = stateName;
		this.stateAbbrv = stateAbbrv;
	}
	public StateAbbrv() {
		super();
	}
}
