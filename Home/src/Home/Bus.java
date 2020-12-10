package Home;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Bus {
	
	    Scanner sc = new Scanner(System.in);
	    int yes_bus=0;
		void search_bus()throws Exception{
		
			Connection con = Main.database_connect();
			Statement st = con.createStatement();
			out.print("Enter source: ");
			String source = sc.nextLine();
			out.print("Enter destination: ");
			String destination = sc.nextLine();
			out.print("Enter journey date: ");
			String date = sc.nextLine();
		    
			String query = "SELECT * FROM bus_info";
			ResultSet r = st.executeQuery(query);
			out.println("**********************************************************************************************************************************");
			out.println("Bus No.     Bus Name       Bus Source     Bus Destination      Price        Journey Date          timing         Available Seats");
			out.println("**********************************************************************************************************************************");
			while(r.next()) {
				
				String bus_source = r.getString(3);
				String bus_destination = r.getString(4);
				String bus_date = r.getString(6);
				if(bus_source.equals(source) && bus_destination.equals(destination) && bus_date.equals(date)) {
					
					 String busData = r.getString(1)+"         "+r.getString(2)+"          "+r.getString(3)+"             "+r.getString(4)+"               "+r.getString(5)+"          "+r.getString(6)+"           "+r.getString(7)+"             "+r.getString(8);
				     out.println(busData);
				     yes_bus++;
				}
			}
			out.println("**********************************************************************************************************************************");
			if(yes_bus==0) {
				
				out.println("Sorry!!! No bus is available.");
			}
			else {
				
				yes_bus=0;
			}
			
		}
	  	
	}

