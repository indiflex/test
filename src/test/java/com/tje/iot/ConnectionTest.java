package com.tje.iot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;



public class ConnectionTest {
	private static final String Driver = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://35.200.26.218:3306/testdb?useSSL=false";
	private static final String USER = "root";
	private static final String PASSWD = "root1!";
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(Driver);
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWD)) {
			System.out.println(conn);
			
			String name = "홍" + System.currentTimeMillis();
			int insertCount = add(conn, name, true);
			if (insertCount != 1)
				throw new Exception("Insert Fail!!");
			
			String name2 = getLast(conn);
			if (!name.equals(name2)) {
				throw new Exception("Not equals name!!");
			} else {
				System.out.println(name2);
			}
			
			int affectedRowCount = rmLast(conn);
			if (affectedRowCount != 1) {
				throw new Exception("Not Valid Removed!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static final String SelectSQL = "select name from Test where id = last_insert_id();";
	private String getLast(Connection conn) throws Exception {
		String result = null;
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(SelectSQL);
			if (rs.next())
				result = rs.getString("name");
		} catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	private static final String DeleteSQL = "delete from Test where id = last_insert_id()";
	private int rmLast(Connection conn) throws Exception {
		return writeDB(conn, DeleteSQL);
	}

	private static final String InsertSQL = "insert into Test(name) values(?)";
	public int add(Connection conn, String name, boolean autoClosable) throws Exception {
		return writeDB(conn, InsertSQL, name);
	}
	
	private int writeDB(Connection conn, String sql) throws Exception {
		return writeDB(conn, sql, null);
	}
	
	private int writeDB(Connection conn, String sql, String name) throws Exception {
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			if (name != null)
				pstmt.setString(1,  name);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}
}
