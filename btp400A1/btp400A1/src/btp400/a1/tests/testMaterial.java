package btp400.a1.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import btp400.a1.Material;

/**
 * Assignment 1 BTP400 - testMaterial
 */

class testMaterial {

	@Test //Test Material creation. Material object requires a String which is the name of the material and an integer which is the quantity. 
	void testMatCreate() {
		assertNotNull(new Material("BOLTS", 500));

	}
	
}
