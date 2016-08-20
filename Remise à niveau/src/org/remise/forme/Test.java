package org.remise.forme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class Test {
	
	public static String SELECT_QUERY= "select * from personne where nom = ':user'";
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String url = "jdbc:postgresql://localhost:5432/Banque";
		Properties props = new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","postgres");
		//props.setProperty("ssl","true");
		Connection conn = null;
		try {
			String user = "Crésus";
			conn = DriverManager.getConnection(url, props);
			Statement unStat = conn.createStatement();
			ResultSet rs = unStat.executeQuery(Test.SELECT_QUERY.replace(":user", user));
			while(rs.next())
			{
				System.out.println("ID " + rs.getString(1));
				System.out.println("Nom " + rs.getString(2));
				System.out.println("Code " + rs.getInt(3));
				System.out.println(System.lineSeparator());
			}
			rs.close();
			unStat.executeUpdate("update compte_bancaire set montant = 5555 where personne = '2'");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
		finally
		{
			try {
				conn.close();
			} catch (Exception e) 
			{
				
			}
		}

		

	}

}
