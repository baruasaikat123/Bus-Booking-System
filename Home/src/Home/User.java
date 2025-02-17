package Home;
import java.util.*;
import static java.lang.System.*;
import java.time.LocalDate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class User {
	
	String email_id;
	String password;
	Scanner sc = new Scanner(System.in);
	
	void setDetail(String email_id, String password) {
		
		this.email_id = email_id;
		this.password = password;
	}
	
	String getEmail() {
		
		return email_id;
	}
	String getPassword() {
		
		return password;
	
	}
	void user_fun()throws Exception {
		
		int bus_no_match=0, go_back=0;
		Connection con = Main.database_connect();
		Statement st = con.createStatement();
		String query;
		ResultSet r;
		while(true) {
			
			out.println("**********************************************************************");
			out.println("1. View Profile\n2. Edit Profile\n3. Change Password\n4. Search Bus\n5. Book Ticket\n6. See All Bookings\n7. Log out");
			out.println("**********************************************************************");
			out.print("Enter choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			
			case 1: query = "SELECT email_id, first_name, last_name, gender, address, mobile_no, pass FROM user_info WHERE email_id='" +getEmail()+ "'";
			        ResultSet r2 = st.executeQuery(query);
			        while(r2.next()) {
			        	
			        	out.println("Name = "+r2.getString(2)+" "+r2.getString(3));
			            out.println("Gender = "+r2.getString(4));
			            out.println("Address = "+r2.getString(5));
			            out.println("Mobile No = "+r2.getString(6));
			            out.println("Email = "+r2.getString(1));
			            break;		            				            		
			        }
			        break;
			        
			case 4: Bus b = new Bus();
				    b.search_bus();
			        break;
			
			case 2: while(true) {
				
				       out.println("1. First Name\n2. Last Name\n3. Mobile No\n4. Address\n5. Go Back");
				       out.print("Enter choice: ");
				       choice = sc.nextInt();
				       sc.nextLine();
				       switch(choice) {
				           
				            case 1: out.print("Enter First Name: ");
				                    String new_fname = sc.nextLine();
				                    query = "UPDATE user_info SET first_name='" +new_fname+ "' WHERE email_id='" +getEmail()+ "'";
				                    st.executeUpdate(query);
				                    out.println("Message: Successfully Updated!!!");
				                    break;
				                    
				            case 2: out.print("Enter Last Name: ");
				                    String new_lname = sc.nextLine();
				                    query = "UPDATE user_info SET last_name='" +new_lname+ "' WHERE email_id='" +getEmail()+ "'";
				                    st.executeUpdate(query);
				                    out.println("Message: Successfully Updated!!!");
				                    break;
				                    
				            case 3: out.print("Enter Mobile No: ");
				                    String new_mobile = sc.nextLine();
				                    query = "UPDATE user_info SET mobile_no='" +new_mobile+ "' WHERE email_id='" +getEmail()+ "'";
				                    st.executeQuery(query);
				                    out.println("Message: Successfully Updated!!!");
				                    break;
				            
				            case 4: out.print("Enter Address: ");
				                    String address = sc.nextLine();
				                    query = "UPDATE user_info SET address='" +address+ "' WHERE email_id='" +getEmail()+ "'";
				                    out.println("Message: Successfully Updated!!!");
				                    break;
				                    
				            case 5: go_back=1;
				                    break;
				            
				            default: out.println("Enter a valid choice.");
				       }
				       if(go_back==1) {
				    	   
				    	   go_back=0;
				    	   break;
				       }
			       }
				   break;
			
			case 3: out.print("Enter current password: ");
			        String old_pass = sc.nextLine();
			        query = "SELECT pass FROM user_info WHERE email_id='" +getEmail()+ "'";
			        ResultSet r10 = st.executeQuery(query);
			        r10.next();
			        String password = r10.getString(1);
			        if(old_pass.equals(password)) {
			        	
			        	out.print("Enter new password: ");
    				    String new_pass = sc.nextLine();
    				    if(old_pass.equals(new_pass)) {
    				    	
    				    	out.println("Warning: Old and New Password can not be same!!!");
    				    }
    				    else {
    				    	out.print("Are you sure?(press 'Y' to update or 'N' to cancel): ");
          	        	    String confirm = sc.nextLine();
          	        	    if(confirm.equalsIgnoreCase("Y")) {
          	        	    	
          	        	    	query = "UPDATE user_info SET pass='" +new_pass+ "' WHERE email_id='" +getEmail()+ "'";
            				    st.executeUpdate(query);
            				    out.println("Message: Successfully Updated!!!");
          	        	    }
          	        	    else if(confirm.equalsIgnoreCase("N")) {
          	        	    	
          	        	    	out.println("Message: Updation is unsuccessful!!!");
          	        	    }
          	        	    else {
          	        	    	
          	        	    	out.println("Warning: Please Enter a valid option.");
          	        	    }
    				    }
    				    
			        }
			        else {
			        	
			        	out.println("Warning: Current password does not match!!!");
			        }
			       
			        break;
			        
			case 5: out.print("Enter the Bus No. you want to book: ");
			        int bus_number = sc.nextInt();
			        //sc.nextLine();
			        query = "SELECT bus_no FROM bus_info";
			        ResultSet r4 = st.executeQuery(query);
			        while(r4.next()) {
			        	
			        	int num = r4.getInt(1);
			        	if(num==bus_number) {
			        		
			        		bus_no_match=0;
			        		query = "SELECT seat FROM bus_info WHERE bus_no=" +bus_number+ "";
    				        ResultSet r3 = st.executeQuery(query);
    				        r3.next();
    				        int total_seat_available = r3.getInt(1);
    				        if(total_seat_available==0) {
    				        	
    				        	out.println("Message: Sorry!!! No Seat is available in this bus.");
    				        }
    				        else {
    				        	
    				        	out.print("How many seats you want to book(you can book maximum 4 seats at a time)?: ");
    				        	int count_seat = sc.nextInt();
    				        	sc.nextLine();
    				        	if(count_seat>4) {
    				        		
    				        		out.println("Message: Sorry!!! You can not book more than 4 seats at a time.");
    				        	}
    				        	else {
    				        		
    				        		if(count_seat>total_seat_available) {
    				        			
    				        			out.println("Message: Only "+total_seat_available+" seats are left.");
    				        		}
    				        		else {
    				        			
    				        			out.println("ENTER PASSENGERS DETAILS:");
    				        			query = "SELECT bus_name,journey_date FROM bus_info WHERE bus_no=" +bus_number+ "";
    				        			ResultSet r8 = st.executeQuery(query);
    				        			r8.next();
    				        			String busName = r8.getString(1);
    				        			String travelDate = r8.getString(2);
    				        			LocalDate bookingDate = LocalDate.now();  
    				        			for(int i=1;i<=count_seat;i++) {
    				        				
    				        				out.println("Fill the details of passenger "+i+":");
    				        				out.print("Name = ");
    				        				String name = sc.nextLine();
    				        				out.print("Gender(M/F) = ");
    				        				char gender =  sc.next().charAt(0);
    				        				sc.nextLine();
    				        				out.print("Age = ");
    				        				int age = sc.nextInt();
    				        				sc.nextLine();
    				        				out.print("Choose a seat- ");
    				        				query = "SELECT seat_number FROM seat_detail WHERE bus_no=" +bus_number+ "";
    				        				ResultSet r6 = st.executeQuery(query);
    				        				while(r6.next()) {
    				        					
    				        					int seat_number = r6.getInt(1);
    				        					out.print(seat_number+", ");
    				        				}
    				        				out.println();
    				        				out.print("Type any seat number - ");
    				        				int select_seat = sc.nextInt();
    				        				sc.nextLine();
    				        				query = "INSERT INTO passenger_info(full_name,gender,age,seat_no,email_id,bus_no) VALUES('" +name+ "','" +gender+ "'," +age+ "," +select_seat+ ",'" +getEmail()+ "'," +bus_number+ ")";
    				        				st.executeUpdate(query);
    				        				query = "INSERT INTO booking_detail(bus_no,bus_name,full_name,seat_no,travel_date,booking_date,email_id) VALUES(" +bus_number+ ",'" +busName+ "','" +name+ "'," +select_seat+ ",'" +travelDate+ "','" +bookingDate+ "','" +getEmail()+ "')";
    				        				st.executeUpdate(query);
    				        				query = "DELETE FROM seat_detail WHERE bus_no=" +bus_number+ " AND seat_number=" +select_seat+ "";
    	                                    st.executeUpdate(query);				            				        				
    				        			}
    				        			out.println("Message: Tickets are booked successfully!!!");
    				        			int now_ticket = total_seat_available-count_seat;
    				        			query = "UPDATE bus_info SET seat=" +now_ticket+ " WHERE bus_no=" +bus_number+ "";
    				        			st.executeUpdate(query);
    				        			
    				        		}
    				        	}
    				        	
    				        }
    				        break;
			        	}
			        	else {
			        		
			        		bus_no_match++;
			        	}
			        }
			        if(bus_no_match>0) {
			        	
			        	bus_no_match=0;
			        	out.println("Warning: Please a enter a valid bus number.");
			        }
			        break;
			        
			case 6: out.println("****** Here are all your booking details *******");
			        out.println("******************************************************************************************************************");
			        out.println("Bus No       Bus Name         Passenger Name(s)        Seat No            Journey Date             Booking Date");
			        out.println("******************************************************************************************************************");
			        query = "SELECT bus_no,bus_name,full_name,seat_no,travel_date,booking_date FROM booking_detail WHERE email_id='" +getEmail()+ "'";
			        ResultSet r7= st.executeQuery(query);
			        while(r7.next()) {
			        	
			        	out.println(r7.getInt(1)+"          "+r7.getString(2)+"           "+r7.getString(3)+"           "+r7.getInt(4)+"                "+r7.getString(5)+"                "+r7.getString(6));
			        }
			        out.println("******************************************************************************************************************");
			        break;
			        
			/*case 7: out.println("***** Ticket Cancellation ******");
			        out.println("Enter Ticket Details");
			        break;*/
						        
			case 7: out.println("Message: Successfully Logged out!!!");
				    Main.logout();
			        break;
			
			default: out.println("Warning: Please enter a valid choice.");
	    }
	
	}
					
  }
}
