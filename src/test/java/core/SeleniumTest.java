package core;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import org.junit.BeforeClass;
import org.junit.ComparisonFailure;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SeleniumTest {
/*
       @BeforeClass
       public static void BeforeClass011111() throws Exception  { } //WHAT ARE PURPOSES TO USE @BeforeClass?
*/       
       @Parameters(name = "Iteration # {index} : exp: {1}; act: {2}") // Test data generator
       public static Collection<String[]> data() throws IOException {
              core.Selenium selenuim = new core.Selenium();
              //System.out.println(Arrays.asList(selenuim.a2d()));
              return Arrays.asList(selenuim.a2d());} // return [[Ljava.lang.String;@31e4bb20,... 25 references
       
       @Parameter(value = 0) // @Parameter for Field injection instead of Constructor
       public String test_id;

       @Parameter(value = 1)
       public String expected_Result;

       @Parameter(value = 2)
       public String actual_Result;
       
       @Test
       public void test_Title_Validation()  throws ComparisonFailure {
       boolean assert_result = false;
       assertEquals("ТЕСТ ПРОВАЛЕН!", expected_Result, actual_Result);   
       System.out.println("Test Case: " + test_id + " Expected Result: " + expected_Result + " Actual Result: " + actual_Result);
              
             
       }

}
