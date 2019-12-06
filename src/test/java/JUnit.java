

  import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection; import java.sql.DriverManager; import
 java.sql.SQLException;

import org.junit.jupiter.api.Test;

 
 public class JUnit { 
	 static Connection connObj = null; //This is sample test
 // case to show that junit is up and running
 
 @Test 
 public void testSetup() { 
	 String str= "I am done with Junit setup";
 assertEquals("I am done with Junit setup",str); } //This is sample test case
 // to show that database connection is up and running
 }