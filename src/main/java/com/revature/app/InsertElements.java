package com.revature.app;

import com.revature.beans.ClientType;
import com.revature.beans.ProductCategory;
import com.revature.database.DataLayer;



public class InsertElements {
	public static void main(String[] args) {
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
		System.out.println("Before setting dl");
		DataLayer dataServiceLayer =  new DataLayer();
		
		String[] prodCat = new String[]{"Ants","Bed Bugs","Fleas","Cockroaches","Spiders","Bettles",
				"Crickets","Earwigs","Flies","Hornets","Mosquitos","Moths","Stink Bugs","Ticks","Wasps","Yellow Jackets",
				"Spray","Bait","Gel","Fogger","Barrier","Lawn Seed"};
		
//		ClientType obj = new ClientType(0, "Supplier");
//		
		for(int i=0; i<prodCat.length; i++){
			System.out.println("In loop");
			int j=i+1;
			ProductCategory obj = new ProductCategory(j, prodCat[i]);
			dataServiceLayer.createRecord(obj);
		}
		
		
	}
}
