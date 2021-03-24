package btp400.a1;

import java.io.Serializable;

/**
 * Assignment 1 BTP400 - Job  
 */

import java.util.ArrayList;

public class Job implements Serializable{
	private boolean isComplete;
	private boolean isValidJob;
	private boolean hasOptional;
	
	private ArrayList<Task> tasks = new ArrayList<Task>(); 
	int jobID;
	
	String [] splitStr;
	
	//_____________________________________________________________________________________________________________________________________________________
	
	/**
	 * Takes a String[] which is the line from text that holds job id and tasks name
	 */
	public Job(String[] jobLine) {
		this.hasOptional = false; 
		this.isValidJob = true;
		
		String tempStr; 
		boolean duplicates = false; 
		
		tempStr = jobLine[0];
		splitStr = tempStr.split(", ");
		
		/**
		 * Get the job ID which will be at the beginning of the String[] index 0
		 * the substring returns the number only which is at the end 
		 */
		jobID = Integer.parseInt(splitStr[0].substring(splitStr[0].length() -1));
		
		//Checking for duplicate tasks
		for(int k = 0; k < splitStr.length - 1; k++) {
			for(int j = 1;j < k; j++ ) {
				if(splitStr[k].equals(splitStr[j])) {
					duplicates = true;
				 
				}				
			}
		}
		
		/**
		 * A valid list of tasks will have either 6 or 7 tasks depending on optional task (If we're following given use case)
		 * length-1 is to account for Job id
		 */
		if(splitStr.length - 1 > 5 && splitStr.length - 1 < 8) {
			
			if(duplicates == true) {
				System.out.println("\nThe job with job ID: [" + jobID + "] is invalid! REASON: HAS DUPLICATE TASKS"  );
				this.isValidJob = false;
			}
			else {
				for(int i = 1; i < splitStr.length; i++) {
				
					if(ValidateTask(splitStr[i])) {
						System.out.println("Successfully validated and added task: " + tasks.get(i -1 ).GetName());
					}
					else {
						System.out.println("\nThe job with job ID: [" + jobID + "] is invalid!"  );
						this.isValidJob = false;
					}
				}	
			}
		}
		else {
			System.out.println("\nThe job with job ID: [" + jobID + "] is invalid! REASON: MISSING MANDATORY TASKS"  );
			this.isValidJob = false;
			
		}		
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	/**
	 * ValidateTask gets a String which is the name of the task
	 * the String is tested using equals() to see if it is a mandatory task or optional
	 * if the name doesn't match then invalid task and as a result invalid job
	 * 
	 */
	public boolean ValidateTask(String taskStr) {
		boolean isValidTask = false;
		String[] allTasks = {"Axels", "Brakes", "Gear Box", "Transmission", "Doors", "Paint"};
		
		
		//Checking the optional feature
		if(taskStr.equals("Collision Sensors")) {
			this.hasOptional = true;
			isValidTask = true;
			this.tasks.add(new Task(taskStr));
		}
		//Not optional then check against mandatory tasks
		else {
			for(int i = 0; i < allTasks.length; i++) {
				if(taskStr.equals(allTasks[i])) {
					isValidTask = true;
					this.tasks.add(new Task(taskStr));
				}	
			}
		}
	
		return isValidTask;
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public ArrayList<Task> getTasks() {
		return this.tasks;
		
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public boolean getIsValid() {
		return isValidJob;
		
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public int getJobID() {
		return jobID;
		
	}
	
	//_____________________________________________________________________________________________________________________________________________________
	
	public boolean isComplete() {
		return isComplete;
		
	}

}