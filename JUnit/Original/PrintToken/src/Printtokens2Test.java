import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import java.lang.System.*;
import java.util.Properties;

public class Printtokens2Test {
	
	public Printtokens2Test () {
		
	}

	@Before
    public void setUp() {
        System.out.println("\nSETUP IS RUNNING -- Start of a Test Notification");
    }

    @After
    public void tearDown() {
        System.out.println("TEARDOWN IS RUNNING -- End of a Test Notification");
    }
    
    /*
     * Method Name : open_character_stream
     * Input : filename as string
     * Output : A BufferedReader
     * No.of Tests: 3
     * Test 1: Filename: open_character_stream_1.txt - File Content : "characterstream()"
     * Test 2: Filename: null   -   System.in Content : "openchar[]"
     * Test 3: Filename: open_character_stream_2.txt  - File Content : null
     */
    @Test
    public void testOpen_character_stream() throws IOException {
    	
    	System.out.println("/********** Started JUnit Testing for the method open_character_stream() ******/");
    	Printtokens2 instance = new Printtokens2();
    	BufferedReader br = null;
    	String actualOutput = "", expectedOutput = "";
    	
    	// Steps for Test 1
    	br = instance.open_character_stream("InputFiles\\open_character_stream_1.txt");
    	actualOutput = br.readLine();
    	expectedOutput = "characterstream()";
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 1 Process Completed -----");
    	
    	// Steps for Test 2
    	ByteArrayInputStream sysInput = new ByteArrayInputStream("openchar[]".getBytes());
    	System.setIn(sysInput);
    	br = instance.open_character_stream(null);
    	actualOutput = br.readLine();
    	expectedOutput = "openchar[]";
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 2 Process Completed -----");
    	
    	// Steps for Test 3
    	br = instance.open_character_stream("InputFiles\\open_character_stream_2.txt");
    	actualOutput = br.readLine();
    	expectedOutput = null;
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 3 Process Completed -----");
    	
    	System.setIn(System.in);
    	
    	System.out.println("/********** End of JUnit Testing for the method open_character_stream() ******/");
    }
    
    /*
     * Method Name : get_char
     * Input : A BufferedReader
     * Output : an Integer with the value of character
     * No.of Tests: 4
     * Test 1: Filename: get_char_1.txt - File Content : " getchar"
     * Test 2: Filename: get_char_1.txt - File Content : "\ngetchar"
     * Test 3: Filename: null   -   System.in Content : "Testgetchar"
     * Test 4: Filename: null   -   System.in Content : null
     */
    @Test
    public void testGet_char() throws FileNotFoundException {
    	
    	System.out.println("/********** Started JUnit Testing for the method get_char() ******/");
    	Printtokens2 instance = new Printtokens2();
    	BufferedReader br = null;
    	int actualOutput = 0, expectedOutput = 0;
    	
    	// Steps for Test 1
    	br = new BufferedReader(new FileReader("InputFiles\\get_char_1.txt"));
    	actualOutput = instance.get_char(br);
    	expectedOutput = 32;
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 1 Process Completed -----");
    	
    	// Steps for Test 2
    	br = new BufferedReader(new FileReader("InputFiles\\get_char_2.txt"));
    	actualOutput = instance.get_char(br);
    	expectedOutput = 92;
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 2 Process Completed -----");
    	
    	// Steps for Test 3
    	br = new BufferedReader(new StringReader("Testgetchar"));
    	actualOutput = instance.get_char(br);
    	expectedOutput = 84;
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 3 Process Completed -----");
    	
    	// Steps for Test 4
    	br = new BufferedReader(new StringReader(""));
    	actualOutput = instance.get_char(br);
    	expectedOutput = -1;
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 4 Process Completed -----");
    	
    	System.out.println("/********** End of JUnit Testing for the method get_char() ******/");
    }
    
    /*
     * Method Name : unget_char
     * Input : Integer Value of a char and A BufferedReader
     * Output : Integer value of null i.e., 0
     * No.of Tests: 2
     * Test 1: Filename: null   -   System.in Content : "getTestchar"
     * Test 2: Filename: null   -   System.in Content : null
     */
    @Test
    public void testUnget_char() throws IOException {
    	
    	System.out.println("/********** Started JUnit Testing for the method unget_char() ******/");
    	Printtokens2 instance = new Printtokens2();
    	BufferedReader br = null;
    	int actualOutput = 0, expectedOutput = 0;
    	int ch = 0;
    	
    	// Steps for Test 1
    	br = new BufferedReader(new StringReader("getTestchar"));
    	br.read();
    	br.read();
    	br.read();
    	br.mark(4);
    	br.read();
    	br.read();
    	ch = br.read();
    	actualOutput = instance.unget_char(ch,br);
    	expectedOutput = 0;
    	assertEquals(expectedOutput, actualOutput);
    	ch = br.read();
    	assertEquals(84, ch); // Value of 'T' is 84
    	System.out.println("----- Test 1 Process Completed -----");
    	
    	// Steps for Test 2
    	br = new BufferedReader(new StringReader(""));
    	br.read();
    	br.mark(4);
    	br.read();
    	ch = br.read();
    	actualOutput = instance.unget_char(ch,br);
    	expectedOutput = 0;
    	assertEquals(expectedOutput, actualOutput);
    	ch = br.read();
    	assertEquals(-1, ch); // Returns -1 since the next char of null is empty
    	System.out.println("----- Test 2 Process Completed -----");
    	
    	
    	System.out.println("/********** End of JUnit Testing for the method unget_char() ******/");
    }
    
    /*
     * Method Name : open_token_stream
     * Input : A filename string
     * Output : A BufferedReader
     * No.of Tests: 2
     * Test 1: token = "open_token_stream_1.txt" and File Content = "test"
     * Test 2: token = "" through System.in
     */
    @Test
    public void testOpen_token_stream() throws IOException {
    	
    	System.out.println("/********** Started JUnit Testing for the method open_token_stream() ******/");
    	Printtokens2 instance = new Printtokens2();
    	BufferedReader br = null;
    	String actualOutput = "", expectedOutput = "", fname = "";
    	
    	// Steps for Test 1
    	fname = "InputFiles//open_token_stream_1.txt";
    	br = instance.open_token_stream(fname);
		actualOutput = br.readLine();
    	expectedOutput = "test";
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 1 Process Completed -----");
    	
    	// Steps for Test 2
    	ByteArrayInputStream sysInput = new ByteArrayInputStream("".getBytes());
    	System.setIn(sysInput);
    	fname = "";
    	br = instance.open_token_stream(fname);
    	try {
			actualOutput = br.readLine();
		} catch (NullPointerException e) {
			actualOutput = null;
		}
    	expectedOutput = null;
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 2 Process Completed -----");
    	
    	System.setIn(System.in);
    	
    	System.out.println("/********** End of JUnit Testing for the method open_token_stream() ******/");    	
    }
    
    /*
     * Method Name : get_token
     * Input : A BufferedReader
     * Output : A token string
     * No.of Tests: 7
     * Test 1: Filename: get_token_1.txt   -   File Content : "gettoken;"
     * Test 2: Filename: null   -   System.in Content : "\n "
     * Test 3: Filename: get_token_2.txt   -   File Content : "[gettoken]"
     * Test 4: Filename: null   -   System.in Content : "token()"
     * Test 5: Filename: null   -   System.in Content : "a token"
     * Test 6: Filename: null   -   System.in Content : "\"token\""
     * Test 7: Filename: null   -   System.in Content : "{tok12}"
     */
    @Test
    public void testGet_token() throws IOException {
    	
    	System.out.println("/********** Started JUnit Testing for the method get_token() ******/");
    	Printtokens2 instance = new Printtokens2();
    	BufferedReader br = null;
    	String actualOutput = "", expectedOutput = "";
    	
    	// Steps for Test 1
    	br = new BufferedReader(new FileReader("InputFiles\\get_token_1.txt"));
    	actualOutput = instance.get_token(br);
    	expectedOutput = "gettoken";
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 1 Process Completed -----");
    	
    	// Steps for Test 2
    	br = new BufferedReader(new StringReader("\n "));
    	actualOutput = instance.get_token(br);
    	expectedOutput = null;
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 2 Process Completed -----");
    	
    	// Steps for Test 3
    	br = new BufferedReader(new FileReader("InputFiles\\get_token_2.txt"));
    	actualOutput = instance.get_token(br);
    	expectedOutput = "[";
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 3 Process Completed -----");
    	
    	// Steps for Test 4
    	br = new BufferedReader(new StringReader("token()"));
    	actualOutput = instance.get_token(br);
    	expectedOutput = "token";
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 4 Process Completed -----");
    	
    	// Steps for Test 5
    	br = new BufferedReader(new StringReader("a token"));
    	actualOutput = instance.get_token(br);
    	expectedOutput = "a";
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 5 Process Completed -----");
    	
    	// Steps for Test 6
    	br = new BufferedReader(new StringReader("\"token\""));
    	actualOutput = instance.get_token(br);
    	expectedOutput = "\"token\"";
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 6 Process Completed -----");
    	
    	// Steps for Test 7
    	br = new BufferedReader(new StringReader("{tok12}"));
    	actualOutput = instance.get_token(br);
    	expectedOutput = "{tok12}";
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 7 Process Completed -----");
    	
    	System.out.println("/********** End of JUnit Testing for the method get_token() ******/");
    }
    
    /*
     * Method Name : is_token_end
     * Input : A character, a token status
     * Output : A boolean value
     * No.of Tests: 8
     * Test 1: str_com_id = 1 and res = -1
     * Test 2: str_com_id = 1 and res = 84
     * Test 3: str_com_id = 1 and res = 34
     * Test 4: str_com_id = 2 and res = 10
     * Test 5: str_com_id = 2 and res = 112
     * Test 6: str_com_id = 3 and res = 91
     * Test 7: str_com_id = 3 and res = 59
     * Test 8: str_com_id = 4 and res = 88
     */
    @Test
    public void testIs_token_end() {
    	
    	System.out.println("/********** Started JUnit Testing for the method is_token_end() ******/");
    	Printtokens2 instance = new Printtokens2();
    	boolean output;
    	
    	// Steps for Test 1
    	output = instance.is_token_end(1, -1);
    	assertTrue(output);
    	System.out.println("----- Test 1 Process Completed -----");
    	
    	// Steps for Test 2
    	output = instance.is_token_end(1, 84);
    	assertFalse(output);
    	System.out.println("----- Test 2 Process Completed -----");
    	
    	// Steps for Test 3
    	output = instance.is_token_end(1, 34);
    	assertTrue(output);
    	System.out.println("----- Test 3 Process Completed -----");
    	
    	// Steps for Test 4
    	output = instance.is_token_end(2, 10);
    	assertTrue(output);
    	System.out.println("----- Test 4 Process Completed -----");
    	
    	// Steps for Test 5
    	output = instance.is_token_end(2, 112);
    	assertFalse(output);
    	System.out.println("----- Test 5 Process Completed -----");
    	
    	// Steps for Test 6
    	output = instance.is_token_end(3, 91);
    	assertTrue(output);
    	System.out.println("----- Test 6 Process Completed -----");
    	
    	// Steps for Test 7
    	output = instance.is_token_end(3, 59);
    	assertTrue(output);
    	System.out.println("----- Test 7 Process Completed -----");
    	
    	// Steps for Test 8
    	output = instance.is_token_end(4, 88);
    	assertFalse(output);
    	System.out.println("----- Test 8 Process Completed -----");
    	
    	System.out.println("/********** End of JUnit Testing for the method is_token_end() ******/");
    }
    
    /*
     * Method Name : token_type
     * Input : A Token string
     * Output : Integer value of token type
     * No.of Tests: 8
     * Test 1: token = "if"
     * Test 2: token = "["
     * Test 3: token = "token"
     * Test 4: token = "55"
     * Test 5: token = ""\"Token\""
     * Test 6: token = "#g"
     * Test 7: token = ";"
     * Test 8: token = "{get}"
     */
    @Test
    public void testToken_type() throws IOException {
    	
    	System.out.println("/********** Started JUnit Testing for the method token_type() ******/");
    	Printtokens2 instance = new Printtokens2();
    	BufferedReader br = null;
    	int actualOutput = 0, expectedOutput = 0;
    	
    	// Steps for Test 1
    	br = new BufferedReader(new StringReader("if"));
    	actualOutput = instance.token_type(br.readLine());
    	expectedOutput = 1;
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 1 Process Completed -----");
    	
    	// Steps for Test 2
    	br = new BufferedReader(new StringReader("[tok]")); // takes only the char at (0) i.e., '['
    	actualOutput = instance.token_type(br.readLine());
    	expectedOutput = 2;
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 2 Process Completed -----");
    	
    	// Steps for Test 3
    	br = new BufferedReader(new StringReader("token"));
    	actualOutput = instance.token_type(br.readLine());
    	expectedOutput = 3;
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 3 Process Completed -----");
    	
    	// Steps for Test 4
    	br = new BufferedReader(new StringReader("55"));
    	actualOutput = instance.token_type(br.readLine());
    	expectedOutput = 41;
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 4 Process Completed -----");
    	
    	// Steps for Test 5
    	br = new BufferedReader(new StringReader("\"Token\""));
    	actualOutput = instance.token_type(br.readLine());
    	expectedOutput = 42;
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 5 Process Completed -----");
    	
    	// Steps for Test 6
    	br = new BufferedReader(new StringReader("#g"));
    	actualOutput = instance.token_type(br.readLine());
    	expectedOutput = 43;
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 6 Process Completed -----");
    	
    	// Steps for Test 7
    	br = new BufferedReader(new StringReader(";"));
    	actualOutput = instance.token_type(br.readLine());
    	expectedOutput = 5;
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 7 Process Completed -----");
    	
    	// Steps for Test 8
    	br = new BufferedReader(new StringReader("{get}"));
    	actualOutput = instance.token_type(br.readLine());
    	expectedOutput = 0;
    	assertEquals(expectedOutput, actualOutput);
    	System.out.println("----- Test 8 Process Completed -----");
    	
    	System.out.println("/********** End of JUnit Testing for the method token_type() ******/");
    }
    
    /*
     * Method Name : print_token
     * Input : A Token string
     * Output : Print the token (void method)
     * No.of Tests: 7
     * Test 1: token = "a+b"
     * Test 2: token = "xor"
     * Test 3: token = "["
     * Test 4: token = "token15"
     * Test 5: token = "455"
     * Test 6: token = ""\"token\""
     * Test 7: token = "#k"
     */
    @Test
    public void testPrint_token() throws IOException {
    	
    	System.out.println("/********** Started JUnit Testing for the method print_token() ******/");
    	Printtokens2 instance = new Printtokens2();
    	String actualOutput = "", expectedOutput = "";
    	PrintStream resetBack = System.out;
    	
    	// Steps for Test 1 
    	ByteArrayOutputStream outputPrint1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputPrint1));
        instance.print_token("a+b");
        actualOutput = outputPrint1.toString();
        expectedOutput = "error,\"a+b\".\n";
        assertEquals(expectedOutput, actualOutput);
        System.out.flush();
        System.setOut(resetBack); // Inorder to print the next line in console
        System.out.println("----- Test 1 Process Completed -----");
        
        // Steps for Test 2 
    	ByteArrayOutputStream outputPrint2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputPrint2));
        instance.print_token("xor");
        actualOutput = outputPrint2.toString();
        expectedOutput = "keyword,\"xor\".\n";
        assertEquals(expectedOutput, actualOutput);
        System.out.flush();
        System.setOut(resetBack); // Inorder to print the next line in console
        System.out.println("----- Test 2 Process Completed -----");
        
        // Steps for Test 3
    	ByteArrayOutputStream outputPrint3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputPrint3));
        instance.print_token("[");
        actualOutput = outputPrint3.toString();
        expectedOutput = "lsquare.\n";
        assertEquals(expectedOutput, actualOutput);
        System.out.flush();
        System.setOut(resetBack); // Inorder to print the next line in console
        System.out.println("----- Test 3 Process Completed -----");
        
        // Steps for Test 4
    	ByteArrayOutputStream outputPrint4 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputPrint4));
        instance.print_token("token15");
        actualOutput = outputPrint4.toString();
        expectedOutput = "identifier,\"token15\".\n";
        assertEquals(expectedOutput, actualOutput);
        System.out.flush();
        System.setOut(resetBack); // Inorder to print the next line in console
        System.out.println("----- Test 4 Process Completed -----");
        
    	
    	// Steps for Test 5 
    	ByteArrayOutputStream outputPrint5 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputPrint5));
        instance.print_token("455");
        actualOutput = outputPrint5.toString();
        expectedOutput = "numeric,455.\n";
        assertEquals(expectedOutput, actualOutput);
        System.out.flush();
        System.setOut(resetBack); // Inorder to print the next line in console
        System.out.println("----- Test 5 Process Completed -----");
    	
        // Steps for Test 6 
    	ByteArrayOutputStream outputPrint6 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputPrint6));
        instance.print_token("\"token\"");
        actualOutput = outputPrint6.toString();
        expectedOutput = "string,\"token\".\n";
        assertEquals(expectedOutput, actualOutput);
        System.out.flush();
        System.setOut(resetBack); // Inorder to print the next line in console
        System.out.println("----- Test 6 Process Completed -----");
        
    	// Steps for Test 7 	
        ByteArrayOutputStream outputPrint7 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputPrint7));
        instance.print_token("#k");
        actualOutput = outputPrint7.toString();
        expectedOutput = "character,\"k\".\n";
        assertEquals(expectedOutput, actualOutput);
        System.out.flush();
        System.setOut(resetBack); // Inorder to print the next line in console
        System.out.println("----- Test 7 Process Completed -----");
    	
    	System.out.println("/********** End of JUnit Testing for the method print_token() ******/");
    }
    
    /*
     * Method Name : is_comment
     * Input : A Token string
     * Output : Boolean value of is_comment
     * No.of Tests: 2
     * Test 1: token = ";//comment"
     * Test 2: token = "comment"
     */
    @Test
    public void testIs_comment() throws IOException {
    	
    	System.out.println("/********** Started JUnit Testing for the method is_comment() ******/");
    	Printtokens2 instance = new Printtokens2();
    	BufferedReader br = null;
    	boolean actualOutput;
    	
    	// Steps for Test 1
    	br = new BufferedReader(new StringReader(";//comment")); //Only first character will be considered
    	actualOutput = instance.is_comment(br.readLine());
    	assertTrue(actualOutput);
    	System.out.println("----- Test 1 Process Completed -----");
    	
    	// Steps for Test 2
    	br = new BufferedReader(new StringReader("comment")); //Only first character will be considered
    	actualOutput = instance.is_comment(br.readLine());
    	assertFalse(actualOutput);
    	System.out.println("----- Test 2 Process Completed -----");
    	
    	System.out.println("/********** End of JUnit Testing for the method is_comment() ******/");    	
    }
    
    /*
     * Method Name : is_keyword
     * Input : A Token string
     * Output : Boolean value of is_keyword
     * No.of Tests: 8
     * Test 1: token = "and"
     * Test 2: token = "or"
     * Test 3: token = "if"
     * Test 4: token = "xor"
     * Test 5: token = "lambda"
     * Test 6: token = "=>"
     * Test 7: token = "orr"
     * Test 8: token = "union"
     */
    @Test
    public void testIs_keyword() throws IOException {
    	
    	System.out.println("/********** Started JUnit Testing for the method is_keyword() ******/");
    	Printtokens2 instance = new Printtokens2();
    	BufferedReader br = null;
    	boolean actualOutput;
    	
    	// Steps for Test 1
    	br = new BufferedReader(new StringReader("and"));
    	actualOutput = instance.is_keyword(br.readLine());
    	assertTrue(actualOutput);
    	System.out.println("----- Test 1 Process Completed -----");
    	
    	// Steps for Test 2
    	br = new BufferedReader(new StringReader("or"));
    	actualOutput = instance.is_keyword(br.readLine());
    	assertTrue(actualOutput);
    	System.out.println("----- Test 2 Process Completed -----");
    	
    	// Steps for Test 3
    	br = new BufferedReader(new StringReader("if"));
    	actualOutput = instance.is_keyword(br.readLine());
    	assertTrue(actualOutput);
    	System.out.println("----- Test 3 Process Completed -----");
    	
    	// Steps for Test 4
    	br = new BufferedReader(new StringReader("xor"));
    	actualOutput = instance.is_keyword(br.readLine());
    	assertTrue(actualOutput);
    	System.out.println("----- Test 4 Process Completed -----");
    	
    	// Steps for Test 5
    	br = new BufferedReader(new StringReader("lambda"));
    	actualOutput = instance.is_keyword(br.readLine());
    	assertTrue(actualOutput);
    	System.out.println("----- Test 5 Process Completed -----");
    	
    	// Steps for Test 6
    	br = new BufferedReader(new StringReader("=>"));
    	actualOutput = instance.is_keyword(br.readLine());
    	assertTrue(actualOutput);
    	System.out.println("----- Test 6 Process Completed -----");
    	
    	// Steps for Test 7
    	br = new BufferedReader(new StringReader("orr"));
    	actualOutput = instance.is_keyword(br.readLine());
    	assertFalse(actualOutput);
    	System.out.println("----- Test 7 Process Completed -----");
    	
    	// Steps for Test 8
    	br = new BufferedReader(new StringReader("union"));
    	actualOutput = instance.is_keyword(br.readLine());
    	assertFalse(actualOutput);
    	System.out.println("----- Test 8 Process Completed -----");
    	
    	System.out.println("/********** End of JUnit Testing for the method is_keyword() ******/");    	
    }
    
    /*
     * Method Name : is_char_constant
     * Input : A Token string
     * Output : Boolean value of is_char_constant
     * No.of Tests: 2
     * Test 1: token = "#y"
     * Test 2: token = "y"
     */
    @Test
    public void testIs_char_constant() throws IOException {
    	
    	System.out.println("/********** Started JUnit Testing for the method is_char_constant() ******/");
    	Printtokens2 instance = new Printtokens2();
    	BufferedReader br = null;
    	boolean actualOutput;
    	
    	// Steps for Test 1
    	br = new BufferedReader(new StringReader("#y")); //Only first character will be considered
    	actualOutput = instance.is_char_constant(br.readLine());
    	assertTrue(actualOutput);
    	System.out.println("----- Test 1 Process Completed -----");
    	
    	// Steps for Test 2
    	br = new BufferedReader(new StringReader("y")); //Only first character will be considered
    	actualOutput = instance.is_char_constant(br.readLine());
    	assertFalse(actualOutput);
    	System.out.println("----- Test 2 Process Completed -----");
    	
    	System.out.println("/********** End of JUnit Testing for the method is_char_constant() ******/");    	
    }
    
    /*
     * Method Name : is_num_constant
     * Input : A Token string
     * Output : Boolean value of is_num_constant
     * No.of Tests: 8
     * Test 1: token = "5"
     * Test 2: token = "55"
     * Test 3: token = "555"
     * Test 4: token = "5555"
     * Test 5: token = "547i"
     * Test 6: token = "[74]"
     * Test 7: token = "gh"
     * Test 8: token = "\"55|""
     */
    @Test
    public void testIs_num_constant() throws IOException {
    	
    	System.out.println("/********** Started JUnit Testing for the method is_num_constant() ******/");
    	Printtokens2 instance = new Printtokens2();
    	BufferedReader br = null;
    	boolean actualOutput;
    	
    	// Steps for Test 1
    	br = new BufferedReader(new StringReader("5"));
    	actualOutput = instance.is_num_constant(br.readLine());
    	assertTrue(actualOutput);
    	System.out.println("----- Test 1 Process Completed -----");
    	
    	// Steps for Test 2
    	br = new BufferedReader(new StringReader("55"));
    	actualOutput = instance.is_num_constant(br.readLine());
    	assertTrue(actualOutput);
    	System.out.println("----- Test 2 Process Completed -----");
    	
    	// Steps for Test 3
    	br = new BufferedReader(new StringReader("555"));
    	actualOutput = instance.is_num_constant(br.readLine());
    	assertTrue(actualOutput);
    	System.out.println("----- Test 3 Process Completed -----");
    	
    	// Steps for Test 4
    	br = new BufferedReader(new StringReader("5555"));
    	actualOutput = instance.is_num_constant(br.readLine());
    	assertTrue(actualOutput);
    	System.out.println("----- Test 4 Process Completed -----");
    	
    	// Steps for Test 5
    	br = new BufferedReader(new StringReader("547i"));
    	actualOutput = instance.is_num_constant(br.readLine());
    	assertFalse(actualOutput);
    	System.out.println("----- Test 5 Process Completed -----");
    	
    	// Steps for Test 6
    	br = new BufferedReader(new StringReader("[74]"));
    	actualOutput = instance.is_num_constant(br.readLine());
    	assertFalse(actualOutput);
    	System.out.println("----- Test 6 Process Completed -----");
    	
    	// Steps for Test 7
    	br = new BufferedReader(new StringReader("gh"));
    	actualOutput = instance.is_num_constant(br.readLine());
    	assertFalse(actualOutput);
    	System.out.println("----- Test 7 Process Completed -----");
    	
    	// Steps for Test 8
    	br = new BufferedReader(new StringReader("\"55\""));
    	actualOutput = instance.is_num_constant(br.readLine());
    	assertFalse(actualOutput);
    	System.out.println("----- Test 8 Process Completed -----");
    	
    	System.out.println("/********** End of JUnit Testing for the method is_num_constant() ******/");    	
    }
    
    /*
     * Method Name : is_str_constant
     * Input : A Token string
     * Output : Boolean value of is_str_constant
     * No.of Tests: 8
     * Test 1: token = "\"sample\""
     * Test 2: token = "\"sample string\""
     * Test 3: token = "\"sample"
     * Test 4: token = "sample\""
     * Test 5: token = "sample"
     * Test 6: token = "[74]"
     * Test 7: token = "'sample'"
     * Test 8: token = "\"55\""
     */
    @Test
    public void testIs_str_constant() throws IOException {
    	
    	System.out.println("/********** Started JUnit Testing for the method is_str_constant() ******/");
    	Printtokens2 instance = new Printtokens2();
    	BufferedReader br = null;
    	boolean actualOutput;
    	
    	// Steps for Test 1
    	br = new BufferedReader(new StringReader("\"sample\""));
    	actualOutput = instance.is_str_constant(br.readLine());
    	assertTrue(actualOutput);
    	System.out.println("----- Test 1 Process Completed -----");
    	
    	// Steps for Test 2
    	br = new BufferedReader(new StringReader("\"sample string\""));
    	actualOutput = instance.is_str_constant(br.readLine());
    	assertTrue(actualOutput);
    	System.out.println("----- Test 2 Process Completed -----");
    	
    	// Steps for Test 3
    	br = new BufferedReader(new StringReader("\"sample"));
    	actualOutput = instance.is_str_constant(br.readLine());
    	assertFalse(actualOutput);
    	System.out.println("----- Test 3 Process Completed -----");
    	
    	// Steps for Test 4
    	br = new BufferedReader(new StringReader("sample\""));
    	actualOutput = instance.is_str_constant(br.readLine());
    	assertFalse(actualOutput);
    	System.out.println("----- Test 4 Process Completed -----");
    	
    	// Steps for Test 5
    	br = new BufferedReader(new StringReader("sample"));
    	actualOutput = instance.is_str_constant(br.readLine());
    	assertFalse(actualOutput);
    	System.out.println("----- Test 5 Process Completed -----");
    	
    	// Steps for Test 6
    	br = new BufferedReader(new StringReader("[74]"));
    	actualOutput = instance.is_str_constant(br.readLine());
    	assertFalse(actualOutput);
    	System.out.println("----- Test 6 Process Completed -----");
    	
    	// Steps for Test 7
    	br = new BufferedReader(new StringReader("'sample'"));
    	actualOutput = instance.is_str_constant(br.readLine());
    	assertFalse(actualOutput);
    	System.out.println("----- Test 7 Process Completed -----");
    	
    	// Steps for Test 8
    	br = new BufferedReader(new StringReader("\"55\""));
    	actualOutput = instance.is_str_constant(br.readLine());
    	assertTrue(actualOutput);
    	System.out.println("----- Test 8 Process Completed -----");
    	
    	System.out.println("/********** End of JUnit Testing for the method is_str_constant() ******/");    	
    }
    
    /*
     * Method Name : is_identifier
     * Input : A Token string
     * Output : Boolean value of is_identifier
     * No.of Tests: 5
     * Test 1: token = "sample"
     * Test 2: token = "sample123"
     * Test 3: token = "sample{}"
     * Test 4: token = "{sample}"
     * Test 5: token = "sample/str"
     */
    @Test
    public void testIs_identifier() throws IOException {
    	
    	System.out.println("/********** Started JUnit Testing for the method is_identifier() ******/");
    	Printtokens2 instance = new Printtokens2();
    	BufferedReader br = null;
    	boolean actualOutput;
    	
    	// Steps for Test 1
    	br = new BufferedReader(new StringReader("sample"));
    	actualOutput = instance.is_identifier(br.readLine());
    	assertTrue(actualOutput);
    	System.out.println("----- Test 1 Process Completed -----");
    	
    	// Steps for Test 2
    	br = new BufferedReader(new StringReader("sample123"));
    	actualOutput = instance.is_identifier(br.readLine());
    	assertTrue(actualOutput);
    	System.out.println("----- Test 2 Process Completed -----");
    	
    	// Steps for Test 3
    	br = new BufferedReader(new StringReader("sample{}"));
    	actualOutput = instance.is_identifier(br.readLine());
    	assertFalse(actualOutput);
    	System.out.println("----- Test 3 Process Completed -----");
    	
    	// Steps for Test 4
    	br = new BufferedReader(new StringReader("{sample}"));
    	actualOutput = instance.is_identifier(br.readLine());
    	assertFalse(actualOutput);
    	System.out.println("----- Test 4 Process Completed -----");
    	
    	// Steps for Test 5
    	br = new BufferedReader(new StringReader("sample/str"));
    	actualOutput = instance.is_identifier(br.readLine());
    	assertFalse(actualOutput);
    	System.out.println("----- Test 5 Process Completed -----");
    	
    	
    	System.out.println("/********** End of JUnit Testing for the method is_identifier() ******/");    	
    }
    
    /*
     * Method Name : unget_error
     * Input : A Token string
     * Output : Print the error (void method)
     * No.of Tests: 1
     * Test 1: BufferReader with some String
     */
    @Test
    public void testUnget_error() throws IOException {
    	
    	System.out.println("/********** Started JUnit Testing for the method unget_error() ******/");
    	Printtokens2 instance = new Printtokens2();
    	String actualOutput = "", expectedOutput = "";
    	BufferedReader br = null;
    	PrintStream resetBack = System.out;
    	
    	// Steps for Test 1 
    	ByteArrayOutputStream outputPrint = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputPrint));
        br = new BufferedReader(new StringReader("errorTest"));
        instance.unget_error(br);
        actualOutput = outputPrint.toString();
        expectedOutput = "It can not get charcter\n";
        assertEquals(expectedOutput, actualOutput);
        System.out.flush();
        System.setOut(resetBack); // Inorder to print the next line in console
        System.out.println("----- Test 1 Process Completed -----");
        
        System.out.println("/********** End of JUnit Testing for the method unget_error() ******/");    	
    }
    
    /*
     * Method Name : print_spec_symbol
     * Input : A Token string
     * Output : Print the token symbol (void method)
     * No.of Tests: 7
     * Test 1: token = "("
     * Test 2: token = ")"
     * Test 3: token = "["
     * Test 4: token = "]"
     * Test 5: token = "'"
     * Test 6: token = "`"
     * Test 7: token = ","
     */
    @Test
    public void testPrint_spec_symbol() throws IOException {
    	
    	System.out.println("/********** Started JUnit Testing for the method print_spec_symbol() ******/");
    	Printtokens2 instance = new Printtokens2();
    	String actualOutput = "", expectedOutput = "";
    	PrintStream resetBack = System.out;
    	
    	// Steps for Test 1 
    	ByteArrayOutputStream outputPrint1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputPrint1));
        instance.print_token("(");
        actualOutput = outputPrint1.toString();
        expectedOutput = "lparen.\n";
        assertEquals(expectedOutput, actualOutput);
        System.out.flush();
        System.setOut(resetBack); // Inorder to print the next line in console
        System.out.println("----- Test 1 Process Completed -----");
        
        // Steps for Test 2 
    	ByteArrayOutputStream outputPrint2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputPrint2));
        instance.print_token(")");
        actualOutput = outputPrint2.toString();
        expectedOutput = "rparen.\n";
        assertEquals(expectedOutput, actualOutput);
        System.out.flush();
        System.setOut(resetBack); // Inorder to print the next line in console
        System.out.println("----- Test 2 Process Completed -----");
        
        // Steps for Test 3
    	ByteArrayOutputStream outputPrint3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputPrint3));
        instance.print_token("[");
        actualOutput = outputPrint3.toString();
        expectedOutput = "lsquare.\n";
        assertEquals(expectedOutput, actualOutput);
        System.out.flush();
        System.setOut(resetBack); // Inorder to print the next line in console
        System.out.println("----- Test 3 Process Completed -----");
        
        // Steps for Test 4
    	ByteArrayOutputStream outputPrint4 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputPrint4));
        instance.print_token("]");
        actualOutput = outputPrint4.toString();
        expectedOutput = "rsquare.\n";
        assertEquals(expectedOutput, actualOutput);
        System.out.flush();
        System.setOut(resetBack); // Inorder to print the next line in console
        System.out.println("----- Test 4 Process Completed -----");
        
    	
    	// Steps for Test 5 
    	ByteArrayOutputStream outputPrint5 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputPrint5));
        instance.print_token("'");
        actualOutput = outputPrint5.toString();
        expectedOutput = "quote.\n";
        assertEquals(expectedOutput, actualOutput);
        System.out.flush();
        System.setOut(resetBack); // Inorder to print the next line in console
        System.out.println("----- Test 5 Process Completed -----");
    	
        // Steps for Test 6 
    	ByteArrayOutputStream outputPrint6 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputPrint6));
        instance.print_token("`");
        actualOutput = outputPrint6.toString();
        expectedOutput = "bquote.\n";
        assertEquals(expectedOutput, actualOutput);
        System.out.flush();
        System.setOut(resetBack); // Inorder to print the next line in console
        System.out.println("----- Test 6 Process Completed -----");
        
    	// Steps for Test 7 	
        ByteArrayOutputStream outputPrint7 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputPrint7));
        instance.print_token(",");
        actualOutput = outputPrint7.toString();
        expectedOutput = "comma.\n";
        assertEquals(expectedOutput, actualOutput);
        System.out.flush();
        System.setOut(resetBack); // Inorder to print the next line in console
        System.out.println("----- Test 7 Process Completed -----");
    	
    	System.out.println("/********** End of JUnit Testing for the method print_spec_symbol() ******/");
    }
    
    /*
     * Method Name : is_spec_symbol
     * Input : A Token string
     * Output : Boolean value of is_spec_symbol
     * No.of Tests: 8
     * Test 1: token = "("
     * Test 2: token = ")"
     * Test 3: token = "["
     * Test 4: token = "]"
     * Test 5: token = "'"
     * Test 6: token = "`"
     * Test 7: token = ","
     * Test 8: token = "{"
     */
    @Test
    public void testIs_spec_symbol() throws IOException {
    	
    	System.out.println("/********** Started JUnit Testing for the method is_spec_symbol() ******/");
    	Printtokens2 instance = new Printtokens2();
    	BufferedReader br = null;
    	boolean actualOutput;
    	String str;
    	char ch;
    	
    	// Steps for Test 1
    	br = new BufferedReader(new StringReader("("));
    	str = br.readLine();
    	ch = (char) str.charAt(0);
    	actualOutput = instance.is_spec_symbol(ch);
    	assertTrue(actualOutput);
    	System.out.println("----- Test 1 Process Completed -----");
    	
    	// Steps for Test 2
    	br = new BufferedReader(new StringReader(")"));
    	str = br.readLine();
    	ch = (char) str.charAt(0);
    	actualOutput = instance.is_spec_symbol(ch);
    	assertTrue(actualOutput);
    	System.out.println("----- Test 2 Process Completed -----");
    	
    	// Steps for Test 3
    	br = new BufferedReader(new StringReader("["));
    	str = br.readLine();
    	ch = (char) str.charAt(0);
    	actualOutput = instance.is_spec_symbol(ch);
    	assertTrue(actualOutput);
    	System.out.println("----- Test 3 Process Completed -----");
    	
    	// Steps for Test 4
    	br = new BufferedReader(new StringReader("]"));
    	str = br.readLine();
    	ch = (char) str.charAt(0);
    	actualOutput = instance.is_spec_symbol(ch);
    	assertTrue(actualOutput);
    	System.out.println("----- Test 4 Process Completed -----");
    	
    	// Steps for Test 5
    	br = new BufferedReader(new StringReader("'"));
    	str = br.readLine();
    	ch = (char) str.charAt(0);
    	actualOutput = instance.is_spec_symbol(ch);
    	assertTrue(actualOutput);
    	System.out.println("----- Test 5 Process Completed -----");
    	
    	// Steps for Test 6
    	br = new BufferedReader(new StringReader("`"));
    	str = br.readLine();
    	ch = (char) str.charAt(0);
    	actualOutput = instance.is_spec_symbol(ch);
    	assertTrue(actualOutput);
    	System.out.println("----- Test 6 Process Completed -----");
    	
    	// Steps for Test 7
    	br = new BufferedReader(new StringReader(","));
    	str = br.readLine();
    	ch = (char) str.charAt(0);
    	actualOutput = instance.is_spec_symbol(ch);
    	assertTrue(actualOutput);
    	System.out.println("----- Test 7 Process Completed -----");
    	
    	// Steps for Test 8
    	br = new BufferedReader(new StringReader("{"));
    	str = br.readLine();
    	ch = (char) str.charAt(0);
    	actualOutput = instance.is_spec_symbol(ch);
    	assertFalse(actualOutput);
    	System.out.println("----- Test 8 Process Completed -----");
    	
    	System.out.println("/********** End of JUnit Testing for the method is_spec_symbol() ******/");    	
    }
    
    //// ******** DE-SCOPED  ******** /////////
    /*
     * Method Name : main
     * Input : A String array
     * Output : Void method
     * No.of Tests: 3
     * Test 1: args[] = ""
     * Test 2: args[] = "main_input_1.txt"
     * Test 3: args[] = "main_input_1.txt", "main_input_2.txt"
     */
    //@Test
    /*public void testMain() throws IOException {
    	
    	Printtokens2 instance = new Printtokens2();
    	
    	//Steps for Test 1
    	ByteArrayInputStream sysInput = new ByteArrayInputStream("testing".getBytes());
    	System.setIn(sysInput);
    	String[] argument1 = {};
    	instance.main(argument1);
    	assertEquals(0, argument1.length);
    	System.setIn(System.in);
    	
    	//Steps for Test 2
    	String[] argument2 = {"InputFiles\\main_input_1.txt"};
    	instance.main(argument2);
    	assertEquals(1, argument2.length);
    	
    	//Steps for Test 2
    	String[] argument3 = {"InputFiles\\main_input_1.txt", "InputFiles\\main_input_2.txt"};
    	instance.main(argument3);
    	assertEquals(2, argument3.length);
    	   	
    }*/
}
