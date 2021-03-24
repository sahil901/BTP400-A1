package btp400.a1.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import btp400.a1.FinalStation;

/**
 * Assignment 1 BTP400 - testFinalStation
 */

class testFinalStation {

	@Test
	void test() { //Test FinalStation creation. On creation, the FinalStation simply goes online through a boolean flag.
		assertNotNull(new FinalStation());
		
	}

}
