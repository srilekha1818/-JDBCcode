package jdbcconcept1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteApp {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		
		// Step2. Establish the Connection
				String url = "jdbc:mysql:///sept";
				String user = "root";
				String password = "1234";
				Connection connection = DriverManager.getConnection(url, user, password);
				System.out.println("connection object created...");

		// Step3. Create statement Object and send the Query
				Statement statement = connection.createStatement();
				System.out.println("statement object created...");
		// Step4. Execute the Query and Process the resultSet
				String sqlDeleteQuery = "delete from student where sid = 2";
				int rowAffected = statement.executeUpdate(sqlDeleteQuery);
				System.out.println("No of rows affected is :: " + rowAffected);
		// Step6. Close the resources
		     	statement.close();
				connection.close();
				System.out.println("Closing the resources...");
				}
	}

