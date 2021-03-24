package btp400.a1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Assignment 1 BTP400 - FinalStation
 */
 
public class FinalStation {
	private ArrayList<String> vinArr = new ArrayList<String>();
	private ArrayList<Car> cars = new ArrayList<Car>();
	private Car car;
	private boolean isOffline = true;
	
	public FinalStation() {
		isOffline = false;   
	
	} 
	
	
	//_____________________________________________________________________________________________________________________________________________________
	
	/**
	 * Generates and picks random VIN which can be used to engrave VIN to a car upon completion
	 * 
	 */
	public String randomVIN() { 
		Random pick = new Random();
		int index = 0;
		
		vinArr.add("JH4KA96572C014538");
		vinArr.add("5GAKVBKD5FJ258850");
		vinArr.add("1YVGE22D5V5681787");
		vinArr.add("WBAPK5C52BA691684");
		vinArr.add("1FDKF37G1TEA59251");
		vinArr.add("3GNEC13T03G164395");
		vinArr.add("WBAET37483NJ82932");
		vinArr.add("3GCPKSE37BG169681");
		vinArr.add("1LNHL9DR5BG614670");
		vinArr.add("3VWLL7AJ5EM230381");
		vinArr.add("3N1AB6AP2BL632035");
		vinArr.add("1FMPU18L9YLA43684");
		vinArr.add("JT3GN86R8T0041361"); 
		vinArr.add("SALME11403A121144");
		
		index = pick.nextInt(vinArr.size());
		
		return vinArr.get(index);
		
	} 
	
	/**
	 * The function receives the list of intermediate stations that worked on the assembly. The stations name also identifies the task
	 * that was done by that station. So using getStation() accessor method of each IntermediateStations, we can write the tasks done
	 * for assembly in the file
	 * 
	 */
	public void doVINAndLog(ArrayList<IntermediateStation> doneList) {
		this.cars.add(new Car(randomVIN()));
		
		File carLog = new File("CarLog.txt");
		FileWriter fr = null;
		 
		try {
			fr = new FileWriter(carLog, true);			
			
			for(int i = 0; i < doneList.size(); i++) {
				fr.write("\nINSTALLED: " + doneList.get(i).getStation());
				
			} 

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
	
	//Use this to turn station on or off, FALSE is on and TRUE is off  
	public void setOffline(boolean state) {
		this.isOffline = state;
		
	}
	
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public boolean getState() {
		return isOffline;
		
	}
	
	public String getCarVIN() {
		return this.car.getCarVIN();
		
	}
	
}
