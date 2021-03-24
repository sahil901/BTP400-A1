package btp400.a1.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import btp400.a1.IntermediateStation;
import btp400.a1.Task;

/**
 * Assignment 1 BTP400 - testMidStations
 */

class testMidStations {

	/**
	 * IntermediateStation requires a Task object, an Integer which specifies the station's ID, and another Integer which specifies the ID
	 * associated with the job that is passing through the station.
	 */
	@Test
	void testIntermediateStation() {
		Task task = new Task("AXELS");

		assertNotNull(new IntermediateStation(task, 1, 1));
	
	}

}
