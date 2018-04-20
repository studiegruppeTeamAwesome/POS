package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.Rolle;

public class DataConnection {
	
	private Connection connection;
	
	public void openConnection() {
		try {
			System.out.println("Loading JDBC Driver...");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			System.out.println("JDBC Driver loaded");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load JDBC Driver!");
			System.exit(1);
		}

		String databaseName = "posDB";

		String connectionString = "jdbc:sqlserver://localhost:1433;" + "instanceName=SQLEXPRESS;" + "databaseName="
				+ databaseName + ";" + "integratedSecurity=true;";

		try {
			System.out.println("Connecting to database...");
			System.out.println(connectionString);

			connection = DriverManager.getConnection(connectionString);

			if (connection != null)
				System.out.println("Connected to database");
			else
				System.out.println("Could not connect to database");

			// connection.close();
		} catch (SQLException e) {
			System.out.println("Failed to connect to database: " + databaseName);

			// if connecting to database failed, then it is no use to continue program =>
			// terminate
			System.exit(1);
		}
	}
	
	public ArrayList<Rolle> getAllRoller() {
		ArrayList<Rolle> roller = new ArrayList<Rolle>();

		try {
			String sql = "SELECT * FROM rolle ";

			System.out.println(sql);

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next())
				roller.add(new Rolle(resultSet.getString("rolleNavn"), resultSet.getInt("id")));
		} catch (SQLException e) {
		}
		System.out.println(roller);
		return roller;
	}

}
