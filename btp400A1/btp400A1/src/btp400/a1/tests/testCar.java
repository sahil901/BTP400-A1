package btp400.a1.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import btp400.a1.Car;

/**
 * Assignment 1 BTP400 - testCar
 */

class testCar {
	
	@Test //Test car creation. Car object requires a VIN string for successful creation. 
	void testCarCreate() {
		assertNotNull(new Car("1FDKF37G1TEA59251"));

	}
	
}
