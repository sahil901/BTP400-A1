package btp400.a1.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import btp400.a1.InitialStation;

/**
 * Assignment 1 BTP400 - testInitialStation
 */

class testInitialStation {
	
	/**
	 * On creation, InitialStation reads from a text file in root directory which hold all the objects that needs to pass through the assembly system.
	 * InitialStation constructor performs validation on each job and the tasks associated with the job. Only the valid jobs are stored
	 * for processing in later stations.
	 */
	@Test 
	void testInitialStaitionCreate() {
		assertNotNull(new InitialStation());
		
	}
	
}

