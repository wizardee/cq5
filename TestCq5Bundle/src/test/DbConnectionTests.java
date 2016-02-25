package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import db.driver.mariadb.DbConnection;

public class DbConnectionTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		DbConnection.testConnection();
	}

}
