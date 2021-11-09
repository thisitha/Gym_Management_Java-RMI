package ServerStart;

import java.rmi.RemoteException;  
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Interface.IGymFeedback;
import ServerImplementation.ServerImplementation;


 


public class Start_Server {
	public static void main(String[] args) {
		System.out.println("Attempting to start the RemoteAuto Server..."); 
		try {
			IGymFeedback new_gym_feedback = new ServerImplementation();
			
			Registry reg = LocateRegistry.createRegistry(1010);
			reg.rebind("GymService2020",new_gym_feedback);

			System.out.println("Service started. Welcome to RemoteAuto Service!");

		} catch (RemoteException e) {
			System.out.println("An error occured: "+e.toString()); 
			e.printStackTrace();
		} 
	}

}
