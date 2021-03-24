package btp400.a1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Assignment 1 BTP400 - Server
 */

public class Server {  

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		int check = 0;
		
		ServerSocket serverSock = new ServerSocket(9999);
		System.out.println("Welcom to Car Assmebly App. [Awaiting connection from system...]");
		
		Socket socket = serverSock.accept();//Waits for the client to connect
		
		InputStream inputStream = socket.getInputStream();
		ObjectInputStream inputObj = new ObjectInputStream(inputStream);
		
		OutputStream outputStream = socket.getOutputStream();
		ObjectOutputStream outputObj = new ObjectOutputStream(outputStream);
		
		while(check == 0) {// Server stays up until client is done
			
			IntermediateStation recvStation = (IntermediateStation) inputObj.readObject(); //Reading sent IntermediateStation from the client output call
			
			if(recvStation != null) {			
				try { 
					recvStation.doTask();
					Thread.sleep(2000); //Simulating assembly installation
					
					/**
					 * If the task at the station was successfully performed then we just return that IntermediateStation 
					 * object back to client input call.
					 */
					if(recvStation.isTaskDone()) {
						outputObj.writeObject(recvStation);
						outputObj.flush();
						 
					}
					/**
					 * Else the task failed so it is logged in FailedLog.txt by writing its associated job ID and the task name. 
					 * The IntermediateStation needs to be send back to client input call for validation purposes.
					 */
					else {
						File failedLog = new File("FailedLog.txt");
						FileWriter frFail = null; 
						try {
							frFail = new FileWriter(failedLog, true);
							frFail.write("\n_________________________________________________________________");
							frFail.write("\nERROR TASK FAILED FOR JOB ID: [" + recvStation.getJobId() + "], TASK: INSTALL " + recvStation.getStation());
							
						} catch (IOException e) {
							e.printStackTrace();
						}finally {
							try {
								frFail.close();
							}catch (IOException e) {
								e.printStackTrace(); 
							} 
			
						}
						outputObj.writeObject(recvStation);
						outputObj.flush();
 
					}
					
				} catch (InterruptedException e) { 
					e.printStackTrace(); 
				} 				 
			}
			else { //Breaking loop and cleaning up
				check = 1; //Used for breaking the loop 
				inputObj.close(); 
				outputObj.close();
				serverSock.close();
				socket.close(); 
				 
			}	
		}	
	}

}
 