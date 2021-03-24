package btp400.a1;

/**
 * Assignment 1 BTP400 - Material
 */

public class Material {

	private String name;
	private int quantity;
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public Material(String str, int q) {
		this.name = str;
		this.quantity = q;
	
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public String getName() {
		return this.name;
		
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public int getQuantity() {
		return this.quantity;
		
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public void setQuantity(int updatedQuantity) {
		this.quantity = updatedQuantity;
		
	}
	
}