package btp400.a1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Assignment 1 BTP400 - IntermediateStation  
 */

public class IntermediateStation implements Serializable {
	
	private final int midStationID;
	private int associatedJobID;
	private boolean isOptional;
	private boolean isOffline = true;	
	private Task currTask;
	private boolean doneTask;
	
	public IntermediateStation(Task doingTask, int id, int jobId) {
		this.midStationID = id;
		this.associatedJobID = jobId;
		this.currTask = doingTask;
		this.doneTask = false;
		this.isOffline = false;
		
		if(doingTask.GetType() == "Optional") {
			this.isOptional = true;
			
		}
		else { 
			this.isOptional = false;
			
		}
		 
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	/**
	 * Performs the passed task for the intermediate station, then logs the task in 
	 * an output file "JobLog.txt"
	 */
	public void doTask() {
		String outStr = "";
		String formattedDate;
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		if(currTask == null) {
			System.out.println("No task available at this station!");
			
		}
		else {		
			if(this.currTask.GetIsComplete()) {
				outStr = "\nTASK: [" + this.currTask.GetName() + "] COMPLETED"; 
				this.doneTask = true;
				
			}
			else {
				outStr = "\nTASK: [" + this.currTask.GetName() + "] FAILED"; 
				this.doneTask = false;
				
			}  
			
			File jobLog = new File("JobLog.txt");
			FileWriter fr = null;
			
			try {
				 
				LocalDateTime date = LocalDateTime.now();
				formattedDate = date.format(dateFormat);
				
				fr = new FileWriter(jobLog, true); 
				fr.write(outStr);		
				
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
		 
		this.isOffline = true;
		
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	//Use this to turn station on or off, FALSE is on and TRUE is off  
	public void setState(boolean state) {
		this.isOffline = state;
		
	} 
	 
	//_____________________________________________________________________________________________________________________________________________________
	 
	public String getStation() {
		return this.currTask.GetName();
			
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public String getType() {
		if(this.isOptional) {
			return "Optional";
			
		}
		else {
			return "Mandatory";
		}
	}
	
	public boolean isTaskDone() {
		return this.doneTask;
		
	}
	
	public int getJobId() {
		return this.associatedJobID;
		
	}
	
}
