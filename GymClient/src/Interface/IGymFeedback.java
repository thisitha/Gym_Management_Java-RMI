package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IGymFeedback extends Remote {
	public boolean AdminLogin(String userName, String password) throws RemoteException;
	public void AddAdmin(String userName, String password) throws RemoteException;
	public void AddAnswer(String Q1, String Q2,String Q3,String Q4,String Q5,String Q6,String Q7,String Q8,String Q9) throws RemoteException;
	public  void getChart() throws RemoteException;
	public String getCh(String Question) throws RemoteException;
	public void AddComplain(String name, String admission, String complain) throws RemoteException;
	ArrayList<String> getCustomerComplain() throws RemoteException;
	
}
