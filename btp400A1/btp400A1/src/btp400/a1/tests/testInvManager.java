package btp400.a1.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import btp400.a1.InventoryManager;

/**
 * Assignment 1 BTP400 - testInvManager
 */

class testInvManager {

	InventoryManager invManager = new InventoryManager();
	
	@Test //Test InventoryManager creation. On creating of theInventoryManager object, the default inventory stock is initialized . 
	void testInvManagerCreate() {
		assertNotNull(invManager);
		
	}
	
	/**
	 * InventoryManager UpdateInvetory() test. The UpdateInventory(int, int, boolean) requires an Integer which is the index of the updating material, a second
	 * Integer which will be the amount by which the operation(add/subtract) will be performed, and lastly a boolean which indicates what type of operation to perform
	 * if true then it is adding otherwise if false it is subtraction.
	 * 
	 */
	@Test  
	void testInvUpdateAdd() { //Adding 60 to the material at index 4 which is "BRAKES" material in the list.
		assertTrue(invManager.UpdateInventory(4, 60, true));
		
	}
	
	@Test
	void testInvUpdateSubtract() { //Subtracting 50 to the material at index 5 which is "WINDSHIELD" material in the list.
		assertTrue(invManager.UpdateInventory(5, 50, false));
		
	}
	
	/**
	 * Subtracting 50 to the material at index 5 which is "WINDSHIELD" material in the list. By default "WINDSHILED" count is 50,
	 * so by performing above subtraction the count currently is at 0. If we try to subtract again, UpdateInventory() will not
	 * update the inventory and return false to indicate it.
	 */
	@Test
	void testInvUpdateFail() { //
		assertFalse(invManager.UpdateInventory(5, 60, false));

		
	}

}
