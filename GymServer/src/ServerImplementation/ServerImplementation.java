package ServerImplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import Interface.IGymFeedback;

public class ServerImplementation extends UnicastRemoteObject implements IGymFeedback{

	Connection conn;
private	String sql="SELECT * FROM `answertable`";
	//System.out.print("Q1");
	
	
private String url = "";
private	int answer1= 0;
private	int answer2 =0;
private	int answer3 =0;
	
	public ServerImplementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean AdminLogin(String userName, String password) throws RemoteException {
		boolean result = false; //false
		 
		String sql="SELECT * FROM `login` WHERE `userName` = '"+userName+"';";
		try{
			PreparedStatement  pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while (rs.next()) {
				if (rs.getString("password").equalsIgnoreCase(password)) {				
					result = true;														 
				} else {
					result = false;
					
				}
			}
					return result; //result
				} catch (Exception e) {
					System.out.println(e);
					return false; //false
				}	
		
		

		
		
	}
	


	@Override
	public void AddAdmin(String userName, String password) throws RemoteException {
		String query="INSERT INTO `login` (`userName`,`password`) VALUES (?,?) ";
		PreparedStatement pts;
		try {
			pts = conn.prepareStatement(query);
			pts.setString(1, userName);
			pts.setString(2, password);
			pts.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		 
					
		
	}
	
	@Override
	public void AddAnswer(String Q1, String Q2,String Q3,String Q4,String Q5,String Q6,String Q7,String Q8,String Q9) throws RemoteException {
	try {
		String query="INSERT INTO `answertable` (`Q1`,`Q2`,`Q3`,`Q4`,`Q5`,`Q6`,`Q7`,`Q8`,`Q9`) VALUES (?,?,?,?,?,?,?,?,?) ";
		PreparedStatement pts;
		pts = conn.prepareStatement(query);
		pts.setString(1, Q1);
		pts.setString(2, Q2);
		pts.setString(3, Q3);
		pts.setString(4, Q4);
		pts.setString(5, Q5);
		pts.setString(6, Q6);
		pts.setString(7, Q7);
		pts.setString(8, Q8);
		pts.setString(9, Q9);
		pts.executeUpdate();
	}
		
	 catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}

}
	
	
	
	
	@Override
	public String getCh(String Question) throws RemoteException {
		  //answer1= 0;
		// answer2 =0;
	 // answer3 =0;
		try{
			PreparedStatement  pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			
			while (rs.next()) {
				
		//		System.out.print(rs.getString("Q1"));
				//Question.equals(true)
				if(Question.equals("Q1")) {
					if (rs.getString("Q1").equals("Social Media")) {
						answer1 = answer1+1;
						//System.out.print("Qanswee11");
					}else if (rs.getString("Q1").equals("From a Add")) {
						answer2 = answer2+1;
					//	System.out.print("answer2");
					}else if (rs.getString("Q1").equals("From a Friend")) {
						answer3 = answer3+1;
						System.out.print("answer3");
					}
					
					
				}else if(Question.equals("Q2")) {
					if (rs.getString("Q2").equals("80>")) {
						answer1 = answer1+1;
						//System.out.print("Qanswee11");
					}else if (rs.getString("Q2").equals("80-65")) {
						answer2 = answer2+1;
					//	System.out.print("answer2");
					}else if (rs.getString("Q2").equals("55<")) {
						answer3 = answer3+1;
						System.out.print("answer3");
					}
					
				}else if(Question.equals("Q3")) {
					if (rs.getString("Q3").equals("1 - 2 Months")) {
						answer1 = answer1+1;
						//System.out.print("Qanswee11");
					}else if (rs.getString("Q3").equals("2 - 3 Months")) {
						answer2 = answer2+1;
					//	System.out.print("answer2");
					}else if (rs.getString("Q3").equals("Greater Than 4 Months")) {
						answer3 = answer3+1;
						System.out.print("answer3");
					}
					
				}else if(Question.equals("Q4")) {
					if (rs.getString("Q4").equals("AfterNoon")) {
						answer1 = answer1+1;
						//System.out.print("Qanswee11");
					}else if (rs.getString("Q4").equals("Morning")) {
						answer2 = answer2+1;
					//	System.out.print("answer2");
					}else if (rs.getString("Q4").equals("Night")) {
						answer3 = answer3+1;
						System.out.print("answer3");
					}
					
				}else if(Question.equals("Q5")) {
					if (rs.getString("Q5").equals("Affordability")) {
						answer1 = answer1+1;
						//System.out.print("Qanswee11");
					}else if (rs.getString("Q5").equals("Facilities")) {
						answer2 = answer2+1;
					//	System.out.print("answer2");
					}else if (rs.getString("Q5").equals("Parking")) {
						answer3 = answer3+1;
						System.out.print("answer3");
					}
					
				}else if(Question.equals("Q6")) {
					if (rs.getString("Q6").equals("Good")) {
						answer1 = answer1+1;
						//System.out.print("Qanswee11");
					}else if (rs.getString("Q6").equals("Average")) {
						answer2 = answer2+1;
					//	System.out.print("answer2");
					}else if (rs.getString("Q6").equals("Poor")) {
						answer3 = answer3+1;
						System.out.print("answer3");
					}
					
				}else if(Question.equals("Q7")) {
					if (rs.getString("Q7").equals("Good")) {
						answer1 = answer1+1;
						//System.out.print("Qanswee11");
					}else if (rs.getString("Q7").equals("Moderate")) {
						answer2 = answer2+1;
					//	System.out.print("answer2");
					}else if (rs.getString("Q7").equals("Poor")) {
						answer3 = answer3+1;
						System.out.print("answer3");
					}
					
				}else if(Question.equals("Q8")) {
					if (rs.getString("Q8").equals("Yes")) {
						answer1 = answer1+1;
						//System.out.print("Qanswee11");
					}else if (rs.getString("Q8").equals("No")) {
						answer2 = answer2+1;
					//	System.out.print("answer2");
					}else if (rs.getString("Q8").equals("Moderate")) {
						answer3 = answer3+1;
						System.out.print("answer3");
					}
					
				}else if(Question.equals("Q9")) {
					if (rs.getString("Q9").equals("Kind Of")) {
						answer1 = answer1+1;
						//System.out.print("Qanswee11");
					}else if (rs.getString("Q9").equals("Of Cource")) {
						answer2 = answer2+1;
					//	System.out.print("answer2");
					}else if (rs.getString("Q9").equals("Absolutely Yes")) {
						answer3 = answer3+1;
						System.out.print("answer3");
					}
					
				}
				
				
				
				
				
					
				
				
					
			}
			
			if(Question.equals("Q1")) {
				url = "https://quickchart.io/chart?c={type:'bar',data:{labels:[],datasets:[{label:'Social_Media',data:["+answer1+"]},{label:'From_a_Friend',data:["+answer2+"]},{label:'From_a_Add',data:["+answer3+"]}]}}";
				//url = "https://quickchart.io/chart?width=400&height=300&c={type:'bar',data:{labels:['Q1','Q2','Q3','Q4'],datasets:[{label:'Users',data:[50, 60, 70, 180]},{label:'Revenue',data:[100, 200, 300, 400]}]}}";
				return url;
		
			}else if(Question.equals("Q2")) {
				url = "https://quickchart.io/chart?c={type:'bar',data:{labels:[],datasets:[{label:'80',data:["+answer1+"]},{label:'80-65',data:["+answer2+"]},{label:'55<',data:["+answer3+"]}]}}";
				//url = "https://quickchart.io/chart?width=400&height=300&c={type:'bar',data:{labels:['Q1','Q2','Q3','Q4'],datasets:[{label:'Users',data:[50, 60, 70, 180]},{label:'Revenue',data:[100, 200, 300, 400]}]}}";
				return url;
				
			}else if(Question.equals("Q3")) {
				url = "https://quickchart.io/chart?c={type:'bar',data:{labels:[],datasets:[{label:'1_-_2_Months',data:["+answer1+"]},{label:'2-3_Months',data:["+answer2+"]},{label:'4_Months>',data:["+answer3+"]}]}}";
				//url = "https://quickchart.io/chart?width=400&height=300&c={type:'bar',data:{labels:['Q1','Q2','Q3','Q4'],datasets:[{label:'Users',data:[50, 60, 70, 180]},{label:'Revenue',data:[100, 200, 300, 400]}]}}";
				return url;
				
			}else if(Question.equals("Q4")) {
				url = "https://quickchart.io/chart?c={type:'bar',data:{labels:[],datasets:[{label:'Afternoon',data:["+answer1+"]},{label:'Morning',data:["+answer2+"]},{label:'Night<',data:["+answer3+"]}]}}";
				//url = "https://quickchart.io/chart?width=400&height=300&c={type:'bar',data:{labels:['Q1','Q2','Q3','Q4'],datasets:[{label:'Users',data:[50, 60, 70, 180]},{label:'Revenue',data:[100, 200, 300, 400]}]}}";
				return url;
				
			}else if(Question.equals("Q5")) {
				url = "https://quickchart.io/chart?c={type:'bar',data:{labels:[],datasets:[{label:'Affordability',data:["+answer1+"]},{label:'Facilities',data:["+answer2+"]},{label:'Parking<',data:["+answer3+"]}]}}";
				//url = "https://quickchart.io/chart?width=400&height=300&c={type:'bar',data:{labels:['Q1','Q2','Q3','Q4'],datasets:[{label:'Users',data:[50, 60, 70, 180]},{label:'Revenue',data:[100, 200, 300, 400]}]}}";
				return url;
				
			}else if(Question.equals("Q6")) {
				url = "https://quickchart.io/chart?c={type:'bar',data:{labels:[],datasets:[{label:'Good',data:["+answer1+"]},{label:'Average',data:["+answer2+"]},{label:'Poor',data:["+answer3+"]}]}}";
				//url = "https://quickchart.io/chart?width=400&height=300&c={type:'bar',data:{labels:['Q1','Q2','Q3','Q4'],datasets:[{label:'Users',data:[50, 60, 70, 180]},{label:'Revenue',data:[100, 200, 300, 400]}]}}";
				return url;
			}else if(Question.equals("Q7")) {
				url = "https://quickchart.io/chart?c={type:'bar',data:{labels:[],datasets:[{label:'Good',data:["+answer1+"]},{label:'Moderate',data:["+answer2+"]},{label:'Poor',data:["+answer3+"]}]}}";
				//url = "https://quickchart.io/chart?width=400&height=300&c={type:'bar',data:{labels:['Q1','Q2','Q3','Q4'],datasets:[{label:'Users',data:[50, 60, 70, 180]},{label:'Revenue',data:[100, 200, 300, 400]}]}}";
				return url;
				
			}else if(Question.equals("Q8")) {
				url = "https://quickchart.io/chart?c={type:'bar',data:{labels:[],datasets:[{label:'Yes',data:["+answer1+"]},{label:'No',data:["+answer2+"]},{label:'Moderate',data:["+answer3+"]}]}}";
				//url = "https://quickchart.io/chart?width=400&height=300&c={type:'bar',data:{labels:['Q1','Q2','Q3','Q4'],datasets:[{label:'Users',data:[50, 60, 70, 180]},{label:'Revenue',data:[100, 200, 300, 400]}]}}";
				return url;
				
			}else if(Question.equals("Q9")) {
				//url = "https://quickchart.io/chart?width=400&height=300&c={type:'bar',data:{labels:['Q1','Q2','Q3','Q4'],datasets:[{label:'Users',data:[50, 60, 70, 180]},{label:'Revenue',data:[100, 200, 300, 400]}]}}";
				return url;
				
			}
				
			
			System.out.println(answer1 );
			System.out.println(answer2 );
			System.out.println(answer3 );
			return url;
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return url;
			
		

	}
	
	
	
	
	
	

	@Override
	public void getChart() throws RemoteException {

	
		
//		String sql="SELECT * FROM `answertable`";
		System.out.print("Q1");
		//try{
		//	PreparedStatement  pst=conn.prepareStatement(sql);
		//	ResultSet rs=pst.executeQuery();
			
			//while (rs.next()) {
				
				//System.out.print(rs.getString("Q1"));
					
			//}
//		}catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		
		
		
	
	
	
	
	
	
	
	
	

}
	
	
 
	 
	@Override
	public ArrayList<String> getCustomerComplain() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String>Get_Complaint=new ArrayList<String>();
		String arrayComplain[];
		arrayComplain=new String[3];
		try {
			String get_com="SELECT * FROM complaintable ";
	        PreparedStatement prt=conn.prepareStatement(get_com);
	        ResultSet rs=prt.executeQuery();
	               
	        while(rs.next())
	        {
	        	arrayComplain[0]=rs.getString("name");
	        	arrayComplain[1]=rs.getString("admission");
	        	arrayComplain[2]=rs.getString("complain");
	        	
	        	
	        	Get_Complaint.addAll(Arrays.asList(arrayComplain));

	        }
	        
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		return Get_Complaint;
	}
	

	@Override
	public void AddComplain(String name, String admission, String complain) throws RemoteException {
		// TODO Auto-generated method stub
		String query="INSERT INTO `complaintable` (`name`,`admission`,`complain`) VALUES (?,?,?) ";
		PreparedStatement pts;
		try {
			pts = conn.prepareStatement(query);
			pts.setString(1, name);
			pts.setString(2, admission);
			pts.setString(3, complain);
			pts.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
