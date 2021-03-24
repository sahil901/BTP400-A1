package btp400.a1;

/**
 * Assignment 1 BTP400 - InitialStation
 */

import java.util.ArrayList;	
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class InitialStation implements Serializable {
	/**
	 * Station state
	 */
	private final int stationID;
	private boolean isOptional;
	private boolean isOffline = true; 
	
	private ArrayList<Job> jobs = new ArrayList<Job>(); //Holds all jobs passed in by file
	protected ArrayList<Job> validJobs = new ArrayList<Job>(); //Holds only valid jobs
	
	/**
	 * File management
	 */
	String fileData;     
	String[] splitLine;
	int jobsCount = 0;
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public InitialStation() {   
		stationID = 0;
		
		try {
			Scanner fileScan = new Scanner(new File("jobs.txt"));
			  
			while(fileScan.hasNextLine()) {
				
				fileData = fileScan.nextLine();
				
				/** 
				 * Building task list to add to create Job objects
				 */
				splitLine = fileData.split(" \n");
				
				/**
				 * Creating the Job object using the line in text file which   
				 * specifies the job id and the tasks
				 */
				if(fileData.lines().count() != 0) {
					jobs.add(new Job(splitLine));
					
					if(jobs.get(jobsCount).getIsValid()) {
						validJobs.add(jobs.get(jobsCount));
						
					} 
					
					jobsCount++;
				}
				
				System.out.println("\nFinished job validation for job ID: [" + jobs.get(jobsCount - 1).jobID +"]");
				System.out.println("_______________________________________\n");
				Thread.sleep(500); //Just seeing how the delay works, [remember to add it in station management]
			}		
			
			System.out.println("\n[VALIDATION FINISHED. NUMBER OF VALID JOBS: " + validJobs.size() + "]");
			System.out.println("\n[ -- STARTING SYSTEM WORKFLOW -- ]\n");
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}			
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	/**
	 * Once the jobs and tasks have been initialized and validated, the materials for each tasks can be 
	 * reserved for the task. The inventory is initialized and the deductions on the materials are performed based
	 * on the tasks in the valid jobs. UpdateInventory() takes the index of the material, the number which will be used
	 * for the operation (i.e. if n = 5 the 5 will be used for addition or subtraction in the inventory), and lastly takes
	 * a boolean which tells if the operation to be performed is addition or subtraction (if FALSE then it is a subtraction, if TRUE
	 * then it is an addition)
	 * 
	 */
	public InventoryManager initializeInv() {
		InventoryManager invM = new InventoryManager();
		
		for(int i = 0; i < this.validJobs.size(); i++) {
			ArrayList<Task> checkTasks = this.validJobs.get(i).getTasks();
			for(int j = 0; j < checkTasks.size(); j++) {
				if(checkTasks.get(j).GetName().equals("Axels")) {
					boolean check1 = invM.UpdateInventory(0, 10, false); //BOLTS
					boolean check2 = invM.UpdateInventory(1, 10, false); // SCREWS
					boolean check3 = invM.UpdateInventory(2, 2, false); //AXELS
					
					if(check1 && check2 && check3) {
						this.validJobs.get(i).getTasks().get(j).setIsComplete();
						
					}
					else {
						break;
				
					}				
				}
				else if(checkTasks.get(j).GetName().equals("Brakes")) {
					boolean check1 = invM.UpdateInventory(0, 10, false); //BOLTS
					boolean check2 = invM.UpdateInventory(1, 10, false); // SCREWS
					boolean check3 = invM.UpdateInventory(4, 1, false); //BRAKES
					
					if(check1 && check2 && check3) {
						this.validJobs.get(i).getTasks().get(j).setIsComplete();
						
					}
					else {
						break;
				
					}			
				}
				else if(checkTasks.get(j).GetName().equals("Gear Box")) {
					boolean check1 = invM.UpdateInventory(0, 10, false); //BOLTS
					boolean check2 = invM.UpdateInventory(1, 10, false); // SCREWS
					boolean check3 = invM.UpdateInventory(6, 1, false); //GEAR BOX
					
					if(check1 && check2 && check3) {
						this.validJobs.get(i).getTasks().get(j).setIsComplete();
						
					}
					else {
						break;
				
					}				
				}
				else if(checkTasks.get(j).GetName().equals("Transmission")) {
					boolean check1 = invM.UpdateInventory(0, 20, false); //BOLTS
					boolean check2 = invM.UpdateInventory(1, 20, false); // SCREWS
					boolean check3 = invM.UpdateInventory(9, 1, false); //TRANSMISSION
					
					if(check1 && check2 && check3) {
						this.validJobs.get(i).getTasks().get(j).setIsComplete();
						
					}
					else {
						break;
				
					}		
				}
				else if(checkTasks.get(j).GetName().equals("Doors")) {
					boolean check1 = invM.UpdateInventory(0, 10, false); //BOLTS
					boolean check2 = invM.UpdateInventory(1, 10, false); // SCREWS
					boolean check3 = invM.UpdateInventory(3, 4, false); //DOORS
					
					if(check1 && check2 && check3) {
						this.validJobs.get(i).getTasks().get(j).setIsComplete();
						
					}
					else {
						break;
				
					}		
				}
				else if(checkTasks.get(j).GetName().equals("Paint")) {
					boolean check1 = invM.UpdateInventory(8, 2, false); //PAINT
					
					if(check1) {
						this.validJobs.get(i).getTasks().get(j).setIsComplete();
						
					}
					else {
						break;
				
					}	
				}
				else if(checkTasks.get(j).GetName().equals("Collision Sensors")) {
					boolean check1 = invM.UpdateInventory(0, 20, false); //BOLTS
					boolean check2 = invM.UpdateInventory(1, 20, false); // SCREWS
					boolean check3 = invM.UpdateInventory(7, 1, false); //SENSORS
					
					if(check1 && check2 && check3) {
						this.validJobs.get(i).getTasks().get(j).setIsComplete();
						
					}
					else {
						break;
				
					}	
				}
				else if(checkTasks.get(j).GetName().equals("Windshield")) {
					boolean check1 = invM.UpdateInventory(5, 1, false); //WINDSHIELD
					
					if(check1) {
						this.validJobs.get(i).getTasks().get(j).setIsComplete();
						
					}
					else {
						break;
				
					}
				}
			}
			
		}
		
		return invM;
		
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public ArrayList<Job> getJobs(){
		return this.validJobs;
		
	}
	
	public void setState(boolean state) {
		this.isOffline = state;
		
	}
	
}

