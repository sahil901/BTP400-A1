package btp400.a1.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import btp400.a1.Job;

/**
 * Assignment 1 BTP400 - testJob
 */

class testJob {
	String[] allTasks = {"Job 1, Axels, Brakes, Gear Box, Transmission, Doors, Paint"};
	
	@Test //Test Job creation. Job object requires a String array which holds all the task for the specific job. 
	void testJobCreate() {
		assertNotNull(new Job(allTasks));

	}
	
	Job job = new Job(allTasks);
	
	/**
	 * Test Job validation passed scenario. The ValidateTask() takes a string and then checks it against all the required tasks for assembly.
	 * If the passed string matches with one of the required tasks then it returns true.
	 */
	@Test
	void testJobValidationPass() {
		assertTrue(job.ValidateTask("Brakes"));

	}
	
	/**
	 * Test Job validation failed scenario. The ValidateTask() takes a string and then checks it against all the required tasks for assembly.
	 * If the passed string does not matches with any of the required tasks then it returns false.
	 */
	@Test
	void testJobValidationFail() {
		assertFalse(job.ValidateTask(""));

	}
	
}
