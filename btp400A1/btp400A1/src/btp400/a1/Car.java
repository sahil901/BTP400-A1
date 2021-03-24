package btp400.a1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Assignment 1 BTP400 - Car   
 */

public class Car {
	private String carVIN;
	 
	public Car(String VIN) {
		this.carVIN = VIN; 
		
		File carLog = new File("CarLog.txt");
		FileWriter fr = null;
		 
		try {
			fr = new FileWriter(carLog, true);
			fr.write("\n____________________________________");
			fr.write("\nCAR VIN: " + this.carVIN);

		} catch (IOException e) {
			e.printStackTrace();
		}finally { 
			try {
				fr.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public String getCarVIN() {
		return this.carVIN;
		
	}

}
