package btp400.a1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Assignment 1 BTP400 - Main
 */ 

import java.util.ArrayList;
 
/**
 * Assignment 1 BTP400 - Main
 */

public class Main { 
 
	/**
	 * Entry point for the program. The main starts the workflow and initializes the inventory based on
	 * the tasks in each jobs.
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		ArrayList<Job> currValidJobList = new ArrayList<Job>();
		ArrayList<IntermediateStation> imStations = new ArrayList<IntermediateStation>();
		
		InitialStation station = new InitialStation();
		currValidJobList = station.getJobs();
		
		InventoryManager invManager = new InventoryManager();
		writeInvLog(invManager);
		
		invManager = station.initializeInv();
		writeInvLog(invManager);
		
		startSystem(currValidJobList, imStations);
				
		station.setState(true);
		
		for(int i = 0; i < imStations.size(); i++) {
			imStations.get(i).setState(true);
			
		}

		System.out.println("\nALL VALID JOBS COMPLETE, SYSTEM IS SHUTTING DOWN [To check jobs status view JobLog.txt]");
	
	}
	 
	//_____________________________________________________________________________________________________________________________________________________
	
	/**
	 * Takes the Inventory Manager as argument and writes to a text file "InvLog". The entire inventory count is logged
	 * in the file which includes the material, the quantity and the date it was logged.
	 * 
	 */
	public static void writeInvLog(InventoryManager inv) {
		String formattedDateInv;
		DateTimeFormatter dateFormatInv = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime date = LocalDateTime.now();
		formattedDateInv = date.format(dateFormatInv);
		
		ArrayList<Material> matList = inv.getAllInventory(); 
		
		File invLog = new File("InvLog.txt");
		FileWriter fr = null;
		
		try {
			fr = new FileWriter(invLog, true);
			fr.write("\n_________________________________________________________________");
			fr.write("\n\nDATE: " + formattedDateInv);
		
			for(int i = 0; i < matList.size(); i++) {		
				fr.write("\nMATERIAL: [" + matList.get(i).getName() + "], QUANTITY: [" + matList.get(i).getQuantity() + "]");
				
			}		
		}catch (IOException e) { 
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
	
	/**
	 * Starts the intermediate stations and sends jobs to final station if the jobs were successful. For each job, this function sends the task over to server 
	 * which processes and performs the installation of the task.    
	 * 
	 */
	public static void startSystem(ArrayList<Job> c, ArrayList<IntermediateStation> im) throws IOException, ClassNotFoundException{
		ArrayList<Job> validJobList = c;
		ArrayList<IntermediateStation> midStations = im;
		FinalStation engraveVIN = new FinalStation();
		String formattedDate;
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		Socket socket = new Socket("localhost", 9999);
		OutputStream outputStream = socket.getOutputStream();
		ObjectOutputStream objectOut = new ObjectOutputStream(outputStream);
		InputStream inputStream = socket.getInputStream();
		ObjectInputStream inputObj = new ObjectInputStream(inputStream);
		
		for(int i = 0; i < validJobList.size(); i++) {		
			File jobLog = new File("JobLog.txt");
			FileWriter fr = null; 
			midStations = new ArrayList<IntermediateStation>();
			ArrayList<Task> tempTask = validJobList.get(i).getTasks();
			boolean jobFailed = false;
 
			try {  
				LocalDateTime date = LocalDateTime.now();
				formattedDate = date.format(dateFormat);
				
				fr = new FileWriter(jobLog, true);
				
				fr.write("\n_________________________________________________________________");
				fr.write("\nJOB ID: [" +validJobList.get(i).getJobID() + "], DATE: " + formattedDate);
				System.out.println("\nCURRENT JOB IN THE SYSTEM: [JOB ID " + validJobList.get(i).getJobID() + "]");
						
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					fr.close();
				}catch (IOException e) { 
					e.printStackTrace();
				}   
			}
			 
			for(int j = 0; j < tempTask.size(); j++) { 
				midStations.add(new IntermediateStation(tempTask.get(j), j+1, validJobList.get(i).getJobID()));
				try {
					System.out.println("\nSENDING TASK: " + tempTask.get(j).GetName());
					Thread.sleep(2000);
				} catch (InterruptedException e) { 
					e.printStackTrace();
				}

				objectOut.writeObject(midStations.get(j));
				objectOut.flush();;
			
				IntermediateStation recvMidStation = (IntermediateStation) inputObj.readObject();

				if(!recvMidStation.isTaskDone()) {
					jobFailed = true;
				}	
			} 
			 
			if(!jobFailed) {
				engraveVIN.doVINAndLog(midStations);;
				engraveVIN.setOffline(true);
				
			}		
		}
		
		objectOut.writeObject(null);		
		socket.close();	
		
	}
}
