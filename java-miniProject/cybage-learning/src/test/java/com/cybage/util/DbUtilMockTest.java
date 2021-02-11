package com.cybage.util;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class DbUtilMockTest {

	@InjectMocks
	private DbUtil dbUtil;
	@Mock
	private Connection mockConnection;
	@Mock
	private Statement mockStatement;

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetCon() throws SQLException {
//		Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
//	    Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
	    int value = DbUtil.executeQuery("insert into category(category_name, image_url) values('cat4', 'url4')");
	    Assert.assertEquals(value, 1);
	    //Mockito.verify(mockConnection.createStatement(), Mockito.times(1));
	}

}
