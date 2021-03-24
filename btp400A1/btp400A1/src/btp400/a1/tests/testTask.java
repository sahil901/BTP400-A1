package btp400.a1.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import btp400.a1.Task;

/**
 * Assignment 1 BTP400 - testTask
 */

class testTask {

	@Test //Test Task creation. Task object requires a string which describes the name of the task for successful creation. 
	void testTaskCreate() {
		assertNotNull(new Task("BRAKES"));

	}

}
