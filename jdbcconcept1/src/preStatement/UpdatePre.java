package preStatement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import jdbcconcept1.JDBCUtility;

public class UpdatePre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scanner = null;

		try {
			connection = JDBCUtility.getJdbcConnection();
			
			String sqlUpdateQuery = "update student set saddress = ? where sid = ?";
			if (connection != null)
				pstmt = connection.prepareStatement(sqlUpdateQuery);

			if (pstmt != null) {
				scanner = new Scanner(System.in);

				System.out.print("Enter the id of the student :: ");
				int sid = scanner.nextInt();

				System.out.print("Enter the saddress of the student :: ");
				String saddress = scanner.next();

				// use precompiled query to set the values
				pstmt.setString(1, saddress);
				pstmt.setInt(2, sid);

				// execute the query
				int rowCount = pstmt.executeUpdate();
				System.out.println("No of rows updated is :: " + rowCount);
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtility.cleanUp(connection, pstmt, null);
				scanner.close();
				System.out.println("Closing the resource...");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	
	}

}
