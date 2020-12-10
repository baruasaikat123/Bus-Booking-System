package Home;
import java.util.*;
import java.sql.*;
import static java.lang.System.out;

public class Registration {
	
	String fname;
	String lname;
	String mobile;
	String email;
	String pass1;
	String address;
	char gender;
	
	Scanner sc = new Scanner(System.in);
	void registration_detail()throws Exception {
		
		Connection con = Main.database_connect();
		Statement st = con.createStatement();
		out.print("Enter FirstName: ");
        fname = sc.nextLine();
        out.print("Enter LastName: ");
        lname = sc.nextLine();
        out.print("Enter gender(M/F): ");
        gender = sc.next().charAt(0);
        sc.nextLine();
        out.print("Enter mobile no: ");
        mobile = sc.nextLine();
        out.print("Enter Email: ");
        email = sc.nextLine();
        out.print("Enter a password: ");
        pass1 = sc.nextLine();
        out.print("Enter Address: ");
        address = sc.nextLine();
        String query = "INSERT INTO user_info VALUES('" +email+ "','" +fname+ "', '" +lname+ "', '" +gender+ "', '" +address+ "', '" +mobile+ "',+'" +pass1+ "')";
        st.executeUpdate(query);
        out.println("Message: Successfully Registered!!!");
        out.println("         Please Log in with your account for further check.");
	}

}
