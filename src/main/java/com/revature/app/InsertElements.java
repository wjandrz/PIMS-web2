package com.revature.app;

import java.util.Date;

import com.revature.beans.StateAbbrv;
import com.revature.database.DataLayer;



//public class InsertElements {
//	public static void main(String[] args) {
//		
//		String[] stateArr = new String[] {"Alabama", "Arkansas", "Arizona", "Alaska", "California", "Colorado", 
//				"Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", 
//				"Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", 
//				"Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", 
//				"New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", 
//				"Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", 
//				"Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" };
//		
//		String[] abbrv = new String[]{"AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL",
//				"IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY",
//				"NC","ND", "OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY"};
//		
//		DataLayer dataServiceLayer =  new DataLayer();
//		
//		for(int i=0; i<stateArr.length; i++){
//			int j=i+1;
//			StateAbbrv obj = new StateAbbrv(j, stateArr[i], abbrv[i]);
//			dataServiceLayer.createRecord(obj);
//		}
//		
//		
//	}
//}
