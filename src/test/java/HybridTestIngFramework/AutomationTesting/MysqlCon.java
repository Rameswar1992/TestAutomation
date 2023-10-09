package HybridTestIngFramework.AutomationTesting;

import java.sql.*;

class MysqlCon {
	public static void main(String args[]) {
		Connection con;
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "root");
            //here sonoo is database name, root is username and password  
			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery("select * from employees where employeeNumber='1002'");
			ResultSet rs = stmt.executeQuery("select * from employees");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "   " + rs.getString(2) + "   " + rs.getString(3) + "    "
						+ rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6) + "  " + rs.getString(7)
						+ "  " + rs.getString(8));

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}