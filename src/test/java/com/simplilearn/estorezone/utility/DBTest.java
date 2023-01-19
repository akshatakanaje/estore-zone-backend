package com.simplilearn.estorezone.utility;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class DBTest {
	
	DB db;
	
	@BeforeEach
	public void setUp() {
		db = new DB();
	}
	
	@AfterEach
	public void cleanUp() {
		db.destroy();
	}
	
	@Test
	@DisplayName("DB Connection Test")
	public void testConnection1() {
		db.init();
		assertNotNull(db.getConnection());
	}
	
	@Test
	@DisplayName("Close DB Connection Test")
	public void testConnection2() {
		assertNull(db.getConnection());
	}

}
