package btp400.a1;

import java.io.Serializable;

/**
 * Assignment 1 BTP400 - Task  
 */

public class Task implements Serializable{
	private String taskType;
	private String taskName;
	private boolean isComplete;
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public Task(String name) {
		this.taskName = name; 
		this.isComplete = false;
		
		if(name.equals("Collision Sensors")) {
			this.taskType = "Optional";
		} 
		else {
			this.taskType = "Mandatory"; 
		} 
		
	} 
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public String GetName() {
		return taskName;
		
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public String GetType() {	
		return taskType;
		
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public boolean GetIsComplete() {		
		return this.isComplete;
		
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public void setIsComplete() {		
		this.isComplete = true;
		
	}

}
