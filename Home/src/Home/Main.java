package Home;
import java.util.*;
import static java.lang.System.*;

import java.sql.*;
public class Main {
	
	
	private static Scanner sc;
	public static void main(String args[])throws Exception {
		
		
		sc = new Scanner(System.in);
        
		try {
		while(true) {
		    
			out.println();
			out.println("************************** WELCOME TO THE BUS RESERVATION SYSTEM ************************");
			out.println();
			out.println("*****************************************");
			out.println("1. Create New Account\n2. Login\n3. About Us\n4. Contact Us\n5. Exit");
			out.println("*****************************************");
			out.print("Enter choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			//sc.close();
		    switch(choice) {
		       case 1: Registration regi = new Registration();
		               regi.registration_detail();
		               break;
		        
		       case 2: Login l = new Login();
		               l.login_detect();
		               break;
		    	      
		       case 3: out.println("*********************************** About Us *********************************************");
		               out.println("Welcome to our Bus Reservation System. Here you can search, book and cancel buses.");
		               out.println("You can only able to book at max 4 tickets at a time. First you have to register in the system");
		               out.println("with your Email Id. To see the bus details and further booking purpose you have to first login");
		               out.println("with your registered email id. Then you can able to see all the necessary details to book a bus.");
		               out.println("You can also see your profile details and also able to edit your profile. You can also change your");
		               out.println("password if you want. After successfully searching buses with given necessary informations you can");
		               out.println("see the bus availablity details. If the required bus seats are available you can easily book a bus");
		               out.println("with given necessary details such as person's name, age, gender and also you can choose a seat no.");
		               out.println("as your choice from a given list. After successfully booking you can also see the booking details");
		               out.println("with proper seat numbers.");
		    	       out.println("******************************************************************************************");
		               break;
		        
		       case 4: out.println("******************************* Contact Us ************************************");
		    	       out.println("Mobile - +91 8597430895\nAddress - Cooch Behar, West Bengal, Pin-736101\nEmail - mrbarua123@gmail.com");
		               out.println("*******************************************************************************");
		    	       break;
		               
		       case 5: exit(0);
		              
		              
		       default: out.println("Message: Please enter a valid choice.");
		    }
			}
		 }
		 catch(InputMismatchException e) {
			
			out.println("Warning: Please enter appropriate Numbers.");
			main(null);
		}
	
	}
		
	
	static Connection database_connect()throws Exception {
		
		String db_name = "jdbc:mysql://localhost:3306/bus_booking";
		String user_name = "root";
		String pass = "saikat218212";
		
		//Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(db_name,user_name,pass);
		return con;
		
	}
	static void logout() throws Exception {
		
		main(null);
	}

}


