package jdbcmysql_crud1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstJdbcMain {

	public static void main(String[] args) {
		// System.out.println("Hello Ashish.");
		/*
		 * try { Class.forName("com.mysql.cj.jdbc.Driver"); String url =
		 * "jdbc:mysql://localhost:3306/firstjdbc_db"; Connection conn =
		 * DriverManager.getConnection(url, "root", ""); Statement stmt =
		 * conn.createStatement(); // stmt.execute("SELECT * FROM employee");
		 * 
		 * 
		 * boolean inserted = stmt.execute(
		 * "INSERT INTO employee(name,department,role) \n" +
		 * "VALUES('Chandrakesh','.Net Developer','Trainee')");
		 * 
		 * if (inserted) { System.out.println("Data Insertion failed"); } else {
		 * System.out.println("Data Insertion successfully"); 
		
		 * boolean update = stmt.execute("UPDATE employee \n" + "SET \n" +
		 * "name = 'Shiva', \n" + "department = 'Staff Office' \n" + "WHERE id = 8");
		 * 
		 * if (update) { System.out.println("Data Update failed"); } else {
		 * System.out.println("Data Update successfully"); }
		 * 
		 * 
		 * 
		 * boolean deleted = stmt.execute("DELETE FROM employee \n" + "WHERE id = 10");
		 * 
		 * System.out.println("rows affected >: "+stmt.getUpdateCount()); if
		 * (stmt.getUpdateCount() > 0) {
		 * System.out.println("Data Deletion successfully"); } else {
		 * System.out.println("Data Deletion failed"); }
		 * 
		 * 
		 * 
		 * ResultSet rs = stmt.executeQuery("SELECT * FROM employee"); while (rs.next())
		 * { System.out.println(rs.getString("id") + "," + rs.getString("name") + "," +
		 * rs.getString("department") + "," + rs.getString("role")); }
		 * 
		 * conn.close(); } catch (ClassNotFoundException e) { e.printStackTrace(); }
		 * catch (SQLException e) { e.printStackTrace(); }
		 */
		//saveEmployee("Anil");
		//showEmployee(5);
		//showEmployee("Sunny' OR 1=1 --' ");
		showEmployee("Sunny");
	}

	static void saveEmployee(String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/firstjdbc_db";
			Connection conn = DriverManager.getConnection(url, "root", "");
			Statement stmt = conn.createStatement();

			boolean inserted = stmt.execute("INSERT INTO employee(name,department,role) \n" + "VALUES('" + name
					+ "','.Net Developer','Trainee')");
			if (inserted) {
				System.out.println("Data Insertion failed");
			} else {
				System.out.println("Data Insertion successfully");
			}

			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void deleteEmployee(Integer id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/firstjdbc_db";
			Connection conn = DriverManager.getConnection(url, "root", "");
			Statement stmt = conn.createStatement();

			boolean deleted = stmt.execute("DELETE FROM employee \n" + "WHERE id = 10");

			System.out.println("rows affected >: " + stmt.getUpdateCount());
			if (stmt.getUpdateCount() > 0) {
				System.out.println("Data Deletion successfully");
			} else {
				System.out.println("Data Deletion failed");
			}

			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void updateEmployee(String department, String role, String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/firstjdbc_db";
			Connection conn = DriverManager.getConnection(url, "root", "");
			Statement stmt = conn.createStatement();

			boolean update = stmt.execute("UPDATE employee \n" + "SET \n" + "name = 'Shiva', \n"
					+ "department = 'Staff Office' \n" + "WHERE id = 8");

			if (update) {
				System.out.println("Data Update failed");
			} else {
				System.out.println("Data Update successfully");
			}

			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static void showEmployee(String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/firstjdbc_db";
			Connection conn = DriverManager.getConnection(url, "root", "");
			//Statement stmt = conn.createStatement();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee WHERE name = ?");
			stmt.setString(1,name);
			//ResultSet rs = stmt.executeQuery("SELECT * FROM employee WHERE name = '"+name+"'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("id") + "," + rs.getString("name") + "," + rs.getString("department")
						+ "," + rs.getString("role"));
			}

			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
