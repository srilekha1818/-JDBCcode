package jdbcconcept1;

import java.sql.*;

class TestApp {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {

//Step1. Load and register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded succesfully....");
//Step2. Establish the Connection with database
			String url = "jdbc:mysql://localhost:3306/sept";
//username and password would vary from user to user
			String userName = "root";
			String passWord = "1234";
			connection = DriverManager.getConnection(url, userName, passWord);
			System.out.println("connection established succesfully...");
			System.out.println("The implement class name is " + connection.getClass().getName());
//Step3. Create statement Object and send the query
			String sqlSelectQuery = "select sid,sname,sage,saddress from student";

			statement = connection.createStatement();
			System.out.println("The implementation class name is ::" + statement.getClass().getName());

			resultSet = statement.executeQuery(sqlSelectQuery);
			System.out.println("The implementation class name is ::" + resultSet.getClass().getName());
			System.out.println();
			System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
//Step4. Process the resultSet
			while (resultSet.next()) {
				Integer sid = resultSet.getInt(1);
				String sname = resultSet.getString(2);
				Integer sage = resultSet.getInt(3);
				String saddr = resultSet.getString(4);
				System.out.println(sid + "\t" + sname + "\t" + sage + "\t" + saddr);
			}
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//closing the resources
			if (connection != null) {
				try {
					connection.close();
					System.out.println("Connection closed...");
				} catch (SQLException se) {

					se.printStackTrace();
				}
			}
		}
	}
}
