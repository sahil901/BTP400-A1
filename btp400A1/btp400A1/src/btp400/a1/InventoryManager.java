package btp400.a1;

/**
 * Assignment 1 BTP400 - InventoryManager
 */

import java.util.ArrayList;

public class InventoryManager {
	
	protected ArrayList<Material> fullInventory = new ArrayList<Material>();
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public InventoryManager() {

		/**Initial each Material object and added to the ArrayList which will make the inventory for the system
		 * TWEAK THE NUMBERS HERE TO TEST FAILED AND COMPLETED TASKS  
		 */
		fullInventory.add(new Material("BOLT", 1000));
		fullInventory.add(new Material("SCREWS", 1000));
		fullInventory.add(new Material("AXELS", 200));
		fullInventory.add(new Material("DOORS", 200)); 
		fullInventory.add(new Material("BRAKES", 50));
		fullInventory.add(new Material("WINDSHIELD", 50));
		fullInventory.add(new Material("GEARBOX", 50)); 
		fullInventory.add(new Material("SENSORS", 200));
		fullInventory.add(new Material("PAINT", 50));
		fullInventory.add(new Material("TRANSMISSION", 50)); 
		
	} 
	  
	//_____________________________________________________________________________________________________________________________________________________
	
	/**
	 * UpdateInventory receives the index of Material object to update, the number which will be used for 
	 * the operation(+/-), and boolean which specifies what type of operation it is. 
	 * 
	 * If isAdding is true then it is adding n to the current quantity, if false then it is subtracting
	 * n from current quantity.
	 */
	public boolean UpdateInventory(int indexOfMat, int n, boolean isAdding) {
		
		//Get current quantity of specified Material
		int currQ = fullInventory.get(indexOfMat).getQuantity();
		
		//Check if quantity is at zero so that it can't be reduced further
		if(fullInventory.get(indexOfMat).getQuantity() <= 0 && !isAdding) {
			fullInventory.get(indexOfMat).setQuantity(0);
			return false;
			
		}
		else if(!isAdding) {	
			if((currQ-n) < 0) {
				return false;
				
			}
			else {
				fullInventory.get(indexOfMat).setQuantity(currQ - n);
				return true;
			
			}
		}
		else{
			fullInventory.get(indexOfMat).setQuantity(currQ + n);
			return true;
			
		}	
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public ArrayList<Material> getAllInventory() {
		return fullInventory;
		
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	/**
	 * Returns the name and the count of the Material object in inventory
	 * based on the query
	 * 
	 */
	public String getInvCountOf(String str) {
		String currCount = "";
		
		if(str.toUpperCase().equals("BOLT")){
			currCount = "** Material: " + fullInventory.get(0).getName() + ", Count: " + Integer.toString(fullInventory.get(0).getQuantity());
			
		}
		else if(str.toUpperCase().equals("SCREWS")){
			currCount = "** Material: " + fullInventory.get(1).getName() + ", Count: " + Integer.toString(fullInventory.get(1).getQuantity());
			
		}
		else if(str.toUpperCase().equals("AXELS")){
			currCount = "** Material: " + fullInventory.get(2).getName() + ", Count: " + Integer.toString(fullInventory.get(2).getQuantity());
			
		}
		else if(str.toUpperCase().equals("DOORS")){
			currCount = "** Material: " + fullInventory.get(3).getName() + ", Count: " + Integer.toString(fullInventory.get(3).getQuantity());
			
		}
		else if(str.toUpperCase().equals("BRAKES")){
			currCount = "** Material: " + fullInventory.get(4).getName() + ", Count: " + Integer.toString(fullInventory.get(4).getQuantity());
			
		}
		else if(str.toUpperCase().equals("WINDSHIELD")){
			currCount = "** Material: " + fullInventory.get(5).getName() + ", Count: " + Integer.toString(fullInventory.get(5).getQuantity());
			
		}
		else if(str.toUpperCase().equals("GEARBOX")){
			currCount = "** Material: " + fullInventory.get(6).getName() + ", Count: " + Integer.toString(fullInventory.get(6).getQuantity());
			
		}
		else if(str.toUpperCase().equals("SENSORS")){
			currCount = "** Material: " + fullInventory.get(7).getName() + ", Count: " + Integer.toString(fullInventory.get(7).getQuantity());
			
		}
		else if(str.toUpperCase().equals("PAINT")){
			currCount = "** Material: " + fullInventory.get(8).getName() + ", Count: " + Integer.toString(fullInventory.get(8).getQuantity());
			
		}
		else if(str.toUpperCase().equals("TRANSMISSION")){
			currCount = "** Material: " + fullInventory.get(9).getName() + ", Count: " + Integer.toString(fullInventory.get(9).getQuantity());
			
		}
		else {
			System.out.print("** Invalid query");
			
		}
		
		return currCount;
		
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	/**
	 * Returns the index of Material in the list
	 * based on the query
	 * 
	 */
	public int getMatIndexOf(String str) {

		if(str.toUpperCase().equals("BOLT")){
			return 0;
			
		}
		else if(str.toUpperCase().equals("SCREWS")){
			return 1;
			
		}
		else if(str.toUpperCase().equals("AXELS")){
			return 2;
			
		}
		else if(str.toUpperCase().equals("DOORS")){
			return 3;
			
		}
		else if(str.toUpperCase().equals("BRAKES")){
			return 4;
			
		}
		else if(str.toUpperCase().equals("WINDSHIELD")){
			return 5;
			
		}
		else if(str.toUpperCase().equals("GEARBOX")){
			return 6;
			
		}
		else if(str.toUpperCase().equals("SENSORS")){
			return 7;
			
		}
		else if(str.toUpperCase().equals("PAINT")){
			return 8;
			
		}
		else if(str.toUpperCase().equals("TRANSMISSION")){
			return 9;
			
		}
		else {
			System.out.print("** Invalid query");
			
		}
		
		return -1;
		
	}
	
}
